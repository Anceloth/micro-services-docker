package com.company.moviesservice.domain.usecases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.company.moviesservice.domain.entities.GetMoviesDTO;
import com.company.moviesservice.domain.entities.Movies;
import com.company.moviesservice.external.MovieRepository;

@Component(value="autowiredFieldDependency")
public class GetMoviesByAuthorUseCase  implements UseCase<GetMoviesDTO, Map<String, Object>>{

	@Autowired
	MovieRepository MoviesRepo;

	@Override
	public Map<String, Object> execute(GetMoviesDTO data) throws Exception {
		List<Movies> Movies = new ArrayList<Movies>();
		Page<Movies> MoviesPage = MoviesRepo.findByAuthorId(data.getAuthorId(), data.getPageable());
		Movies = MoviesPage.getContent();
		
		Map<String, Object> responsePaginated = new HashMap<>();
		responsePaginated.put("Movies", Movies);
		responsePaginated.put("currentPage", MoviesPage.getNumber());
		responsePaginated.put("totalItems", MoviesPage.getTotalElements());
		responsePaginated.put("totalPages", MoviesPage.getTotalPages());

		return responsePaginated;
	}

}
