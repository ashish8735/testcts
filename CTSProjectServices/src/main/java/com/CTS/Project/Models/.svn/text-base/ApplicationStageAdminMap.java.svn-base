package com.CTS.Project.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
@Table(name="mapping_application_stageadmin")
public class ApplicationStageAdminMap {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="stageadminId")
	private Long stageadminId;
	
	/*@JsonInclude()
	@ManyToOne
	@JoinColumn(name = "applicationId")
	private MstApplication mapStageapplicationId;
	 */
	
	@JsonInclude()
	@ManyToOne
	@JoinColumn(name = "applicationStageId")
	private MappingApplicationStage mapapplicationStageId;
	
	@ManyToOne
	@JoinColumn(name = "sId")
	private MstStage mapsId;
	
	@JsonInclude()
	@ManyToOne
	@JoinColumn(name = "mapresourceRoleID")
	private ResourceRoleMap mapresourceRoleID;

	

	public Long getStageadminId() {
		return stageadminId;
	}

	public void setStageadminId(Long stageadminId) {
		this.stageadminId = stageadminId;
	}

		

	public MappingApplicationStage getMapapplicationStageId() {
		return mapapplicationStageId;
	}

	public void setMapapplicationStageId(MappingApplicationStage mapapplicationStageId) {
		this.mapapplicationStageId = mapapplicationStageId;
	}

	public ResourceRoleMap getMapresourceRoleID() {
		return mapresourceRoleID;
	}

	public void setMapresourceRoleID(ResourceRoleMap mapresourceRoleID) {
		this.mapresourceRoleID = mapresourceRoleID;
	}

	public MstStage getMapsId() {
		return mapsId;
	}

	public void setMapsId(MstStage mapsId) {
		this.mapsId = mapsId;
	}
	
	
}
