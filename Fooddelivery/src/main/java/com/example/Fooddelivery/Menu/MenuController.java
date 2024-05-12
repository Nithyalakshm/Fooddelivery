package com.example.Fooddelivery.Menu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping(value="/api/v1/menu")
    public List<Menu> getMenus(){
        System.out.println("input get menu");
        List<Menu> menu = menuService.getMenu();
        return menu;
    }

    @PostMapping(value="/api/v1/menu/create")
    public Menu addMenu(@RequestBody Menu menu){
        System.out.println("input for add" + menu.toString());
        BigDecimal price = new BigDecimal(String.valueOf(menu.getPrice()));
        Long restaurantId = Long.parseLong(String.valueOf(menu.getResturantId()));
        menu.setPrice(price);
        menu.setResturantId(restaurantId);
        System.out.println("input for add 2" + menu.toString());

        return menuService.addMenu(menu);
    }

    @DeleteMapping(value="/api/v1/menu/delete/{id}")
    public void deleteMenu(@PathVariable("id") String menuid){
        System.out.println("input for delete" + menuid);
        Menu menu = new Menu();
        menu.setMenuId(Long.parseLong(menuid));
        menuService.deleteMenu(menu);

    }

    @PutMapping(value="/api/v1/menu/update")
    public void updateMenu(@RequestBody Menu menu){
        try {

            System.out.println("input for update" + menu);
            menuService.updateMenu(menu);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping(value="/api/v1/menu/{restaurantId}")
    public Optional<List<Menu>> findByResturantId(@PathVariable("restaurantId") String restaurantId){
        System.out.println("input get menu by restaurantId" +restaurantId );
        Long restaurantIdinput = Long.parseLong(String.valueOf(restaurantId));

        return menuService.findByResturantId(restaurantIdinput);
    }

}
