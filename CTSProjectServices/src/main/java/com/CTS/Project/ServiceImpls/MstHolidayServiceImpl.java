package com.CTS.Project.ServiceImpls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MstApplication;
import com.CTS.Project.Models.MstHoliday;
import com.CTS.Project.Repository.MstApplicationRepository;
import com.CTS.Project.Repository.MstHolidayRepository;
import com.CTS.Project.Services.MstHolidayService;
@Service
public class MstHolidayServiceImpl implements MstHolidayService{

	@Autowired
	MstHolidayRepository mstholidayrepo;
	
	@Autowired
	MstApplicationRepository mstapplicationrepo;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void save(MstHoliday mstholiday) {
		mstholidayrepo.save(mstholiday);
	}

	@Override
	public MstHoliday findById(Long holidayId) {
		return entityManager.find(MstHoliday.class, holidayId);
	}

	@Override
	public void deleteById(Long holidayId) {
	 mstholidayrepo.deleteById(holidayId);	
	}

	@Override
	public Page<MstHoliday> findAllRecords(PageRequest pageRequest) {
		return mstholidayrepo.findAll(pageRequest);
	}

	@Override
	public Iterable<MstHoliday> compliteSearch(String searchString, Pageable pageRequest) {
		return mstholidayrepo.findAllByReasonofHolidayContainsAndIsActiveTrueOrHolidayApplicationIdApplicationNameContainsAndIsActiveTrue(searchString,searchString, pageRequest);
	}

	@Override
	public List<MstApplication> getAllApplication() {
		return mstapplicationrepo.findAll();
	}

	
}
