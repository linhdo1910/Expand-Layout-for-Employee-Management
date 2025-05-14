package com.example.models;

import java.util.ArrayList;

public class ListCategory {
    private ArrayList<Category> categories;

    public ListCategory() {
        categories = new ArrayList<>();
    }

    public void addCategory(Category c) {
        categories.add(c);
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void generate_sample_dataset() {
        addCategory(new Category(1, "Food"));
        addCategory(new Category(2, "Toys"));
        addCategory(new Category(3, "Accessories"));
        addCategory(new Category(4, "Hygiene"));
        addCategory(new Category(5, "Healthcare"));
        addCategory(new Category(6, "Housing"));
    }
}
