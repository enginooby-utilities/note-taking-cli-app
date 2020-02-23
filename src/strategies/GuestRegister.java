package strategies;

import java.util.Random;

import mainpack.Global;
import mainpack.User;

public class GuestRegister implements GuestStrategy {

	public void action() {
		// enter email
		System.out.println("\r\n------REGISTER------");
		//String skipThis = input.nextLine(); // this will be skipped
		System.out.print("Enter email: ");
		String email = input.nextLine();
		while (checkEmail(email)) {
			System.out.print(Global.RED + "This email has been used! Try another: " + Global.RESET);
			email = input.nextLine();
		}
		// enter username and password
		System.out.print("Enter username: ");
		String username = input.nextLine();
		while (checkUsername(username)) {
			System.out.print(Global.RED + "This username has been used! Try another: " + Global.RESET);
			username = input.nextLine();
		}
		System.out.print("Enter password: ");
		String pass = input.nextLine();
		// verify email
		int code = new Random().nextInt(999) + 1000;
		System.out.println(Global.BLUE + "[New email] Your code to activate the account is: " + code + Global.RESET);
		System.out.print(Global.BLUE + "Enter your activation code: " + Global.RESET);
		int activate = input.nextInt();
		while (activate != code) {
			System.out.print(Global.RED + "The code is wrong! Try again: " + Global.RESET);
			activate = input.nextInt();
		}
		// create a new user
		System.out.println(Global.GREEN + "Register successfully!" + Global.RESET);
		User user = new User(email, username, pass);
		Global.userList.add(user);
		user.setID(Global.countUserId++);
	}

//CHECK IF EMAIL EXISTS
	public boolean checkEmail(String email) { // used in register()
		boolean a = false;
		for (User user : Global.userList) {
			a |= email.equals(user.getEmail());
		}
		return a;
	}

	// CHECK IF USERNAME EXIST
	public static boolean checkUsername(String username) { // used in register(), login()
		boolean a = false;
		for (User user : Global.userList) {
			a |= username.equals(user.getUsername());
		}
		return a;
	}
}
