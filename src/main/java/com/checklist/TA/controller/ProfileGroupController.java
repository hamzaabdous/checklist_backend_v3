package com.checklist.TA.controller;

import com.checklist.TA.bo.ProfileGroup;
import com.checklist.TA.service.ProfileGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/ProfileGroup")
public class ProfileGroupController {
    @Autowired
    private ProfileGroupService profileGroupService;

    @PostMapping("/add")
    public Optional<ProfileGroup> add(@RequestBody ProfileGroup profileGroup){
        //  Optional<UserDao> userCreated=userService.userSave(user);
        return profileGroupService.profileGroupSave(profileGroup);

    }

    @GetMapping("/")
    public List<ProfileGroup> findAll(){
        List<ProfileGroup> profileGroups= profileGroupService.findAll();
        return profileGroups;
    }

    @PostMapping("/delete/{id}")
    public Optional<ProfileGroup> DeleteId(@PathVariable("id") ProfileGroup profileGroup){
        return profileGroupService.DeleteId(profileGroup);
    }

    @PutMapping("/update")
    public Optional<ProfileGroup>  UpdateProfileGroup(@RequestBody ProfileGroup profileGroup){
        return profileGroupService.UpdateProfileGroup(profileGroup);
    }

    @GetMapping("/count")
    public Long countProfileGroups(){
        return profileGroupService.countProfileGroups();
    }
}
