package com.CTS.Project.ServiceImpls;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.CTS.Project.Models.MstResourceArea;
import com.CTS.Project.Models.MstResourceZone;
import com.CTS.Project.Repository.MstAreaRepository;
import com.CTS.Project.Repository.MstResourceZoneRepository;
import com.CTS.Project.Services.MstAreaService;

@Service
public class MstAreaServiceImpl implements MstAreaService{
	
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	MstAreaRepository areaRepo;
	
	@Autowired
	MstResourceZoneRepository mstResourceZoneRepository;


	@Override
	public Page<MstResourceArea> findAllRecords(PageRequest pageRequest) {
		
		return areaRepo.findAll(pageRequest);
	}

	
	@Override
	public void save(MstResourceArea area) {
		areaRepo.save(area);
		
	}

	@Override
	public List<MstResourceArea> saveAll(List<MstResourceArea> area) {
		return areaRepo.saveAll(area);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MstResourceZone> findAllByZoneRecords(String page, String size, String sort, String col) {
		String query="select * from mst_resource_zone z inner join zone_state_id rz on z.resource_zone_id =rz.mst_resource_zone_resource_zone_id inner join mst_state s on rz.zone_state_id_state_id=s.state_id inner join state_area_id si on si.mst_state_state_id=s.state_id inner join mst_resource_area a on a.resource_area_id=si.state_area_id_resource_area_id where z.is_active=1 and s.is_active=1";
		String countQuery=StringUtils.replace(query, " * fr", " count(z.resource_zone_id) fr");
		List<MstResourceZone> list=entityManager.createNativeQuery(query,MstResourceZone.class).setFirstResult(((Integer.parseInt(page)-1)*Integer.parseInt(size))).setMaxResults(Integer.parseInt(size)).getResultList();
		BigInteger count=(BigInteger)entityManager.createNativeQuery(countQuery).getSingleResult();
		if(list.size()>0) {
			list.get(0).setCount(count.longValue());
		}
		
		return list;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MstResourceZone> completeSearch(String page, String size, String searchString, String col, String col2) {
		String query="select * from mst_resource_zone z inner join zone_state_id rz on z.resource_zone_id =rz.mst_resource_zone_resource_zone_id inner join mst_state s on rz.zone_state_id_state_id=s.state_id inner join state_area_id si on si.mst_state_state_id=s.state_id inner join mst_resource_area a on a.resource_area_id=si.state_area_id_resource_area_id where z.resource_zone_name like '%"+searchString+"%' or s.state_name like '%"+searchString+"%' or a.resource_area_name like '%"+searchString+"%'";
		String countQuery=StringUtils.replace(query, " * fr", " count(z.resource_zone_id) fr");
		List<MstResourceZone> list=entityManager.createNativeQuery(query,MstResourceZone.class).setFirstResult(((Integer.parseInt(page)-1)*Integer.parseInt(size))).setMaxResults(Integer.parseInt(size)).getResultList();
		BigInteger count=(BigInteger)entityManager.createNativeQuery(countQuery).getSingleResult();
		if(list.size()>0) {
			list.get(0).setCount(count.longValue());
		}
		return list;
	}


	@Override
	public MstResourceZone checkUniqueRecord(long stateAreaId, String resourceAreaName) {
		try {
		return (MstResourceZone) entityManager.createNativeQuery("select * from mst_resource_zone z inner join zone_state_id rz on z.resource_zone_id =rz.mst_resource_zone_resource_zone_id inner join mst_state s on rz.zone_state_id_state_id=s.state_id inner join state_area_id si on si.mst_state_state_id=s.state_id inner join mst_resource_area a on a.resource_area_id=si.state_area_id_resource_area_id  "+
				" where rz.zone_state_id_state_id="+stateAreaId+" and a.resource_area_name='"+resourceAreaName+"' and z.is_active=1 and s.is_active=1",MstResourceZone.class).getSingleResult();
		}catch(Exception e) {
			return null;
		}
}


	}


	

