package com.company.authorsservice.domain.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.company.authorsservice.domain.entities.AuthorDomain;
import com.company.authorsservice.domain.entities.PageableMovies;
import com.company.authorsservice.external.AuthorRepository;
import com.company.authorsservice.external.entities.Author;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;

@Component
public class GetAuthorByIdUseCase implements UseCase<Long, AuthorDomain>{
	
	@Autowired
	AuthorRepository authorRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private EurekaClient eurekaClient;

	
	@Override
	public AuthorDomain execute(Long id) throws Exception {
		Author author = authorRepo.getReferenceById(id);
		AuthorDomain authorResponse = new AuthorDomain(author.getAuthorId(), author.getAuthorName());
		
		try {
			// PageableMovies moviesResponse  = restTemplate.getForObject("http://movie-service/movies/"+id, PageableMovies.class);
			// PageableMovies moviesResponse = restTemplate.getForObject(environment.getProperty("service.movie")+"/"+id, PageableMovies.class);
			
			Applications applications = eurekaClient.getApplications();
			Application application = applications.getRegisteredApplications(environment.getProperty("service.movie"));
			InstanceInfo instanceInfo = application.getInstances().get(0);
			String url = "http://"+instanceInfo.getIPAddr()+":"+instanceInfo.getPort()+"/movies/"+id;
			System.out.println("URL "+ url);
			PageableMovies moviesResponse = restTemplate.getForObject(url, PageableMovies.class);
			
			authorResponse.setMovies(moviesResponse);
			
		} catch (RestClientException e) {
			e.printStackTrace();
			throw new Exception("Issues getting movies from microservice movie-service "+ e.getMessage());
		}
		
		return authorResponse;
	}
	
}
