package com.sundl.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sun on 2015/5/8.
 */
@Entity
@Table(name = "T_USER")
public class User {

    private Integer id;
    private String name;
    private Date birthday;
    private Gender gender = Gender.MAN;
    private String info;
    private Byte[] file;
    private String imagepath;


    //不持久化到数据库
    @Transient
    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    //延迟加载大数据
    @Lob
    @Basic(fetch = FetchType.LAZY)
    public Byte[] getFile() {
        return file;
    }

    public void setFile(Byte[] file) {
        this.file = file;
    }


    @Lob
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Temporal(TemporalType.DATE)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 20, nullable = false, name = "PNAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
