package com.checklist.TA.service;

import com.checklist.TA.bo.Equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentService {
    public Optional<Equipment> equipmentSave (Equipment equipment);
    public List<Equipment> findAll();
    public Optional<Equipment>  DeleteId(Equipment equipment);
    public Optional<Equipment>  UpdateEquipment(Equipment equipment);
    public long countEquipments();
}
