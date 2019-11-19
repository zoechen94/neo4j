package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author pdtyreus
 * @author Mark Angrish
 * 对象 :#{#p.name}
 */
public interface PersonRepository extends Neo4jRepository<Person, Long> {
   @Query("create (n:导演{name::#{#p.name},birth::#{#p.birth},place::#{#p.place},sex::#{#p.sex}}) return n")
   Person addNodes(@Param("p") Person p);


   //   @Query("match (n:导演{name:{name}}) return n")
   Person findByName(@Param("name")String name);

}