package com.redesocial.Comida.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.Comida.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "maria silva", "maria@gmail.com");
		User lucas = new User("1", "lucas silva", "lucas@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,lucas));
		return ResponseEntity.ok().body(list);
	}
}
