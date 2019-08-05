package com.CTS.Project.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mst_resource_pool")
public class MstResourcePool {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "resourceId")
	private Long resourceId;
	
	@ManyToOne
	@JoinColumn(name="rpResourceTypeId")
	private MstResourceType rpResourceTypeId;
	
	@ManyToOne
	@JoinColumn(name="rpResourceDesignationTypeId")
	private MstResourceDesignation rpResourceDesignationTypeId;
	
	@ManyToOne
	@JoinColumn(name="rpResourceZoneTypeId")
	private MstResourceZone rpResourceZoneTypeId;
	
	@ManyToOne
	@JoinColumn(name="rpStateId")
	private MstState rpStateId;
	
	@ManyToOne
	@JoinColumn(name="rpAreaId")
	private MstResourceArea rpAreaId;

	@Column(name = "roleFlag")
	private String roleFlag;

	@Column(name = "nonAd", columnDefinition = "binary(1)", nullable = false)
	private Boolean nonAd=false;

	@ManyToOne
	@JoinColumn(name = "resourcePoolStateId")
	private MstState resourcePoolStateId;
	
	@Column(name = "resourceName")
	private String resourceName;

	@Column(name = "loginID")
	private String loginId;

	@Column(name = "password")
	private String password;

	@Column(name = "department")
	private String department;

	@Column(name = "emailId")
	private String emailId;

	@Column(name = "dealerCode")
	private String dealerCode;

	@Column(name = "branchName")
	private String branchName;

	@Column(name = "alternativeEmailId")
	private String alternativeEmailId;

	@Column(name = "phone")
	private String phone;

	@Column(name = "mobileNo")
	private String mobileNo;

	@Column(name = "fax")
	private String fax;

	@Column(name = "privateKeyIn")
	private String privateKeyIn;

	@Column(name = "blockStatus")
	private String blockStatus;

	@Column(name = "flag")
	private String flag;

	@Column(name = "adminFlag")
	private String adminFlag;

	@Column(name = "lastUpdatedDate")
	private String lastUpdatedDate;

	@Column(name = "securityKey")
	private String securityKey;
	
	@Column(name = "parentCode")
	private String parentCode;

	@Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean isActive = true;

	@Column(name = "thirdPartyResource", columnDefinition = "binary(1) default false", nullable = false)
	private Boolean thirdPartyresource = false;

	@Column(name = "isDealer", columnDefinition = "binary(1) default false", nullable = false)
	private Boolean isDealer = false;
	
	@Column(name = "refreshToken")
	private String refreshToken;

	@JsonIgnore
	@CreatedBy
	private String createdBy;

	@JsonIgnore
	@CreatedDate
	@Column(nullable = false, updatable = false)
	private Date createdDate = new Date();

	@JsonIgnore
	@LastModifiedBy
	private String ModifiedBy;

	@JsonIgnore
	@LastModifiedDate
	@Column(nullable = false, updatable = false)
	private Date modifiedDate = new Date();
	
	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public MstResourceType getRpResourceTypeId() {
		return rpResourceTypeId;
	}

	public void setRpResourceTypeId(MstResourceType rpResourceTypeId) {
		this.rpResourceTypeId = rpResourceTypeId;
	}

	public MstState getRpStateId() {
		return rpStateId;
	}

	public MstResourceArea getRpAreaId() {
		return rpAreaId;
	}

	public void setRpAreaId(MstResourceArea rpAreaId) {
		this.rpAreaId = rpAreaId;
	}

	public void setRpStateId(MstState rpStateId) {
		this.rpStateId = rpStateId;
	}

	public MstResourceDesignation getRpResourceDesignationTypeId() {
		return rpResourceDesignationTypeId;
	}

	public void setRpResourceDesignationTypeId(MstResourceDesignation rpResourceDesignationTypeId) {
		this.rpResourceDesignationTypeId = rpResourceDesignationTypeId;
	}

	public MstResourceZone getRpResourceZoneTypeId() {
		return rpResourceZoneTypeId;
	}

	public void setRpResourceZoneTypeId(MstResourceZone rpResourceZoneTypeId) {
		this.rpResourceZoneTypeId = rpResourceZoneTypeId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAlternativeEmailId() {
		return alternativeEmailId;
	}

	public void setAlternativeEmailId(String alternativeEmailId) {
		this.alternativeEmailId = alternativeEmailId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Boolean getThirdPartyresource() {
		return thirdPartyresource;
	}

	public void setThirdPartyresource(Boolean thirdPartyresource) {
		this.thirdPartyresource = thirdPartyresource;
	}

	public Boolean getIsDealer() {
		return isDealer;
	}

	public void setIsDealer(Boolean isDealer) {
		this.isDealer = isDealer;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return ModifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getRoleFlag() {
		return roleFlag;
	}

	public void setRoleFlag(String roleFlag) {
		this.roleFlag = roleFlag;
	}

	public Boolean getNonAd() {
		return nonAd;
	}

	public void setNonAd(Boolean nonAd) {
		this.nonAd = nonAd;
	}

	public MstState getResourcePoolStateId() {
		return resourcePoolStateId;
	}

	public void setResourcePoolStateId(MstState resourcePoolStateId) {
		this.resourcePoolStateId = resourcePoolStateId;
	}

	public String getPrivateKeyIn() {
		return privateKeyIn;
	}

	public void setPrivateKeyIn(String privateKeyIn) {
		this.privateKeyIn = privateKeyIn;
	}

	public String getBlockStatus() {
		return blockStatus;
	}

	public void setBlockStatus(String blockStatus) {
		this.blockStatus = blockStatus;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(String adminFlag) {
		this.adminFlag = adminFlag;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getSecurityKey() {
		return securityKey;
	}

	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "MstResourcePool [resourceId=" + resourceId + ", rpResourceTypeId=" + rpResourceTypeId
				+ ", rpResourceDesignationTypeId=" + rpResourceDesignationTypeId + ", rpResourceZoneTypeId="
				+ rpResourceZoneTypeId + ", rpStateId=" + rpStateId + ", rpAreaId=" + rpAreaId + ", resourceName="
				+ resourceName + ", loginId=" + loginId + ", password=" + password + ", department=" + department + ", emailId=" + emailId + ", dealerCode=" + dealerCode + ", branchName="
				+ branchName + ", alternativeEmailId=" + alternativeEmailId + ", phone=" + phone + ", mobileNo="
				+ mobileNo + ", fax=" + fax + ", isActive=" + isActive + ", thirdPartyresource=" + thirdPartyresource
				+ ", isDealer=" + isDealer + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", ModifiedBy=" + ModifiedBy + ", modifiedDate=" + modifiedDate + ", roleFlag=" + roleFlag
				+ ", nonAd=" + nonAd + ", resourcePoolStateId=" + resourcePoolStateId + ", privateKeyIn=" + privateKeyIn
				+ ", blockStatus=" + blockStatus + ", flag=" + flag + ", adminFlag=" + adminFlag + ", lastUpdatedDate="
				+ lastUpdatedDate + ", securityKey=" + securityKey + "]";
	}

	

	

	
	
	

	

	

}
