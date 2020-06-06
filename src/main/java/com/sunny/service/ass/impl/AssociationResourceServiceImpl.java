package com.sunny.service.ass.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunny.model.system.AssociationResource;
import com.sunny.service.ass.AssociationResourceService;
import com.sunny.utils.BaseService;

@Service
public class AssociationResourceServiceImpl extends BaseService implements AssociationResourceService {

	@Override
	public List<AssociationResource> displayResources() {
		List<AssociationResource> resources = associationResourceMapperImpl.selectAllResources();
		return resources;
	}

	@Override
	public void deleteResourceByResourceId(long resourceId) {
		associationResourceMapperImpl.deleteByPrimaryKey(resourceId);
	}

	@Override
	public AssociationResource findUpdateObject(long resourceId) {
		AssociationResource resource = associationResourceMapperImpl.selectByPrimaryKey(resourceId);
		return resource;
	}

	@Override
	public void updateResource(AssociationResource resource) {
		associationResourceMapperImpl.updateByPrimaryKeySelective(resource);
	}

	@Override
	public void addResource(AssociationResource resource) {
		associationResourceMapperImpl.insertSelective(resource);
	}

	
}
