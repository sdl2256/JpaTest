package com.sundl.bean.one2one;

import javax.persistence.*;

/**
 * Created by Sun on 2015/5/8.
 */
@Entity
@Table(name = "IDPerson")
public class Person {
    private Integer id;
    private String name;

    private IDCard card;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "idcard_id")
    public IDCard getCard() {
        return card;
    }

    public void setCard(IDCard card) {
        this.card = card;
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

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}
