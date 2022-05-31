package com.ecommerce.config.databaseseeding;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.ecommerce.entities.BusinessEntity;
import com.ecommerce.entities.CategoryEntity;
import com.ecommerce.entities.ProductEntity;
import com.ecommerce.entities.UserEntity;
import com.ecommerce.repositories.BusinessRepository;
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
	private BusinessRepository businessRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		dbsUsers();
		
		dbsBusiness();

		dbsCategory();
		
		dbsProduct();

	}

	/**
	 * Populando tabela de Usuário com dados fictícios!
	 */
	public void dbsUsers() {
		UserEntity u1, u2, u3, u4, u5, u6, u7, u8, u9, u10, u11, u12, u13, u14, u15, u16, u17, u18, u19, u20, uAdmin, uTest, uTest2, uTest3, uTest4;
		String passwordTest = "senhaficticia";

		u1 = new UserEntity("Henzo Alpuim", "henzo@email.com", passwordTest);
		u2 = new UserEntity("Jayden Lagoa", "jayden@email.com", passwordTest);
		u3 = new UserEntity("Erica Santarem", "erica@email.com", passwordTest);		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
	}

	/**
	 * Populando tabela de Negocios com dados fictícios!
	 */
	public void dbsBusiness() {
		BusinessEntity b1, b2, b3;

		b1 = new BusinessEntity("Games Eduu", "Conheça a melhor loja de Games");
		b2 = new BusinessEntity("Americanas", "Tem tudo");
		b3 = new BusinessEntity("Melissa Cosméticos", "Perfume-se");		
		businessRepository.saveAll(Arrays.asList(b1, b2, b3));
	}
	
	/**
	 * Populando tabela de Categoria com dados fictícios!
	 */
	public void dbsCategory() {
		CategoryEntity c1, c2, c3;

		c1 = new CategoryEntity("Moda");
		c2 = new CategoryEntity("Eletrônicos");
		c3 = new CategoryEntity("Livros");
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
	}
	
	/**
	 * Populando tabela de Produtos com dados fictícios!
	 */
	public void dbsProduct() {
		ProductEntity p1, p2, p3, p4, p5, p6;

		p1 = new ProductEntity("The Lord of the Rings", "Lorem ipsum dolor amet", new BigDecimal("90.5"), null);
		p2 = new ProductEntity("Smart TV", "Nulla eu purus. Maecenas ante", new BigDecimal("2190.0"), null);
		p3 = new ProductEntity("Macbook Pro", "Nam eleifend maximus tortor", new BigDecimal("1250.0"), null);
		p4 = new ProductEntity("Redmi X3", "The better smartphone.", new BigDecimal("800.99"), null);
		p5 = new ProductEntity("Hidratante", "Neutrogena matte 3 em 1", new BigDecimal("20.33"), null);
		p6 = new ProductEntity("Garrafa de agua", "Vendida em Jundiai", new BigDecimal("1555.99"), null);
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
	}
}