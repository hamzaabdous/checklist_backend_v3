package com.checklist.TA.service.umpl;

import com.checklist.TA.bo.Function;
import com.checklist.TA.repository.FunctionRepository;
import com.checklist.TA.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FunctionServiceUmpl implements FunctionService {

    @Autowired
    private FunctionRepository functionRepository;

    @Override
    public Optional<Function> functionSave(Function function) {
        Date currentDate = new Date();
        function.setCreatedDate(currentDate);
        return Optional.ofNullable(functionRepository.save(function));
    }

    @Override
    public List<Function> findAll() {
        return functionRepository.findAll();
    }

    @Override
    public Optional<Function> DeleteId(Function function) {
        functionRepository.deleteById(function.getId());
        return Optional.ofNullable(function);
    }

    @Override
    public Optional<Function> UpdateFunction(Function function) {
        Date currentDate = new Date();
        function.setUpdateDate(currentDate);
        return Optional.ofNullable(functionRepository.save(function));
    }

    @Override
    public long countFunctions() {
        return functionRepository.count();
    }
}
