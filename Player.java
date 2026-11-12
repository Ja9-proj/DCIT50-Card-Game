
public class Player {
    private String name;
    private String className;
    private int hp;
    private int mana;
    private int maxHp;
    private int maxMana;

    public Player(String name, int hp, int mana) {
        this(name, "Adventurer", 100, 10, hp, mana);
    }

    public Player(String name, CharacterClass characterClass) {
        this(name, characterClass.getDisplayName(), characterClass.getMaxHp(),
                characterClass.getMaxMana(), characterClass.getMaxHp(), characterClass.getMaxMana());
    }

    private Player(String name, String className, int maxHp, int maxMana, int hp, int mana) {
        if (hp > maxHp || mana > maxMana) {
            throw new IllegalArgumentException("Hp or Mana Cannot exceed maxHp and maxMana");
        }

        if (hp < 0 || mana < 0) {
            throw new IllegalArgumentException("Hp or Mana cannot be negative");
        }
        this.name = name;
        this.className = className;
        this.maxHp = maxHp;
        this.maxMana = maxMana;
        this.hp = hp;
        this.mana = mana;
    }

    // getters

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }
    
    public int getHp() {
        return hp;
    }

    public int getMana() {
        return mana;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxHp(int amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("MaxHp value cannot be negative");
        }

        maxHp += amount;
    }

    // methods
    public void takeDamage(int amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Take Damage cannot be negative");
        }

        hp = Math.max(0, hp - amount);

    }

    public void heal(int amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Heal cannot be negative");
        }

        hp = Math.min(maxHp, hp + amount);
    }

    public void spendMana(int amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Spend Mana cannot be negative");
        }

        mana = Math.max(0, mana - amount);
    }

    public void restoreMana(int amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Restore Mana cannot be negative");
        }
        
        mana = Math.min(maxMana, mana + amount);
    }
}