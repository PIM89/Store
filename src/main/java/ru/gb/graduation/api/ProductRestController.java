package ru.gb.graduation.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.graduation.repository.ProductRepository;

@RestController
@RequestMapping("/product-info")
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductRepository productRepository;
    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id){
        return productRepository.findById(id)
                .map(it -> ResponseEntity.ok(it))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
