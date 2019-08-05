package com.CTS.Project.Security;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.CTS.Project.Models.JwtUser;
import com.CTS.Project.Models.MstGroup;
import com.CTS.Project.Models.MstRole;
import com.CTS.Project.Models.ResourceRoleMap;


public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(List<ResourceRoleMap> resourceList) {
    	
    	List<MstGroup> mstGroup=new ArrayList<MstGroup>();
    	List<MstRole> mstRole=new ArrayList<MstRole>();
    	for(ResourceRoleMap obj:resourceList) {
    		if (!mstGroup.contains(obj.getMtRoleId().getRoleGroupID())) {
    			mstGroup.add(obj.getMtRoleId().getRoleGroupID());
    		}
    		if (!mstRole.contains(obj.getMtRoleId())) {
    			mstRole.add(obj.getMtRoleId());
    		}
    	}
    	
        return new JwtUser(
        		resourceList.get(0).getmResourceId().getResourceId(),
        		resourceList.get(0).getmResourceId().getLoginId(),
        		resourceList.get(0).getmResourceId().getResourceName(),
        		resourceList.get(0).getmResourceId().getBranchName(),
        		resourceList.get(0).getmResourceId().getPassword(),
                mapToGrantedAuthorities(mstGroup),mstRole);
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<MstGroup> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getGroupName().trim()))
                .collect(Collectors.toList());
    }
}
