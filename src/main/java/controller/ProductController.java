package controller;


import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;
import product.product;
import dao.productRepository;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/products")

public class ProductController {
    private final product_service product_service;
    @Autowired

    private productRepository ProductRepository;

    @PostMapping
    public product addproduct(@RequestBody product product){
        return productRepository.save(product);
    }
    @GetMapping("/id")
    public product getProductByID(@PathVariable product product){
        return productRepository.findById(Id).orElse(null);
    }
    @GetMapping
    public product getAllProducts(){
        return productRepository.findAll();
    }
    @PutMapping("/id")
    public product updateproduct(@PathVariable Long ID,@RequestBody product updateproduct){
        if(productRepository.existById(id)){
          updateproduct.setId(id);
            return productRepository.save(product);
        }
        else {
            return  null;
        }

}
@DeleteMapping("/id")
    public product deleteproduct(@PathVariable long id){
        productRepository.deleteByid(id);
}

}
