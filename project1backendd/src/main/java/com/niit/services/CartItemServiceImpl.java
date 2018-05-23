package com.niit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CartItemDao;
import com.niit.model.CartItem;
import com.niit.model.User;

@Service
public class CartItemServiceImpl {
	@Autowired
	private CartItemDao cartItemDao;
	public void saveOrUpdateCartItem(CartItem cartItem) {
		cartItemDao.saveOrUpdateCartItem(cartItem);
		
	}

	public void removeCartItem(int cartItemId) {
		cartItemDao.removeCartItem(cartItemId);
	}
   
	public User getUser(String email) {
		return cartItemDao.getUser(email);
	}
	

}
