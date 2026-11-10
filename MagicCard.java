
public class MagicCard extends Card {
    private int damage;
    private int healAmount;
    private int manaRestore;

    public MagicCard(String name, int manaCost, int damage, int healAmount, int manaRestore) {
        super(name, manaCost);
        this.damage = damage;
        this.healAmount = healAmount;
        this.manaRestore = manaRestore;
    }

    @Override 
    public void play(Player player, Enemy boss) {


        if (player.getMana() < getManaCost()) {
            System.out.println("Not Enough Mana!");
            return;
        }



         System.out.println("Player Cast " + super.getName() + " Dealt "  + damage + " to " + boss.getName());
         System.out.println("Healed player by " + healAmount + " HP");
         System.out.println("Restored " + manaRestore + " mana.");
         player.spendMana(super.getManaCost());
         boss.takeDamage(damage);
         player.heal(healAmount);
         player.restoreMana(manaRestore);

        
    }

    @Override
    public void printDetails() {
        System.out.println("------------ MAGIC CARD ------------");
        System.out.println("Card: " + super.getName());
        System.out.println("Mana Cost: " + super.getManaCost());
        System.out.println("Damage: " + damage);
        System.out.println("Heal:" + healAmount);
        System.out.println("Restored: " + manaRestore);
        System.out.println("----------------------------------------");
    }
}
