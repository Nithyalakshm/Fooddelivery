package com.example.Fooddelivery.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*")
@RestController
public class RestaruantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaruantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping(value="/api/v1/restaurant")
    public List<Restaruant> getRestaurants(){
        System.out.println("input get restaurant");
        List<Restaruant> restaruants = restaurantService.getRestaurants();
        return restaruants;
    }

    @PostMapping(value="/api/v1/restaurant/create")
    public Restaruant addRestaurant(@RequestBody Restaruant restaruant){
        System.out.println("input for add" + restaruant.toString());
        restaruant.setOwnerId(Long.parseLong(String.valueOf("1")));
        return restaurantService.addRestaurant(restaruant);
    }

    @DeleteMapping(value="/api/v1/restaurant/delete/{id}")
    public void deleteRestaurant(@PathVariable("id") String restaurantId){
        System.out.println("input for delete" + restaurantId);
        Restaruant restaruant = new Restaruant();
        restaruant.setId(Long.parseLong(String.valueOf(restaurantId)));
        restaurantService.deleteRestaurant(restaruant);
    }

    @PutMapping(value="/api/v1/restaurant/update")
    public void updateRestaurant(@RequestBody Restaruant restaruant){
        try {

        System.out.println("input for update" + restaruant);
        restaurantService.updateRestaurant(restaruant);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @GetMapping(value="/api/v1/restaurant/{id}")
    public Optional<Restaruant> getRestaurantsbyId(@PathVariable("id") String restaurantId){
        System.out.println("input get restaurant");
        Optional<Restaruant> restaruant = restaurantService.getRestaurantsbyId(Long.parseLong(restaurantId));
        return restaruant;
    }

}
