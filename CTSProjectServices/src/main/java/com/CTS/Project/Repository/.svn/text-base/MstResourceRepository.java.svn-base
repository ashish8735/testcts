package com.CTS.Project.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CTS.Project.Models.MstResourcePool;

@Repository
public interface MstResourceRepository extends JpaRepository<MstResourcePool, Long> {

	Page<MstResourcePool> findAllByResourceNameContainsOrRpResourceDesignationTypeIdResourceDesignationNameContainsOrDepartmentContainsOrEmailIdContainsOrDealerCodeContainsOrBranchNameContainsOrMobileNoContainsOrFaxContainsAndIsActiveTrue(
			String resourcename, String designation, String department, String email, String dealer, String branch,
			String mob, String fax, Pageable pageRequest);

	List<MstResourcePool> findAllByRpResourceTypeIdResourceTypeId(Long resource_type_id);

	@Query(value="select * from mst_resource_pool p where BINARY p.loginid=:lid",nativeQuery = true)
	MstResourcePool findByLoginIdContaining(@Param("lid") String lid);

	MstResourcePool findByResourceId(Long id);

}