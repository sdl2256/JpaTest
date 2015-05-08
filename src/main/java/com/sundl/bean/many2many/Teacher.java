package com.sundl.bean.many2many;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sun on 2015/5/8.
 */
@Entity
public class Teacher {

    private Integer id;
    private String name;

    private Set<Student> students = new HashSet<Student>();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "teachers", fetch = FetchType.LAZY)
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Id
    @GeneratedValue
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
