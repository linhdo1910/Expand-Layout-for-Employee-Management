package com.example.models;

import java.util.ArrayList;

public class ListProduct {
    private ArrayList<Product> products;

    public ListProduct() {
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void generate_sample_dataset() {

        addProduct(new Product(1, "Dog Food", 50, 200_000, 1));       // Food
        addProduct(new Product(2, "Cat Litter", 40, 150_000, 1));     // Food
        addProduct(new Product(3, "Dog Toy", 100, 80_000, 2));        // Toys
        addProduct(new Product(4, "Pet Collar", 60, 70_000, 3));      // Accessories
        addProduct(new Product(5, "Pet Shampoo", 30, 120_000, 4));    // Hygiene
        addProduct(new Product(6, "Vitamin Supplements", 25, 90_000, 5)); // Healthcare
        addProduct(new Product(7, "Rabbit Hutch", 15, 850_000, 6));   // Housing
        addProduct(new Product(8, "Fish Tank", 20, 650_000, 6));      // Housing
        addProduct(new Product(9, "Bird Cage", 18, 500_000, 6));      // Housing
        addProduct(new Product(10, "Turtle Food", 35, 100_000, 1));   // Food
    }
}
