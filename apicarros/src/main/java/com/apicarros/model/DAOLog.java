package com.apicarros.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Entity
@Table(name = "LOG")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DAOLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long _id;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_hora;
	private String car_id;
}
