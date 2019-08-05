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
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="mapping_rolestage")
public class RoleStageMap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roleStageId", unique = true, nullable = false)
	private long roleStageId;
		
    @JsonInclude()
    @ManyToOne
    @JoinColumn(name = "roleId")
    private MstRole maproleId;
	
    @JsonInclude()
    @ManyToOne
    @JoinColumn(name = "stageId")
	private MstStage stageId;
	
	
	@Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean isActive = true;
	
	@JsonIgnore
    @CreatedBy
	private String createdBy;
	
	@JsonIgnore
    @CreatedDate
	@Column(name = "createdDate")
	private Date createdDate=new Date();
	
	@JsonIgnore
    @LastModifiedBy
	@Column(name = "modifiedBy")
	private String modifiedBy;
	
	@JsonIgnore
    @LastModifiedDate
	@Column(name = "modifiedDate")
	private Date modifiedDate=new Date();

	public long getRoleStageId() {
		return roleStageId;
	}

	public void setRoleStageId(long roleStageId) {
		this.roleStageId = roleStageId;
	}

	

	public MstRole getMaproleId() {
		return maproleId;
	}

	public void setMaproleId(MstRole maproleId) {
		this.maproleId = maproleId;
	}

	public MstStage getStageId() {
		return stageId;
	}

	public void setStageId(MstStage stageId) {
		this.stageId = stageId;
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

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	
}
