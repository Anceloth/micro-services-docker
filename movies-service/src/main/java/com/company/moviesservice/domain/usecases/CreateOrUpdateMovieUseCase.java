package com.company.moviesservice.domain.usecases;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.moviesservice.external.MovieRepository;
import com.company.moviesservice.domain.entities.Movies;

@Component
public class CreateOrUpdateMovieUseCase implements UseCase<Movies, Movies>{
	
	@Autowired
	MovieRepository movieRepo;

	@Override
	public Movies execute(Movies author) throws Exception {
		
		return movieRepo.save(author);
	}

}
