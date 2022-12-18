
public class Goblet extends Artifacts implements Count{
	private double mainstat;
	private String stat, element;
	public Goblet(String title, String type, int level, double mainstat, String stat, int rarity, double total, String element) {
		super(title, type, level, rarity, total);
		this.mainstat = mainstat;
		this.stat = stat;
		this.element = element;

	}
	public double getMainstat() {
		return mainstat;
	}
	public void setMainstat(double mainstat) {
		this.mainstat = mainstat;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	@Override
	public double count() {
		double temp = this.getMainstat();
		double multiplier = 0;
		if(this.getRarity()==4) {
			multiplier = 0.28;
		}
		else if(this.getRarity()==5) {
			multiplier = 0.29;
		}
		
		for(int i=0;i<this.getLevel();i++) {
			temp = temp + (this.getMainstat()*multiplier);
		}
		
		double total = temp;
		return total;
	}
	
}
