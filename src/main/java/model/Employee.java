package model;

import java.io.Serializable;
import jakarta.persistence.Entity;

@Entity
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.Auto)
	private Long id;
	private String name;
	private String email;
	private String jobTitle;
	private String phone;
	private String imageURL;
	private String employeeCode;

}
