package movies.spring.data.neo4j.controller;

import io.swagger.annotations.ApiOperation;
import movies.spring.data.neo4j.domain.Relation;
import movies.spring.data.neo4j.services.RelDirectService;
import movies.spring.data.neo4j.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2019/11/19 3:33 下午
 * @Created by 长眉师父
 */
@RestController
@RequestMapping("/relation")
public class RelationController {
    @Autowired
    private RelDirectService relDirectService;
    @GetMapping("add")
    @ApiOperation("添加")
    public Response<Relation> get(String startName,String endName){
        return Response.success(relDirectService.addRelation(startName,endName));
    }
}
