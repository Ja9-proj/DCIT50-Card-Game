import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class BattleEngine {
    private ArrayList<Card> hand;
    private Random random = new Random();
    public BattleEngine(){
        this.hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public Enemy drawBoss(ArrayList<Enemy> selectedBosses) {

        int randomIndex = random.nextInt(selectedBosses.size());
        Enemy boss = selectedBosses.get(randomIndex);

        return boss;
    }
    public void drawHand(Deck deck, int numberOfCards) {
        
        for (int i = 0; i < numberOfCards; i++) {
            
            Card drawnCard = deck.drawRandomCard();

            if (drawnCard == null) {
                System.out.println("Deck is Empty!");
                return;
            }

            hand.add(drawnCard);
        }
    }

    public void executeTurn(Player player, Enemy boss, Deck masterDeck, Scanner inpt) {
        int bossStartingHP = boss.getHp();
        int playerTotalDamageTaken = 0;
        int turn = 1;

        System.out.print("Searching for an oppenent");

        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print(".");
        }

        System.out.println("\nBOSS ENCOUNTERED: " + boss.getName());
        System.out.println("HP: " + boss.getHp() + " | " + " Damage: " + boss.getDamage());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("----- Boss Battle Begins -----");
        System.out.println("Player | HP: " + player.getHp() + " | Mana: " + player.getMana());

        while (player.getHp() > 0 && !boss.isDead()) {
            if (turn > 1 && hand.isEmpty()) {
                drawHand(masterDeck, 3);
            }
            System.out.println("===== TURN: " + turn + " =====");
            System.out.println("===== CURRENT HAND =====");
            for (int i = 0; i < hand.size(); i++) {
                System.out.println(i+1 + ".) " + hand.get(i).getName());
            }
            System.out.println("----------------------");
            System.out.println("'h': Check one card stats");
            System.out.println("'a': Check all card stats");
            System.out.println("'s': Check match status");
            System.out.print("Choose a number(card) to play: ");
            String choice = inpt.nextLine();
            if(choice.equalsIgnoreCase("h")) {
                System.out.println("Which card to check?: ");
                int stats = inpt.nextInt();
                hand.get(stats-1).printDetails();
                inpt.nextLine();
            }
            else if(choice.equalsIgnoreCase("a")) {
                for(Card cards : hand) {
                    cards.printDetails();
                }
            } else if(choice.equalsIgnoreCase("s")) {
                System.out.println("---------------------");
                System.out.println("Player | HP: " + player.getHp() + " | Mana: " + player.getMana());
                System.out.println("---------------------");
                System.out.println("Boss | HP: " + boss.getHp() + " | Damage: " + boss.getDamage());
                System.out.println("---------------------");
            }
            try{
                int cardChoice = Integer.parseInt(choice);
                if(cardChoice > 0 && cardChoice <= hand.size()) {
                    int card = cardChoice-1;
                    hand.get(card).play(player,boss);
                    hand.remove(card);
                }
                if (hand.isEmpty()) {
                    turn++;
                }
                if (!boss.isDead() && player.getHp() > 0 && hand.isEmpty()) {
                    boss.rageMode();

                    int hpBeforeAttack = player.getHp();
                    boss.isInflicted();
                    if (!boss.isDead()) {
                        boss.attack(player);
                    }
                    playerTotalDamageTaken += hpBeforeAttack - player.getHp();
                }
            }
            catch (NumberFormatException e) {
                if (!choice.equalsIgnoreCase("h") && !choice.equalsIgnoreCase("a")
                && !choice.equalsIgnoreCase("s")) {
                    System.out.println("Invalid Input");
                }
            }
        }
            System.out.println("\n------------ BATTLE FINISHED ------------");
            if (player.getHp() > 0 && boss.isDead()) {
                System.out.println("~~~ PLAYER WINS ~~~");
            } else {
                System.out.println("~~~ PLAYER LOSE ~~~");
            }

            System.out.println("Player Final Status");
            System.out.println("HP: "+ player.getHp() + "/" + player.getMaxHp() + " | Mana: " + player.getMana() + "/" + player.getMaxMana());
            System.out.println("Total Damage Taken: " + playerTotalDamageTaken);

            if (player.getHp() == 0 && !boss.isDead()) {
                System.out.println("\n~~~ BOSS WINS ~~~");
            } else {
                System.out.println("\n~~~ BOSS LOSE ~~~");
            }
            System.out.println(boss.getName() + " Final Status");
            System.out.println("HP: " + boss.getHp() + "/" + boss.getMaxHp());
            System.out.println("Total Damage Taken: " + (bossStartingHP - boss.getHp()));
    }
}
