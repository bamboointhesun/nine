package com.sunny.service.ass;

import java.util.List;

import com.sunny.model.system.AssociationExternal;

public interface AssociationExternalService {

	void deleteExternalBySponsorId(long sponsorId);
	
	List<AssociationExternal> displaySponsors();

	AssociationExternal findUpdateObject(long sponsorId);

	void updateExternal(AssociationExternal sponsor);

	void addSponor(AssociationExternal sponsor);
}
