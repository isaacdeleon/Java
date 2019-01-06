package com.in28minutes.rest.webservices.restfulwebservices.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "all deatails of the bean")
@Entity
public class UserBean {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "Name should have at least two characters")
    @ApiModelProperty(notes = "at least 2 characters")
    private String name;

    @Past
    @ApiModelProperty(notes = "cant be in past")
    private Date birthDate;

    @OneToMany(mappedBy = "userBean")
    private List<Post> posts;

    protected UserBean() {

    }

    public UserBean(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
