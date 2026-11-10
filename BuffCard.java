import java.util.Random;


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

        System.out.println("Player " + super.getName() + " MaxHP "  + player.getMaxHp() + " increase to +" + hpBoost);
        player.setMaxHp(hpBoost);
        player.spendMana(super.getManaCost());
        
        if (manaReduction > 0) {

            if (battleEngine.getHand().isEmpty()) {
                System.out.println("No Card left to reduce!");
                return;
            }

            int randomIndex = random.nextInt(battleEngine.getHand().size());
            
            Card currentCard = battleEngine.getHand().get(randomIndex);

            int oldCost = currentCard.getManaCost();
            int newCost = Math.max(0, currentCard.getManaCost() - manaReduction);

            currentCard.setManaCost(newCost);

            System.out.println(currentCard.getName() + ": " + oldCost + " -> " + newCost);
        }
    }

    @Override
    public void printDetails() {
        System.out.println("------------ BUFF CARD ------------");
        System.out.println("Card: " + super.getName());
        System.out.println("Mana Cost: " + super.getManaCost());
        System.out.println("HP Boost: " + hpBoost);
        System.out.println("Mana Cost Reduction: " + manaReduction);
        System.out.println("----------------------------------------");
    }

}