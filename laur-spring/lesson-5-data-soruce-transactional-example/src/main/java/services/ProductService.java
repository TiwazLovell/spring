package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional 
    // rollsback the RuntimeException but does not rollback the checked exception
    public void addOneProduct() {
//        right way
//        productRepository.addProduct("Wine");
//        throw new RuntimeException(":)");

////        wrong way
//        productRepository.addProduct("Whiskey");
//        try {
//            throw new RuntimeException(":(");
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        }
    }
}
