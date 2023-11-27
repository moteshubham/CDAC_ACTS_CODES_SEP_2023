package beans;

import java.util.List;

import dao.TeamDaoImpl;

public class TeamBean {

	private TeamDaoImpl teamDao;

	public TeamBean() {
		// dependant object has to creae dependecnises
		teamDao = new TeamDaoImpl();
		System.out.println("Team bean created...");
	}

	public TeamDaoImpl getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDaoImpl teamDao) {
		this.teamDao = teamDao;
	}

	public List<String> fetchAllTeamsAbbr() {
		return teamDao.getAllTeamsAbbr();
	}
	
	
}
