package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table(name = "emps") 
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"dept","projects"})
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true,of = "email")
public class Employee extends BaseEntity {

	@Column(length = 30)
	private String firstName;
	@Column(length = 30)
	private String lastName;
	@Column(length = 30, unique = true) // =>unique
	private String email;
	@Column(nullable = false) // =>NOT NULL
	private String password;		
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joinDate;
	@Enumerated(EnumType.STRING) // col : varchar => enum constant name
	@Column(length = 30)
	private EmpType type;
	//@Lob // large object :col : longblob
	//private byte[] image;
	private String imagePath;
	private double salary;
	// many to one association
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)//MERGE : NEW n INTERESTING !!!!!
	@JoinColumn(name = "department_id") // Optional BUT reco , to specify the name of FK col.
	private Department dept;
	// many-to many : non owning
	@ManyToMany(mappedBy = "emps")
	//change collection type to List : in inverse side , for better optimization
	private List<Project> projects = new ArrayList<>();
	// one to one association Employee ----> AdharCard
//	@Embedded // OPTIONAL
//	private AdhaarCard card;
	
	public void addProject(Project p)
	{
		projects.add(p);
		p.getEmps().add(this);
	}
	public void removeProject(Project p)
	{
		projects.remove(p);
		p.getEmps().remove(this);
	}
	public Employee(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}


}
