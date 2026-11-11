import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random random = new Random();

        ArrayList<Enemy> easyBosses = new ArrayList<>();
        ArrayList<Enemy> mediumBosses = new ArrayList<>();
        ArrayList<Enemy> hardBosses = new ArrayList<>();
        
        ArrayList<Enemy> selectedBosses = null;
        Enemy boss = null;
        Player hero = new Player(100, 10);
        
        BattleEngine engine = new BattleEngine();
        Deck masterDeck = new Deck(engine);

        easyBosses.add(new Enemy("Goblin King", 70, 3));
        easyBosses.add(new Enemy("Cave Spider", 75, 3));
        easyBosses.add(new Enemy("Skeleton Warrior", 80, 4));
        easyBosses.add(new Enemy("Swamp Troll", 85, 4));
        easyBosses.add(new Enemy("Forest Guardian", 90, 4));

        mediumBosses.add(new Enemy("Shadow Knight", 100, 5));
        mediumBosses.add(new Enemy("Frost Guardian", 105, 5));
        mediumBosses.add(new Enemy("Flame Warden", 110, 6));
        mediumBosses.add(new Enemy("Iron Golem", 115, 6));
        mediumBosses.add(new Enemy("Dark Sorcerer", 120, 7));

        hardBosses.add(new Enemy("Abyss Lord", 135, 7));
        hardBosses.add(new Enemy("Ancient Dragon", 150, 8));
        hardBosses.add(new Enemy("Void Emperor", 145, 9));
        hardBosses.add(new Enemy("Death Bringer", 155, 8));
        hardBosses.add(new Enemy("Badong the Great", 169, 10));


        
        System.out.println("====== CARD BATTLE ======");
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
        System.out.print("Choose: ");
        String menu = in.nextLine().strip();
        
        switch (menu) {
            case "1":
                System.out.println("====== SELECT DIFFICULTY ======");
                System.out.println("1. Easy");
                System.out.println("2. Medium");
                System.out.println("3. Hard");
                System.out.print("Choose: ");
                int difficulty = in.nextInt();
                in.nextLine();

                switch (difficulty) {
                    case 1:
                        selectedBosses = easyBosses;
                        boss = engine.drawBoss(selectedBosses);
                        break;
                    case 2:
                        selectedBosses = mediumBosses;
                        boss = engine.drawBoss(selectedBosses);
                        break;
                    case 3:
                        selectedBosses = hardBosses;
                        boss = engine.drawBoss(selectedBosses);
                        break;
                    default:
                        System.out.println("Invalid Input!");
                        break;
                }
                break;
            case "2":
                System.out.println("Thank you so much byes~");
                return;
            default:
            System.out.println("Invalid input!");
            return;
        }

            if (selectedBosses == null || boss == null) {
                System.out.println("No boss Found!");
                return;
            }

            engine.drawHand(masterDeck, 4);
            engine.executeTurn(hero, boss, masterDeck);
    }
}
