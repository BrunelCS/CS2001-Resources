package com.example.demo.Models;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="Orders")
@EntityListeners(AuditingEntityListener.class)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
    @Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date Date;

     @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="buyer")
    private User buyer;


    public Order() {
    }


    public Order(User buyer) {
        this.buyer = buyer;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Date getDate() {
        return Date;
    }


    public void setDate(Date date) {
        Date = date;
    }


    public User getBuyer() {
        return buyer;
    }


    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    
    


}
