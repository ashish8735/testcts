package com.CTS.Project.Models;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "mst_stage")
public class MstStage {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sId", unique = true, nullable = false)
    private long sId;


	@Column(name="stageName")
	private String stageName;
	
	@Column(name = "description")
    private String description;
	
    @Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
    private Boolean isActive = true;

	public long getsId() {
		return sId;
	}

	public void setsId(long sId) {
		this.sId = sId;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "MstStage [sId=" + sId + ", stageName=" + stageName + ", description=" + description + ", isActive="
				+ isActive + "]";
	}

    
    
}



