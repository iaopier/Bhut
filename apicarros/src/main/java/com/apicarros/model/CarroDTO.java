package com.apicarros.model;


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
	private String title;
	private String brand;
	private String price;
	private int age;
	
}
