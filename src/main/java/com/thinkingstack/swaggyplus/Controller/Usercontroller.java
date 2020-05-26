package com.thinkingstack.swaggyplus.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.thinkingstack.swaggyplus.Entity.Cart;
import com.thinkingstack.swaggyplus.Entity.Dish;
import com.thinkingstack.swaggyplus.Entity.Restaurant;
import com.thinkingstack.swaggyplus.Entity.User;
import com.thinkingstack.swaggyplus.Repository.Cartrepo;
import com.thinkingstack.swaggyplus.Repository.Dishrepo;
import com.thinkingstack.swaggyplus.Repository.Resrepo;
import com.thinkingstack.swaggyplus.Repository.Userrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Usercontroller {
   @Autowired
   private Userrepo user;
   
    @Autowired
    private Resrepo restaurant;

    @Autowired
    private Dishrepo dish;

    @Autowired
    private Cartrepo cart;

   @GetMapping("/hello")
   public String hello (){
    return "Hey- Dude!!!";
   }
   
   @PostMapping("/adduser")
   public User adduser(@RequestBody final User u) {
       User u1 = user.saveAndFlush(u);
      Cart c= new Cart();
       c.setUser(u);
       c= cart.saveAndFlush(c);
       return u1;
   }

   @PostMapping("/login")
   public ResponseEntity<String> login(@RequestBody final User u1) {
       try {
           final User byId = user.findById(u1.getId()).get();
           if (byId.getPassword().equals(u1.getPassword())) {
               return new ResponseEntity<>((byId.getId()).toString(), HttpStatus.OK);
           } else {
               return new ResponseEntity<>("unauthorized", HttpStatus.UNAUTHORIZED);
           }
       } catch (final NoSuchElementException e) {
           return new ResponseEntity<>("unauthorized", HttpStatus.UNAUTHORIZED);
       }
   }
            
        
            @GetMapping(value="/cart/dish")
            public Cart showalldish(@RequestParam Integer userId){
                
               User u=user.findById(userId).get();
                Cart c = cart.findByuser(u);
                System.out.println(c);
                
                return c;
            }
            

            @DeleteMapping(value="/{userId}/cart/dish")
            public Cart deleteFromCart(@PathVariable Integer userId,@RequestParam Long dishId){
                User u=user.findById(userId).get();
                Dish d=dish.findById(dishId).get();
                Cart c= cart.findByuser(u);
                List<Dish> d1=c.getdishes();
                int index=d1.indexOf(d);
                d1.remove(index);
                c.setdishes(d1);
                c.settotalAmount(this.calculateCost(d1));
                return cart.save(c);
            }

    
            @PostMapping(value="/{userId}/cart/{dishId}")
            public Cart addToCart(@PathVariable Integer userId,@PathVariable Long dishId) {
                User u=user.findById(userId).get();
                Dish d=dish.findById(dishId).get();
                Cart c= cart.findByuser(u);
                Restaurant byDish = restaurant.findByDishesContaining(dish);
                        List<Dish> d1=c.getdishes();
                        d1.add(d);
                        c.setdishes(d1);
                        c.settotalAmount(this.calculateCost(d1));
                        c=cart.save(c);
                        return c;
                    
                }
                
            

                
            public Double calculateCost(List<Dish> d){
                double cost=0;
                for(Dish d1:d)
                {
                    cost=cost+d1.getPrice();
                }
                return cost;
            }
}