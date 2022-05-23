package com.checklist.TA.service.umpl;

import com.checklist.TA.bo.ProfileGroup;
import com.checklist.TA.repository.ProfileGroupRepository;
import com.checklist.TA.service.ProfileGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ProfileGroupServiceUmpl implements ProfileGroupService {
    @Autowired
    private ProfileGroupRepository profileGroupRepository;

    @Override
    public Optional<ProfileGroup> profileGroupSave(ProfileGroup profileGroup) {
        Date currentDate = new Date();
        profileGroup.setCreatedDate(currentDate);
        return Optional.ofNullable(profileGroupRepository.save(profileGroup));
    }

    @Override
    public List<ProfileGroup> findAll() {
        return profileGroupRepository.findAll();
    }

    @Override
    public Optional<ProfileGroup> DeleteId(ProfileGroup profileGroup) {
        profileGroupRepository.deleteById(profileGroup.getId());
        return Optional.ofNullable(profileGroup);
    }

    @Override
    public Optional<ProfileGroup> UpdateProfileGroup(ProfileGroup profileGroup) {
        Date currentDate = new Date();
        profileGroup.setUpdateDate(currentDate);
        return Optional.ofNullable(profileGroupRepository.save(profileGroup));
    }

    @Override
    public long countProfileGroups() {
        return profileGroupRepository.count();
    }
}
