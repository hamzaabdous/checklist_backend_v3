package com.checklist.TA.service.umpl;

import com.checklist.TA.bo.Equipment;
import com.checklist.TA.repository.EquipmentRepository;
import com.checklist.TA.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service

public class EquipmentServiceUmpl implements EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public Optional<Equipment> equipmentSave(Equipment equipment) {
        Date currentDate = new Date();
        equipment.setCreatedDate(currentDate);
        return Optional.ofNullable(equipmentRepository.save(equipment));
    }

    @Override
    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    @Override
    public Optional<Equipment> DeleteId(Equipment equipment) {
        equipmentRepository.deleteById(equipment.getId());
        return Optional.ofNullable(equipment);
    }

    @Override
    public Optional<Equipment> UpdateEquipment(Equipment equipment) {
        Date currentDate = new Date();
        equipment.setUpdateDate(currentDate);
        return Optional.ofNullable(equipmentRepository.save(equipment));
    }

    @Override
    public long countEquipments() {
        return equipmentRepository.count();
    }
}
