package ru.gb.graduation.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.gb.graduation.model.Product;
import ru.gb.graduation.service.ProductService;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public String products(){
        return "products_create";
    }

    @PostMapping(value = "/create")
    public String createProduct(@RequestParam("files")MultipartFile[] files, Model model, Product product){
        Product savedProduct = productService.save(product, files);
        model.addAttribute("product", savedProduct);
        return "redirect:/cart";
    }
}
