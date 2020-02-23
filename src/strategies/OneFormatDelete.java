package strategies;

import mainpack.Global;

public class OneFormatDelete implements OneFormatStrategy {
	public void action() {
		if (Global.formatList.contains(Global.currentFormat)) {
			Global.formatList.remove(Global.currentFormat);
		} else if (Global.privateFormatList.contains(Global.currentFormat))
			Global.privateFormatList.remove(Global.currentFormat);
	}
}
