package ru.gb.graduation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.graduation.model.Image;
import ru.gb.graduation.repository.ImageRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    public Optional<Image> getImageById (Long id){
        return imageRepository.findById(id);
    }
}
