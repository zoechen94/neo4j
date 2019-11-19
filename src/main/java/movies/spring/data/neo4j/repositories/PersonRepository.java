package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author pdtyreus
 * @author Mark Angrish
 * 对象 :#{#p.name}
 */
public interface PersonRepository extends Neo4jRepository<Person, Long> {
   @Query("create (n:导演{name::#{#person.name},birth:#{p.birth},place::#{#p.place},sex::#{#p.sex}}) return n")
   Person addNodes(@Param("person") Person person); //todo 有错误，只能简单类型，无法复杂类型


   //   @Query("match (n:导演{name:{name}}) return n")
   Person findByName(@Param("name")String name);


   @Query(value = "MATCH (n:导演) where n.name={name} return n",countQuery = "MATCH (n:导演) where n.name={name} return count(n) ")
   Page<Person> page(@Param("name") String name, Pageable pageable);//todo  坑，分页从0开始
}