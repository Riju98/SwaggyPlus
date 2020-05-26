package com.thinkingstack.swaggyplus.Repository;

import java.util.List;

import com.thinkingstack.swaggyplus.Entity.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Resrepo extends JpaRepository<Restaurant, Integer> {
    public List<Restaurant> findByresNameContainingIgnoreCase(String resName);

    public List<Restaurant> findByDishes_dishNameContainingIgnoreCase(String restaurentName);
    public List<Restaurant> findByisActive(Boolean isActive);
    public Restaurant findByDishesContaining(Dishrepo dish);

}