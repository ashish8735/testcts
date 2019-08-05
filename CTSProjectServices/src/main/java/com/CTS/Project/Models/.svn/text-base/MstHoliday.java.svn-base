package com.CTS.Project.Models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.CreatedBy;
@Entity
@Table(name="mst_Holiday")
public class MstHoliday {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "holidayId", unique = true, nullable = false)
	private long holidayId;
		
    @JsonInclude()
    @ManyToOne
    @JoinColumn(name = "holidayApplicationId")
    private MstApplication holidayApplicationId;
	
	@Column(name = "holidayYear")
	private String holidayYear;
	
	@Column(name = "holidayDate")
	private Date holidayDate;
	
	@Column(name = "reasonofHoliday")
	private String reasonofHoliday;	
	
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

	public long getHolidayId() {
		return holidayId;
	}

	public void setHolidayId(long holidayId) {
		this.holidayId = holidayId;
	}	

	

	public MstApplication getHolidayApplicationId() {
		return holidayApplicationId;
	}

	public void setHolidayApplicationId(MstApplication holidayApplicationId) {
		this.holidayApplicationId = holidayApplicationId;
	}

	public String getHolidayYear() {
		return holidayYear;
	}

	public void setHolidayYear(String holidayYear) {
		this.holidayYear = holidayYear;
	}

	public Date getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}

	public String getReasonofHoliday() {
		return reasonofHoliday;
	}

	public void setReasonofHoliday(String reasonofHoliday) {
		this.reasonofHoliday = reasonofHoliday;
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
