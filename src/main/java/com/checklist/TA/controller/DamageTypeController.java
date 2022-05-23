package com.checklist.TA.controller;

import com.checklist.TA.bo.DamageType;
import com.checklist.TA.service.DamageTypeService;
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
        List<DamageType> damageTypes= damageTypeService.findAll();
        return damageTypes;
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
