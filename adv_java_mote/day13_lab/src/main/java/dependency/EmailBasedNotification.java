package dependency;

public class EmailBasedNotification implements CustomerNotification {

	public EmailBasedNotification() {
		System.out.println("in ctor of sms ");
	}

	@Override
	public void alertCustomer(String mesg) {
		System.out.println("Email ala re  " + getClass().getName() +mesg);

	}

}
