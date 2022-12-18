
public class Flower extends Artifacts implements Count{
	private int hp;

	public Flower(String title, String type, int level, int hp, int rarity, double total) {
		super(title, type, level, rarity, total);
		this.hp = hp;
	
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}


	@Override
	public double count() {
		double temp = this.getHp();
		double multiplier = 0;
		if(this.getRarity()==4) {
			multiplier = 0.28;
		}
		else if(this.getRarity()==5) {
			multiplier = 0.29;
		}
		
		for(int i=0;i<this.getLevel();i++) {
			temp = temp + (this.getHp()*multiplier);
		}
		
		double total = temp;
		return total;
		
	}
	
}
