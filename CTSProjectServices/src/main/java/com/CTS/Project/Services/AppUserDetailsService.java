package com.CTS.Project.Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.CTS.Project.Models.ResourceRoleMap;
import com.CTS.Project.Models.RoleStageMap;
import com.CTS.Project.Security.JwtUserFactory;

/**
 * Created by nydiarra on 06/05/17.
 */
@Component
public class AppUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

		String groupQuery = "select * from mapping_resourcerole mr inner join mst_resource_pool r on mr.mst_resource_id=r.resource_id " + 
				"inner join mst_role rr on mr.mst_role_id=rr.role_id inner join mst_group g on rr.role_groupid=g.group_id " + 
				"where BINARY r.loginid='"+s+"' and mr.is_active=1 and r.is_active=1 and rr.is_active=1 and g.is_active=1 ";
				
		List<ResourceRoleMap> list = entityManager.createNativeQuery(groupQuery, ResourceRoleMap.class).getResultList();
		for(ResourceRoleMap obj:list) {
			if(obj.getMtRoleId().getRoleGroupID().getGroupName().trim().equalsIgnoreCase("administrator")) {
				break;
			}else {
				String stageCheckQuery="select * from mapping_rolestage mrs inner join mst_stage s on mrs.stage_id=s.s_id " + 
						"where  mrs.role_id="+obj.getMtRoleId().getRoleId()+" and mrs.is_active=1 and s.is_active=1 ";
				List<RoleStageMap> roleStagelist=entityManager.createNativeQuery(stageCheckQuery, RoleStageMap.class).getResultList();
				if(roleStagelist.size()==0) {
					list.clear();
				}
			}
			
		}
		
		
		
//		String query = "select * from mapping_resourcerole mr inner join mst_resource_pool r on mr.mst_resource_id=r.resource_id "
//				+ "inner join mst_role rr on mr.mst_role_id=rr.role_id inner join mst_group g on rr.role_groupid=g.group_id "
//				+ "inner join mapping_rolestage mrs on mrs.role_id=rr.role_id inner join mst_stage s on mrs.stage_id=s.s_id "
//				+ "where BINARY r.loginid='" + s
//				+ "' and mr.is_active=1 and r.is_active=1 and rr.is_active=1 and g.is_active=1 and mrs.is_active=1 and s.is_active=1 ";
//		@SuppressWarnings("unchecked")
//		List<ResourceRoleMap> user = entityManager.createNativeQuery(query, ResourceRoleMap.class).getResultList();
		
		return JwtUserFactory.create(list);
	}

}
