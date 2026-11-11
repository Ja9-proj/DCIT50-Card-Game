import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random random = new Random();
        Player hero = new Player(100, 10);
        
        BattleEngine engine = new BattleEngine();
        Deck masterDeck = new Deck(engine);
        Difficulty difficulty = null;
        Enemy boss = null;

        
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
                    String level = in.nextLine().strip();
    
                    switch (level) {
                        case "1":
                            difficulty = Difficulty.EASY;
                            boss = engine.drawBoss(difficulty.getBosses());
                            break;
                        case "2":
                            difficulty = Difficulty.MEDIUM;
                            boss = engine.drawBoss(difficulty.getBosses());
                            break;
                        case "3":
                            difficulty = Difficulty.HARD;
                            boss = engine.drawBoss(difficulty.getBosses());
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
            
            if (boss == null) {
                System.out.println("No boss Found!");
                return;
            }

            engine.drawHand(masterDeck, 4);
            engine.executeTurn(hero, boss, masterDeck);
        
        


    }
}
