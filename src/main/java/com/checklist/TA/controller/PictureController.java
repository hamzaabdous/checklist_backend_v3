package com.checklist.TA.controller;

import com.checklist.TA.bo.Picture;
import com.checklist.TA.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/Picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @PostMapping("/add")
    public Optional<Picture> add(@RequestBody Picture picture){
        //  Optional<UserDao> userCreated=userService.userSave(user);
        return pictureService.pictureSave(picture);

    }

    @GetMapping("/")
    public List<Picture> findAll(){
        List<Picture> pictures= pictureService.findAll();
        return pictures;
    }

    @PostMapping("/delete/{id}")
    public Optional<Picture> DeleteId(@PathVariable("id") Picture picture){
        return pictureService.DeleteId(picture);
    }

    @PutMapping("/update")
    public Optional<Picture>  UpdatePicture(@RequestBody Picture picture){
        return pictureService.UpdatePicture(picture);
    }

    @GetMapping("/count")
    public Long countPictures(){
        return pictureService.countPictures();
    }
}
