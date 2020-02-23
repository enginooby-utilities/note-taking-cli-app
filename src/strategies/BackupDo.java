package strategies;

import mainpack.Backup;
import mainpack.Global;

public class BackupDo implements BackupStrategy {
public void action() {
	Backup aBackup = new Backup();
	aBackup.backupFile();
	Global.currentUser.getBackupList().add(aBackup);
}
}
