package com.CTS.Project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CTS.Project.Models.MstResourceZone;

@Repository
public interface MstResourceZoneRepository extends JpaRepository<MstResourceZone,Long> {
	Page<MstResourceZone> findAllByResourceZoneNameContainsOrResourceZoneDescriptionContainsAndIsActiveTrue(String name,String des,Pageable pageRequest);
	
//	@Query(value ="select * from mst_resource_zone z inner join zone_state_id rz on z.resource_zone_id =rz.mst_resource_zone_resource_zone_id inner join mst_state s on rz.zone_state_id_state_id=s.state_id inner join state_area_id si on si.mst_state_state_id=s.state_id inner join mst_resource_area a on a.resource_area_id=si.state_area_id_resource_area_id where z.resource_zone_name like %:sd% or s.state_name like %:sd% or a.resource_area_name like %:sd%   \n#pageable\n",countQuery = "select count(*) from mst_resource_zone z inner join zone_state_id rz on z.resource_zone_id =rz.mst_resource_zone_resource_zone_id inner join mst_state s on rz.zone_state_id_state_id=s.state_id inner join state_area_id si on si.mst_state_state_id=s.state_id inner join mst_resource_area a on a.resource_area_id=si.state_area_id_resource_area_id where z.resource_zone_name like %:sd% or s.state_name like %:sd% or a.resource_area_name like %:sd% ", nativeQuery = true)
//	Page<MstResourceZone>findAllByResourceAreaNameContainsOrResourceAreaDescriptionContainsAndIsActiveTrue(@Param("sd") String sd, Pageable page);

}
