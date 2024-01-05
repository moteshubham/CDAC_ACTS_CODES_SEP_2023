package pojos;

//id | name    | party    | votes
public class Candidate {
	private int candidateId;
	private String candidateName;
	private String party;
	private int votes;

	public Candidate() {
		// TODO Auto-generated constructor stub
	}

	public Candidate(int candidateId, String candidateName, String party, int votes) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.party = party;
		this.votes = votes;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ", party=" + party
				+ ", votes=" + votes + "]";
	}
}
