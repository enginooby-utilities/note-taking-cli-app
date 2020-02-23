package mainpack;
public class Format {
	private int idFormat;
	private String header;
	private Enumerations.Color color = Enumerations.Color.BLUE;
	private boolean isPrivated = false;
	private String timeCreated;

	// CONSTRUCTOR
	public Format(int idFormat, String header, String timeCreated) {
		this.idFormat = idFormat;
		this.header = header;
		this.timeCreated = timeCreated;
	}

	// BORING GETTER-SETTER STUFF BLA BLA
	public int getIdFormat() {
		return idFormat;
	}

	public void setIdFormat(int idFormat) {
		this.idFormat = idFormat;
	}

	public String getHeader() {
		return header;
	}

	public Enumerations.Color getColor() {
		return color;
	}

	

	public boolean isPrivated() {
		return isPrivated;
	}

	public String getTimeCreated() {
		return timeCreated;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public void setColor(Enumerations.Color color) {
		this.color = color;
	}



	public void setPrivated(boolean isPrivated) {
		this.isPrivated = isPrivated;
	}

	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}
}
