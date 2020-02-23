package mainpack;
import java.util.*;
import strategies.*;

public class Guest extends MenuCreate {
	Scanner input = new Scanner(System.in);
	
	private PinStrategy pinStrategy; //duplicate User
	private ViewStrategy viewStrategy;	//duplicate User
	private GuestStrategy guestStrategy;
	
		
	public void pinAction(PinStrategy pinStrategy) {
		this.pinStrategy = pinStrategy;
		pinStrategy.action();
	}
	
	public void viewAction(ViewStrategy viewStrategy) {
		this.viewStrategy = viewStrategy;
		viewStrategy.action();
	}
	
	public void guestAction(GuestStrategy guestStrategy) {
		this.guestStrategy = guestStrategy;
		guestStrategy.action();
	}

	/**************** GUEST MENU ****************/
	public void menuGuest() { // indicated by menuState = 1
		Global.displayInfo();

		System.out.println("\r\n------MENU------");
		System.out.println("(1) Register");
		System.out.println("(2) Login");
		System.out.println("(3) Create a format");
		System.out.println("(4) View formats");
		System.out.println("(5) View private formats");
		System.out.println("(6) Create a PIN");
		System.out.println("(7) Change PIN");
		System.out.print("Enter a number: ");
		int option = input.nextInt();

		switch (option) {
		case 1:
			guestAction(new GuestRegister());
			break;
		case 2:
			guestAction(new GuestLogin());
			break;
		case 3:
			createFormat();
			break;
		case 4:
			viewAction(new ViewUnprivateFormat());
			break;
		case 5:
			viewAction(new ViewPrivateFormat());
			break;
		case 6:
			pinAction(new PinCreate());
			break;
		case 7:
			pinAction(new PinChange());
			break;

		}
	}

}
