package com.tcf.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.aspectj.apache.bcel.classfile.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tcf.entity.SmbmsRole;
import com.tcf.entity.SmbmsUser;
import com.tcf.service.SmbmsRoleService;
import com.tcf.service.SmbmsUserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private SmbmsUserService us;
	
	@Autowired
	private SmbmsRoleService rs;
	
	@RequestMapping(value="login.do",method={RequestMethod.POST})
	public String login(SmbmsUser user,HttpSession session,Map<String, Object> model){
		/*int a = 10/0;*/
		SmbmsUser logined = us.login(user);
		if(logined != null){
			session.setAttribute("userSession", logined);
			System.out.println("==================================");
			return "jsp/frame";
		}
		model.put("error", "用户名或者密码错误！！！");
		return "login";
	}
	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("userSession");
		return "login";
	}
	
	/*@ExceptionHandler(RuntimeException.class)
	public String exceptionHandler(RuntimeException exception,HttpServletRequest req){
		req.setAttribute("exception", exception);
		return "jsp/error";
	}*/
	
	private int pageSize = 5;
	
	@RequestMapping("user.do")
	public String getUsers(String queryname,Integer queryUserRole,@RequestParam(defaultValue="1") Integer pageIndex,Map<String,Object> model){
		
		int totalCount = us.getUserRows(queryname, queryUserRole);
		int totalPageCount = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		model.put("userList", us.getSmbmsUsers(queryname, queryUserRole, pageIndex, pageSize));
		model.put("roleList", rs.getSmbmsRoles());
		model.put("currentPageNo", pageIndex);//当前的页码
		model.put("totalPageCount", totalPageCount);//总页数
		model.put("totalCount", totalCount);//总行数
		model.put("queryUserName", queryname);
		model.put("queryUserRole", queryUserRole);
		return "jsp/userlist";
	}
	
	@RequestMapping("goAddUser.do")
	public String goAddUser(Map<String,Object> model,HttpSession session){
		Map<Integer,String> genders = new HashMap<Integer, String>();
		genders.put(1, "男");
		genders.put(2, "女");
		model.put("user", new SmbmsUser());
		session.setAttribute("genders", genders);
		session.setAttribute("roles", getMap(rs.getSmbmsRoles()));
		return "jsp/adduser";
	}
	/*@RequestMapping("addUser.do")
	public String addUser(@ModelAttribute("user") @Valid SmbmsUser user,BindingResult result){
		if(!result.hasErrors() && us.addSmbmsUser(user)>0){
			return "redirect:user.do";
		}
		return "jsp/adduser";
	}*/
	/*@RequestMapping("addUser.do")
	public String addUser(@ModelAttribute("user") @Valid SmbmsUser user,BindingResult result,MultipartFile photo,HttpServletRequest req){
		System.out.println("========================================");
		if(!result.hasErrors()){
			String path = req.getSession().getServletContext().getRealPath("photos");
			//1.检测
			String err = getErrInfo(photo);
			//2.上传
			if(err == null){
				String fileName = upload(photo, path);
				if(fileName != null){
					user.setPhotoPath("photos"+File.separator+fileName);
					if(us.addSmbmsUser(user)>0){
						return "redirect:user.do";
					}
				}
			}
			req.setAttribute("errors", err);
		}
		return "jsp/adduser";
	}*/
	@RequestMapping("addUser.do")
	public String addUser(@ModelAttribute("user") @Valid SmbmsUser user,BindingResult result,@RequestParam("photos") MultipartFile[] photos,HttpServletRequest req){
		System.out.println("========================================");
		if(!result.hasErrors()){
			String path = req.getSession().getServletContext().getRealPath("photos");
			List<String> errors = new ArrayList<String>();
			List<String> filenames = new ArrayList<String>();
			//1.检测
			for(MultipartFile photo:photos){
				String err = getErrInfo(photo);
				//2.上传
				if(err == null){
					String fileName = upload(photo, path);
					filenames.add(fileName);
				}else{
					errors.add(err);
				}
			}
			
			if(filenames.size() > 0){
				user.setPhotoPath("photos"+File.separator+filenames.get(0));
				if(us.addSmbmsUser(user)>0){
					return "redirect:user.do";
				}
			}
			req.setAttribute("errors", errors);
			req.setAttribute("filenames", filenames);
		}
		return "jsp/adduser";
	}
	/**
	 * 
	 * @param photo
	 * @param path
	 * @return
	 */
	public String upload(MultipartFile photo,String path){
		String fileName = photo.getOriginalFilename();
		long time = System.currentTimeMillis();
		int randNumber = RandomUtils.nextInt(1000000);
		File dest = new File(path,time+"_"+randNumber+"_"+fileName);
		try {
			photo.transferTo(dest);
			return fileName;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * //1).上传的文件是否为空
		//2).上传文件的大小
		//3).上传文件的格式
	 * @param photo
	 * @return null is ok!!!
	 */
	public String getErrInfo(MultipartFile photo){
		String fileName = photo.getOriginalFilename();
		String suf = FilenameUtils.getExtension(fileName);
		String err = null;
		if(photo.isEmpty()){
			err = String.format("%s：上传文件不能为空",fileName);
		}else if(photo.getSize()>500000){
			err = String.format("%s：上传文件大小不能超过500KB",fileName);
		}else if(!formats.contains(suf.toLowerCase())){
			err = String.format("%s：上传文件格式不正确，支持的格式：%s",fileName,formats);
		}
		return err;
	}
	static List<String> formats = new ArrayList<String>();
	static{
		formats.add("png");
		formats.add("jpg");
		formats.add("jpeg");
		formats.add("pneg");
	}
	/*@RequestMapping("modifyUser.do")
	public String modifyUser(Long id,Map<String,Object> model){
		model.put("user", us.getById(id));
		return "jsp/usermodify";
	}*/
	@RequestMapping("modifyUser/{id}")
	public String modifyUser(@PathVariable("id") Long id,Map<String,Object> model){
		model.put("user", us.getById(id));
		return "jsp/usermodify";
	}
	@RequestMapping("viewUser/{id}")
	public String viewUser(@PathVariable("id") Long id,Map<String,Object> model){
		model.put("user", us.getById(id));
		return "jsp/userview";
	}
	@RequestMapping("updateUser.do")
	public String updateUser(SmbmsUser user){
		if(us.updateSmbmsUser(user)>0){
			return "redirect:user.do";
		}
		return "jsp/usermodify";
	}
	
	
	
	
	
	public Map<Long,String> getMap(List<SmbmsRole> roles){
		Map<Long,String> map = new HashMap<Long, String>();
		for(SmbmsRole role:roles){
			map.put(role.getId(), role.getRoleName());
		}
		return map;
	}
}
