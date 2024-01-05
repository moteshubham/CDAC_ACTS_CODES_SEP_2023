package pojos;
/*
 * emp_id(PK) ,first_name,last_name,email(unique)
password(not null),join_date,emp_type(full_time/part_time/contract...:enum),salary


 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity // mandatory
@Table(name = "emps")
public class Employee extends BaseEntity{
	@Column(name="first_name",length = 30)//varchar(30)
	private String firstName;
	@Column(name="last_name",length = 30)//varchar(30)
	private String lastName;
	@Column(length = 30,unique = true)//varchar(30) , unique 
	private String email;
	@Column(length = 20,nullable = false)//NOT NULL constraint
	private String password;
//	@Transient //skip from persistence (i.e no col will be generated)
//	private String confirmPassword;
	@Column(name="join_date")
	private LocalDate joinDate;
	@Enumerated(EnumType.STRING) //col type : varchar : to store enum const names
	@Column(length = 30,name="emp_type")
	private EmploymentType empType;
	private double salary;//auto adds NOT NULL constraint
	//Emp *--->1 Dept 
	@ManyToOne//mandatory anno for specifying many--> one asso.
	@JoinColumn(name="dept_id")//optional BUT reco.
	private Department myDept;
	//many to many Employee *---->* Project , inverse side
	@ManyToMany(mappedBy = "employees")
	private Set<Project> projects=new HashSet<>();
	//Associations between Entity n value types 
	//Emp 1----1  AdhaarCard (embeddable)
	@Embedded //optional annotation
	private AdhaarCard card;
	//Emp 1---* Skills(String) => collection of basic value types
	//mandatory
	@ElementCollection //o.w MappingExc
	//optional 
	@CollectionTable(name="skills",joinColumns = @JoinColumn(name="emp_id"))
	@Column(name="emp_skill",length = 50)
	private List<String> skills;
	//Emp 1----*PaymentOptions(collection of embeddables)
	@ElementCollection
	@CollectionTable(name="payment_options",joinColumns = @JoinColumn(name="emp_id"))
	private List<PaymentOption> paymentOptions=new ArrayList<>();
	

	public Employee() {
		System.out.println("in def ctor of emp");
	}

	public Employee(String firstName, String lastName, String email, String password, LocalDate joinDate,
			EmploymentType empType, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.joinDate = joinDate;
		this.empType = empType;
		this.salary = salary;
	}
	

	public Employee(String firstName, String lastName, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public EmploymentType getEmpType() {
		return empType;
	}

	public void setEmpType(EmploymentType empType) {
		this.empType = empType;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getMyDept() {
		return myDept;
	}

	public void setMyDept(Department myDept) {
		this.myDept = myDept;
	}
	
	

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	

	public AdhaarCard getCard() {
		return card;
	}

	public void setCard(AdhaarCard card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Employee [empId=" +getId() + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", joinDate=" + joinDate + ", empType=" + empType + ", salary=" + salary + "]";
	}
	
	
	//generate as per the contract , hashCode n equals

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	

	public List<PaymentOption> getPaymentOptions() {
		return paymentOptions;
	}

	public void setPaymentOptions(List<PaymentOption> paymentOptions) {
		this.paymentOptions = paymentOptions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
}
