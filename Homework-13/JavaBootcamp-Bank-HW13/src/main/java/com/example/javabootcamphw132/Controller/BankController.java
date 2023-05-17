package com.example.javabootcamphw132.Controller;

import com.example.javabootcamphw132.ApiResponse.ApiResponse;
import com.example.javabootcamphw132.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customer")
public class BankController {

    ArrayList<Customer> customers=new ArrayList<>();

    // read - get

    @GetMapping("/get")
    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    // create - post

    @PostMapping("/add")
    public ApiResponse addCustomer(Customer customer){
        customers.add(customer);
        return new ApiResponse("customer added");
    }

    // update - Put

    @PutMapping("/update")
    public ApiResponse updateCustomer(@PathVariable int index,@RequestBody
    Customer customer){
        customers.set(index,customer);
        return new ApiResponse("customer updated");
    }

    // delete - Delete

    @DeleteMapping("/delete")
    public ApiResponse deleteCustomer(int index){
        customers.remove(index);
        return new ApiResponse("customer deleted");
    }

    // deposit

    @PostMapping("/deposit")
    public ApiResponse deposit(int id, @RequestParam double amount){
        Customer customer = customers.get(id);
        customer.setBalance(customer.getBalance()+amount);
        return new ApiResponse("money deposit");
    }

    // withdraw

    @PostMapping("/withdraw")
    public ApiResponse withdraw(int index, @RequestParam double amount){
        Customer customer=customers.get(index);
        if (customer.getBalance() >= amount){
            customer.setBalance(customer.getBalance()-amount);
        }
        return new ApiResponse("amount withdraw");
    }
}
