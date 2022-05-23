package com.checklist.TA.service;

import com.checklist.TA.bo.Picture;

import java.util.List;
import java.util.Optional;

public interface PictureService {
    public Optional<Picture> pictureSave (Picture picture);
    public List<Picture> findAll();
    public Optional<Picture>  DeleteId(Picture picture);
    public Optional<Picture>  UpdatePicture(Picture picture);
    public long countPictures();
}
