package com.moeen.Mapping.Repository;

import com.moeen.Mapping.Entity.Customer;
import com.moeen.Mapping.dto.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "SELECT * FROM customer WHERE customer_id=:n",nativeQuery = true)
    public Customer getJoinInfo(@Param("n") Long id);
    @Query(value="SELECT customer_name  FROM customer WHERE customer_id=:n",nativeQuery = true)
    public Customer getCustomerName(@Param("n")Long id);

}
