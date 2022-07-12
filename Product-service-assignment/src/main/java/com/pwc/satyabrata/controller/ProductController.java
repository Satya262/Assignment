package com.pwc.satyabrata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pwc.satyabrata.model.catalog;
import com.pwc.satyabrata.myException.productNotFoundException;
import com.pwc.satyabrata.service.productService;
import com.pwc.satyabrata.model.catalog;
import com.pwc.satyabrata.model.product;
import com.pwc.satyabrata.myException.productAlreadyCreatedException;

@RestController
@RequestMapping(" /pwc")
public class ProductController {
	@Autowired
	private productService pds;
	
	@PostMapping("/createProduct")
	public ResponseEntity<catalog> createProduct(@RequestBody product productObject) throws productAlreadyCreatedException{
		catalog createProduct = this.pds.createProduct(productObject);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(createProduct);
	}
	
	@GetMapping("/ListOfProducts")
	public ResponseEntity<List<product>> ListOfProducts() {
		List<product> listOfProducts = this.pds.ListOfProducts();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(listOfProducts);
	}
	
	@PutMapping("/modifyProduct")
	public ResponseEntity<catalog> modifyProduct(@RequestBody product produsctObject){
		catalog modifyProduct = this.pds.modifyProduct(produsctObject);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(modifyProduct);
	}
	
	@DeleteMapping("/DeleteProduct")
	public ResponseEntity<String> DeleteProduct(@PathVariable String productName) throws productNotFoundException{
		String delete = this.pds.Delete(productName);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(delete);
}
}
