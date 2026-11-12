public class InflictionCard extends Card{
    private int inflictTurn;
    private int damage;
    public InflictionCard(String name, int manaCost, int damage, int inflictTurn) {
        super(name, manaCost);
        this.damage = damage;
        this.inflictTurn = inflictTurn;
    }
    @Override
    public void play(Player player, Enemy boss) {
        if (player.getMana() < getManaCost()) {
            System.out.println("Not Enough Mana!");
            return;
        }
        player.spendMana(getManaCost());
        boss.applyInflictDmg(damage, inflictTurn);
        System.out.println("Player Cast " + super.getName() + " Inflicted "  + damage + " Damage to " + boss.getName());
        System.out.println("Inflict Duration: " + inflictTurn);
    }
    @Override
    public void printDetails() {
        System.out.println("------------ INFLICTION CARD ------------");
        System.out.println("Card: " + super.getName());
        System.out.println("Mana Cost: " + super.getManaCost());
        System.out.println("Damage: " + damage);
        System.out.println("Infliction Duration: " + inflictTurn + " turns");
        System.out.println("----------------------------------------");
    }
}
