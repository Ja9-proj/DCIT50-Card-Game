import java.util.Random;
import java.util.ArrayList;


public class BuffCard extends Card {
    private Random random;
    private BattleEngine battleEngine;
    private int hpBoost;
    private int manaReduction;


    public BuffCard(String name, int manaCost, int hpBoost, int manaReduction, BattleEngine battleEngine) {
        super(name, manaCost);
        this.random = new Random();
        this.battleEngine = battleEngine;
        this.hpBoost = hpBoost;
        this.manaReduction = manaReduction;
    }

    @Override
    public void play(Player player, Enemy boss) {

        if (player.getMana() < getManaCost()) {
            System.out.println("Not Enough Mana!");
            return;
        }

        System.out.printf("%s MaxHP %d increase to +%d", player.getName(), player.getMaxHp(), hpBoost);
        player.setMaxHp(hpBoost);
        player.spendMana(super.getManaCost());
        
        if (manaReduction > 0) {

            ArrayList<Card> eligibleCards = new ArrayList<>(battleEngine.getHand());
            eligibleCards.remove(this);

            if (eligibleCards.isEmpty()) {
                System.out.println("No other card left to reduce!");
                return;
            }

            int randomIndex = random.nextInt(eligibleCards.size());
            Card currentCard = eligibleCards.get(randomIndex);

            int oldCost = currentCard.getManaCost();
            int newCost = Math.max(0, currentCard.getManaCost() - manaReduction);

            currentCard.setManaCost(newCost);

            System.out.printf("%n%s : %d -> %d", currentCard.getName(), oldCost, newCost);
        }
    }

    @Override
    public void printDetails() {
        System.out.print("------------ BUFF CARD ------------");
        System.out.printf("%nCard %s", super.getName());
        System.out.printf("%nMana Cost: %d", super.getManaCost());
        System.out.printf("%nHP Boost:  %d", hpBoost);
        System.out.printf("%nMana Cost Reduction: %d", manaReduction);
        System.out.printf("%n----------------------------------------%n");
    }

}