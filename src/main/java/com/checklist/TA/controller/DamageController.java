package com.checklist.TA.controller;

import com.checklist.TA.bo.Damage;
import com.checklist.TA.service.DamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Damage")
public class DamageController {
    @Autowired
    private DamageService damageService;

    @PostMapping("/add")
    public Optional<Damage> add(@RequestBody Damage damage){
        //  Optional<UserDao> userCreated=userService.userSave(user);
        return damageService.damageSave(damage);

    }
    @PostMapping("/addList")
    public List<Damage> add(@RequestBody List<Damage> damages){
        //  Optional<UserDao> userCreated=userService.userSave(user);
        return damageService.damageSaveList(damages);
    }

    @GetMapping("/")
    public List<Damage> findAll(){
        List<Damage> damages= damageService.findAll();
        return damages;
    }

    @GetMapping("/getAllId")
    public List<Long> GetAllDamages(){
        List<Long> damages= damageService.GetAllDamages();
        return damages;
    }
    @PostMapping("/delete/{id}")
    public Optional<Damage> DeleteId(@PathVariable("id") Damage damage){
        return damageService.DeleteId(damage);
    }

    @PutMapping("/update")
    public Optional<Damage>  UpdateDamage(@RequestBody Damage damage){
        return damageService.UpdateDamage(damage);
    }

    @GetMapping("/count")
    public Long countDamages(){
        return damageService.countDamages();
    }

    @PostMapping("/FindDamageType/{id}")
    public List<Damage> FindDamageTypeByEquipmentID(@PathVariable("id") Long idEquipment){
        return damageService.FindDamageTypeByEquipmentID(idEquipment);
    }
    @PostMapping("/FindDamageTypeByEquipmentID/{equipement_id}/{damage_type_id}")
    public List<Damage> FindDamageTypeByEquipmentID(@PathVariable("equipement_id") Long equipement_id,@PathVariable("damage_type_id") Long damage_type_id){
        return damageService.FindDamageTypeByEquipmentIDandDamage_type_id(equipement_id,damage_type_id);
    }


}
