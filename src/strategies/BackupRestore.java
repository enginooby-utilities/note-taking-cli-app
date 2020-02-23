package strategies;

import mainpack.Backup;
import mainpack.Format;
import mainpack.Global;
import java.util.Scanner;

public class BackupRestore implements BackupStrategy {
	public void action() {
		Scanner input = new Scanner(System.in);
		System.out.println("\r\n------RESTORE------");
		System.out.println("(0) Return");
		displayBackup2();
		System.out.print("Enter backup ID: ");
		// String skipThis = input.nextLine();
		int backupId = input.nextInt();
		if (backupId == 0)
			return;
		for (Backup backup : Global.currentUser.getBackupList()) {
			if (backupId == backup.getId()) {
				Global.formatList = backup.getBackupFile();
			}
		}
	}

	// DISPLAY ALL BACKUPS OF CURRENT USER
	public void displayBackup2() { // used by restoreBackup()
		if (!Global.currentUser.getBackupList().isEmpty()) {
			for (Backup backup : Global.currentUser.getBackupList()) {
				System.out.print("+ Backup ID: " + backup.getId() + " - Time created: " + backup.getTime()
						+ " - Amount of formats: " + backup.getBackupFile().size() + " - ");
				for (Format format : backup.getBackupFile()) {
					System.out.print("[ID" + format.getIdFormat() + " " + format.getHeader() + "] ");
				}
				System.out.println();
			}
		}

	}
}
