package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Movie;
import movies.spring.data.neo4j.services.MovieService;
import movies.spring.data.neo4j.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * @author Mark Angrish
 * @author Michael J. Simons
 */
@RestController
@RequestMapping("/")
public class MovieController {

	private final MovieService movieService;
	
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

    @GetMapping("/graph")
	public Response<Collection<Movie>> graph(@RequestParam(value = "limit",required = false) Integer limit) {
		return Response.success(movieService.graph(limit == null ? 100 : limit));
	}

	@GetMapping("/getAll")
	public Response<List<Movie>> getMovies(){
		return Response.success(movieService.getMovies());
	}

	@GetMapping("add")
	public Response<Movie> addMovie(String name){
		return Response.success(movieService.addMovie(name));
	}
}
