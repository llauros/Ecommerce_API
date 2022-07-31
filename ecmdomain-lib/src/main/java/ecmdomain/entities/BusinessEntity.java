package ecmdomain.entities;

import static java.util.stream.Collectors.toList;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ecmdomain.models.Business;

@Entity
@Table(name = "tb_negocio")
public class BusinessEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String name;

	@Column(name = "descricao")
	private String description;
	
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private UserEntity ownerUser;
	
	@OneToMany(mappedBy = "business", cascade = CascadeType.ALL)
	private List<ProductEntity> products;
	
//	@Column(name = "foto_perfil") TODO
//	private String profilePicture;
//	@Column(name = "banner")
//	private String bannerImage;
//	@Column(name = "senha")
//	private Date createdAt;
//	@Column(name = "senha")
//	private Date updatedAt;
	
	public BusinessEntity(Business model) {
		if(model != null && model.getOwnerUser() != null) {
			this.name = model.getName();
			this.description = model.getDescription();
			 
			this.ownerUser = new UserEntity(model.getOwnerUser());		
			
			if(model.getProducts() != null)
				this.products = model.getProducts().stream().map(a -> new ProductEntity(a)).collect(toList());
		}
	}

	public BusinessEntity(String name, String description, UserEntity ownerUser) {
		this.name = name;
		this.description = description;
		this.ownerUser = ownerUser;
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
	public UserEntity getOwnerUser() {
		return ownerUser;
	}
	public void setOwnerUser(UserEntity ownerUser) {
		this.ownerUser = ownerUser;
	}
	public List<ProductEntity> getProducts() {
		return products;
	}
	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public Business toModel() {
		Business model = new Business();
		
		model.setId(this.id);
		model.setName(this.name);
		model.setDescription(this.description);
		
		model.setOwnerUser(this.ownerUser.toModel());
		
		//TODO COMPLETAR RELAÇÃO NEGOCIO - PRODUTO
		if(this.products != null)
			model.setProducts(this.products.stream().map(a -> a.toModel()).collect(toList()));
		
		return model;
	}

}
