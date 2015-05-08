package com.sundl.bean.CompositePK;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 联合主键类
 * 1.public无参数构造函数
 * 2.实现序列号接口
 * 3.重写hashCode 和 equal方法
 * Created by Sun on 2015/5/9.
 * 只使用联合主键类的属性，作为实体类的持久化字段
 */
@Embeddable
public class AirLinePK implements Serializable{


    private String startCity;
    private String endCity;


    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AirLinePK airLinePK = (AirLinePK) o;

        if (startCity != null ? !startCity.equals(airLinePK.startCity) : airLinePK.startCity != null) return false;
        return !(endCity != null ? !endCity.equals(airLinePK.endCity) : airLinePK.endCity != null);

    }

    @Override
    public int hashCode() {
        int result = startCity != null ? startCity.hashCode() : 0;
        result = 31 * result + (endCity != null ? endCity.hashCode() : 0);
        return result;
    }
}
