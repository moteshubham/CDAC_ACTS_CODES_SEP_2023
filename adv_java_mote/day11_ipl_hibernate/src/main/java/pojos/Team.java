package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//id , name, abbrevation,owner,max_age,batting_avg,wickets_taken
@Entity
@Table(name = "teams")
public class Team extends BaseEntity {

		@Column( length = 100)
		private String name;
		@Column( length = 10)
		private String abbreviation;
		@Column( length = 20)
		private String owner;
		@Column( name = "max_age")
		private int maxAge;
		@Column( name = "batting_avg")
		private double minBattingAvg;
		private int wicketsTaken;
		@OneToMany(mappedBy = "myTeam", cascade = CascadeType.ALL, orphanRemoval = true)
		private List<Player> players = new ArrayList<>();
	public Team() {
		
	}
	//add helper method  to establish a bi dir link between Team n Player
	public void addPlayer(Player p) {
		players.add(p);
		p.setMyTeam(this);
	}
	
	public void removePlayer(Player p) {
		players.remove(p);
		p.setMyTeam(this);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public double getMinBattingAvg() {
		return minBattingAvg;
	}
	public void setMinBattingAvg(double minBattingAvg) {
		this.minBattingAvg = minBattingAvg;
	}
	public int getWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	@Override
	public String toString() {
		return "Team [name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner + ", maxAge=" + maxAge
				+ ", minBattingAvg=" + minBattingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}
	public Team(String name, String abbreviation, String owner, int maxAge, double minBattingAvg, int wicketsTaken) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minBattingAvg = minBattingAvg;
		this.wicketsTaken = wicketsTaken;
	}



}
