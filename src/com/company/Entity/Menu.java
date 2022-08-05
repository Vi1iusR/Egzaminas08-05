//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "foodmenu"
)
public class Menu {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "dishId"
    )
    private int dishId;
    @Column(
            name = "dishName"
    )
    private String dishName;
    @Column(
            name = "dishDesc"
    )
    private String dishDesc;
    @Column(
            name = "orderCount"
    )
    private int orderCount;
    @Column(
            name = "bought",
            columnDefinition = "SMALLINT"
    )
    private boolean bought;

    public Menu() {
    }

    public Menu(int dishId, String dishName, String dishDesc) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishDesc = dishDesc;
    }

    public Menu(String dishName, String dishDesc) {
        this.dishName = dishName;
        this.dishDesc = dishDesc;
    }

    public String getDishName() {
        return this.dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishDesc() {
        return this.dishDesc;
    }

    public void setDishDesc(String dishDesc) {
        this.dishDesc = dishDesc;
    }

    public int getDishId() {
        return this.dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public boolean isbought() {
        return this.bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public int getOrderCount() {
        return this.orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public String toString() {
        return "Id of the dish = " + this.dishId + ", Name of the dish = '" + this.dishName + '\'' + ", Description of the dish = '" + this.dishDesc + ".";
    }
}
