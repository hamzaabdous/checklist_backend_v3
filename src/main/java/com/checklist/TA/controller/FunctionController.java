package com.checklist.TA.controller;

import com.checklist.TA.bo.Function;
import com.checklist.TA.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/Function")
public class FunctionController {
    @Autowired
    private FunctionService functionService;

    @PostMapping("/add")
    public Optional<Function> add(@RequestBody Function function){
        //  Optional<UserDao> userCreated=userService.userSave(user);
        return functionService.functionSave(function);

    }

    @GetMapping("/")
    public List<Function> findAll(){
        List<Function> functions= functionService.findAll();
        return functions;
    }

    @PostMapping("/delete/{id}")
    public Optional<Function> DeleteId(@PathVariable("id") Function function){
        return functionService.DeleteId(function);
    }

    @PutMapping("/update")
    public Optional<Function>  UpdateFunction(@RequestBody Function function){
        return functionService.UpdateFunction(function);
    }

    @GetMapping("/count")
    public Long countFunctions(){
        return functionService.countFunctions();
    }
}
