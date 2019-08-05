package com.CTS.Project.ServiceImpls;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MstRole;
import com.CTS.Project.Repository.MstRoleRepository;
import com.CTS.Project.Services.MstRoleService;

@Service
public class MstRoleServiceImpl implements MstRoleService {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	MstRoleRepository mstRoleRepository;

	@Override
	public void save(MstRole mstRole) {
		mstRoleRepository.save(mstRole);
	}

	@Override
	public Page<MstRole> findAllRecords(PageRequest pageRequest) {
		return mstRoleRepository.findAll(pageRequest);
	}

	@Override
	public Page<MstRole> compliteSearch(String searchString, PageRequest pageRequest) {
		return mstRoleRepository.findAllByRoleNameContainsAndIsActiveTrueOrRoleGroupIDGroupNameContainsAndIsActiveTrue(
				searchString, searchString, pageRequest);
	}

	@Override
	public MstRole findOneById(Long appId) {
		return entityManager.find(MstRole.class, appId);
	}

	@Override
	public void deleteById(Long appId) {
		mstRoleRepository.deleteById(appId);
	}

	@Override
	public Page<MstRole> findAllRecordsByIsActive(Pageable pageRequest) {
		return mstRoleRepository.findAllByIsActiveTrue(pageRequest);
	}

}
