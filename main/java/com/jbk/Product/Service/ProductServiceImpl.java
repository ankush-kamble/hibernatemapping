package com.jbk.Product.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jbk.Product.Dao.ProductDao;
import com.jbk.Product.Entity.Product;
import com.jbk.Product.sort.ProductPriceComparator;
import com.jbk.Product.sort.ProductQtyComparator;
import com.jbk.Product.sort.ProductTypeComparator;
import com.jbk.Product.sort.ProductQtyComparator;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	String excludedRows = "";
	int totalRecordCount = 0;
	
	@Override
	public boolean saveProduct(Product product) {
		if (product.getProductId() == null) {
			String id = new SimpleDateFormat("yyyyMMddHHssSSS").format(new Date());
			product.setProductId(id);
		}
		boolean isAdded = dao.saveProduct(product);
		return isAdded;
	}

	@Override
	public Product getProductById(String productId) {
		Product product = dao.getProductById(productId);
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> list = dao.getAllProduct();
		return list;
	}

	@Override
	public boolean deleteProductbyId(String productId) {
		boolean isDeleted = dao.deleteProductbyId(productId);
		return isDeleted;
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean isUpdated = dao.updateProduct(product);
		return isUpdated;
	}

	@Override
	public List<Product> sortProduct(String sortBy) {
		List<Product> list = getAllProduct();
		if (!list.isEmpty()) {
			if (sortBy.equalsIgnoreCase("productprice")) {
				Collections.sort(list, new ProductPriceComparator());
			} else if (sortBy.equalsIgnoreCase("productPrice")) {
				Collections.sort(list, new ProductPriceComparator());

			} else if (sortBy.equalsIgnoreCase("productQty")) {
				Collections.sort(list, new ProductQtyComparator());

			} else if (sortBy.equalsIgnoreCase("productType")) {
				Collections.sort(list, new ProductTypeComparator());
			}
		}
		return list;
	}

	@Override
	public List<Product> sortProduct_Desc(String sortBy) {
		List<Product> list = getAllProduct();
		if (sortBy.equalsIgnoreCase("productPrice")) {
			Collections.sort(list, new ProductPriceComparator().reversed());
		}
		return list;
	}

	@Override
	public int getTotalCountofProducts() {
		List<Product> list = getAllProduct();
		int productCount = 0;
		if (!list.isEmpty()) {
			productCount = list.size();
		}
		return productCount;
	}

	@Override
	public double getSumofProductprice() {
		List<Product> list = getAllProduct();
		double sum = 0;
		if (!list.isEmpty()) {
			sum = list.stream().mapToDouble(Product::getProductPrice).sum();
		}
		return sum;
	}

	@Override
	public Product getMaxProductDetails() {
		List<Product> list = getAllProduct();
		Product product = null;
		if (!list.isEmpty()) {
			product = list.stream().max(Comparator.comparingDouble(Product::getProductPrice)).get();
		}
		return product;
	}

	@Override
	public Product getMaxProductDetails_2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getMaxProductDetails_3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getMaxProductvalue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
	