package com.moeen.Mapping.Controller;

import com.moeen.Mapping.Entity.Customer;
import com.moeen.Mapping.Entity.Product;
import com.moeen.Mapping.Repository.CustomerRepository;
import com.moeen.Mapping.Repository.ProductRepository;
import com.moeen.Mapping.dto.OrderRequest;
import com.moeen.Mapping.dto.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest orderRequest)
    {
        return customerRepository.save(orderRequest.getCustomer());
    }
    @GetMapping("/allOrder")
    public List<Customer> findAllOrder()
    {
        return customerRepository.findAll();
    }
    @GetMapping("/joinInfo/{id}")
    public Customer getAllJoin(@PathVariable("id") Long id)
    {
        return customerRepository.getJoinInfo(id);
    }
    @GetMapping("/name/{id}")
    public Customer getCustomerName(@PathVariable("id") Long id)
    {
        return customerRepository.getCustomerName(id);
    }

}
