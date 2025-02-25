package com.example.demo.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jwt_tokens")
public class JWTToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int token_id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@Column
	private String token;
	@Column
	private LocalDateTime expiresAt;
	
	public JWTToken() {
		// TODO Auto-generated constructor stub
	}

	public JWTToken(int token_id, User user, String token, LocalDateTime expiresAt) {
		super();
		this.token_id = token_id;
		this.user = user;
		this.token = token;
		this.expiresAt = expiresAt;
	}

	public JWTToken(User user, String token, LocalDateTime expiresAt) {
		super();
		this.user = user;
		this.token = token;
		this.expiresAt = expiresAt;
	}

	public int gettoken_id() {
		return token_id;
	}

	public void settoken_id(int token_id) {
		this.token_id = token_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}

}
