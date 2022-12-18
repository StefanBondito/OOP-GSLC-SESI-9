
public class Plume extends Artifacts implements Count{
	private int atk;
	public Plume(String title, String type, int level, int rarity, int atk, double total) {
		super(title, type, level, rarity, total);
		this.atk = atk;

	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}

	@Override
	public double count() {
		// TODO Auto-generated method stub
		double temp = this.getAtk();
		double multiplier = 0;
		if(this.getRarity()==4) {
			multiplier = 0.28;
		}
		else if(this.getRarity()==5) {
			multiplier = 0.29;
		}
		
		for(int i=0;i<this.getLevel();i++) {
			temp = temp + (this.getAtk()*multiplier);
		}
		
		double total = temp;
		return total;
	}
	
	
}
