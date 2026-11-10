import java.util.*;


public class BattleEngine {
    private ArrayList<Card> hand;

    public BattleEngine(){
        this.hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
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

    public void executeTurn(Player player, Enemy boss, Deck masterDeck) {

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

            System.out.println("===== TURN: " + turn + " =====");

            if (turn > 1) {
                drawHand(masterDeck, 3);
            }

            if (hand.isEmpty()) {
                System.out.println("No cards avaiable this turn.");
            }

            while (!hand.isEmpty() && player.getHp() > 0 && !boss.isDead()) {
                Card card = hand.remove(0);
                card.printDetails();
                card.play(player, boss);

            }     
            if (!boss.isDead() && player.getHp() > 0) {
                boss.rageMode();

                int hpBeforeAttack = player.getHp();
                boss.attack(player);

                playerTotalDamageTaken += hpBeforeAttack - player.getHp();
            }
            turn++;
        }

            System.out.println("\n------------ BATTLE FINISHED ------------");
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

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