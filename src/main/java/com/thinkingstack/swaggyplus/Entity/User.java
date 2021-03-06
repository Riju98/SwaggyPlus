package com.thinkingstack.swaggyplus.Entity;import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id // primary key
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String name;

  private String password;

  public User() {
		
	}
	public User(Integer id, String name, String password) {
		
		this.id = id;
		this.name = name;
		this.password = password;
	}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
  }

  
}