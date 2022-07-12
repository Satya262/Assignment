package com.pwc.satyabrata.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="catalog_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class catalog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String categoryName;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="FK_product",referencedColumnName = "id")
	private List<product> products;
}
