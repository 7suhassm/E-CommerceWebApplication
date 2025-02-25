package com.example.demo.entities;

import java.time.LocalDateTime;


import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Role role;
	@Column
	private LocalDateTime createdAt= LocalDateTime.now();
	@Column
	private LocalDateTime updatedAt= LocalDateTime.now();
	// for mapping of items to userid and updating cart//
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	List<CartItems> cart_items = new ArrayList<>();

	public User() {
		// TODO Auto-generated constructor stub
		super();
	}

	public User(int userId, String username, String email, String password, Role role, LocalDateTime createdAt,
			LocalDateTime updatedAt, List<CartItems> cart_items) {
		
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	this.cart_items = cart_items;
	}

	public User(String username, String email, String password, Role role, LocalDateTime createdAt,
			LocalDateTime updatedAt	, List<CartItems> cart_items) {
	
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.cart_items = cart_items;
	}

	// for user login
	public User(String username, String email, String password, Role role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<CartItems> getCart_items() {
		return cart_items;
	}

	public void setCart_items(List<CartItems> cart_items) {
		this.cart_items = cart_items;
	}

}
