package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import product.product;

public interface productRepository extends JpaRepository<product,long> {
}
