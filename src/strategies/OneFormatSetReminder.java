package strategies;

public class OneFormatSetReminder implements OneFormatStrategy {
	public void action() {
		System.out.print("Enter day (yyyy-mm-dd): ");
		// String something = input.nextLine();
		String day = input.nextLine();
		System.out.print("Enter time (hh:mm): ");
		String time = input.nextLine();
		System.out.println("Reminder has been set at " + time + " " + day);
	}
}