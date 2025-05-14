package com.example.models;

import java.util.ArrayList;

public class ListCustomer {
    private ArrayList<Customer>customers;

    public ListCustomer() {
        customers=new ArrayList<>();
    }
    public void addCustomer(Customer c)
    {
        customers.add(c);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
    public void generate_sample_dataset()
    {
        addCustomer(new Customer(1,"Teo","teo@gmail.com","0123456788","teo","123"));
        addCustomer(new Customer(2,"Ti","ti@gmail.com","0123453234","ti","456"));
        addCustomer(new Customer(3,"To","to@gmail.com","0123456789","to","789"));
        addCustomer(new Customer(4,"Hong","hong@gmail.com","0123453789","hong","987"));
        addCustomer(new Customer(5,"An","an@gmail.com","0123446789","an","654"));
        addCustomer(new Customer(6,"Trinh","trinh@gmail.com","0113456789","trinh","321"));
        addCustomer(new Customer(7,"Linh","linh@gmail.com","0153456789","linh","112"));
        addCustomer(new Customer(8,"Khoa","khoa@gmail.com","0123656789","khoa","113"));
        addCustomer(new Customer(9,"Minh","minh@gmail.com","0123756789","minh","115"));
        addCustomer(new Customer(10,"Hoang","hoang@gmail.com","0193456789","hoang","133"));
    }
}
