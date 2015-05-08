package com.sundl.bean.CompositePK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created by Sun on 2015/5/9.
 */
@Entity
public class AirLine {

    private AirLinePK id;
    private String name;

    /**
     * 复合主键类的标识符
     * @return
     */
    @EmbeddedId
    public AirLinePK getId() {
        return id;
    }

    public void setId(AirLinePK id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
