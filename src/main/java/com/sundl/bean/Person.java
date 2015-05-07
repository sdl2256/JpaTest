package com.sundl.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Sun on 2015/5/8.
 */
@Entity
public class Person {

    private Integer id;
    private String name;

    @Id
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
}
