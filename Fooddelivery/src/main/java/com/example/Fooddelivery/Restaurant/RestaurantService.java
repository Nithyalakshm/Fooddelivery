package com.example.Fooddelivery.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RestaurantService {

    @Autowired
    private RestaruantRepo repo;
    public List<Restaruant> getRestaurants(){
        return repo.findAll();
    }

    public Restaruant addRestaurant(Restaruant restaruant) {
        return repo.save(restaruant);
    }

    public void deleteRestaurant(Restaruant restaruant) {
        System.out.println("input for delete in service" + restaruant.getId());
        repo.delete(restaruant);
    }

    public void updateRestaurant(Restaruant restaruant) {

        System.out.println("input for update in service" + restaruant.getId());
        repo.save(restaruant);
    }

    public Optional<Restaruant> getRestaurantsbyId(Long id) {
        return repo.findById(id);
    }
}
