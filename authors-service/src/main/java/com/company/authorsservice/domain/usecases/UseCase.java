package com.company.authorsservice.domain.usecases;


public interface UseCase<Argument, Result> {
	
	public Result execute(Argument input) throws Exception;

}

