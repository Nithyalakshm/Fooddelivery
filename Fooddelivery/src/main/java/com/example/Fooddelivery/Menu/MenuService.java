package com.example.Fooddelivery.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository mrepo;
    public List<Menu>  getMenu(){
        return mrepo.findAll();
    }
    public Menu addMenu(Menu menu){
        return mrepo.save(menu);
    }
    public void deleteMenu(Menu menu){
        System.out.println("input for delete in service" + menu.getMenuId());
        mrepo.delete(menu);
    }
    public void updateMenu(Menu menu){
        System.out.println("input for update in service" + menu.getMenuId());
        mrepo.save(menu);
    }

    public List<Menu>  getMenuByRestaurantName(String restaurantName){
        //return mrepo.findBy
        return null;
    }

    public Optional<List<Menu>> findByResturantId(Long restaurantId){
        return mrepo.findByResturantId(restaurantId);
    }


}
