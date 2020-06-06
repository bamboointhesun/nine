package com.sunny.service.system;


import com.sunny.model.system.WebUser;

public interface WebUserService {

	int loginService(String webLoginame, String webPassword);

	void registerService(WebUser webUser);
	
	WebUser findMyInformation(String webLoginame);
	
	void updateMyInformation(WebUser webUser);

}
