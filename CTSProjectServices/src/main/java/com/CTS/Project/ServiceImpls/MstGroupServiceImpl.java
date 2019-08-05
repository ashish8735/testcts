package com.CTS.Project.ServiceImpls;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MstGroup;
import com.CTS.Project.Repository.MstGroupRepository;
import com.CTS.Project.Services.MstGroupService;

@Service
public class MstGroupServiceImpl implements MstGroupService {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	MstGroupRepository mstGroupRepository;

	@Override
	public Page<MstGroup> findAllRecords(PageRequest pageRequest) {
		return mstGroupRepository.findAll(pageRequest);
	}

	@Override
	public Page<MstGroup> compliteSearch(String searchString, PageRequest pageRequest) {
		return mstGroupRepository.findAllByGroupNameContainsAndIsActiveTrue(searchString, pageRequest);
	}

	@Override
	public void deleteById(Long groupId) {
		// TODO Auto-generated method stub
		mstGroupRepository.deleteById(groupId);
	}

	@Override
	public MstGroup findOneById(Long groupId) {
		// TODO Auto-generated method stub
		return entityManager.find(MstGroup.class,groupId);
	}

	@Override
	public void save(MstGroup mstgroup) {
		// TODO Auto-generated method stub
		 mstGroupRepository.save(mstgroup);
	}

}
