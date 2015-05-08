package com.sundl.bean.one2one;

import javax.persistence.*;

/**
 * Created by Sun on 2015/5/8.
 */
@Entity
public class IDCard {
    private Integer id;
    private String cardno;
    private Person person;

    @OneToOne(mappedBy = "card", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 18, nullable = false)
    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public IDCard() {
    }

    public IDCard(String cardno) {
        this.cardno = cardno;
    }
}
