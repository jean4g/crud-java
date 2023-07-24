package repository;

import model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private List<Product> products = new ArrayList<Product>();
    private Integer lastId = 0;

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(Integer id) {
        return products
                .stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }

    public Product add(Product product) {

        lastId++;
        
        product.setId(lastId);
        products.add(product);

        return product;
    }
}
