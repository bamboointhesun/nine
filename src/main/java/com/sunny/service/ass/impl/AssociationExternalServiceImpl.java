package com.sunny.service.ass.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunny.model.system.AssociationExternal;
import com.sunny.service.ass.AssociationExternalService;
import com.sunny.utils.BaseService;

@Service
public class AssociationExternalServiceImpl extends BaseService implements AssociationExternalService {

	@Override
	public void deleteExternalBySponsorId(long sponsorId) {
		associationExternalMapperImpl.deleteByPrimaryKey(sponsorId);
	}

	@Override
	public List<AssociationExternal> displaySponsors() {
		List<AssociationExternal> sponsors = associationExternalMapperImpl.selectAllSponsors();
		return sponsors;
	}

	@Override
	public AssociationExternal findUpdateObject(long sponsorId) {
		AssociationExternal sponsor = associationExternalMapperImpl.selectByPrimaryKey(sponsorId);
		return sponsor;
	}

	@Override
	public void updateExternal(AssociationExternal sponsor) {
		associationExternalMapperImpl.updateByPrimaryKeySelective(sponsor);
	}

	@Override
	public void addSponor(AssociationExternal sponsor) {
		associationExternalMapperImpl.insertSelective(sponsor);
		
	}

	
	
}
