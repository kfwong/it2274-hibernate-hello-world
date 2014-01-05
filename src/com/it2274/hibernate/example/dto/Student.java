package com.it2274.hibernate.example.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// Most of the annotation are import from javax.persistence.* library if possible.
// Even though Hibernate does provide their own implementation of JPA annotation syntax.
// If you are not going to use hibernate's extra feature, it's best to use JPA implementation for compatiblity.

@Entity //Use @Entity to map a Java class
@Table(name = "STUDENT") // Explicitly set table name. By default it uses Java class name.
public class Student {

	@Id	// Use @Id to declare this field as primary key
	@GeneratedValue // Tell Hibernate to use default sequence generation
	@Column(name = "ID") // Explicitly set column name
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ADMIN_NO")
	private String adminNo;

	@Column(name = "AGE")
	private int age;
	
	// You can also annotate a field as @Transient to tell Hibernate not to record the field into database.
	// By default all fields will be inserted during commit.
	// e.g:
	/*
	 * @Transient
	 * private String notSoImportantField;
	 * 
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
