import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
	Scanner sc = new Scanner(System.in);
	ArrayList<Artifacts> artifactList = new ArrayList<>();
	Random rand = new Random();
	// Function to display menu
	public void menu() {
		System.out.println("========================");
		System.out.println("|Artifact Database v1.0|");
		System.out.println("========================");
		System.out.println("1. Insert Artifacts");
		System.out.println("2. View obtainable artifacts");
		System.out.println("3. Search for artifact");
		System.out.println("4. Exit");
		System.out.print(">> ");
	}
	// This program is called "Artifact Database v1.0". 
	// The usage for this program is to register a genshin artifact into a list. 
	// while calculating the main stat for said artifact. 
	// Lastly, this program will also simulate getting an artifact from the list 
	
	public Main() {
		// Function for choosing the menu
		int choice;
		do {
			menu();
			choice = sc.nextInt();sc.nextLine();
			switch (choice) {
			case 1:
				insert();
				break;
			case 2:
				view();
				break;
			case 3:
				grind();
				break;

			default:
				break;
			}
		}while(choice !=4);
	}
	
	// Below are functions for validating the user's input
	
	public int validasiTitle(String title) {
		if(title.length() >= 5 && title.length() <=25) {
			return 1;
		}
		return 0;
	}
	
	public int validasiType(String type) {
		if(type.equals("Flower") || type.equals("Plume") || type.equals("Sands") || type.equals("Goblet") || type.equals("Circlet")) {
			return 1;
		}
		return 0;
	}
	
	public int validasiLevel(int level) {
		if(level >= 1 && level <= 20) {
			return 1;
		}
		return 0;
	}
	
	public int validasiRarity(int rarity) {
		if(rarity == 4 || rarity == 5) {
			return 1;
		}
		return 0;
	}
	
	public int validasiHp(int hp) {
		if(hp >= 645 && hp <= 717) {
			return 1;
		}
		return 0;
	}
	
	public int validasiAtk(int atk) {
		if(atk >= 42 && atk <= 47) {
			return 1;
		}
		return 0;
	}
	
	public int validasiStat(String stat) {
		if(stat.equals("HP%") || stat.equals("ATK%") || stat.equals("DEF%") || stat.equals("Phys") || stat.equals("Elem") || stat.equals("EM") || stat.equals("ER") || stat.equals("Crit Rate") || stat.equals("Crit Damage") || stat.equals("Healing Bonus")) {
			return 1;
		}
		return 0;
	}
	
	public int validasiMainStat(String stat, double mainstat) {
		if(stat.equals("HP%")) {
			if(mainstat >= 6.3 && mainstat <= 7.0) {
				return 1;
			}
		}
		
		else if(stat.equals("ATK%")) {
			if(mainstat >= 6.3 && mainstat <= 7.0) {
				return 1;
			}
		}
		else if(stat.equals("DEF%")) {
			if(mainstat >= 7.9 && mainstat <= 8.7) {
				return 1;
			}
		}
		else if(stat.equals("EM")) {
			if(mainstat >= 25.2 && mainstat <= 28) {
				return 1;
			}
		}
		else if(stat.equals("ER")) {
			if(mainstat >= 7.0 && mainstat <= 7.8) {
				return 1;
			}
		}
		else if(stat.equals("Phys")) {
			if(mainstat >= 7.9 && mainstat <= 8.7) {
				return 1;
			}
		}
		else if(stat.equals("Elem")) {
			if(mainstat >= 6.3 && mainstat <= 7.0) {
				return 1;
			}
		}
		else if(stat.equals("Crit Rate")) {
			if(mainstat >= 4.2 && mainstat <= 4.7) {
				return 1;
			}
		}
		else if(stat.equals("Crit Damage")) {
			if(mainstat >= 8.4 && mainstat <= 9.3) {
				return 1;
			}
		}
		else if(stat.equals("Healing Bonus")) {
			if(mainstat >= 4.8 && mainstat <= 5.4) {
				return 1;
			}
		}
		return 0;
	}
	
	public int validasiElement(String element) {
		if(element.equals("Pyro") || element.equals("Hydro") ||element.equals("Cryo") ||element.equals("Dendro") ||element.equals("Electro") ||element.equals("Geo") ||element.equals("Anemo")) {
			return 1;
		}
		return 0;
	}
	
	public void insert() {
		// This is the function for inputting an artifact
		String title, type;
		String element = "";
		int level, rarity;
		int hp, atk;
		double mainstat = 0;
		double total = 0;
		String stat;
			System.out.println();
			System.out.println("Add new artifacts");
			System.out.println("===========================");
			// This is the part for the user to input data
			while(true) {
				System.out.print("Input Title [5..25 characters] : ");
				title = sc.nextLine();
				if(validasiTitle(title)==1) {
					break;
				}
			}
			
			while(true) {
				System.out.print("Input type [Flower | Plume | Sands | Goblet | Circlet] [Case Sensitive] : ");
				type = sc.nextLine();
				if(validasiType(type)==1) {
					break;
				}
			}
			
			while(true) {
				System.out.print("Input artifact rarity [4 | 5] Stars : ");
				rarity = sc.nextInt();sc.nextLine();
				if(validasiRarity(rarity)==1) {
					break;
				}
			}
			
			while(true) {
				System.out.print("Input artifact level [1..20] : ");
				level = sc.nextInt();sc.nextLine();
				if(validasiLevel(level)==1) {
					break;
				}
			}
			// Separated input based on the type that the user inserted
			// Flower Class
			if(type.equals("Flower")) {
				while(true) {
					System.out.print("Input base HP stat [645 - 717] : ");
					hp = sc.nextInt();sc.nextLine();
					if(validasiHp(hp)==1) {
						break;
					}
				}
				// Making an object based from the user's input
				artifactList.add(new Flower(title, type, level, hp, rarity, total));
				Artifacts flower = artifactList.get(artifactList.size()-1);
				// Calling the count function to get total stat
				total = ((Flower)flower).count();
				((Flower)flower).setTotal(total);
			}
			
			// Plume Class
			else if(type.equals("Plume")) {
				while(true) {
					System.out.print("Input base ATK stat [42 - 47] : ");
					atk = sc.nextInt();sc.nextLine();
					if(validasiAtk(atk)==1) {
						break;
					}
				}
				// Making an object based from the user's input
				artifactList.add(new Plume(title, type, level, rarity, atk, total));
				Artifacts plume = artifactList.get(artifactList.size()-1);
				// Calling the count function to get total stat
				total = ((Plume)plume).count();
				((Plume)plume).setTotal(total);
			}
			
			// Sands Class
			else if(type.equals("Sands")) {
				while(true) {
					System.out.print("Input Main Stat [HP% | ATK% | DEF% | EM | ER] : ");
					stat = sc.nextLine();
					if(validasiStat(stat)==1) {
						break;
					}
				}
				if(stat.equals("HP%")) {
					while(true) {
						System.out.print("Input Main Stat Value [6.3 - 7.0] : ");
						mainstat = sc.nextDouble();sc.nextLine();
						if(validasiMainStat(stat, mainstat)==1) {
							break;
						}
					}
				}
				else if(stat.equals("ATK%")) {
					while(true) {
						System.out.print("Input Main Stat Value [6.3 - 7.0] : ");
						mainstat = sc.nextDouble();sc.nextLine();
						if(validasiMainStat(stat, mainstat)==1) {
							break;
						}
					}
				}
				else if(stat.equals("DEF%")) {
					while(true) {
						System.out.print("Input Main Stat Value [7.9 - 8.7] : ");
						mainstat = sc.nextDouble();sc.nextLine();
						if(validasiMainStat(stat, mainstat)==1) {
							break;
						}
					}
				}
				else if(stat.equals("EM")) {
					while(true) {
						System.out.print("Input Main Stat Value [25.2 - 28] : ");
						mainstat = sc.nextDouble();sc.nextLine();
						if(validasiMainStat(stat, mainstat)==1) {
							break;
						}
					}
				}
				else if(stat.equals("ER")) {
					while(true) {
						System.out.print("Input Main Stat Value [7.0 - 7.8] : ");
						mainstat = sc.nextDouble();sc.nextLine();
						if(validasiMainStat(stat, mainstat)==1) {
							break;
						}
					}
				}
				// Making an object based from the user's input
				artifactList.add(new Sands(title, type, level, mainstat, stat, rarity, total));
				Artifacts sands = artifactList.get(artifactList.size()-1);
				// Calling the count function to get total stat
				total = ((Sands)sands).count();
				((Sands)sands).setTotal(total);
			}
			// Goblet
				else if(type.equals("Goblet")) {
					while(true) {
						System.out.print("Input Main Stat [HP% | ATK% | DEF% | EM | Phys | Elem] : ");
						stat = sc.nextLine();
						if(validasiStat(stat)==1) {
							break;
						}
					}
					if(stat.equals("HP%")) {
						while(true) {
							System.out.print("Input Main Stat Value [6.3 - 7.0] : ");
							mainstat = sc.nextDouble();sc.nextLine();
							if(validasiMainStat(stat, mainstat)==1) {
								break;
							}
						}
					}
					else if(stat.equals("ATK%")) {
						while(true) {
							System.out.print("Input Main Stat Value [6.3 - 7.0] : ");
							mainstat = sc.nextDouble();sc.nextLine();
							if(validasiMainStat(stat, mainstat)==1) {
								break;
							}
						}
					}
					else if(stat.equals("DEF%")) {
						while(true) {
							System.out.print("Input Main Stat Value [7.9 - 8.7] : ");
							mainstat = sc.nextDouble();sc.nextLine();
							if(validasiMainStat(stat, mainstat)==1) {
								break;
							}
						}
					}
					else if(stat.equals("EM")) {
						while(true) {
							System.out.print("Input Main Stat Value [25.2 - 28] : ");
							mainstat = sc.nextDouble();sc.nextLine();
							if(validasiMainStat(stat, mainstat)==1) {
								break;
							}
						}
					}
					else if(stat.equals("Phys")) {
						while(true) {
							System.out.print("Input Main Stat Value [7.9 - 8.7] : ");
							mainstat = sc.nextDouble();sc.nextLine();
							if(validasiMainStat(stat, mainstat)==1) {
								break;
							}
						}
					}
					else if(stat.equals("Elem")) {
						while(true) {
							System.out.print("Input Element Bonus [Pyro | Electro | Cryo | Dendro | Hydro | Anemo | Geo] : ");
							element = sc.nextLine();
							if(validasiElement(element)==1) {
								break;
							}
						}
						while(true) {
							System.out.print("Input Main Stat Value [6.3 - 7.0] : ");
							mainstat = sc.nextDouble();sc.nextLine();
							if(validasiMainStat(stat, mainstat)==1) {
								break;
							}
						}
					}
					// Making an object based from the user's input
					artifactList.add(new Goblet(title, type, level, mainstat, stat, rarity, total, element));
					Artifacts goblet = artifactList.get(artifactList.size()-1);
					// Calling the count function to get total stat
					total = ((Goblet)goblet).count();
					((Goblet)goblet).setTotal(total);
				}
			
			// Circlet
				else if(type.equals("Circlet")) {
					while(true) {
						System.out.print("Input Main Stat [HP% | ATK% | DEF% | EM | Crit Rate | Crit Damage] : ");
						stat = sc.nextLine();
						if(validasiStat(stat)==1) {
							break;
						}
					}
					if(stat.equals("HP%")) {
						while(true) {
							System.out.print("Input Main Stat Value [6.3 - 7.0] : ");
							mainstat = sc.nextDouble();sc.nextLine();
							if(validasiMainStat(stat, mainstat)==1) {
								break;
							}
						}
					}
					else if(stat.equals("ATK%")) {
						while(true) {
							System.out.print("Input Main Stat Value [6.3 - 7.0] : ");
							mainstat = sc.nextDouble();sc.nextLine();
							if(validasiMainStat(stat, mainstat)==1) {
								break;
							}
						}
					}
					else if(stat.equals("DEF%")) {
						while(true) {
							System.out.print("Input Main Stat Value [7.9 - 8.7] : ");
							mainstat = sc.nextDouble();sc.nextLine();
							if(validasiMainStat(stat, mainstat)==1) {
								break;
							}
						}
					}
					else if(stat.equals("EM")) {
						while(true) {
							System.out.print("Input Main Stat Value [25.2 - 28] : ");
							mainstat = sc.nextDouble();sc.nextLine();
							if(validasiMainStat(stat, mainstat)==1) {
								break;
							}
						}
					}
					else if(stat.equals("Crit Rate")) {
						while(true) {
							System.out.print("Input Main Stat Value [4.2 - 4.7] : ");
							mainstat = sc.nextDouble();sc.nextLine();
							if(validasiMainStat(stat, mainstat)==1) {
								break;
							}
						}
					}
					else if(stat.equals("Crit Damage")) {
						while(true) {
							System.out.print("Input Main Stat Value [8.4 - 9.3] : ");
							mainstat = sc.nextDouble();sc.nextLine();
							if(validasiMainStat(stat, mainstat)==1) {
								break;
							}
						}
					}
					else if(stat.equals("Healing Bonus")) {
						while(true) {
							System.out.print("Input Main Stat Value [4.8 - 5.4] : ");
							mainstat = sc.nextDouble();sc.nextLine();
							if(validasiMainStat(stat, mainstat)==1) {
								break;
							}
						}
					}
					// Making an object based from the user's input
					artifactList.add(new Circlet(title, type, level, mainstat, stat, rarity, total));
					Artifacts circlet = artifactList.get(artifactList.size()-1);
					// Calling the count function to get total stat
					total = ((Circlet)circlet).count();
					((Circlet)circlet).setTotal(total);
				}
			System.out.println();
			System.out.println("New Artifact has been added");
			System.out.println("Press Enter to Continue...");sc.nextLine();
			}
	
	
	public void view() {
		// Validate if the list is empty or not
		if(artifactList.size()==0) {
			System.out.println("No obtainable artifacts!");
			System.out.println("Press Enter to continue ...");sc.nextLine();
		}
		else {
			int number = 0;
			// the for loop is used to get all artifacts inside the list 'artifactList'
			for(Artifacts artifact : artifactList) {
				number++;
				// We use this 'if... instanceof...' specifically for calling out attributes that is available in the parent and the child class
				if(artifact instanceof Flower) {
					System.out.println("=======================================");
					System.out.println("Artifact No. " + number);
					System.out.print("Name: ");
					System.out.println(artifact.getTitle());
					System.out.print("Type: ");
					System.out.println(artifact.getType());
					System.out.print("Level: ");
					System.out.println(artifact.getLevel());
					System.out.print("Rarity: ");
					System.out.println(artifact.getRarity());
					System.out.print("Main Stat: ");
					System.out.println("Hp");
					System.out.print("Base Stat: ");
					// this is typecasting the artifact as an object from the child class flower, so that we can access the getter of the child class
					System.out.println(((Flower)artifact).getHp());
					System.out.print("Total Stat: ");
					System.out.println((int) artifact.getTotal());
					System.out.println("=======================================");
					System.out.println();
				}
				// We use this 'if... instanceof...' specifically for calling out attributes that is available in the parent and the child class
				else if(artifact instanceof Plume) {
					System.out.println("=======================================");
					System.out.println("Artifact No. " + number);
					System.out.print("Name: ");
					System.out.println(artifact.getTitle());
					System.out.print("Type: ");
					System.out.println(artifact.getType());
					System.out.print("Level: ");
					System.out.println(artifact.getLevel());
					System.out.print("Rarity: ");
					System.out.println(artifact.getRarity());
					System.out.print("Main Stat: ");
					System.out.println("Hp");
					System.out.print("Base Stat: ");
					// this is typecasting the artifact as an object from the child class plume, so that we can access the getter of the child class
					System.out.println(((Plume)artifact).getAtk());
					System.out.print("Total Stat: ");
					System.out.println((int) artifact.getTotal());
					System.out.println("=======================================");
					System.out.println();
				}
				// We use this 'if... instanceof...' specifically for calling out attributes that is available in the parent and the child class
				else if(artifact instanceof Sands) {
					System.out.println("=======================================");
					System.out.println("Artifact No. " + number);
					System.out.print("Name: ");
					System.out.println(artifact.getTitle());
					System.out.print("Type: ");
					System.out.println(artifact.getType());
					System.out.print("Level: ");
					System.out.println(artifact.getLevel());
					System.out.print("Rarity: ");
					System.out.println(artifact.getRarity());
					System.out.print("Main Stat: ");
					// this is typecasting the artifact as an object from the child class Sands, so that we can access the getter of the child class
					System.out.println(((Sands)artifact).getStat());
					System.out.print("Base Stat: ");
					System.out.println(((Sands)artifact).getMainstat());
					System.out.print("Total Stat: ");
					System.out.println((int) artifact.getTotal());
					System.out.println("=======================================");
					System.out.println();
				}
				// We use this 'if... instanceof...' specifically for calling out attributes that is available in the parent and the child class
				else if(artifact instanceof Goblet) {
					System.out.println("=======================================");
					System.out.println("Artifact No. " + number);
					System.out.print("Name: ");
					System.out.println(artifact.getTitle());
					System.out.print("Type: ");
					System.out.println(artifact.getType());
					System.out.print("Level: ");
					System.out.println(artifact.getLevel());
					System.out.print("Rarity: ");
					System.out.println(artifact.getRarity());
					System.out.print("Main Stat: ");
					// this is typecasting the artifact as an object from the child class Goblet, so that we can access the getter of the child class
					System.out.println(((Goblet)artifact).getStat());
					System.out.print("Base Stat: ");
					System.out.println(((Goblet)artifact).getMainstat());
					System.out.print("Total Stat: ");
					System.out.println((int) artifact.getTotal());
					System.out.println("=======================================");
					System.out.println();
				}
				// We use this 'if... instanceof...' specifically for calling out attributes that is available in the parent and the child class
				else if(artifact instanceof Circlet) {
					System.out.println("=======================================");
					System.out.println("Artifact No. " + number);
					System.out.print("Name: ");
					System.out.println(artifact.getTitle());
					System.out.print("Type: ");
					System.out.println(artifact.getType());
					System.out.print("Level: ");
					System.out.println(artifact.getLevel());
					System.out.print("Rarity: ");
					System.out.println(artifact.getRarity());
					System.out.print("Main Stat: ");
					// this is typecasting the artifact as an object from the child class Circlet, so that we can access the getter of the child class
					System.out.println(((Circlet)artifact).getStat());
					System.out.print("Base Stat: ");
					System.out.println(((Circlet)artifact).getMainstat());
					System.out.print("Total Stat: ");
					System.out.println((int) artifact.getTotal());
					System.out.println("=======================================");
					System.out.println();
				}
			}
			System.out.println("Press enter to continue...");sc.nextLine();
		}
	}
	
	
	public int validasiSearch(String search) {
		if(search.length()!=0) {
			return 1;
		}
		return 0;
	}
	public void grind() {
		String search;
		while(true) {
			System.out.print("Input your character : ");
			search = sc.nextLine();
			if(validasiSearch(search)==1) {
				break;
			}
		}
		// This is a function for obtaining a random index for an artifact in the list
		int idx = rand.nextInt(artifactList.size()) + 1;
		System.out.println();
		System.out.println(search + " has farmed an artifact");
		Artifacts chosen = artifactList.get(idx-1);
		
		// Below is printing the obtained artifact from its index
		if(chosen instanceof Flower) {
			System.out.println("=======================================");
			System.out.print("Name: ");
			System.out.println(chosen.getTitle());
			System.out.print("Type: ");
			System.out.println(chosen.getType());
			System.out.print("Level: ");
			System.out.println(chosen.getLevel());
			System.out.print("Rarity: ");
			System.out.println(chosen.getRarity());
			System.out.print("Main Stat: ");
			System.out.println("Hp");
			System.out.print("Base Stat: ");
			System.out.println(((Flower)chosen).getHp());
			System.out.print("Total Stat: ");
			System.out.println((int) chosen.getTotal());
			System.out.println("=======================================");
			System.out.println();
		}
		else if(chosen instanceof Plume) {
			System.out.println("=======================================");
			System.out.print("Name: ");
			System.out.println(chosen.getTitle());
			System.out.print("Type: ");
			System.out.println(chosen.getType());
			System.out.print("Level: ");
			System.out.println(chosen.getLevel());
			System.out.print("Rarity: ");
			System.out.println(chosen.getRarity());
			System.out.print("Main Stat: ");
			System.out.println("Hp");
			System.out.print("Base Stat: ");
			System.out.println(((Plume)chosen).getAtk());
			System.out.print("Total Stat: ");
			System.out.println((int) chosen.getTotal());
			System.out.println("=======================================");
			System.out.println();
		}
		else if(chosen instanceof Sands) {
			System.out.println("=======================================");
			System.out.println("Artifact No. " + chosen);
			System.out.print("Name: ");
			System.out.println(chosen.getTitle());
			System.out.print("Type: ");
			System.out.println(chosen.getType());
			System.out.print("Level: ");
			System.out.println(chosen.getLevel());
			System.out.print("Rarity: ");
			System.out.println(chosen.getRarity());
			System.out.print("Main Stat: ");
			System.out.println(((Sands)chosen).getStat());
			System.out.print("Base Stat: ");
			System.out.println(((Sands)chosen).getMainstat());
			System.out.print("Total Stat: ");
			System.out.println((int) chosen.getTotal());
			System.out.println("=======================================");
			System.out.println();
		}
		else if(chosen instanceof Goblet) {
			System.out.println("=======================================");
			System.out.print("Name: ");
			System.out.println(chosen.getTitle());
			System.out.print("Type: ");
			System.out.println(chosen.getType());
			System.out.print("Level: ");
			System.out.println(chosen.getLevel());
			System.out.print("Rarity: ");
			System.out.println(chosen.getRarity());
			System.out.print("Main Stat: ");
			System.out.println(((Goblet)chosen).getStat());
			System.out.print("Base Stat: ");
			System.out.println(((Goblet)chosen).getMainstat());
			System.out.print("Total Stat: ");
			System.out.println((int) chosen.getTotal());
			System.out.println("=======================================");
			System.out.println();
		}
		else if(chosen instanceof Circlet) {
			System.out.println("=======================================");
			System.out.print("Name: ");
			System.out.println(chosen.getTitle());
			System.out.print("Type: ");
			System.out.println(chosen.getType());
			System.out.print("Level: ");
			System.out.println(chosen.getLevel());
			System.out.print("Rarity: ");
			System.out.println(chosen.getRarity());
			System.out.print("Main Stat: ");
			System.out.println(((Circlet)chosen).getStat());
			System.out.print("Base Stat: ");
			System.out.println(((Circlet)chosen).getMainstat());
			System.out.print("Total Stat: ");
			System.out.println((int) chosen.getTotal());
			System.out.println("=======================================");
			System.out.println();
		}
		System.out.println("Press Enter to continue ... ");sc.nextLine();
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}

