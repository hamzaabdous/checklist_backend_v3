package com.checklist.TA.controller;

import com.checklist.TA.bo.Damage;
import com.checklist.TA.bo.Picture;
import com.checklist.TA.message.ResponseMessage;
import com.checklist.TA.repository.PictureRepository;
import com.checklist.TA.service.PictureService;
import com.checklist.TA.util.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Picture")
public class PictureController {
    @Autowired
    PictureService storageService;
    @Autowired
    private PictureRepository pictureRepository;
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("damage") String damage, @RequestParam("description") String description) {
        String message = "";
        Date currentDate = new Date();
        Damage dm = new Damage();
        dm.setId(Long.parseLong(damage));

        try {
            pictureRepository.save(Picture.builder()
                    .name(file.getOriginalFilename())
                    .url(file.getOriginalFilename())
                    .description(description).damage(dm).createdDate(currentDate).build());
            storageService.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<Picture>> getListFiles() {
        List<Picture> fileInfos = storageService.loadAll().map(path -> {
           String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(PictureController.class, "getFile", path.getFileName().toString()).build().toString();

        return new Picture(filename, url);
      }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
