package com.pwc.satyabrata.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.pwc.satyabrata.model.catalog;
import com.pwc.satyabrata.model.product;
import com.pwc.satyabrata.myException.productAlreadyCreatedException;
import com.pwc.satyabrata.myException.productNotFoundException;
import com.pwc.satyabrata.repo.catalogrepo;
import com.pwc.satyabrata.repo.productrepo;

@Configuration
public class productService {

	@Autowired
	private catalogrepo catalogrepo;
	
	@Autowired
	private productrepo productrepo;
	
	
	public catalog createProduct(product productObject) throws productAlreadyCreatedException {
		Optional<product> productobjectFromDB = this.productrepo.findByProductName(productObject.getProductName());
		Optional<catalog> catelogobjectFromDB = this.catalogrepo.findByCategoryName(productObject.getCatagoryName());
		if(!productobjectFromDB.isPresent() && !catelogobjectFromDB.isPresent() ) {
			return this.catalogrepo.save(new catalog(0, productObject.getCatagoryName(), new ArrayList<>(List.of(productObject))));
		}
		throw new productAlreadyCreatedException("product already exits");
	}

	public catalog modifyProduct(product productObject) throws InputMismatchException {
		Optional<product> productobjectFromDB = this.productrepo.findByProductName(productObject.getProductName());
		Optional<catalog> catelogobjectFromDB = this.catalogrepo.findByCategoryName(productObject.getCatagoryName());
		if(productobjectFromDB.isPresent()) {
			return this.catalogrepo.save(new catalog(productobjectFromDB.get().getId(), productobjectFromDB.get().getCatagoryName(), new ArrayList<>(List.of(productobjectFromDB.get()))));
		}
		throw new InputMismatchException();
	}


	public String Delete(String productName) throws productNotFoundException {
		Optional<product> productobjectFromDB = this.productrepo.findByProductName(productName);
		if(productobjectFromDB.isPresent()) {
			this.productrepo.deleteById(productobjectFromDB.get().getId());
		}
		throw new productNotFoundException("product doesn't exist");
	}

	public List<product> ListOfProducts(){
		return this.productrepo.findAll();
}
}