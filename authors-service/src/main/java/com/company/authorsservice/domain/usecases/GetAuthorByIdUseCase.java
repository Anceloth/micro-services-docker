package com.company.authorsservice.domain.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.company.authorsservice.domain.entities.AuthorDomain;
import com.company.authorsservice.domain.entities.PageableMovies;
import com.company.authorsservice.external.AuthorRepository;
import com.company.authorsservice.external.entities.Author;

@Component
public class GetAuthorByIdUseCase implements UseCase<Long, AuthorDomain>{
	
	@Autowired
	AuthorRepository authorRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public AuthorDomain execute(Long id) throws Exception {
		Author author = authorRepo.getReferenceById(id);
		AuthorDomain authorResponse = new AuthorDomain(author.getAuthorId(), author.getAuthorName());
		
		try {
			//movies = restTemplate.getForObject("http://movie-service/movies/${authorId}", MoviesDomain[].class);
			PageableMovies moviesResponse = restTemplate.getForObject("http://localhost:8082/movies/"+id, PageableMovies.class);				
			authorResponse.setMovies(moviesResponse);
			
		} catch (RestClientException e) {
			e.printStackTrace();
			throw new Exception("Issues getting movies from microservice movie-service "+ e.getMessage());
		}
		
		return authorResponse;
	}
	
}
