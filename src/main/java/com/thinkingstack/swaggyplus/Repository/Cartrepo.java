package com.thinkingstack.swaggyplus.Repository;

import com.thinkingstack.swaggyplus.Entity.Cart;
import com.thinkingstack.swaggyplus.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Cartrepo extends JpaRepository<Cart, Long> {
    public Cart findByuser(User u);
}