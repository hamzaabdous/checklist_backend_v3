package com.checklist.TA.service;

import com.checklist.TA.bo.Function;

import java.util.List;
import java.util.Optional;

public interface FunctionService {
    public Optional<Function> functionSave (Function function);
    public List<Function> findAll();
    public Optional<Function>  DeleteId(Function function);
    public Optional<Function>  UpdateFunction(Function function);
    public long countFunctions();
}
