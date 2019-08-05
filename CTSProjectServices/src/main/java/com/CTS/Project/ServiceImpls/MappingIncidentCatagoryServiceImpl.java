package com.CTS.Project.ServiceImpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MappingIncidentCatagory;
import com.CTS.Project.Models.ResourceRoleMap;
import com.CTS.Project.Repository.MappingIncidentCatagoryRepository;
import com.CTS.Project.Services.MappingIncidentCategoryService;

@Service
public class MappingIncidentCatagoryServiceImpl implements MappingIncidentCategoryService {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	MappingIncidentCatagoryRepository mappingIncidentCatagoryRepository;

	@Override
	public void save(MappingIncidentCatagory mappingIncidentCatagory) {

		mappingIncidentCatagoryRepository.save(mappingIncidentCatagory);
	}

	@Override
	public Page<MappingIncidentCatagory> findAllRecords(Pageable pageRequest) {

		return mappingIncidentCatagoryRepository.findAll(pageRequest);
	}

	@Override
	public MappingIncidentCatagory findOneById(Long mapincidentCatagoryId) {

		return entityManager.find(MappingIncidentCatagory.class, mapincidentCatagoryId);
	}

	@Override
	public void deleteById(Long mapincidentCatagoryId) {

		mappingIncidentCatagoryRepository.deleteById(mapincidentCatagoryId);
	}

	@Override
	public Iterable<MappingIncidentCatagory> compliteSearch(String searchString, Pageable pageRequest) {

		return mappingIncidentCatagoryRepository
				.findAllByMicApplicationIdApplicationNameContainsAndIsActiveTrueOrMicIncidentcategoryIdIncidentcategoryNameContainsAndIsActiveTrue(
						searchString, searchString, pageRequest);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MappingIncidentCatagory> getIncidentCategory(long app_id) {
		String query="SELECT * FROM mst_map_incident_category mmi INNER JOIN mst_incident_category mic ON mmi.mic_incidentcategory_id=mic.incidentcategory_id WHERE mmi.mic_application_id="+app_id+"";
		return entityManager.createNativeQuery(query, MappingIncidentCatagory.class).getResultList();
	}

}
