package pojos;
//  id | name    | party    | votes |  
public class Candidate {
private int candidateId;
private String candidateName;
private String candidateParty;
private int voteCount;

public Candidate() {
	
}

public Candidate(int candidateId, String candidateName, String candidateParty, int voteCount) {
	//so that we can lift all the details
	super();
	this.candidateId = candidateId;
	this.candidateName = candidateName;
	this.candidateParty = candidateParty;
	this.voteCount = voteCount;
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

public String getCandidateParty() {
	return candidateParty;
}

public void setCandidateParty(String candidateParty) {
	this.candidateParty = candidateParty;
}

public int getVoteCount() {
	return voteCount;
}

public void setVoteCount(int voteCount) {
	this.voteCount = voteCount;
}

@Override
public String toString() {
	return "Candidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ", candidateParty="
			+ candidateParty + ", voteCount=" + voteCount + "]";
}



}
