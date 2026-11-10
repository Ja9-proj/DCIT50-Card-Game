
public class PureCard extends Card{
    private int damage;
    private int selfDamage;

    public PureCard(String name, int manaCost, int damage, int selfDamage) {
        super(name, manaCost);
        this.damage = damage;
        this.selfDamage = selfDamage;
    }

    @Override 
    public void play(Player player, Enemy boss) {

        if (selfDamage >= player.getHp()) {
            System.out.println("Too weak to cast");
            return;
        }

        if (player.getMana() < getManaCost()) {
            System.out.println("Not Enough Mana!");
            return;
        }

         System.out.println("Player Cast " + super.getName() + " Dealt "  + damage + " to " + boss.getName());
         System.out.println("Player took " + selfDamage + " self-damage.");
         player.spendMana(super.getManaCost());
         boss.takeDamage(damage);
         player.takeDamage(selfDamage);
    }


    @Override
    public void printDetails() {
        System.out.println("------------ PURE CARD ------------");
        System.out.println("Card: " + super.getName());
        System.out.println("Mana Cost: " + super.getManaCost());
        System.out.println("Damage: " + damage);
        System.out.println("Self-Damage: " + selfDamage);
        System.out.println("----------------------------------------");
    }
    
}