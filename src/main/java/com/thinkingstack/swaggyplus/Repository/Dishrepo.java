package com.thinkingstack.swaggyplus.Repository;

import java.util.List;

import com.thinkingstack.swaggyplus.Entity.Dish;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Dishrepo extends JpaRepository<Dish, Long> {
    public List<Dish> findBydishName(String dishName);
}