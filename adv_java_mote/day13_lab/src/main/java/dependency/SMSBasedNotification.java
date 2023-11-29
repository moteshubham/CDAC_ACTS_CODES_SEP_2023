package dependency;

public class SMSBasedNotification implements CustomerNotification {

	public SMSBasedNotification() {
		System.out.println("in def ctor of sms ");
	}

	@Override
	public void alertCustomer(String mesg) {
		System.out.println("Notifying Cust via  " + getClass().getName() + mesg +"using SMS");

	}

}
