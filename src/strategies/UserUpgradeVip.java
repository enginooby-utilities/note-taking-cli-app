package strategies;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import mainpack.Enumerations;
import mainpack.Global;
import mainpack.Payment;

public class UserUpgradeVip implements UserStrategy {
	

	public void action() {
		if (Global.currentUser.getUserState() == Enumerations.UserState.VIP) {
			System.out.println(Global.RED + "You can't be more VIP! Wait for next month!" + Global.RESET);
		} else {
			System.out.println("\r\n------UPGRADE VIP------");
			System.out.println(Global.BLUE
					+ "Being a VIP user, you will have many benefits. The package expires after a month. Enter information below:"
					+ Global.RESET);
			System.out.print("Account type: ");
			String accountType = input.nextLine();
			System.out.print("Account number: ");
			int accountNumber = input.nextInt();
			System.out.print("Amount: ");
			int amount = input.nextInt();
			LocalDateTime now = LocalDateTime.now();
			Global.currentUser.setLastestPayment(
					new Payment(Global.countPaymentId++, accountType, accountNumber, amount, formatTime.format(now)));
			// = new Payment(Global.countPaymentId++, accountType, accountNumber, amount,
			// formatTime.format(now)); // update lastest payment
			Global.currentUser.getPaymentList().add(Global.currentUser.getLastestPayment());
			Global.currentUser.setUserState(Enumerations.UserState.VIP);
			System.out.println(Global.GREEN + "Purchased successfully!" + Global.RESET);
		}
	}

	// UPDATE USER STATE
	public void updateUserState() {
		if (Global.currentUser.getLastestPayment() != null) {
			LocalDateTime lastPaid = LocalDateTime.parse(Global.currentUser.getLastestPayment().getTimePaid(),
					formatTime);
			LocalDateTime expiredDate = lastPaid.plusMonths(1);
			LocalDateTime now = LocalDateTime.now();
			if (expiredDate.isAfter(now)) {
				Global.currentUser.setUserState(Enumerations.UserState.NORMAL); // = Enumerations.UserState.NORMAL;
			}
		}
	}
}
