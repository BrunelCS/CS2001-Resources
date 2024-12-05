package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Table;

@Entity
@Table(name="OrderItems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Order_id")
    Order order;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Seller_Produce")
    SellerProduce seller_produce;

    @NotNull
    Integer quantity;

    @NotNull
    Double price_at_order;

    public OrderItem() {
    }

    public OrderItem(SellerProduce seller_produce, @NotNull Integer quantity, @NotNull Double price_at_order) {
        this.seller_produce = seller_produce;
        this.quantity = quantity;
        this.price_at_order = price_at_order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SellerProduce getSeller_produce() {
        return seller_produce;
    }

    public void setSeller_produce(SellerProduce seller_produce) {
        this.seller_produce = seller_produce;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice_at_order() {
        return price_at_order;
    }

    public void setPrice_at_order(Double price_at_order) {
        this.price_at_order = price_at_order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    

}
