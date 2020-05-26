package com.thinkingstack.swaggyplus.Controller;

import java.util.NoSuchElementException;

import com.thinkingstack.swaggyplus.Entity.Admin;
import com.thinkingstack.swaggyplus.Repository.Adminrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")

public class Admincontroller {
    @Autowired
	private Adminrepo adminrepo;
	
	
	@PostMapping("/addAdmin")
	public String addAdmin(@RequestBody Admin admin) {
		Admin a= adminrepo.saveAndFlush(admin);
		return a.getAdmin_id().toString();

}

	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody Admin admin) {
		System.out.println(admin);
		try{
			Admin byId=adminrepo.findById(admin.getAdmin_id()).get();
			if(byId.getPassword().equals(admin.getPassword())) {
				return new ResponseEntity<>(byId.getAdmin_id().toString() ,HttpStatus.OK);
			}else {
				return  new ResponseEntity<>("unauthorized",HttpStatus.UNAUTHORIZED);
			}
		}catch (NoSuchElementException e) {
			return new ResponseEntity<>("unauthorized", HttpStatus.UNAUTHORIZED);
		}


        
	}

	@GetMapping("/getAdminName")
	public ResponseEntity<String> getUserName(@RequestParam String Id){
        
	   Admin name=adminrepo.findById(Long.parseLong(Id)).get();
	      return new ResponseEntity<>(name.getName(),HttpStatus.OK);
		
	}

}