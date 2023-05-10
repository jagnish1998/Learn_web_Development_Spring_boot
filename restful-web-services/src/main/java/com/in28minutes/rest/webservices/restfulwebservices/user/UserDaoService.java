package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {
	
	private static List<User> users  = new ArrayList<>();
	
	private static int userCount =0;
	static {
		users.add(new User(++userCount,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(++userCount,"Eve",LocalDate.now().minusYears(40)));
		users.add(new User(++userCount,"Jim",LocalDate.now().minusYears(24)));
		users.add(new User(++userCount,"John",LocalDate.now().minusYears(15)));
		users.add(new User(++userCount,"Ranga",LocalDate.now().minusYears(37)));	
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findOne(int id) {
		User user = users.stream().filter(u->u.getId()==id).findFirst().orElse(null);
		if(user==null) {
			throw new UserNotFoundException("id "+id);
		}
		return user;
	}
	
	public void DeleteById(int id) {
		User user = users.stream().filter(u->u.getId()==id).findFirst().orElse(null);
		if(user==null) {
			throw new UserNotFoundException("id "+id);
		}
		users.remove(user);
	}

	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
}
