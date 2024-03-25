package ru.gb.graduation.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.graduation.model.Image;
import ru.gb.graduation.service.ImageService;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageRestController {
    private final ImageService imageService;
    @GetMapping("/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id){
        Image image = imageService.getImageById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamReader(new ByteArrayInputStream(image.getBytes())));
    }
}
