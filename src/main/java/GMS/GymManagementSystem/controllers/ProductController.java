/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GMS.GymManagementSystem.controllers;

import GMS.GymManagementSystem.models.Product;
import GMS.GymManagementSystem.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

import javax.validation.Valid;

/**
 *
 * @author Sai Rohith Gorla
 */
@Controller
@RequestMapping(path = "products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/add")
    public String addNewProductForm(Product product) {

        return "newProduct";
    }

    @PostMapping("/add")
    public String addProduct(@Valid Product product, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "newProduct";
        }

        productRepository.save(product);
        model.addAttribute("products", productRepository.findAll());

        return "productsList";
    }

    @GetMapping()
    public String addProducts(Model model) {

        model.addAttribute("products", productRepository.findAll());
        return "productsList";

    }

    @PostMapping("/buy")
    public String buyProducts(@ModelAttribute ArrayList<Product> values, BindingResult result, Model model) {

        model.addAttribute("products", productRepository.findAll());
        return "productsList";
    }
}
