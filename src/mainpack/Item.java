package mainpack;

public class Item {
	private String itemName;
	private boolean isChecked = false;

	// CONSTRUCTOR
	public Item(String itemName, boolean isChecked) {
		this.itemName = itemName;
		this.isChecked = isChecked;
	}

	// GET CONTENT OF A ITEM
	public String getItem() {
		if (isChecked == false)
			return (itemName + "|Unchecked ");
		else
			return (itemName + "|Checked ");
	}

	// GETTER-SETTER
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
