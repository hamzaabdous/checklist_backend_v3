package com.checklist.TA.service.umpl;

import com.checklist.TA.bo.Picture;
import com.checklist.TA.repository.PictureRepository;
import com.checklist.TA.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service

public class PictureServiceUmpl implements PictureService {
    @Autowired
    private PictureRepository pictureRepository;

    @Override
    public Optional<Picture> pictureSave(Picture picture) {
        Date currentDate = new Date();
        picture.setCreatedDate(currentDate);
        return Optional.ofNullable(pictureRepository.save(picture));
    }

    @Override
    public List<Picture> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public Optional<Picture> DeleteId(Picture picture) {
        pictureRepository.deleteById(picture.getId());
        return Optional.ofNullable(picture);
    }

    @Override
    public Optional<Picture> UpdatePicture(Picture picture) {

        return Optional.ofNullable(pictureRepository.save(picture));
    }

    @Override
    public long countPictures() {
        return pictureRepository.count();
    }
}
