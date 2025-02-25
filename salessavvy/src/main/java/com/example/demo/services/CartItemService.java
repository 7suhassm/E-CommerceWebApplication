package com.example.demo.services;

import org.springframework.stereotype.Service
;

import com.example.demo.repositories.CartItemRepository;
import com.example.demo.repositories.UserRepository;
@Service
public class CartItemService {

	CartItemRepository cartItemRepository;
	UserRepository userRepository;
	public CartItemService(CartItemRepository cartItemRepository,UserRepository userRepository) {
	this.cartItemRepository=cartItemRepository;
	this.userRepository=userRepository;
	}
	public int getCartItemCount(int userId) {
	return cartItemRepository.countTotalItems(userId);
	}

}
