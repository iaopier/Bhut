package com.apicarros.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class CarroDTO {
	private String _id;
	@NotEmpty(message = "Titulo não pode ser vazio")
	private String title;
	@NotEmpty(message = "Marca não pode ser vazia")
	private String brand;
	@NotEmpty(message = "Preço não pode ser vazio")
	private String price;
	@NotNull(message= "Idade não pode ser vazia")
	private int age;
	
}
