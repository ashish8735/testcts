package com.CTS.Project.Services;

public interface ChangePasswordService {

	String sendPasswordURL(String emailId);

	Boolean verifyUserByRefeshToken(String refToken);

	Boolean changePassword(String password, String refToken);

	Boolean emailAvailabilityCheck(String emailId);

}
