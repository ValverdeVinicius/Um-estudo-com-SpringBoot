package com.viniciusvalverde.estudo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.viniciusvalverde.estudo.entities.Category;
import com.viniciusvalverde.estudo.entities.Order;
import com.viniciusvalverde.estudo.entities.Product;
import com.viniciusvalverde.estudo.entities.User;
import com.viniciusvalverde.estudo.entities.enums.OrderStatus;
import com.viniciusvalverde.estudo.repositories.CategoryRepository;
import com.viniciusvalverde.estudo.repositories.OrderRepository;
import com.viniciusvalverde.estudo.repositories.ProductRepository;
import com.viniciusvalverde.estudo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category ca1 = new Category(null, "Electronics");
		Category ca2 = new Category(null, "Books");
		Category ca3 = new Category(null, "Computers");
		
		
		Product p1 = new Product(null, "DVD Player", "A DVD player to watch movies and shows", 205.6, "");
		Product p2 = new Product(null, "Smart TV", "A TV to complement the DVD Player", 1709.4, "");
		Product p3 = new Product(null, "PC Gamer", "A PC to run the new gen games", 3450.20, "");
		Product p4 = new Product(null, "The C++ Programming Language", "The official book to learn C++", 458.3, "");
		Product p5 = new Product(null, "Fuerrilha Cibernética", "A information security book to learn advanced hacking techniques", 98.70, "");
		
		categoryRepository.saveAll(Arrays.asList(ca1, ca2, ca3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(null, "Maria da Silva", "maria@gmail.com", "98888888", "password");
		User u2 = new User(null, "Vinícius Valverde", "vinicius@gmail.com", "99999999", "senha");
		
		Order o1 = new Order(null, Instant.parse("2023-06-25T18:50:03Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2022-05-16T11:15:18Z"),OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2021-08-09T08:34:26Z"),OrderStatus.WAITING_PAYMENT, u1);
		
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}	
}