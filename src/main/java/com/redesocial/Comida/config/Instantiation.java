package com.redesocial.Comida.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.redesocial.Comida.domain.Post;
import com.redesocial.Comida.domain.User;
import com.redesocial.Comida.dto.AuthorDTO;
import com.redesocial.Comida.dto.CommentDTO;
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
		
		repository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null,sdf.parse("21/03/2021"), "Partiu viagem", "Vou viajar para são Paulo",new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("24/07/2021"), "Viajar", "Partiu! jericoacoara",new AuthorDTO(maria));
		
		
		CommentDTO c1 = new CommentDTO("Boa viagem!",sdf.parse("21/03/2021"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Volta quando ?", sdf.parse("22/03/2021"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Legal demais", sdf.parse("25/03/2021"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		repository.save(maria);
		
		
	}

}
