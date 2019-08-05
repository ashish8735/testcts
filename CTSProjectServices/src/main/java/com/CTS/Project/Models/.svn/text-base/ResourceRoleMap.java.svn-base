package com.CTS.Project.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mapping_resourcerole")
public class ResourceRoleMap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resourceRoleID")
	private Long resourceRoleID;

	@Column(name = "resourceID")
	private String resourceID;

	@ManyToOne
	@JoinColumn(name = "mstApplicationId")
	private MstApplication mtApplicationId;

	@ManyToOne
	@JoinColumn(name = "mstRoleId")
	private MstRole mtRoleId;

	@ManyToOne
	@JoinColumn(name = "mstResourceTypeId")
	private MstResourceType mtResourceTypeId;

	@ManyToOne
	@JoinColumn(name = "mstResourceId")
	private MstResourcePool mResourceId;

	@Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean isActive = true;

	@JsonIgnore
	@CreatedBy
	@Column(name = "createdBy")
	private String createdBy;

	@JsonIgnore
	@CreatedDate
	@Column(nullable = false, updatable = false)
	private Date createdDate = new Date();

	@JsonIgnore
	@LastModifiedBy
	private String modifiedBy;

	@JsonIgnore
	@LastModifiedDate
	private Date lastModifiedDate = new Date();
	
	@Transient
	List<MstRole> mstRoleList;
	
	

	public List<MstRole> getMstRoleList() {
		return mstRoleList;
	}

	public void setMstRoleList(List<MstRole> mstRoleList) {
		this.mstRoleList = mstRoleList;
	}

	public Long getResourceRoleID() {
		return resourceRoleID;
	}

	public void setResourceRoleID(Long resourceRoleID) {
		this.resourceRoleID = resourceRoleID;
	}

	public String getResourceID() {
		return resourceID;
	}

	public void setResourceID(String resourceID) {
		this.resourceID = resourceID;
	}

	public MstApplication getMtApplicationId() {
		return mtApplicationId;
	}

	public void setMtApplicationId(MstApplication mtApplicationId) {
		this.mtApplicationId = mtApplicationId;
	}

	public MstRole getMtRoleId() {
		return mtRoleId;
	}

	public void setMtRoleId(MstRole mtRoleId) {
		this.mtRoleId = mtRoleId;
	}

	public MstResourceType getMtResourceTypeId() {
		return mtResourceTypeId;
	}

	public void setMtResourceTypeId(MstResourceType mtResourceTypeId) {
		this.mtResourceTypeId = mtResourceTypeId;
	}

	public MstResourcePool getmResourceId() {
		return mResourceId;
	}

	public void setmResourceId(MstResourcePool mResourceId) {
		this.mResourceId = mResourceId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
