package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Relation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

/**
 * @Date 2019/11/19 3:37 下午
 * @Created by 长眉师父
 */
public interface RelDirectRepository extends Neo4jRepository<Relation,Long> {
    @Query("match (n:导演{name:{startName}}),(end:电影{name:{endName}}) create (n)-[r:导演]->(end)")
    Relation addRelation(@Param("startName") String startName, @Param("endName") String endName);
}
