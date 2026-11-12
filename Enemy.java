
public class Enemy {
    private String name;
    private int hp;
    private int damage;
    private int maxHp;
    private boolean isActivated = false;
    private int turns;
    private int inflictDamage;
    public Enemy(String name, int hp, int damage) {
        if (hp <= 0) {
            throw new IllegalArgumentException("Enemy hp must not be negative or zero");
        }   

        if (damage <= 0) {
            throw new IllegalArgumentException("Enemy damage must not be negative or zero");
        }
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.maxHp = hp; // whatever hp the user place, it becomes the maxHp
    }

    // getters
    public int getTurns() {return turns; }
    public String getName(){
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getDamage() {
        return damage;
    }
    // methods
    public void takeDamage(int amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Take Damage cannot be negative");
        }


        hp = Math.max(0, hp - amount);
    }

    public void attack(Player p) {
        if (damage < 0) {
            System.out.println("No damage is dealt");
            return;
        }

        p.takeDamage(damage);

        System.out.println(name + " Dealt " + damage + " to " + p.getName());
    }
    // ADDED INFLICTION DAMAGE FEATURE
    public void applyInflictDmg(int damage, int duration) {
        this.inflictDamage = damage;
        this.turns = duration;
    }
    public void isInflicted() {
        if (turns > 0) {
            System.out.println(getName() + " gets inflicted " + inflictDamage + " damage");
            takeDamage(inflictDamage);
            turns--;
        }
    }

    public void rageMode() {
        if (hp <= 0.25 * maxHp && !isActivated && !isDead()) {
            System.out.println("\n========= RAGE MODE ===========");
            this.damage = 2 * damage;
            isActivated = true;
        }
    }

    public boolean isDead() {
        return hp <= 0;
    }
}
