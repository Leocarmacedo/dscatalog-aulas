package com.carnacorp.dscatalog.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.carnacorp.dscatalog.entities.Category;
import com.carnacorp.dscatalog.entities.Product;

public class ProductDTO {

	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
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
