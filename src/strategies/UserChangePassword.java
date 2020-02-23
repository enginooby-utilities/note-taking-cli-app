package strategies;

import mainpack.Global;

public class UserChangePassword implements UserStrategy {
	public void action() {
		System.out.println("\r\n------CHANGE PASSWORD------");
		// String skipThis = input.nextLine();
		System.out.print("Enter old password: ");
		String oldPass = input.nextLine();
		while (!Global.currentUser.getPassword().equals(oldPass)) {
			System.out.print(Global.RED + "Wrong password! Try again: " + Global.RESET);
			oldPass = input.nextLine();
		}
		System.out.print("Enter new password: ");
		String newPass = input.nextLine();
		Global.currentUser.setPassword(newPass);
		System.out.println("Password changed!");
	}
}
