package movies.spring.data.neo4j.domain;


import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * @author Mark Angrish
 */
@NodeEntity(label = "导演")
public class Person {

    @Id
    @GeneratedValue
	private Long id;
    @Property(value = "name")
	private String name;
    @Property(value = "birth")
	private String birth;
    @Property(value = "place")
	private String place;
    @Property(value = "sex")
	private String sex;

	public Person() {
	}

	public Person(String name,String birth,String place,String sex) {
		this.name = name;
		this.birth=birth;
		this.place=place;
		this.sex=sex;
	}

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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}