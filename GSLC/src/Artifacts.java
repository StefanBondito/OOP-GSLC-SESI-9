	
public abstract class Artifacts {
	private String title, type;
	private int level, rarity;
	private double total;

	
	public Artifacts(String title, String type, int level, int rarity, double total) {
		this.title = title;
		this.type = type;
		this.level = level;
		this.rarity = rarity;
		this.total = total;

	}

	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
}
