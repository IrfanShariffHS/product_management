package com.becoder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.becoder.model.Product;
import com.becoder.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{
	
	

	@Autowired
	private ProductRepository productRespo;

	@Override
	public Product saveProduct(Product product) {
		
		return productRespo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRespo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		
		return productRespo.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
		Product product = productRespo.findById(id).get();
		
		if(product!=null) {
			productRespo.delete(product);
			return "Product Deleted";
		}
		return "Something wrong on server";
		
	}
	@Override
	public Product editProduct(Product p, Integer id) {
		
		Product oldProduct = productRespo.findById(id).get();
		oldProduct.setProductName(p.getProductName());
		oldProduct.setDescription(p.getDescription());
		oldProduct.setPrice(p.getPrice());
		oldProduct.setStatus(p.getStatus());
		
		
		return productRespo.save(oldProduct);
	}

}
