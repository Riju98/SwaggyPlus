package com.thinkingstack.swaggyplus.Repository;

import com.thinkingstack.swaggyplus.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepo extends JpaRepository<User,Integer> {
    
}

