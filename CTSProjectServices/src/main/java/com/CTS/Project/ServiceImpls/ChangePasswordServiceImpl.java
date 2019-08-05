package com.CTS.Project.ServiceImpls;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.CTS.Project.Models.MstResourcePool;
import com.CTS.Project.Repository.MstResourceRepository;
import com.CTS.Project.Security.Emailsend;
import com.CTS.Project.Security.PasswordUtil;
import com.CTS.Project.Services.ChangePasswordService;

@Service
public class ChangePasswordServiceImpl implements ChangePasswordService{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	Emailsend emailsend;
	
	@Autowired
	MstResourceRepository mstResourceRepository;
	
	@Value("${spring.change-password}")
	String changePassworURL;


	@Override
	public String sendPasswordURL(String emailId) {
		try{
		   MstResourcePool userObj=entityManager.createQuery("select p from MstResourcePool p where p.emailId='"+emailId+"' and p.isActive=1 ",MstResourcePool.class).getSingleResult();
		   if(userObj!=null) {
			   String subject="CTS Change Password";
			   String refreshToken=UUID.randomUUID().toString();
			   userObj.setRefreshToken(refreshToken);
			   mstResourceRepository.save(userObj);
			   String body=" Hello "+userObj.getResourceName()+", \r\n\r\n Password Reset Link:"+changePassworURL+refreshToken;
			   if(emailsend.sendSimpleMessage(userObj.getEmailId(),null,null,subject,body)) {
				   return "success";
			   }else {
				   return "fail";
			   }
		   }else {
			   return "fail";
		   }
		}catch (Exception e) {
			System.out.println("-----------"+e.getMessage());
			return "fail";
		}
		
	}

	@Override
	public Boolean verifyUserByRefeshToken(String refToken) {
	 try{
		 MstResourcePool obj=entityManager.createQuery("select p from MstResourcePool p where p.refreshToken='"+refToken+"'",MstResourcePool.class).getSingleResult();
		 if(obj!=null) {
			 return true;
		 }else {
			 return false;
		 }
	 }catch (Exception e) {
		 System.out.println("varify user error:----"+e.getMessage());
		 return false;
	 }
	}

	@Override
	public Boolean changePassword(String password, String refToken) {
		 try{
			 MstResourcePool obj=entityManager.createQuery("select p from MstResourcePool p where p.refreshToken='"+refToken+"'",MstResourcePool.class).getSingleResult();
			 if(obj!=null) {
				 obj.setPassword(PasswordUtil.getPasswordHash(password));
				 obj.setRefreshToken(null);
				 mstResourceRepository.save(obj);
				 return true;
			 }else {
				 return false;
			 }
		 }catch (Exception e) {
			 System.out.println("varify user error:----"+e.getMessage());
			 return false;
		 }
	}

	@Override
	public Boolean emailAvailabilityCheck(String emailId) {
		 try{
			 MstResourcePool obj=entityManager.createQuery("select p from MstResourcePool p where p.emailId='"+emailId+"'",MstResourcePool.class).getSingleResult();
			 if(obj!=null) {
				 return true;
			 }else {
				 return false;
			 }
		 }catch (Exception e) {
			 System.out.println("varify user error:----"+e.getMessage());
			 return false;
		 }
	}
}