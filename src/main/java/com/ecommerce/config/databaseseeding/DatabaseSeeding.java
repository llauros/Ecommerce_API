package com.ecommerce.config.databaseseeding;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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
	 * Populando tabela de Negocios com dados fictícios!
	 */
	public void dbsBusiness() {
		BusinessEntity b1, b2, b3;

		List<UserEntity> usersT = userRepository.findAll();
		
		b1 = new BusinessEntity("Games Eduu", "Conheça a melhor loja de Games", usersT.get(0));
		b2 = new BusinessEntity("Americanas", "Tem tudo", usersT.get(1));
		b3 = new BusinessEntity("Melissa Cosméticos", "Perfume-se", usersT.get(2));		
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

		List<BusinessEntity> b = businessRepository.findAll();
				
		p1 = new ProductEntity("The Lord of the Rings", "Lorem ipsum dolor amet", new BigDecimal("90.5"), null, b.get(0));
		p2 = new ProductEntity("Smart TV", "Nulla eu purus. Maecenas ante", new BigDecimal("2190.0"), null, b.get(0));
		p3 = new ProductEntity("Macbook Pro", "Nam eleifend maximus tortor", new BigDecimal("1250.0"), null, b.get(0));
		p4 = new ProductEntity("Redmi X3", "The better smartphone.", new BigDecimal("800.99"), null, b.get(0));
		p5 = new ProductEntity("Hidratante", "Neutrogena matte 3 em 1", new BigDecimal("20.33"), null, b.get(0));
		p6 = new ProductEntity("Garrafa de agua", "Vendida em Jundiai", new BigDecimal("1555.99"), null, b.get(0));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
	}
	
	/**
	 * Populando tabela de Usuário com dados fictícios!
	 */
	public List<UserEntity> dbsUsers() {
		UserEntity u1, u2, u3;
		String p = "senha";

		u1 = new UserEntity("Henzo Alpuim", "henzo@email.com", p);
		u2 = new UserEntity("Jayden Lagoa", "jayden@email.com", p);
		u3 = new UserEntity("Erica Santarem", "erica@email.com", p);	
		
		return userRepository.saveAll(Arrays.asList(u1, u2, u3));
	}
}