package com.sunny.service.system.impl;


import org.springframework.stereotype.Service;

import com.sunny.model.system.WebUser;
import com.sunny.service.system.WebUserService;
import com.sunny.utils.BaseService;

@Service
public class WebUserServiceImpl extends BaseService implements WebUserService {

	
	@Override
	public int loginService(String webLoginame, String webPassword) {
		int flag = 0; // 没有用户，返回0
		WebUser selectByLoginame = webUserMapperImpl.selectByLoginame(webLoginame);
		if (selectByLoginame != null) {
			/**
			 * 判断是否有此用户 有此用户则校验密码
			 */
			String dbPassword = selectByLoginame.getUserPassword();
			if (dbPassword.equals(webPassword)) {
				flag = 1; // 密码吻合则登录成功，返回1
			} else {
				flag = -1; // 登录失败，返回-1
			}
		}
		return flag;
	}

	@Override
	public void registerService(WebUser webUser) {
		webUserMapperImpl.insertSelective(webUser);
	}

	@Override
	public WebUser findMyInformation(String webLoginame) {
		WebUser webUser = webUserMapperImpl.selectByLoginame(webLoginame);
		return webUser;
	}

	@Override
	public void updateMyInformation(WebUser webUser) {
		webUserMapperImpl.updateByPrimaryKeySelective(webUser);
	}
	
}
