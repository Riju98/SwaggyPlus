package com.thinkingstack.swaggyplus.Entity;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dish {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long dish_id;

    private String dishName;

    private String description;

    private String img_url;

    private Boolean isVeg;

    private Boolean free_delivery;

	private Double price;
	
	public Dish() {
		
	}

	

	public Long getDish_id() {
        return dish_id;
    }

	public void setDish_id(long dish_id) {
		this.dish_id = dish_id;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public Boolean getIsVeg() {
		return isVeg;
	}

	public void setIsVeg(Boolean isVeg) {
		this.isVeg = isVeg;
	}

	public Boolean getFree_delivery() {
		return free_delivery;
	}

	public void setFree_delivery(Boolean free_delivery) {
		this.free_delivery = free_delivery;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Dish(Long dish_id, String dishName, String description, String img_url, Boolean isVeg, Boolean free_delivery,
			Double price) {
		this.dish_id = dish_id;
		this.dishName = dishName;
		this.description = description;
		this.img_url = img_url;
		this.isVeg = isVeg;
		this.free_delivery = free_delivery;
		this.price = price;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}



	public Optional<User> findById(Long dishId) {
		return null;
	}

	@Override
	public String toString() {
		return "Dish [description=" + description + ", dishName=" + dishName + ", dish_id=" + dish_id
				+ ", free_delivery=" + free_delivery + ", img_url=" + img_url + ", isVeg=" + isVeg + ", price=" + price
				+ "]";
	}

    }
    