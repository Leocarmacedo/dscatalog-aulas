package com.carnacorp.dscatalog.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.carnacorp.dscatalog.entities.Category;
import com.carnacorp.dscatalog.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

	private Long id;
	
	@Size(min = 5, max = 60, message = "Nome deve conter entre 5 e 60 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String name;
	
	@NotBlank(message = "Campo obrigatório")
	private String description;
	
	@Positive(message = "Preço deve ser um valor positivo")
	private Double price;
	private String imgUrl;
	
	@PastOrPresent(message = "A data do produto não pode ser futura")
	private Instant date;

	private List<CategoryDTO> categories = new ArrayList<>();

	public ProductDTO() {
	}

	public ProductDTO(Long id, String name, String description, Double price, String imgUrl, Instant date,
			List<CategoryDTO> categories) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
		this.date = date;
		this.categories = categories;
	}

	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();
		date = entity.getDate();
	}

	public ProductDTO(Product entity, Set<Category> categories) {
		this(entity);
		categories.forEach(cat -> this.categories.add(new CategoryDTO(cat)));
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public Instant getDate() {
		return date;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

}
