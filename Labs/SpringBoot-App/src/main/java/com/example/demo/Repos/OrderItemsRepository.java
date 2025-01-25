package com.example.demo.Repos;

import com.example.demo.Models.OrderItem;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface OrderItemsRepository extends CrudRepository<OrderItem,Long>{
    @Query("SELECT SUM(o.price_at_order * o.quantity) FROM OrderItem o WHERE o.order.id = :order_id") 
    Double sumOrderItemsByOrderIdParams( @Param("order_id") Long order_id);	
}
