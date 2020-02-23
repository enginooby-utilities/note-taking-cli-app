package strategies;

public class OneFormatShare implements OneFormatStrategy {
	public void action() {
		System.out.print("(1)Email - ");
		System.out.print("(2)Share Facebook - ");
		System.out.println("(3)Share Whatsapp");
		System.out.print("Choose option: ");
		// String something = input.nextLine();
		int shareOption = input.nextInt();
		switch (shareOption) {
		case 1:
			System.out.println("Sent email!");
			break;
		case 2:
			System.out.println("Shared Facebook!");
			break;
		case 3:
			System.out.println("Shared Whatsapp!");
			break;
		}
	}
}
