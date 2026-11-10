
public class DemiCard extends Card {
    private double damage;

    public DemiCard(String name, int manaCost, double damage) {
        super(name, manaCost);
        this.damage = damage;
    }

    @Override 
    public void play(Player player, Enemy boss) {
        
        if (player.getMana() < getManaCost()) {
            System.out.println("Not Enough Mana!");
            return;
        }

        double damageCal = boss.getHp() * (damage / 100);
        int finalDamage = (int) Math.ceil(damageCal); // always round up siya
        player.spendMana(super.getManaCost());
        boss.takeDamage(finalDamage);

        System.out.println("Player Cast " + super.getName() + " Dealt "  + finalDamage + " to " + boss.getName());

    }

    @Override
    public void printDetails() {
        System.out.println("------------ DEMI CARD ------------");
        System.out.println("Card: " + super.getName());
        System.out.println("Mana Cost: " + super.getManaCost());
        System.out.println("Damage: " + damage + "%");
        System.out.println("----------------------------------------");
    }

}