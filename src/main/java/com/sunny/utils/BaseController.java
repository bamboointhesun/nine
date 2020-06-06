package com.sunny.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.sunny.service.system.WebUserService;
import com.sunny.service.ass.AssociationExternalService;
import com.sunny.service.ass.AssociationJobService;
import com.sunny.service.ass.AssociationMemberService;
import com.sunny.service.ass.AssociationResourceService;

public class BaseController {
	@Autowired
	public WebUserService webUserServiceImpl;
	@Autowired
	protected AssociationMemberService associationMemberServiceImpl;
	@Autowired
	protected AssociationJobService associationJobServiceImpl;
	@Autowired
	protected AssociationResourceService associationResourceServiceImpl;
	@Autowired
	protected AssociationExternalService associationExternalServiceImpl;
}
