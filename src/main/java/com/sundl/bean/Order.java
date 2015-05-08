package com.sundl.bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sun on 2015/5/8.
 */
@Entity
@Table(name = "ORDERS")
public class Order {
    private String orderId;
    private Float amount = 0f;
    private Set<OrderItem> items = new HashSet<OrderItem>();

    /**
     * ToMany 得到多的一方，默认延迟加载；
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY ,mappedBy = "order")
    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    @Column(nullable = false)
    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Id
    @Column(length = 12)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void addOrderItem(OrderItem item) {
        item.setOrder(this);
        this.items.add(item);
    }
}
