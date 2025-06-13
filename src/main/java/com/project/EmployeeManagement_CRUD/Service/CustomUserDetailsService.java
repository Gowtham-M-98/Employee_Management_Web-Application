package com.project.EmployeeManagement_CRUD.Service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.EmployeeManagement_CRUD.Dao.UsersRepository;
import com.project.EmployeeManagement_CRUD.Model.Users;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersRepository.findByUserName(username)
		.orElseThrow(()-> new UsernameNotFoundException("User name was not found"));
		return new User(user.getUserName(),user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("USER_ROLE")));
	}
	
}
