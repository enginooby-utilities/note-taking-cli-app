package strategies;

import mainpack.Global;
import mainpack.User;

public class GuestLogin implements GuestStrategy{
public void action() {
	System.out.println("\r\n------LOGIN------");
	String skipThis = input.nextLine(); // this will be skipped
	System.out.print("Username: ");
	String loginName = input.nextLine();
	while (!checkUsername(loginName)) {
		System.out.print(Global.RED + "Username does not exist! Try again: " + Global.RESET);
		loginName = input.nextLine();
	}
	getUserByUsername(loginName);
	System.out.print("Password: ");
	String password = input.nextLine();
	while (!Global.currentUser.getPassword().equals(password)) {
		System.out.print(Global.RED + "Wrong password! Try again: " + Global.RESET);
		password = input.nextLine();
	}
	// change to application menu for users
	Global.menuState = 2;
}

public static void getUserByUsername(String username) { // used in login()
	for (int i = 0; i < Global.userList.size(); i++) {
		if (Global.userList.get(i).getUsername().equals(username)) {
			Global.currentUser = Global.userList.get(i);
		}
	}
}

public static boolean checkUsername(String username) { // used in register(), login()  ////////duplicate
	boolean a = false;
	for (User user : Global.userList) {
		a |= username.equals(user.getUsername());
	}
	return a;
}
}
