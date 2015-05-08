package com.sundl.bean.many2many;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sun on 2015/5/8.
 */
@Entity
public class Student {
    private Integer id;
    private String name;
    private Set<Teacher> teachers = new HashSet<Teacher>();

    public void addTeacher(Teacher teacher) {
        if (!this.teachers.contains(teacher))
            this.teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        if (this.teachers.contains(teacher))
            this.teachers.remove(teacher);
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "student_teacher", inverseJoinColumns = @JoinColumn(name = "teacher_id"),
            joinColumns = @JoinColumn(name = "student_id"))
    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
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
