package com.tcf.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * SmbmsUser entity. @author MyEclipse Persistence Tools
 */

public class SmbmsUser implements java.io.Serializable {

	// Fields

	private Long id;
	@NotNull(message="用户编码不能为空")
	@NotEmpty(message="用户编码不能为空")
	private String userCode;
	@NotEmpty(message="用户姓名不能为空")//""
	@NotNull(message="用户姓名不能为空")// null
	private String userName;
	@NotNull(message="用户密码不能为空")
	@Length(max=18,min=3,message="用户密码必须是3-18位")
	private String userPassword;
	private Integer gender;
	@NotNull(message="出生日期不能为空")
	@Past(message="您不能出生未来")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private String phone;
	private String address;
	private Integer userRole;
	private String roleName;
	private Long createdBy;
	private Timestamp creationDate;
	private Long modifyBy;
	private Timestamp modifyDate;
	private String photoPath;
	public SmbmsUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SmbmsUser(String userCode, String userName, Date birthday,
			String phone, String address) {
		super();
		this.userCode = userCode;
		this.userName = userName;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
	}

	public SmbmsUser(Long id, String userCode, String userName,
			String userPassword, Integer gender, Date birthday, String phone,
			String address, Integer userRole, String roleName, Long createdBy,
			Timestamp creationDate, Long modifyBy, Timestamp modifyDate) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.userRole = userRole;
		this.roleName = roleName;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public Long getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	@Override
	public String toString() {
		return "SmbmsUser [id=" + id + ", userCode=" + userCode + ", userName="
				+ userName + ", userPassword=" + userPassword + ", gender="
				+ gender + ", birthday=" + birthday + ", phone=" + phone
				+ ", address=" + address + ", userRole=" + userRole
				+ ", roleName=" + roleName + ", createdBy=" + createdBy
				+ ", creationDate=" + creationDate + ", modifyBy=" + modifyBy
				+ ", modifyDate=" + modifyDate + "]";
	}
}