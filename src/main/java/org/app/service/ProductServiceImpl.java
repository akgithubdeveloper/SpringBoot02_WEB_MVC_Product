package org.app.service;

import java.util.List;

import org.app.model.Product;
import org.app.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repo;

	@Transactional
	@Override
	public Integer saveProduct(Product p) {
		
		p=repo.save(p);
		return p.getId();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Product> getAllProducts() {
		
		return repo.findAll();
	}

@Transactional
	@Override
	public void deleteProduct(Integer id) {
		
	repo.deleteById(id);
		
	}

@Override
public Product getProductById(Integer id) {
	
	return repo.getOne(id);
}

}
