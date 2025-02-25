package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.CartItems;

import jakarta.transaction.Transactional;

@Repository
public interface CartRepository extends JpaRepository<CartItems, Integer> {


 
    // Fetch cart item for a given userId and productId
    @Query("SELECT c FROM CartItems c WHERE c.user.userId = :userId AND c.product.productId = :productId")
    Optional<CartItems> findByUserAndProduct(int userId, int productId);
 
    @Query("SELECT c FROM CartItems c JOIN FETCH c.product p LEFT JOIN FETCH ProductImage pi ON p.productId = pi.product.productId WHERE c.user.userId = :userId")
    List<CartItems> findCartItemsWithProductDetails(int userId);
 
    // Update quantity for a specific cart item
    @Query("UPDATE CartItems c SET c.quantity = :quantity WHERE c.id = :cartItemsId")
    void updateCartItemQuantity(int cartItemsId, int quantity);
 
    // Delete a product from the cart
    @Modifying
    @Transactional
    @Query("DELETE FROM CartItems c WHERE c.user.userId = :userId AND c.product.productId = :productId")
    void deleteCartItem(int userId, int productId);
 
    // Count the total quantity of items in the cart
    @Query("SELECT COALESCE(SUM(c.quantity), 0) FROM CartItems c WHERE c.user.userId = :userId")
    int countTotalItems(int userId);
    
    
    @Modifying
    @Transactional
    @Query("DELETE FROM CartItems c WHERE c.user.userId = :userId")
    void deleteAllCartItemsByUserId(int userId);
}
