package com.checklist.TA.service.umpl;

import com.checklist.TA.bo.Damage;
import com.checklist.TA.repository.DamageRepository;
import com.checklist.TA.service.DamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DamageServiceUmpl implements DamageService {
    @Autowired
    private DamageRepository damageRepository;

    @Override
    public Optional<Damage> damageSave(Damage damage) {
        Date currentDate = new Date();
        damage.setCreatedDate(currentDate);
        return Optional.ofNullable(damageRepository.save(damage));
    }

    @Override
    public List<Damage> findAll() {
        return damageRepository.findAll();
    }

    @Override
    public Optional<Damage> DeleteId(Damage damage) {
        damageRepository.deleteById(damage.getId());
        return Optional.ofNullable(damage);
    }

    @Override
    public Optional<Damage> UpdateDamage(Damage damage) {
        Date currentDate = new Date();
        damage.setUpdateDate(currentDate);
        return Optional.ofNullable(damageRepository.save(damage));
    }

    @Override
    public long countDamages() {
        return damageRepository.count();
    }

    @Override
    public List<Damage> FindDamageTypeByEquipmentID(Long idEquipment) {
        return damageRepository.FindDamageTypeByEquipmentID(idEquipment);
    }
}
