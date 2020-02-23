package mainpack;

//Database for user accounts, PIN, format including lists, notes and privated ones
import java.util.*;

public class Global {
	Scanner input = new Scanner(System.in);
	public static List<User> userList = new ArrayList<User>();
	public static List<Format> formatList = new ArrayList<Format>();
	public static List<Format> privateFormatList = new ArrayList<Format>();
	public static int menuState = 1;
	public static int countUserId = 1;
	public static int countPaymentId = 1;
	public static int countFormatId = 1;
	public static int countBackupId = 1;
	public static User currentUser;
	public static Format currentFormat;
	public static int pin;
	public static boolean isVerified = false;

	/**** Color stuffs ****/
	public static final String RESET = "\u001B[0m";
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	// public static final String WHITE = "\u001B[37m";

	// DISPLAY ALL FORMATS METHOD
	public static void displayFormat2() { // used in View Format Menu; headerSort(), colorSort(), dateCreatedSort() in
											// Arrange Menu
		List<Format> list = new ArrayList<Format>();
		if (Global.isVerified) {
			list = Global.privateFormatList;
		} else
			list = Global.formatList;
		if (list.size() != 0) {
			System.out.println("List of formats:");
			for (Format format : list) {
				switch (format.getColor()) {
				case BLUE:
					System.out.print(Global.BLUE);
					break;
				case GREEN:
					System.out.print(Global.GREEN);
					break;
				case YELLOW:
					System.out.print(Global.YELLOW);
					break;
				}
				System.out.print("  + ID: " + format.getIdFormat() + " - " + format.getClass().getSimpleName()
						+ " - Header: " + format.getHeader() + " - Content: ");
				if (format instanceof Note) {
					System.out.print(((Note) format).getContent());
				} else if (format instanceof Checklist) {
					System.out.print(((Checklist) format).getContent());
				}
				System.out.println(" - Color: " + format.getColor() + " - Time created: " + format.getTimeCreated());
				System.out.print(Global.RESET);
			}
		} else {
			System.out.println("There is no format!");
		}
	}

	// DISPLAY A FORMAT IN MENU
	public static void displayAFormat(Format format) { // used in Edit Menu, Option Menu
		switch (format.getColor()) {
		case BLUE:
			System.out.print(Global.BLUE);
			break;
		case GREEN:
			System.out.print(Global.GREEN);
			break;
		case YELLOW:
			System.out.print(Global.YELLOW);
			break;
		}
		System.out.println("\r\n------" + format.getHeader() + "------");
		if (format instanceof Note) {
			System.out.println(((Note) Global.currentFormat).getContent());
		} else if (format instanceof Checklist) {
			System.out.println(((Checklist) format).getContent());
		}
		System.out.println("[ID: " + Global.currentFormat.getIdFormat() + " - Color: " + Global.currentFormat.getColor()
				+ " - Time created: " + Global.currentFormat.getTimeCreated() + "]");
		System.out.print(Global.RESET);
	}

	/**** All of stuffs below only to display data in database to observe ****/
	// DISPLAY ALL INFORMATION
	public static void displayInfo() {
		System.out.print(Global.CYAN);
		Global.displayUser();
		Global.displayPayment();
		Global.displayBackup();
		Global.displayFormat(Global.formatList);
		Global.displayFormat(Global.privateFormatList);
		Global.displayPin();
		System.out.print(Global.RESET);
	}

	// DISPLAY PIN
	public static void displayPin() {
		if (pin == 0) {
			System.out.println("// PIN hasn't been created");
		} else
			System.out.println("// PIN: " + pin);
	}

	// DISPLAY ALL USERS
	public static void displayUser() {
		System.out.println("\r\n// DATABASE\r\n// List of users:");
		for (User user : userList) {
			System.out.println(
					"//   + ID: " + user.getID() + " - Email: " + user.getEmail() + " - Username: " + user.getUsername()
							+ " - Password: " + user.getPassword() + " - User state: " + user.getUserState());
		}
	}

	// DISPLAY ALL PAYMENTS OF CURRENT USER
	public static void displayPayment() {
		if (Global.menuState == 2 && Global.currentUser.getPaymentList().size() != 0) {
			System.out.println("// List of payments of user " + Global.currentUser.getUsername() + ":");
			for (Payment payment : Global.currentUser.getPaymentList()) {
				System.out.println("//   + ID: " + payment.getIdPayment() + " - Account type: "
						+ payment.getAccountType() + " - Account number: " + payment.getAccountNumber() + " - Amount: "
						+ payment.getAmount() + " - Time: " + payment.getTimePaid());
			}
		}
	}

	// DISPLAY ALL FORMATS
	public static void displayFormat(List<Format> list) {
		if (list.equals(Global.formatList) && !Global.formatList.isEmpty()) {
			System.out.println("// List of formats:");
		} else if (list.equals(Global.privateFormatList) && !Global.privateFormatList.isEmpty())
			System.out.println("// List of private formats:");
		for (Format format : list) {
			System.out.print("//   + ID: " + format.getIdFormat() + " - " + format.getClass().getSimpleName()
					+ " - Header: " + format.getHeader() + " - Content: ");
			if (format instanceof Note) {
				System.out.print(((Note) format).getContent());
			} else if (format instanceof Checklist) {
				System.out.print(((Checklist) format).getContent());
			}
			System.out.println(" - Time created: " + format.getTimeCreated());
		}
	}

	// DISPLAY ALL BACKUP OF CURRENT USER
	public static void displayBackup() {
		if (currentUser != null) {
			if (!currentUser.getBackupList().isEmpty()) {
				System.out.println("// List of backups:");
				for (Backup backup : currentUser.getBackupList()) {
					System.out.println("//   + ID: " + backup.getId() + " - Time created: " + backup.getTime()
							+ " - Amount of formats: " + backup.getBackupFile().size());
					System.out.print("//         ");
					for (Format format : backup.getBackupFile()) {
						System.out.print(" [ID" + format.getIdFormat() + " " + format.getHeader() + "]");
					}
					System.out.println();
				}
			}
		}
	}

}