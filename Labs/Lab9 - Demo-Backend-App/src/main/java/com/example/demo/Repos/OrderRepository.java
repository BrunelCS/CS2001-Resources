package com.example.demo.Repos;

import com.example.demo.Models.Order;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<Order,Long>{
	
}
