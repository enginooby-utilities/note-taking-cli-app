package mainpack;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Backup {
	private int id;
	private String time;
	private List<Format> backupFile = new ArrayList<Format>();
	private int formatAmount;
	DateTimeFormatter getTime = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	public void backupFile() {
		for (Format format : Global.formatList) {
			Format aFormat = new Format(0,"","");
			aFormat = format;
			backupFile.add(aFormat);
		}
		LocalDateTime now = LocalDateTime.now();
		time = getTime.format(now);
		id = Global.countBackupId++;
	}
	
	public void displayFormatInBackup() {
		for (Format format: backupFile) {
			System.out.println(format.getHeader());
		}
	}

	public List<Format> getBackupFile() {
		return backupFile;
	}

	public void setBackupFile(List<Format> backupFile) {
		this.backupFile = backupFile;
	}

	public int getId() {
		return id;
	}

	public String getTime() {
		return time;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getFormatAmount() {
		return formatAmount;
	}

	public void setFormatAmount(int formatAmount) {
		this.formatAmount = formatAmount;
	}
}
