package com.checklist.TA.controller;

import com.checklist.TA.bo.DamageType;
import com.checklist.TA.service.DamageTypeService;
import com.checklist.TA.vo.damage_damagetype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/DamageType")
public class DamageTypeController {
    @Autowired
    private DamageTypeService damageTypeService;

    @PostMapping("/add")
    public Optional<DamageType> add(@RequestBody DamageType damageType){
        //  Optional<UserDao> userCreated=userService.userSave(user);
        return damageTypeService.damageTypeSave(damageType);

    }

    @GetMapping("/")
    public List<DamageType> findAll(){
       // List<DamageType> damageTypes= damageTypeService.getAll();
        return damageTypeService.findAll();
    }
    @PostMapping("/getByProfile_group_id/{id}")
    public List<DamageType> getDamage_typesByProfile_group_id(@PathVariable("id") Long id){
        // List<DamageType> damageTypes= damageTypeService.getAll();
        return damageTypeService.getDamage_typesByProfile_group_id(id);
    }
    @PostMapping("/getAllByProfileGroupAndAndDepartmentAndEquipmentIN/{profile_group_id}/{department_id}/{equipement_id}")
    public List<DamageType> getAllByProfileGroupAndAndDepartmentAndEquipmentIN(@PathVariable("profile_group_id") Long profile_group_id, @PathVariable("department_id") Long department_id, @PathVariable("equipement_id")  Long equipement_id){

        return damageTypeService.getAllByProfileGroupAndAndDepartmentAndEquipmentIN(profile_group_id,department_id,equipement_id);
    }
    @PostMapping("/getAllByProfileGroupAndAndDepartmentAndEquipmentNOT/{profile_group_id}/{department_id}/{equipement_id}")
    public List<DamageType> getAllByProfileGroupAndAndDepartmentAndEquipmentNOT(@PathVariable("profile_group_id") Long profile_group_id,@PathVariable("department_id") Long department_id,@PathVariable("equipement_id")  Long equipement_id){
        return damageTypeService.getAllByProfileGroupAndAndDepartmentAndEquipmentNOT(profile_group_id,department_id,equipement_id);
    }
    @PostMapping("/delete/{id}")
    public Optional<DamageType> DeleteId(@PathVariable("id") DamageType damageType){
        return damageTypeService.DeleteId(damageType);
    }

    @PutMapping("/update")
    public Optional<DamageType>  UpdateDamageType(@RequestBody DamageType damageType){
        return damageTypeService.UpdateDamageType(damageType);
    }

    @GetMapping("/count")
    public Long countDamageTypes(){
        return damageTypeService.countDamageTypes();
    }
}
