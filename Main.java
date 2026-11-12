import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        BattleEngine engine = new BattleEngine();
        Deck masterDeck = new Deck(engine);
        Difficulty difficulty = null;
        Enemy boss = null;
        Player hero;

        
            System.out.println("====== CARD BATTLE ======");
            System.out.println("1. Start Game");
            System.out.println("2. Exit");
            System.out.print("Choose: ");
            String menu = in.nextLine().strip();

            switch (menu) {
                case "1":
                    System.out.println("====== SELECT CLASS ======");
                    System.out.println("1. Mage     (100 HP, 12 Mana)");
                    System.out.println("2. Wizard   (90 HP, 15 Mana)");
                    System.out.println("3. Archmage (80 HP, 20 Mana)");
                    System.out.print("Choose: ");
                    String classChoice = in.nextLine().strip();
                    CharacterClass characterClass;

                    switch (classChoice) {
                        case "1":
                            characterClass = CharacterClass.MAGE;
                            break;
                        case "2":
                            characterClass = CharacterClass.WIZARD;
                            break;
                        case "3":
                            characterClass = CharacterClass.ARCHMAGE;
                            break;
                        default:
                            System.out.println("Invalid Input!");
                            return;
                    }
                    hero = new Player("Player", characterClass);

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
            startGame(engine,hero,boss,masterDeck, in); // used a static method for player input
    }

    public static void startGame(BattleEngine engine,Player hero, Enemy boss, Deck masterDeck, Scanner in) {
        System.out.printf("Class: %s | HP: %d | Mana: %d%n",
                hero.getClassName(), hero.getHp(), hero.getMana());
        if (!boss.isDead()) {
            engine.drawHand(masterDeck, 4);
            engine.executeTurn(hero, boss, masterDeck, in);
        }
    }
}
