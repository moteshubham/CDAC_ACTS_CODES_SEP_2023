package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * team_id | name| abbrevation | owner  | max_age | batting_avg | wickets_taken
 */
@Entity
@Table(name = "teams")
public class Team extends BaseEntity {

	@Column(name = "team_name", length = 30)
	private String name;
	private String abbreviation;
	private String owner;
	private int maxAge;
	private double minBattingAvg;
	private int minWicketsTaken;
	@OneToMany(mappedBy = "teamId")
	private List<Player> players = new ArrayList<>();

	public Team() {

	}

		
	public Team(String name, String abbreviation, String owner, int maxAge, double minBattingAvg,
			int minWicketsTaken) {
		super();
		System.out.println("in team ctor");
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minBattingAvg = minBattingAvg;
		this.minWicketsTaken = minWicketsTaken;
	}
	
	public void addPlayer(Player p) {
		players.add(p);
		p.setTeamId(this);
	}
	
	public void removePlayer(Player p) {
		players.remove(p);
		p.setTeamId(this);
	}
	
	

	@Override
	public String toString() {
		return " name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", minBattingAvg=" + minBattingAvg + ", minWicketsTaken=" + minWicketsTaken
				+ "]";
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

	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}

	public void setMinWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
