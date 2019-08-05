package com.CTS.Project.ServiceImpls;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.CTS.Project.Models.MstResourceZone;
import com.CTS.Project.Models.MstState;
import com.CTS.Project.Repository.MstStateRepository;
import com.CTS.Project.Services.MstStateService;

@Service
public class MstStateServiceImpl implements MstStateService {
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	MstStateRepository stateRepo;

	@Override
	public Page<MstState> findAllRecords(PageRequest pageRequest) {
		return stateRepo.findAll(pageRequest);

	}

	@Override
	public Page<MstState> completeSearch(String searchString, Pageable pageRequest) {

		return stateRepo.findAllByStateNameContainsOrAbbreviationContainsAndIsActiveTrue(searchString, searchString,
				pageRequest);

	}

	@Override
	public void save(MstState state) {
		stateRepo.save(state);

	}

	@Override
	public List<MstState> saveAll(List<MstState> state) {
		return stateRepo.saveAll(state);
	}

	@Override
	public void deleteById(Long stateId) {
		stateRepo.deleteById(stateId);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MstResourceZone> findAllByZoneRecords(String page, String size, String sort, String col) {
		String query = "select * from mst_resource_zone z inner join zone_state_id rz on z.resource_zone_id =rz.mst_resource_zone_resource_zone_id inner join mst_state s on rz.zone_state_id_state_id=s.state_id where z.is_active=1 and s.is_active=1";
		String countQuery = StringUtils.replace(query, " * fr", " count(z.resource_zone_id) fr");
		List<MstResourceZone> list = entityManager.createNativeQuery(query, MstResourceZone.class)
				.setFirstResult(((Integer.parseInt(page) - 1) * Integer.parseInt(size)))
				.setMaxResults(Integer.parseInt(size)).getResultList();
		BigInteger count = (BigInteger) entityManager.createNativeQuery(countQuery).getSingleResult();
		if (list.size() > 0) {
			list.get(0).setCount(count.longValue());
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MstResourceZone> completeSearch(String page, String size, String searchString, String col,
			String col2) {
		String query = "select * from mst_resource_zone z inner join zone_state_id rz on z.resource_zone_id =rz.mst_resource_zone_resource_zone_id inner join mst_state s on rz.zone_state_id_state_id=s.state_id  where z.resource_zone_name like '%"
				+ searchString + "%' or s.state_name like '%" + searchString + "%'";
		String countQuery = StringUtils.replace(query, " * fr", " count(z.resource_zone_id) fr");
		List<MstResourceZone> list = entityManager.createNativeQuery(query, MstResourceZone.class)
				.setFirstResult(((Integer.parseInt(page) - 1) * Integer.parseInt(size)))
				.setMaxResults(Integer.parseInt(size)).getResultList();
		BigInteger count = (BigInteger) entityManager.createNativeQuery(countQuery).getSingleResult();
		if (list.size() > 0) {
			list.get(0).setCount(count.longValue());
		}
		return list;
	}

	
	/*
	 * @Override public MstResourceZone checkUniqueRecord(long zoneStateId, String
	 * stateName) { try { return (MstResourceZone) entityManager.
	 * createNativeQuery("select * from mst_resource_zone z inner join zone_state_id rz on z.resource_zone_id =rz.mst_resource_zone_resource_zone_id inner join mst_state s on rz.zone_state_id_state_id=s.state_id"
	 * + "where rz.zone_state_id_state_id="+zoneStateId+" and "+
	 * "s.state_name='"+stateName+"' and z.is_active=1 and"+
	 * "s.is_active=1",MstResourceZone.class).getSingleResult(); }catch(Exception e)
	 * { return null; } }
	 */
	@Override
	public MstResourceZone checkUniqueRecord(long zoneId, String stateName) {
		try {
			  return (MstResourceZone) entityManager.
	  createNativeQuery("select * from mst_resource_zone z inner join zone_state_id rz on z.resource_zone_id =rz.mst_resource_zone_resource_zone_id inner join mst_state s on rz.zone_state_id_state_id=s.state_id "
	  + " where z.resource_zone_id="+zoneId+" and "+
	  " s.state_name='"+stateName+"' and z.is_active=1 and "+
	  " s.is_active=1",MstResourceZone.class).getSingleResult();
	  }catch(Exception e) {
			return null;
		}
	}
	  
	 

}