package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Movie;
import movies.spring.data.neo4j.repositories.MovieRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    private final static Logger LOG = LoggerFactory.getLogger(MovieService.class);

	private final MovieRepository movieRepository;
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}


	private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		result.put(key1, value1);
		result.put(key2, value2);
		return result;
	}

	public Movie addMovie(String name){
		return movieRepository.addMovie(name);
	}


    @Transactional
	public List<Movie> getMovies(){
		return movieRepository.getMovies();
	}

	@Transactional(readOnly = true)
	public Collection<Movie> graph(int limit){
		return movieRepository.graph(limit);
	}

	@Transactional(readOnly = true)
	public Page<Movie> page(int page, int size,String name){
		Pageable p=new PageRequest(page,size);
		if(StringUtils.isEmpty(name)){
			return movieRepository.findAll(p);
		}
		return movieRepository.page(name,p);
	}

	public List<Movie> getName(String name){
		return movieRepository.getMoviesByName(name);
	}
}
