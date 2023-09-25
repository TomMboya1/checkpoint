package service;

import dao.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class product_service {
    @Service
    public class ProductService {
        private final productRepository productRepository;

        @Autowired
        public ProductService(productRepository productRepository) {
            this.productRepository = productRepository;
        }

        public product addProduct(Product product) {
            // Add custom validation logic here if needed
            return productRepository.save(product);
        }

        public Product getProductById(Long id) {
            Optional<Product> product = productRepository.findById(id);
            return product.orElse(null);
        }

        public List<Product> getAllProducts() {
            return productRepository.findAll();
        }

        public Product updateProduct(Long id, Product updatedProduct) {
            if (productRepository.existsById(id)) {
                updatedProduct.setId(id);
                return productRepository.save(updatedProduct);
            } else {
                return null; // Handle not found case
            }
        }

        public void deleteProduct(Long id) {
            productRepository.deleteById(id);
        }
    }
}
