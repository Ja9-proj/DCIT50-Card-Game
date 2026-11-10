
public class PhysicalCard extends Card {
    private int damage;

    public PhysicalCard(String name, int manaCost, int damage) {
        super(name, manaCost);
        this.damage = damage;
    }

    @Override 
    public void play(Player player, Enemy boss) {

        
        if (player.getMana() < getManaCost()) {
            System.out.println("Not Enough Mana!");
            return;
        }

        System.out.println("Player Cast " + super.getName() + " Dealt "  + damage + " to " + boss.getName());
        player.spendMana(super.getManaCost());
        boss.takeDamage(damage);


    }

    @Override
    public void printDetails() {
        System.out.println("------------ PHYSICAL CARD ------------");
        System.out.println("Card: " + super.getName());
        System.out.println("Mana Cost: " + super.getManaCost());
        System.out.println("Damage: " + damage);
        System.out.println("----------------------------------------");
    }

}