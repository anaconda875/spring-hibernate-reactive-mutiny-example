package com.example.demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Entity
//@Table(name = "A")
@Data
@ToString(exclude = "bs")
public class A {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ID")
	private Long id;

	@OneToMany(mappedBy = "a")
	@JsonBackReference
	private List<B> bs;

	@JsonBackReference
	public List<B> getBs() {
		return bs;
	}
}
