package com.thinkingstack.swaggyplus.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import java.util.*;

@Entity
public class Cart {
    @Id
	@GeneratedValue
	private Long cartId;

	@OneToOne(targetEntity=User.class,cascade=CascadeType.ALL)
	@JoinColumn(name="userId",referencedColumnName="id")
	private User user;

	@ManyToMany(targetEntity = Dish.class, cascade = CascadeType.ALL)
	private List<Dish> dishes;
	private Double totalAmount;


	@OneToOne(targetEntity=Restaurant.class,cascade=CascadeType.ALL)
	@JoinColumn(name="restId",referencedColumnName="resId")
	private Restaurant restaurant;


	


	public Cart() {
		
	}
	public Long getcartId() {
		return cartId;
	}
	public void setcartId(Long cartId) {
		this.cartId = cartId;
	}
	public java.util.List<Dish> getdishes() {
		return dishes;
	}
	public void setdishes(List<Dish> dishes) {
		this.dishes = dishes;
	}
	public Double gettotalAmount() {
		return totalAmount;
	}
	public void settotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", dishes=" + dishes + ", totalAmount=" + totalAmount + ", user=" + user
				+ "]";
	}

	public Cart(Long cartId, User user, List<Dish> dishes, Double totalAmount, Restaurant restaurant) {
		this.cartId = cartId;
		this.user = user;
		this.dishes = dishes;
		this.totalAmount = totalAmount;
		this.restaurant = restaurant;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	
}