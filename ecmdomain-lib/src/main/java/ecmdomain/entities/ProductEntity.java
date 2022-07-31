package ecmdomain.entities;

import static java.util.stream.Collectors.toSet;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ecmdomain.models.Product;

@Entity
@Table(name = "tb_produto")
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", length = 100)
	private String name;

	@Column(name = "descricao", length = 500)
	private String description;

	@Column(name = "preco")
	private BigDecimal price;

	@Column(name = "foto")
	private String photo;

	@ManyToMany
	@JoinTable(name = "tb_produto_subcategoria", joinColumns = @JoinColumn(name = "id_produto"), inverseJoinColumns = @JoinColumn(name = "id_subcategoria"))
	private Set<SubCategoryEntity> subCategories = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "negocio_id")
	private BusinessEntity business;

	public ProductEntity(Product model) {
		this.name = model.getName();
		this.description = model.getDescription();
		this.price = model.getPrice();
		this.photo = model.getPhoto();
		
		if(model.getBusiness() != null) 
			this.business = new BusinessEntity(model.getBusiness());
		
		if (model.getSubCategories() != null) {
			this.subCategories = model.getSubCategories()
					.stream().map(a -> new SubCategoryEntity(a))
					.collect(toSet());
		}
	}

	public ProductEntity(String name, String description, BigDecimal price, String photo, BusinessEntity business) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.photo = photo;
		this.business = business;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Set<SubCategoryEntity> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(Set<SubCategoryEntity> subCategories) {
		this.subCategories = subCategories;
	}
	public BusinessEntity getBusiness() {
		return business;
	}
	public void setBusiness(BusinessEntity business) {
		this.business = business;
	}

	public Product toModel() {
		Product model = new Product();

		model.setId(this.id);
		model.setName(this.name);
		model.setDescription(this.description);
		model.setPrice(this.price);
		model.setPhoto(this.photo);

		if (this.subCategories != null)
			model.setSubCategories(this.subCategories.stream().map(a -> a.toModel()).collect(toSet()));
		
		if (this.business != null)
			model.setBusiness(this.business.toModel());

		return model;
	}
}
