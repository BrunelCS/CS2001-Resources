package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class SellerProduce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="seller")
    private User seller;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="produce")
    private Produce produce;

    @NotNull
    private Double price;

    @NotNull
    private Integer quantity;

    public SellerProduce(){
        super();
    }

    public SellerProduce(User seller, Produce produce, @NotNull Double price, @NotNull Integer quantity) {
        this.seller = seller;
        this.produce = produce;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Produce getProduce() {
        return produce;
    }

    public void setProduce(Produce produce) {
        this.produce = produce;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SellerProduce [id=" + id + ", seller=" + seller.name + ", produce=" + produce.name + ", price=" + price
                + ", quantity=" + quantity + "]";
    }

    


}
