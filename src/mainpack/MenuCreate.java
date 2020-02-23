package mainpack;
import java.util.*;

import strategies.CreateChecklist;
import strategies.CreateNote;
import strategies.CreateStrategy;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

public abstract class MenuCreate {
	Scanner input = new Scanner(System.in);
	DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
	private CreateStrategy strategy;

	// SET CREATE STRATEGY THEN IMPLEMENT
	public void action(CreateStrategy strategy) {
		this.strategy = strategy;
		strategy.create();
	}

	/****** CREATE FORMAT MENU ******/
	public void createFormat() {
		System.out.println("\r\n------CHOOSE FORMAT------");
		System.out.println("(1) Create a note");
		System.out.println("(2) Create a checklist");
		int option1 = input.nextInt();
		switch (option1) {
		case 1:
			action(new CreateNote());
			break;
		case 2:
			action(new CreateChecklist());
			break;
		}
	}

}
