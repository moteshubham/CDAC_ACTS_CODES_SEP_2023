package com.app.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp_adr")
public class Address extends BaseEntity {
	@Column(name="adr_line1",length=100)
	private String adrLine1;
	@Column(name="adr_line2",length=100)
	private String adrLine2;
	@Column(length=20)
	private String city;
	@Column(length=20)
	private String state;
	@Column(length=20)
	private String country;
	@Column(length=20,name="zip_code")
	private String zipCode;
	//one-to-one , uni dir Address 1--->1 Employee
	//owning side : Address (since FK)
	@OneToOne (fetch = FetchType.LAZY)//mandatory , o.w hib throws MappingExc
	@JoinColumn(name="emp_id")//optional : to specify name of FK col
	@MapsId//optional BUT reco : to use shared PK between Emp n Address
	private Employee owner;
	public Address() {
		System.out.println("in def ctor of "+getClass());
	}
	public Address(String adrLine1, String adrLine2, String city, String state, String country, String zipCode) {
		super();
		this.adrLine1 = adrLine1;
		this.adrLine2 = adrLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}
	public String getAdrLine1() {
		return adrLine1;
	}
	public void setAdrLine1(String adrLine1) {
		this.adrLine1 = adrLine1;
	}
	public String getAdrLine2() {
		return adrLine2;
	}
	public void setAdrLine2(String adrLine2) {
		this.adrLine2 = adrLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public Employee getOwner() {
		return owner;
	}
	public void setOwner(Employee owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "Address ID "+getId()+" [adrLine1=" + adrLine1 + ", adrLine2=" + adrLine2 + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", zipCode=" + zipCode + "]";
	}
	
}
