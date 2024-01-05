package beans;

import java.time.LocalDate;
import java.time.Period;

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

public class PlayerBean {
	
	private String myTeam;
	private Player player;
	private String fn;
	private String ln;
	private String dob;
	private double avg;
	private int wickets;
	private String mesg;
	//dependecies = team dao, player dao
	private PlayerDao playerDao;
	private TeamDao teamDao;
	
	public PlayerBean() {
		playerDao = new PlayerDaoImpl();
		teamDao = new TeamDaoImpl();
		System.out.println("Player bean created...");
	}
	
	public Player getPlayer() {
		return player;
	}

	public TeamDao getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public String getMyTeam() {
		return myTeam;
	}

	public void setMyTeam(String myTeam) {
		this.myTeam = myTeam;
	}

	public PlayerDao getPlayerDao() {
		return playerDao;
	}

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	
	public String getMesg() {
		return mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}

	public String validateAndAddPlayer() {
		//validation logic
		//get team details by its abbreviation
		Team team = teamDao.getDetailsByTeamAbbr(myTeam);
		LocalDate date = LocalDate.parse(dob);
		int age = Period.between(date, LocalDate.now()).getYears();
		if(age>team.getMaxAge() || avg<team.getMinBattingAvg() || wickets < team.getWicketsTaken()) {
			mesg = "invalid player dets";
			return "add_player_form";
		}
		Player player = new Player(fn, ln, date, avg, wickets);
		System.out.println("here + " + player);
		 mesg = playerDao.addNewPlayer(player, team.getId());
		return mesg;
	}
}
