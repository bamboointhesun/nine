package com.sunny.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.sunny.dao.system.ActivityProMapper;
import com.sunny.dao.system.ApplyActivityMapper;
import com.sunny.dao.system.AssociationExternalMapper;
import com.sunny.dao.system.AssociationJobMapper;
import com.sunny.dao.system.AssociationMemberMapper;
import com.sunny.dao.system.AssociationProjectMapper;
import com.sunny.dao.system.AssociationResourceMapper;
import com.sunny.dao.system.AssociationSocialMapper;
import com.sunny.dao.system.CommentsMapper;
import com.sunny.dao.system.WebUserMapper;

public class BaseService {
	@Autowired
	protected WebUserMapper webUserMapperImpl;
	@Autowired
	protected AssociationMemberMapper associationMemberMapperImpl;
	@Autowired
	protected AssociationJobMapper associationJobMapperImpl;
	@Autowired
	protected AssociationResourceMapper associationResourceMapperImpl;
	@Autowired
	protected AssociationExternalMapper associationExternalMapperImpl;
	@Autowired
	protected AssociationProjectMapper associationProjectMapperImpl;
	@Autowired
	protected AssociationSocialMapper associationSocialMapperImpl;
	@Autowired
	protected ActivityProMapper activityProMapperImpl;
	@Autowired
	protected CommentsMapper commentsMapperImpl;
	@Autowired
	protected ApplyActivityMapper applyActivityMapperImpl;
}
