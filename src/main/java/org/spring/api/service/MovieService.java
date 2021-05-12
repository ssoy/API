package org.spring.api.service;

import java.util.List;
import java.util.Map;

import kr.or.kobis.kobisopenapi.consumer.rest.exception.OpenAPIFault;

public interface MovieService {
	public List<Map<String,String>> movieParse(String targetDt,String multiMovieYn, String repNationCd ) throws OpenAPIFault, Exception;
}
