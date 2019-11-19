package movies.spring.data.neo4j.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import movies.spring.data.neo4j.domain.Person;
import movies.spring.data.neo4j.services.PersonService;
import movies.spring.data.neo4j.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person")
@RestController
@Api(description = "个人中心")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/findByName")
    @ApiOperation("根据名字查找")
    private Response<Person> findByName(String name){
        return Response.success(personService.findByName(name));
    }

    @PostMapping("/addPersonNodes")
    @ApiOperation("添加导演节点")
    private Response<Person> addNode(@RequestBody Person p){
        return Response.success(personService.addNodes(p));
    }

    @PostMapping("/savePersonNodes")
    @ApiOperation("添加导演节点")
    private Response<Person> save(@RequestBody Person p){
        return Response.success(personService.ysadd(p));
    }
}
