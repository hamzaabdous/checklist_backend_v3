package com.checklist.TA.controller;

import com.checklist.TA.bo.Damage;
import com.checklist.TA.bo.Picture;
import com.checklist.TA.repository.PictureRepository;
import com.checklist.TA.util.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Picture")
public class PictureController {
    @Autowired
    private PictureRepository pictureRepository;

    @PostMapping("/upload/image")

    public ResponseEntity<ImageUploadResponse> uplaodImage(@RequestParam("image") MultipartFile file, @RequestParam("damage") String damage, @RequestParam("description") String description)
            throws IOException {
        System.out.println(description);
        Date currentDate = new Date();
        Damage dm = new Damage();
        dm.setId(Long.parseLong(damage));
        pictureRepository.save(Picture.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).description(description).damage(dm).createdDate(currentDate).build());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse("Image uploaded successfully: " +
                        file.getOriginalFilename()));
    }

    @GetMapping(path = {"/get/image/info/{name}"})
    public Picture getImageDetails(@PathVariable("name") String name) throws IOException {

        final Optional<Picture> dbImage = pictureRepository.findByName(name);

        return Picture.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(ImageUtility.decompressImage(dbImage.get().getImage())).build();
    }

    @GetMapping(path = {"/get/image/{name}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {

        final Optional<Picture> dbImage = pictureRepository.findByName(name);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(ImageUtility.decompressImage(dbImage.get().getImage()));
    }
}
