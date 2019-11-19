package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
/**
 * @author Michael Hunger
 * @author Mark Angrish
 * @author Michael J. Simons
 */
@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {
    @Query("MATCH (n:电影) return n")
    List<Movie> getMovies();

    @Query("create (n:电影{name:{name}}) return n")
    Movie addMovie(@Param("name") String name);

    @Query("match (m:电影)<-[r:导演]-(d:导演) Return m,r,d LIMIT {limit}")
	Collection<Movie> graph(@Param("limit") int limit);
}