package com.example.Fooddelivery.Menu;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(generator="my_seq_menu")
    @SequenceGenerator(name="my_seq_menu",sequenceName="menus_menu_id_seq", allocationSize=1)
    @Column(name = "menu_id")
    private Long menuId;
    @Column(name = "restaurant_id")
    private Long resturantId;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "availability")
    private boolean availability;


    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getResturantId() {
        return resturantId;
    }

    public void setResturantId(Long resturantId) {
        this.resturantId = resturantId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", resturantId=" + resturantId +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", availability=" + availability +
                '}';
    }
}
