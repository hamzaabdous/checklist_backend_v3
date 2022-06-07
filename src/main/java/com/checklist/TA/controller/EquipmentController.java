package com.checklist.TA.controller;

import com.checklist.TA.bo.Equipment;
import com.checklist.TA.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/Equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/add")
    public Optional<Equipment> add(@RequestBody Equipment equipment){
        //  Optional<UserDao> userCreated=userService.userSave(user);
        return equipmentService.equipmentSave(equipment);

    }

    @GetMapping("/")
    public List<Equipment> findAll(){
        List<Equipment> equipments= equipmentService.findAll();
        return equipments;
    }

    @PostMapping("/delete")
    public Optional<Equipment> DeleteId(@RequestBody Equipment equipment){
        return equipmentService.DeleteId(equipment);
    }

    @PutMapping("/update")
    public Optional<Equipment>  UpdateEquipment(@RequestBody Equipment equipment){
        return equipmentService.UpdateEquipment(equipment);
    }

    @GetMapping("/count")
    public Long countEquipments(){
        return equipmentService.countEquipments();
    }
}
