package com.redesocial.Comida.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.redesocial.Comida.domain.Post;
import com.redesocial.Comida.domain.User;
import com.redesocial.Comida.repository.PostRepository;
import com.redesocial.Comida.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		repository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		
		
		Post post1 = new Post(null,sdf.parse("21/03/2021"), "Partiu viagem", "Vou viajar para são Paulo",maria);
		Post post2 = new Post(null,sdf.parse("24/07/2021"), "Viajar", "Partiu! jericoacoara",maria);
		
		
		
		repository.saveAll(Arrays.asList(maria,alex,bob));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		
		
	}

}
