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
            System.out.printf("Not Enough Mana!%n");
            return;
        }
        player.spendMana(getManaCost());
        boss.applyInflictDmg(damage, inflictTurn);
        System.out.printf("Player Cast %s Inflicted %d Damage to %s%n", super.getName(), damage, boss.getName());
        System.out.printf("Inflict Duration: %d%n", inflictTurn);
    }
    @Override
    public void printDetails() {
        System.out.printf("------------ INFLICTION CARD ------------%n");
        System.out.printf("Card: %s%n", super.getName());
        System.out.printf("Mana Cost: %d%n", super.getManaCost());
        System.out.printf("Damage: %d%n", damage);
        System.out.printf("Infliction Duration: %d turns%n", inflictTurn);
        System.out.printf("----------------------------------------%n");
    }
}
