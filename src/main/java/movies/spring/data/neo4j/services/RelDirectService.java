package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Relation;
import movies.spring.data.neo4j.repositories.RelDirectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date 2019/11/19 3:45 下午
 * @Created by 长眉师父
 */
@Service
public class RelDirectService {
    @Autowired
    private RelDirectRepository relDirectRepository;
    public Relation addRelation(String startName, String endName){
        return relDirectRepository.addRelation(startName,endName);
    }
}
