package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.CartItems;
@Repository
public interface CartItemRepository  extends JpaRepository<CartItems, Integer>{
	
	@Query("SELECT COALESCE(SUM(c.quantity), 0) FROM CartItems c WHERE c.user.userId = :userId")
    int countTotalItems(int userId);

}
