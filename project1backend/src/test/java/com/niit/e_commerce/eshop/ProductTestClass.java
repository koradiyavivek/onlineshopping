package com.niit.e_commerce.eshop;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDaoImpl;
import com.niit.model.Category;
import com.niit.model.Product;

import junit.framework.TestCase;




public class ProductTestClass   {
//
//	public ProductTestClass( String testName )
//    {
//        super( testName );
//    }
	static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	static ProductDaoImpl productDaoImpl;
	Product product;
	Category category;
	
	@BeforeClass
	public static void init()
	{
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com");
		annotationConfigApplicationContext.refresh();
		
		productDaoImpl = (ProductDaoImpl) annotationConfigApplicationContext.getBean(ProductDaoImpl.class);
		annotationConfigApplicationContext.close();
	}
	
	@Test
	public void getAllProductTest() {

		
		productDaoImpl.getAllProducts();
		
		assert(true);
	}
	
	@Test
	public void addProductTest()
	{
	product=new Product();
	category=new Category();
	product.setPrice(1000);
	product.setProductname("Nike Shoes");
	product.setProductdescription("Nike Shoes");
	product.setQuantity(80);
	product.setCategory(category);
	productDaoImpl.saveOrUpdateProduct(product);
	assert(true);
	}
	
	 

}
