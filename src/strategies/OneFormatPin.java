package strategies;

import mainpack.*;

public class OneFormatPin implements OneFormatStrategy {

	public void action() {
		Format tempFormat = new Format(0, "", "");
		tempFormat = Global.currentFormat;
		if (Global.isVerified) {
			Global.privateFormatList.remove(Global.currentFormat);
			Global.privateFormatList.add(0, tempFormat);
		} else {
			Global.formatList.remove(Global.currentFormat);
			Global.formatList.add(0, tempFormat);
			System.out.println(Global.GREEN + "Pinned on top!" + Global.RESET);
		}
	}
}
