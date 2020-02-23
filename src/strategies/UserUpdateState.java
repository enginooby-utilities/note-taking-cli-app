package strategies;

import java.time.LocalDateTime;

import mainpack.Enumerations;
import mainpack.Global;

public class UserUpdateState implements UserStrategy {
	public void action() {
		if (Global.currentUser.getLastestPayment() != null) {
			LocalDateTime lastPaid = LocalDateTime.parse(Global.currentUser.getLastestPayment().getTimePaid(), formatTime);
			LocalDateTime expiredDate = lastPaid.plusMonths(1);
			LocalDateTime now = LocalDateTime.now();
			if (!expiredDate.isAfter(now)) {
				Global.currentUser.setUserState(Enumerations.UserState.NORMAL);
			}
		}
	}
}
