package enums;

public enum Status {
	PENDING,
	IN_PROCESS,
	COMPLETED;
	
	public String toString() {
		return  this.name();
	}
		
}
