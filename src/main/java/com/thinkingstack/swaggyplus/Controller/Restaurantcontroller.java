package com.thinkingstack.swaggyplus.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.thinkingstack.swaggyplus.Entity.Dish;
import com.thinkingstack.swaggyplus.Entity.Restaurant;
import com.thinkingstack.swaggyplus.Repository.Dishrepo;
import com.thinkingstack.swaggyplus.Repository.Resrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin(origins = "http://localhost:4200")
public class Restaurantcontroller {
    @Autowired
    private Resrepo restaurant;

    @Autowired
    private Dishrepo dish;

    //API to add a new restaurant
    @PostMapping(value= "/add-res")  // only an Admin is anle to perform this
    public Restaurant add_res(@RequestBody Restaurant r){
        return restaurant.saveAndFlush(r);
    }

    //API to show all the restaurants
    @GetMapping(value = "/showrestaurants")  // to show all the restaurants (this is for all users)
    public List<Restaurant>showAll(){
        return restaurant.findAll();
    }   
    
    //API for edit Restaurant
    @PutMapping("/edit-res")   // only an Admin is anle to perform this
	public ResponseEntity<Restaurant> editRestaurent(@RequestParam Integer id, @RequestBody Restaurant res){
		Restaurant updatedRestaurent=restaurant.save(res);
		return new ResponseEntity<Restaurant>(updatedRestaurent,HttpStatus.OK);
    }
    
    //API for find restaurant by ID
    @GetMapping("/resById")   // for all users
	public ResponseEntity<Restaurant> getRestaurentById(@RequestParam Integer id) {
		try{
			return new ResponseEntity<Restaurant>(restaurant.findById(id).get(), HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Restaurant>( HttpStatus.NOT_FOUND);
		}
    }

    //API to find restaurant by Name
    @GetMapping("/resByName")   // for all users
	public ResponseEntity<List<Restaurant>> getRestaurentByName(@RequestParam String resName) {
		try{
			
			return new ResponseEntity<List<Restaurant>>(restaurant.findByresNameContainingIgnoreCase(resName),HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<List<Restaurant>>( HttpStatus.NOT_FOUND);
		}
    }

    //API to add dishes
    @PutMapping("/addDish/{id}")    // Only an admin can perform this
	public ResponseEntity<Restaurant> addDish(@PathVariable Integer id,@RequestBody Dish d){
		try {
			Restaurant r=restaurant.findById(id).get();
			List<Dish> d1=r.getDishes();
			d1.add(d);
            r.setDishes(d1);
			return new ResponseEntity<Restaurant>(restaurant.save(r),HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Restaurant>( HttpStatus.NOT_FOUND);
		}	
	}
    
    //API to find dish by ID
    @GetMapping("/dishById")
	public ResponseEntity<Dish> getDishById(@RequestParam Long id) {
		try{
			return new ResponseEntity<Dish>(dish.findById(id).get(), HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Dish>( HttpStatus.NOT_FOUND);
		}
    }

    //API to find dish by name along eith the corresponding restaurant
    @GetMapping("/dishByName")
	public ResponseEntity<List<Restaurant>> getDishByName(@RequestParam String dish_name) {
		try{
			return new ResponseEntity<List<Restaurant>>(restaurant.findByDishes_dishNameContainingIgnoreCase(dish_name),HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<List<Restaurant>>( HttpStatus.NOT_FOUND);
		}
    }

    @GetMapping("/getrestaurent/active")
	public List<Restaurant> getActiveRestaurent() {
		return restaurant.findByisActive(true);
	}

	@PutMapping("/edit-dish/{id}")
	public ResponseEntity<Dish> editDish(@PathVariable Long id, @RequestBody Dish d){
		Dish editednew=dish.save(d);
		return new ResponseEntity<Dish>(editednew,HttpStatus.OK);
	}
}