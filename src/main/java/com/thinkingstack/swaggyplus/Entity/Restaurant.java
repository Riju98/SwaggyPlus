package com.thinkingstack.swaggyplus.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Restaurant {
    @Id // primary key
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer resId;

  private String resName;

  private String resAddress;

  private Integer rating;

  private Boolean isActive;

  @OneToMany(targetEntity = Dish.class, cascade = CascadeType.ALL)
  @JoinColumn(name="resId",referencedColumnName="resId")
  private List<Dish> dishes;



  public Integer getResId() {
    return resId;
  }

  public void setResId(Integer resId) {
    this.resId = resId;
  }

  public String getResName() {
    return resName;
  }

  public void setResName(String resName) {
    this.resName = resName;
  }

  public String getResAddress() {
    return resAddress;
  }

  public void setResAddress(String resAddress) {
    this.resAddress = resAddress;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public List<Dish> getDishes() {
    return dishes;
  }

  public void setDishes(List<Dish> dishes) {
    this.dishes = dishes;
  }

  public Restaurant(){

  }

  public Restaurant(Integer resId, String resName, String resAddress, Integer rating, Boolean isActive,
      List<Dish> dishes) {
    this.resId = resId;
    this.resName = resName;
    this.resAddress = resAddress;
    this.rating = rating;
    this.isActive = isActive;
    this.dishes = dishes;
  }

}