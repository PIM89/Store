package ru.gb.graduation.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.gb.graduation.model.Image;
import ru.gb.graduation.model.Product;
import ru.gb.graduation.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    @Value("${application.maxImagesDownload:1}")
    private Integer maxImagesDownload;

    public Product save(Product product, MultipartFile... files) {
        int i = 0;
        List<Image> imageList = new ArrayList<>();
        for (MultipartFile multipartFile : files) {
            if (multipartFile.getSize() != 0 || i <= maxImagesDownload) {
                try {
                    Image image = toImageEntity(multipartFile);
                    image.setProduct(product);
                    if (i == 0) image.setPreviewImages(true);
                    imageList.add(image);
                    i++;
                    log.info("Сохранение {} товара", i);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        product.setImages(imageList);
        Product saveProduct = productRepository.save(product);
        saveProduct.setPreviewImageId(saveProduct.getImages().getFirst().getId());
        return productRepository.save(saveProduct);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setOriginalFileName(file.getOriginalFilename());
        image.setName(file.getName());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
