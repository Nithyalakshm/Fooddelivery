package com.example.Fooddelivery.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaruantRepo extends JpaRepository<Restaruant, Long> {
}
