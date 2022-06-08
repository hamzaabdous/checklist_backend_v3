package com.checklist.TA.controller;

import com.checklist.TA.bo.User;
import com.checklist.TA.repository.FunctionRepository;
import com.checklist.TA.service.JwtUserDetailsService;
import com.checklist.TA.service.UserService;
import com.checklist.TA.vo.ReturnredValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private FunctionRepository functionRepository;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    ReturnredValue returnredValue;

    @PostMapping("/add")
    public ReturnredValue add(@RequestBody User user) throws JsonProcessingException {
        System.err.println( user);
        HashMap<String, String> map = new HashMap<>();
        user.setPassword("123");
        Date currentDate = new Date();
        user.setCreatedDate(currentDate);
      //  if(functionRepository.findById(user.getFunction().getId()).isEmpty()){
           // returnredValue=new ReturnredValue("users_add_function_404","The function does not exist !");

          //  return returnredValue;
      //  }
         returnredValue=new ReturnredValue("users_add_200",userDetailsService.save(user));

        return returnredValue;

    }

    @GetMapping("/")
    public ReturnredValue findAll(){
        List<User> users = userService.findAll();
        returnredValue=new ReturnredValue("users_index_200",users);
        return returnredValue;
    }

    @PostMapping("/delete")
    public ReturnredValue Delete(@RequestBody User user){
        userService.Delete(user);
        ReturnredValue returnredValue=new ReturnredValue("users_delete_200",user);
        return returnredValue;
    }

    @PutMapping("/update")
    public ReturnredValue UpdateUser(@RequestBody User user){
        userService.UpdateUser(user);
        returnredValue=new ReturnredValue("users_delete_200",user);
        return returnredValue;
    }

    @PutMapping("/passwordChange")
    public ReturnredValue  changePassword(@RequestBody User user)
    {
        userService.changePassword(user);
        returnredValue=new ReturnredValue("users_delete_200",user);
        return returnredValue;
    }

    @GetMapping("/count")
    public ReturnredValue countUsers(){

        returnredValue=new ReturnredValue("users_count_200",userService.countUsers());
        return returnredValue;
    }


}
