package com.CTS.Project.ServiceImpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MappingApplicationStage;
import com.CTS.Project.Models.MstApplication;
import com.CTS.Project.Models.MstIncidentState;
import com.CTS.Project.Models.MstResourcePool;
import com.CTS.Project.Models.TranAddIncident;
import com.CTS.Project.Models.TranAddIncidentReview;
import com.CTS.Project.Models.Tranincidentattachment;
import com.CTS.Project.Repository.MapApplicationStageRepository;
import com.CTS.Project.Repository.MstApplicationRepository;
import com.CTS.Project.Repository.TranAddIncidentRepository;
import com.CTS.Project.Repository.TranAddIncidentReviewrepository;
import com.CTS.Project.Repository.TranincidentattachmentRepository;
import com.CTS.Project.Services.TranAddIncidentService;

@Service
public class TranAddIncidentServiceImpl implements TranAddIncidentService {

	@Value("${spring.num}")
	private int num;

	@Value("${spring.stateId}")
	private Long stateId;

	@Autowired
	TranAddIncidentRepository tranrepo;

	@Autowired
	TranAddIncidentReviewrepository reviewrepo;

	@Autowired
	TranincidentattachmentRepository attachrepo;

	@Autowired
	MapApplicationStageRepository appstagerepo;

	@Autowired
	MstApplicationRepository mstApp;

	@PersistenceContext
	EntityManager entitymangaer;

	@Override
	public void save(TranAddIncident tran, String fileurl) {

		String incidentId = getIncidentId(tran.getTaiApplicationId().getAppId());
//		String url=tran.getAttachment_path();
//		tran.setAttachment_path(null);
		MstIncidentState objstate = entitymangaer.find(MstIncidentState.class, stateId);
		tran.setTaiIncidentStateId(objstate);
		tran.setIncidentId(incidentId);
		tran.getTaiApplicationId().getAppId();
		
		List<MappingApplicationStage> listmst = entitymangaer.createQuery(
				"select p from MappingApplicationStage p where p.mapStageapplicationId.appId="
						+ tran.getTaiApplicationId().getAppId() + " order by p.configureOrder asc ",
				MappingApplicationStage.class).getResultList();
		
		MstResourcePool robj=entitymangaer.find(MstResourcePool.class, tran.getAssignedTo().getResourceId());

		if(robj.getRpResourceTypeId().getResourceTypeId()==1) {
			if(listmst.get(0).getMapresourceId()!=null) {
				tran.setAssignedTo(listmst.get(0).getMapresourceId());
			}
		}
		
		TranAddIncident abc = tranrepo.save(tran);
		
		List<TranAddIncidentReview> list = new ArrayList<TranAddIncidentReview>();
	
		for (MappingApplicationStage mstStage : listmst) {
			TranAddIncidentReview obj = new TranAddIncidentReview();
			obj.setAutoIncidentId(abc);
			obj.setIncidentStateId(objstate);
			obj.setApplicationStageId(mstStage.getStageId());
			obj.setIsActive(false);
			list.add(obj);
		}

		list.get(0).setIsActive(true);
		reviewrepo.saveAll(list);

		if (fileurl != null && !fileurl.equals("")) {
			Tranincidentattachment attach = new Tranincidentattachment();
			attach.setApplicationId(entitymangaer.find(MstApplication.class, tran.getTaiApplicationId().getAppId()));
			attach.setAutoIncidentID(incidentId);
			attach.setAttachmentName(fileurl);
			attach.setAttachmentPath("src/main/resources/upload/" + fileurl);
			attachrepo.save(attach);

		}

	}

	public String getIncidentId(Long appId) {
		String resultIncident;

		MstApplication map = entitymangaer.find(MstApplication.class, appId);
		String abbrName = map.getAbbreviationName();
		String incidentId = "";
		int id = 1;
		try {
			incidentId = (String) entitymangaer.createNativeQuery(
					"SELECT tran.incident_id FROM transaction_addincident tran WHERE tran.tia_application_id='" + appId
							+ "' ORDER BY tran.auto_incident_id DESC limit 1")
					.getSingleResult();
		} catch (Exception e) {

			for (int i = 1; i < num; i++) {
				abbrName += "0";
			}
			System.out.println("abbrName------------" + abbrName);
		}
		System.out.println("incidentId---------" + incidentId);
		if (incidentId == "") {

			resultIncident = abbrName + (Integer.toString(id));
		} else {
			String[] part = incidentId.split("(?<=\\D)(?=\\d)");
			int partId = Integer.parseInt(part[1]) + 1;
			int partId2 = Integer.parseInt(part[1]) + 1;
			String.valueOf(partId2).length();
			int count = 0;
			while (partId != 0) {
				partId = partId / 10;
				count++;
			}
			int num1 = num - count;

			for (int i = 0; i < num1; i++) {
				part[0] += "0";
			}

			resultIncident = part[0] + (Integer.toString(partId2));

		}

		return resultIncident;

	}

}
