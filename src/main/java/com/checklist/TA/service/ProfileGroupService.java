package com.checklist.TA.service;

import com.checklist.TA.bo.ProfileGroup;

import java.util.List;
import java.util.Optional;

public interface ProfileGroupService {
    public Optional<ProfileGroup> profileGroupSave (ProfileGroup profileGroup);
    public List<ProfileGroup> findAll();
    public Optional<ProfileGroup>  DeleteId(ProfileGroup profileGroup);
    public Optional<ProfileGroup>  UpdateProfileGroup(ProfileGroup profileGroup);
    public long countProfileGroups();
}
