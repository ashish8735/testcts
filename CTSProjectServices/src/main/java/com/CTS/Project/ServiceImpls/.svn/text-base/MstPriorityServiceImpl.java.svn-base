package com.CTS.Project.ServiceImpls;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CTS.Project.Models.MstPriority;
import com.CTS.Project.Repository.MstPriorityRepository;
import com.CTS.Project.Services.MstPriorityService;

@Service
public class MstPriorityServiceImpl implements MstPriorityService{

	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	MstPriorityRepository mstpriorityrepo;
		
	Date createddate=new Date();
	
	@Override
	@Transactional
	public void save(MstPriority mstpriority) {
		
		mstpriorityrepo.save(mstpriority);	
		
	}

	@Override
	public MstPriority findById(Long priorityId) {
		return entityManager.find(MstPriority.class,priorityId);
	}

	@Override
	public void deleteById(Long priorityId) {	
		mstpriorityrepo.deleteById(priorityId);
	}

	@Override
	public List<MstPriority> getAllPriority() {
		
		return mstpriorityrepo.findAll();
	}

	@Override
	public Page<MstPriority> findAllRecords(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return mstpriorityrepo.findAll(pageRequest);
	}

	@Override
	public Iterable<MstPriority> compliteSearch(String searchString, PageRequest pageRequest) {
		return mstpriorityrepo.findAllByPriorityNameContainsAndIsActiveTrueOrDescriptionContainsAndIsActiveTrue(searchString,searchString, pageRequest);
	}

	@Override
	public Page<MstPriority> findAllRecordsByIsActive(Pageable pageRequest) {
		return mstpriorityrepo.findAllByIsActiveTrue(pageRequest);
	}

}
