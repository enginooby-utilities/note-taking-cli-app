package strategies;

import mainpack.Global;

public class UserDelete implements UserStrategy {
	public void action() {
		Global.userList.remove(Global.currentUser);
		Global.menuState = 1; // return to the menu of guest
	}
}
