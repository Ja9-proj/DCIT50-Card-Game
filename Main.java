import java.util.ArrayList;
import java.util.List;
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
            System.out.println("2. Selection Mode");
            System.out.println("3. Exit");
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
                    System.out.println("====== SELECT CLASS ======");
                    System.out.println("1. Mage     (100 HP, 12 Mana)");
                    System.out.println("2. Wizard   (90 HP, 15 Mana)");
                    System.out.println("3. Archmage (80 HP, 20 Mana)");
                    System.out.print("Choose: ");
                    classChoice = in.nextLine().strip();

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
                    boss = selectBoss();
                    break;
                case "3":
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

    private static Enemy selectBoss() {
        List<Enemy> bosses = new ArrayList<>();
        System.out.println("====== SELECT BOSS ======");
        for (Difficulty difficulty : Difficulty.values()) {
            for (Enemy boss : difficulty.getBosses()) {
                bosses.add(boss);
                System.out.printf("%2d. %-22s (%s) HP: %d | Damage: %d%n",
                        bosses.size(), boss.getName(), difficulty,
                        boss.getHp(), boss.getDamage());
            }
        }

        System.out.print("Choose a boss: ");
        try {
            int choice = Integer.parseInt(in.nextLine().strip());
            if (choice < 1 || choice > bosses.size()) {
                System.out.println("Invalid boss selection!");
                return null;
            }
            return bosses.get(choice - 1);
        } catch (NumberFormatException e) {
            System.out.println("Invalid boss selection!");
            return null;
        }
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
