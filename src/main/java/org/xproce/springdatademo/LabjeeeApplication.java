package org.xproce.springdatademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xproce.springdatademo.dao.entities.product;
import org.xproce.springdatademo.dao.repositories.ProductRepository;

import java.util.Date;

@SpringBootApplication
public class LabjeeeApplication implements CommandLineRunner{
    @Autowired
    private ProductRepository productRepository ;

    public static void main(String[] args) {
        SpringApplication.run(LabjeeeApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        product produit= new product(1,"fufu","x",new Date(1996,02,13));
        productRepository.save(produit);
        produit= new product(2,"fufu","x",new Date(1996,02,13));

        product UpdatedById = productRepository.findById(1).get();
        System.out.println(UpdatedById);

        UpdatedById = productRepository.findById(1).get();
        productRepository.delete(UpdatedById);

        produit.setNom("dudu");
        productRepository.save(produit);

        try {
            System.out.println(productRepository.findById(1).get());
        } catch (Exception exception) {
            System.out.println("The product has been deleted");
        }
        System.out.println(produit);



    }
}
