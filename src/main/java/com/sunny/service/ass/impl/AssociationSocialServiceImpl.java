package com.sunny.service.ass.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunny.model.system.AssociationSocial;
import com.sunny.service.ass.AssociationSocialService;
import com.sunny.utils.BaseService;

@Service
public class AssociationSocialServiceImpl extends BaseService implements AssociationSocialService {

	@Override
	public List<AssociationSocial> displaySocials() {
		List<AssociationSocial> socials = associationSocialMapperImpl.selectAllSocials();
		return socials;
	}

	@Override
	public void deleteSocialBySocialId(long socialId) {
		associationSocialMapperImpl.deleteByPrimaryKey(socialId);
	}

	@Override
	public AssociationSocial findUpdateObject(long socialId) {
		AssociationSocial social = associationSocialMapperImpl.selectByPrimaryKey(socialId);
		return social;
	}

	@Override
	public void updateSocial(AssociationSocial social) {
		associationSocialMapperImpl.updateByPrimaryKeySelective(social);
	}

	@Override
	public void addSocial(AssociationSocial social) {
		associationSocialMapperImpl.insertSelective(social);
	}

}
