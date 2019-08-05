package com.CTS.Project.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mst_resource_type")
public class MstResourceType {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "resourceTypeId")
   private  Long  resourceTypeId;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="resourceDesignationId")
	private List<MstResourceDesignation> resourceDesignationId;
	
	@Column(name = "resourceTypeName")
   private  String  resourceTypeName;
	
	 @Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
	    private Boolean isActive = true;

	public Long getResourceTypeId() {
		return resourceTypeId;
	}

	public void setResourceTypeId(Long resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}

	public String getResourceTypeName() {
		return resourceTypeName;
	}

	public void setResourceTypeName(String resourceTypeName) {
		this.resourceTypeName = resourceTypeName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	

	public List<MstResourceDesignation> getResourceDesignationId() {
		return resourceDesignationId;
	}

	public void setResourceDesignationId(List<MstResourceDesignation> resourceDesignationId) {
		this.resourceDesignationId = resourceDesignationId;
	}

	@Override
	public String toString() {
		return "ResourceType [resourceTypeId=" + resourceTypeId + ", resourceTypeName=" + resourceTypeName
				+ ", isActive=" + isActive + "]";
	}

	 
}
