package com.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="employee")
public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer Id;

@Column(name="name")
private String name;

public Integer getId() {
	return Id;
}
public void setId(Integer Id) {
 this.Id=Id;
}
public String getName() {
	return name;
}
public void setName(String name) {
 this.name=name;
}
}
