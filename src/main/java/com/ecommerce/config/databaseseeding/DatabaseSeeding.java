package com.ecommerce.config.databaseseeding;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.ecommerce.entities.BusinessEntity;
import com.ecommerce.entities.CategoryEntity;
import com.ecommerce.entities.OrderEntity;
import com.ecommerce.entities.ProductEntity;
import com.ecommerce.entities.SubCategoryEntity;
import com.ecommerce.entities.UserEntity;
import com.ecommerce.repositories.BusinessRepository;
import com.ecommerce.repositories.CategoryRepository;
import com.ecommerce.repositories.OrderRepository;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.SubCategoryRepository;
import com.ecommerce.repositories.UserRepository;

@Component
@Configuration
//@Profile(value = { "dev", "prod", "test" })
public class DatabaseSeeding implements CommandLineRunner {

	@Autowired private UserRepository userRepository;
	@Autowired private BusinessRepository businessRepository;
	@Autowired private OrderRepository orderRepository;
	@Autowired private ProductRepository productRepository;
	@Autowired private CategoryRepository categoryRepository;
	@Autowired private SubCategoryRepository subCategoryRepository;

	@Override
	public void run(String... args) throws Exception {

		/*List<UserEntity> usuarios = dbsUsers();
		List<BusinessEntity> negocios = dbsBusiness(usuarios);	
		List<CategoryEntity> cetegorias = dbsCategory();
		List<SubCategoryEntity> subCategorias = dbsSubCategory(cetegorias);
		dbsProduct(negocios, subCategorias);*/

		// dbsOrders(usuarios);

	}

	public List<UserEntity> dbsUsers() {
		String p = "senha";
		UserEntity u1 = new UserEntity("Henzo Alpuim", "henzo@email.com", p);
		UserEntity u2 = new UserEntity("Jayden Lagoa", "jayden@email.com", p);
		UserEntity u3 = new UserEntity("Erica Santarem", "erica@email.com", p);
		return userRepository.saveAll(Arrays.asList(u1, u2, u3));
	}// Populando tabela de Usuário com dados fictícios!

	public List<BusinessEntity> dbsBusiness(List<UserEntity> usuarios) {
		BusinessEntity b1 = new BusinessEntity("Games Eduu", "Conheça a melhor loja de Games", usuarios.get(0));
		BusinessEntity b2 = new BusinessEntity("Americanas", "Tem tudo", usuarios.get(1));
		BusinessEntity b3 = new BusinessEntity("Melissa Cosméticos", "Perfume-se", usuarios.get(2));
		return businessRepository.saveAll(Arrays.asList(b1, b2, b3));
	}// Populando tabela de Negocios com dados fictícios!

	private void dbsOrders(List<UserEntity> users) {
		OrderEntity o1 = new OrderEntity(Instant.parse("2019-06-20T19:53:07Z"), users.get(0));
		OrderEntity o2 = new OrderEntity(Instant.parse("2019-07-21T03:42:10Z"), users.get(1));
		OrderEntity o3 = new OrderEntity(Instant.parse("2019-07-22T15:21:22Z"), users.get(2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

	public List<CategoryEntity> dbsCategory() {
		CategoryEntity c1 = new CategoryEntity("Moda");
		CategoryEntity c2 = new CategoryEntity("Eletrônicos");
		CategoryEntity c3 = new CategoryEntity("Alimentos & Bebidas");
		return categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
	}// Populando tabela de Categoria com dados fictícios!
	
	public List<SubCategoryEntity> dbsSubCategory(List<CategoryEntity> cetegorias) {
		SubCategoryEntity s1 = new SubCategoryEntity("Moda Feminina", cetegorias.get(0));
		SubCategoryEntity s2 = new SubCategoryEntity("Moda Masculina", cetegorias.get(0));
		SubCategoryEntity s3 = new SubCategoryEntity("Smart", cetegorias.get(1));
		SubCategoryEntity s4 = new SubCategoryEntity("Pãezinhos", cetegorias.get(2));
		return subCategoryRepository.saveAll(Arrays.asList(s1, s2, s3));
	}// Populando tabela de SubCategoria com dados fictícios!

	public void dbsProduct(List<BusinessEntity> negocios, List<SubCategoryEntity> subcategorias) {
		ProductEntity p1 = new ProductEntity("Camisa Naruto", "Naruto Shippuden", new BigDecimal("90.5"), null, negocios.get(0));
		p1.getSubCategories().add(subcategorias.get(1));
		p1.getSubCategories().add(subcategorias.get(0));
		ProductEntity p2 = new ProductEntity("Macbook Pro", "Nam eleifend maximus tortor", new BigDecimal("1250.0"), null, negocios.get(0));
		p2.getSubCategories().add(subcategorias.get(2));
		ProductEntity p3 = new ProductEntity("Redmi X3", "The better smartphone.", new BigDecimal("800.99"), null, negocios.get(0));
		p3.getSubCategories().add(subcategorias.get(2));
		ProductEntity p4 = new ProductEntity("Hidratante", "Neutrogena matte 3 em 1", new BigDecimal("20.33"), null, negocios.get(0));
		p4.getSubCategories().add(subcategorias.get(0));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
	}// Populando tabela de Produtos com dados fictícios!

}
