package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * @author Mark Angrish
 */
@NodeEntity(label = "电影")
public class Movie {

	@Id
	@GeneratedValue
	private Long id;
	@Property
	private String name;

	public Movie(String name){
		this.name=name;
	}
    public Movie(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}