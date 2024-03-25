package ru.gb.graduation.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.graduation.service.ProductService;

@Controller
@RequestMapping({"", "/"})
@RequiredArgsConstructor
public class MainController {
    private final ProductService productService;
    @GetMapping()
    public String index(Model model){
        model.addAttribute("products", productService.findAll());
        return "index";
    }
}
