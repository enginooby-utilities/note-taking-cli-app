package mainpack;

/*options to all formats
including: select, search, arrange*/
import java.util.Scanner;

import strategies.PinStrategy;
import strategies.SortByColor;
import strategies.SortByHeader;
import strategies.SortByTime;

import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategies.*;

public abstract class MenuAllFormatOption extends MenuOneFormatOption {
	Scanner input = new Scanner(System.in);
	
	private SearchStrategy searchStrategy;
	//private SortStrategy sortStrategy;
	
	public void searchAction(SearchStrategy searchStrategy) {
		this.searchStrategy = searchStrategy;
		searchStrategy.action();
	}

	/**************** SELECT MENU ****************/
	public void selectMenu() { // including option menu
		while (true) {
			System.out.println("\r\n------SECLECT------");
			System.out.println("(0) Return");
			System.out.print("Enter format ID: ");
			int optionSelect = input.nextInt();
			if (optionSelect == 0)
				break;
			while (optionSelect < 0 || !checkFormatId(optionSelect)) {
				System.out.println("(0) Return");
				System.out.print("Invalid ID! Try again: ");
				optionSelect = input.nextInt();
			}
			getFormatById(optionSelect);
			optionMenu();
			break;
		}
	}

	/**************** SEARCH MENU ****************/
	public void searchMenu() {
		while (true) {
			System.out.println("\r\n------SEARCH------");
			System.out.println("(0) Return");
			System.out.println("(1) Search header");
			System.out.println("(2) Search content");
			System.out.print("Enter a number: ");
			int optionSearch = input.nextInt();
			if (optionSearch == 0)
				break;
			while (optionSearch == 1) {
				searchAction(new SearchHeader());
				break;
			}
			while (optionSearch == 2) {
				
				searchAction(new SearchContent());
				break;
			}
		}
	}

	/**************** ARRANGE MENU ****************/
	public void arrangeMenu() {
		while (true) {
			System.out.println("\r\n------ARRANGE------");
			System.out.println("(0) Return");
			System.out.println("(1) Order by header");
			System.out.println("(2) Order by color");
			System.out.println("(3) Order by created time");
			System.out.print("Enter a number: ");
			int optionArrange = input.nextInt();
			if (optionArrange == 0)
				break;
			while (optionArrange == 1) {
				headerSort();
				break;
			}
			while (optionArrange == 2) {
				colorSort();
				break;
			}
			while (optionArrange == 3) {
				timeSort();
				break;
			}
		}
	}

	// CHECK IF FORMAT ID EXISTS
	public static boolean checkFormatId(int id) { // used in Select Menu
		boolean a = false;
		List<Format> list = new ArrayList<Format>();
		if (Global.isVerified) {
			list = Global.privateFormatList;
		} else
			list = Global.formatList;
		for (Format format : list) {
			a |= (id == format.getIdFormat());
		}
		return a;
	}

	// GET FORMAT BY FORMAT ID METHOD
	public static void getFormatById(int id) { // used in Select Menu
		List<Format> list = new ArrayList<Format>();
		if (Global.isVerified) {
			list = Global.privateFormatList;
		} else
			list = Global.formatList;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdFormat() == id) {
				Global.currentFormat = list.get(i);
			}
		}
	}



	// SORT FORMAT BY HEADER
	public void headerSort() {
		System.out.println("Sorted by header!");
		if (!Global.isVerified) {
			Collections.sort(Global.formatList, new SortByHeader());
		} else {
			Collections.sort(Global.privateFormatList, new SortByHeader());
		}
		Global.displayFormat2();
	}

	// SORT FORMAT BY COLOR
	public void colorSort() {
		System.out.println("Sorted by color!");
		if (!Global.isVerified) {
			Collections.sort(Global.formatList, new SortByColor());
		} else {
			Collections.sort(Global.privateFormatList, new SortByHeader());
		}
		Global.displayFormat2();
	}

	// SORT FORMAT BY TIME CREATED
	public void timeSort() {
		System.out.println("Sorted by time created!");
		if (!Global.isVerified) {
			Collections.sort(Global.formatList, new SortByTime());
		} else {
			Collections.sort(Global.privateFormatList, new SortByTime());
		}
		Global.displayFormat2();
	}

	
}
