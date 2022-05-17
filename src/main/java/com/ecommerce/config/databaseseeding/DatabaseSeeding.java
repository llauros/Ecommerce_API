package com.ecommerce.config.databaseseeding;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.ecommerce.entities.CategoryEntity;
import com.ecommerce.entities.ProductEntity;
import com.ecommerce.entities.UserEntity;
import com.ecommerce.repositories.CategoryRepository;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.UserRepository;

@Component
@Configuration
//@Profile(value = { "dev", "prod", "test" })
public class DatabaseSeeding implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	 private ProductRepository productRepository;
	
	@Autowired
	 private CategoryRepository categoryRepository;
	
	
	@Override
	public void run(String... args) throws Exception {

		UserEntity u1, u2, u3, u4, u5, u6, u7, u8, u9, u10, u11, u12, u13, u14, u15, u16, u17, u18, u19, u20, uAdmin, uTest, uTest2, uTest3, uTest4;
		String passwordTest = "senhaficticia";
		
		CategoryEntity c1, c2, c3;
		ProductEntity p1, p2, p3, p4, p5, p6;
		
		//DATABASE SEEDING FOR CATEGORY
		c1 = new CategoryEntity("Moda");
		c2 = new CategoryEntity("Eletrônicos");
		c3 = new CategoryEntity("Livros");
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
				
		// DATABASE SEEDING FOR PRODUCT
		p1 = new ProductEntity("The Lord of the Rings", "Lorem ipsum dolor amet", new BigDecimal("90.5"), null);
		p2 = new ProductEntity("Smart TV", "Nulla eu purus. Maecenas ante", new BigDecimal("2190.0"), null);
		p3 = new ProductEntity("Macbook Pro", "Nam eleifend maximus tortor", new BigDecimal("1250.0"), null);
		p4 = new ProductEntity("Redmi X3", "The better smartphone.", new BigDecimal("800.99"), null);
		p5 = new ProductEntity("Hidratante", "Neutrogena matte 3 em 1", new BigDecimal("20.33"), null);
		p6 = new ProductEntity("Garrafa de agua", "Vendida em Jundiai", new BigDecimal("1555.99"), null);
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		
		// DATABASE SEEDING FOR USER
		u1 = new UserEntity("Henzo Alpuim", "henzo@email.com", passwordTest);
		u2 = new UserEntity("Jayden Lagoa", "jayden@email.com", passwordTest);
		u3 = new UserEntity("Erica Santarem", "erica@email.com", passwordTest);
		u4 = new UserEntity("Stéphanie Sampaio", "stephanie@email.com", passwordTest);
		u5 = new UserEntity("Angelina Galvão", "angelina@email.com", passwordTest);
		u6 = new UserEntity("Wallace Camilo", "wallace@email.com", passwordTest);
		u7 = new UserEntity("Fernando Batata", "fernando@email.com", passwordTest);
		u8 = new UserEntity("Leonel Cotrim", "leonel@email.com", passwordTest);
		u9 = new UserEntity("Tomé Goulão", "tome@email.com", passwordTest);
		u10 = new UserEntity("Olivia Parafita", "olivia@email.com", passwordTest);
		u11 = new UserEntity("Kevin Ruas", "kevin@email.com", passwordTest);
		u12 = new UserEntity("Rian Gomide", "rian@email.com", passwordTest);
		u13 = new UserEntity("Márcia Borba", "marcia@email.com", passwordTest);
		u14 = new UserEntity("Baltasar Soverosa", "baltasar@email.com", passwordTest);
		u15 = new UserEntity("Violeta Ilha", "violeta@email.com", passwordTest);
		u16 = new UserEntity("Carlos Bragança", "carlos@email.com", passwordTest);
		u17 = new UserEntity("Yana Bugalho", "yana@email.com", passwordTest);
		u18 = new UserEntity("Darius Darius", "darius@email.com", passwordTest);
		u19 = new UserEntity("Ana Portugal", "anap@email.com", passwordTest);
		u20 = new UserEntity("Ana Calheiros", "anac@email.com", passwordTest);
		uAdmin = new UserEntity("admin", "admin@email.com",
				"$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq");
		uTest = new UserEntity("teste", "teste@teste.com",
				"$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq");
		uTest2 = new UserEntity("teste", "existe@email.com",
				"$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq");
		uTest3 = new UserEntity("Maria das Testes", "maria@email.com",
				"$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq");
		uTest4 = new UserEntity("Jose das Testes", "jose@email.com",
				"$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq");
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8, u9, u10, u11, u12, u13, u14, u15, u16, u17,
				u18, u19, u20, uAdmin, uTest, uTest2, uTest3, uTest4));
	}
}