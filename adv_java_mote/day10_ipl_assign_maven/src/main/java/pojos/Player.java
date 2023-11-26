package pojos;
/*
 * id , first_name,last_name, dob,batting_avg,wickets_taken....
+team_id 
 */

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player   extends BaseEntity {

	@Column(name = "first_name", length = 30)
	private String firstName;
	@Column(name = "last_name", length = 30)
	private String lastName;
	private Date dob;
	private double battingAvg;
	private int wicketsTaken;
//FK 
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team teamId;  //make it team type n check

	public Player() {

	}

	public Player(String firstName, String lastName, Date dob, double battingAvg, int wicketsTaken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	public Team getTeamId() {
		return teamId;
	}

	public void setTeamId(Team teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return " firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + ", teamId=" + teamId + "]";
	}

}
