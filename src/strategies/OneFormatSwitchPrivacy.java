package strategies;

import mainpack.Global;

public class OneFormatSwitchPrivacy implements OneFormatStrategy {
	public void action() {
		if (Global.formatList.contains(Global.currentFormat)) {
			Global.currentFormat.setPrivated(true);
			Global.privateFormatList.add(Global.currentFormat);
			Global.formatList.remove(Global.currentFormat);
		} else {
			Global.currentFormat.setPrivated(false);
			Global.formatList.add(Global.currentFormat);
			Global.privateFormatList.remove(Global.currentFormat);
		}
	}
}
