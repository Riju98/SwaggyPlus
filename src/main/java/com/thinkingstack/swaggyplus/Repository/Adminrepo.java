package com.thinkingstack.swaggyplus.Repository;

import com.thinkingstack.swaggyplus.Entity.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Adminrepo extends JpaRepository<Admin,Long>{
    
}