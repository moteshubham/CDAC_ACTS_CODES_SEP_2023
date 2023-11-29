package dependent;

import dependency.CustomerNotification;
import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;
	private double cash;
	private CustomerNotification notficationService;

	public ATMImpl(double c1234) {
		cash = c1234;
		System.out.println("in cnstr of " + cash + " " + myTransport + " " + notficationService);

	}

	public void setNotficationService(CustomerNotification notficationService) {
		System.out.println("in setter notification service");
		this.notficationService = notficationService;
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);// dependent obj is calling dependency's method to inform the bank
		notficationService.alertCustomer("deposited " + amt);
	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
		notficationService.alertCustomer("withdraw " + cash);
	}

	public void setMyTransport(Transport myTransport) {
		System.out.println("in setter of transport");
		this.myTransport = myTransport;
	}


	// custom init method
	public void myInit() {
		System.out.println("in init " + myTransport);// not null
	}

	// custom destroy method
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);// not null
	}

}
