package com.sunny.service.ass;

import java.util.List;

import com.sunny.model.system.AssociationResource;

public interface AssociationResourceService {


	List<AssociationResource> displayResources();

	void deleteResourceByResourceId(long resourceId);

	AssociationResource findUpdateObject(long resourceId);

	void updateResource(AssociationResource resource);

	void addResource(AssociationResource resource);
	
}
