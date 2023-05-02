package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class UserDaoService {
	
	private static List<User> users  = new ArrayList<>();
	
	static {
		users.add(new User(1,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(2,"Eve",LocalDate.now().minusYears(40)));
		users.add(new User(3,"Jim",LocalDate.now().minusYears(24)));
		users.add(new User(4,"John",LocalDate.now().minusYears(15)));
		users.add(new User(5,"Ranga",LocalDate.now().minusYears(37)));	
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findOne(int id) {
		return users.stream().filter(u->u.getId()==id).findFirst().get();
	}
	
}
