package com.example.invoice.controller;

import com.example.invoice.entity.Client;
import com.example.invoice.entity.Product;
import com.example.invoice.entity.ProductCategory;
import com.example.invoice.service.ClientService;
import com.example.invoice.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String displayProductsPage(Model model) {
        List<Product> productList = productService.findAllProducts();
        model.addAttribute("products", productList);
        return "products";
    }

    @GetMapping("/add-product")
    public String displayProductForm() {
        return "add-product";
    }

    @PostMapping("/add-product")
    public String handleProductForm(@RequestParam String productName,
                                    @RequestParam String productDescription,
                                    @RequestParam String priceHt,
                                    @RequestParam String productCategory) {

      productService.addProductByForm(productName,productDescription,priceHt,new ProductCategory(productCategory));
        return "redirect:/products";
    }
}
