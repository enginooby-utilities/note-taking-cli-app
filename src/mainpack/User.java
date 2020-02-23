package mainpack;
import java.util.*;
import java.util.List;
import strategies.*;


import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

;
public class User extends MenuCreate {
	static Scanner input = new Scanner(System.in);
	private String email, username, password;
	private int ID;
	private Enumerations.UserState userState = Enumerations.UserState.NORMAL;
	private List<Payment> paymentList = new ArrayList<Payment>();
	private Payment lastestPayment;
	private List<Backup> backupList = new ArrayList<Backup>();
	DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	private PinStrategy pinStrategy;
	private ViewStrategy viewStrategy;
	private BackupStrategy backupStrategy;
	private UserStrategy userStrategy;

	public void pinAction(PinStrategy pinStrategy) {
		this.pinStrategy = pinStrategy;
		pinStrategy.action();
	}
	
	public void viewAction(ViewStrategy viewStrategy) {
		this.viewStrategy = viewStrategy;
		viewStrategy.action();
	}
	
	public void backupAction(BackupStrategy backupStrategy) {
		this.backupStrategy = backupStrategy;
		backupStrategy.action();
	}
	
	public void userAction(UserStrategy userStrategy) {
		this.userStrategy = userStrategy;
		userStrategy.action();
	}

	// constructor
	public User(String email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}

	/**************** USER MENU ****************/
	public void menuUser() { // indicated by menuState = 2
		Global.displayInfo();

		userAction(new UserUpdateState()); // update state of user every time log in
		System.out.println("\r\n------MENU------");
		displayCurrentUser();
		System.out.println("(1) Change password");
		System.out.println("(2) Log out");
		System.out.println("(3) Upgrade VIP");
		System.out.println("(4) Create a format");
		System.out.println("(5) View formats");
		System.out.println("(6) View private formats");
		System.out.println("(7) Create a PIN");
		System.out.println("(8) Change PIN");
		System.out.println("(9) Backup");
		System.out.println("(10) Restore backup");
		System.out.println("(11) Delete account");
		System.out.print("Enter a number: ");
		int option = input.nextInt();
		switch (option) {
		case 1:
			userAction(new UserChangePassword());
			break;
		case 2:
			Global.menuState = 1; // log out, return to the menu of guest
			break;
		case 3:
			userAction(new UserUpgradeVip());
			break;
		case 4:
			createFormat();	//Create Menu
			break;
		case 5:
			viewAction(new ViewUnprivateFormat());
			break;
		case 6:
			viewAction(new ViewPrivateFormat());
			break;
		case 7:
			pinAction(new PinCreate());
			break;
		case 8:
			pinAction(new PinChange());
			break;
		case 9:
			backupAction(new BackupDo());
			break;
		case 10:
			backupAction(new BackupRestore());
			break;
		case 11:
			userAction(new UserDelete());
			break;
		}
	}

	// DISPLAY CURRENT USER
	public void displayCurrentUser() {
		System.out.println("Current user: " + Global.currentUser.getUsername() + " - ID: " + Global.currentUser.getID()
				+ " - State: " + Global.currentUser.getUserState());
	}

	// BORING GETTER-SETTER STUFF BLA BLA
	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Enumerations.UserState getUserState() {
		return userState;
	}

	public void setUserState(Enumerations.UserState userState) {
		this.userState = userState;
	}

	public List<Payment> getPaymentList() {
		return paymentList;
	}

	public List<Backup> getBackupList() {
		return backupList;
	}

	public void setBackupList(List<Backup> backupList) {
		this.backupList = backupList;
	}

	public Payment getLastestPayment() {
		return lastestPayment;
	}

	public void setLastestPayment(Payment lastestPayment) {
		this.lastestPayment = lastestPayment;
	}
	
}
