
public abstract class Card {
    private String name;
    private int manaCost;

    public Card(String name, int manaCost) {
        this.name = name;
        setManaCost(manaCost);
    }

    // getters

    public String getName() {
        return name;
    }

    public int getManaCost() {
        return manaCost;
    }

    // setter
    public void setManaCost(int manaCost) {
        if (manaCost < 0) {
            throw new IllegalArgumentException("Mana cost cannot be negative");
        }

        this.manaCost = manaCost;
    }


    // methods
    public abstract void play(Player player, Enemy boss);

    public abstract void printDetails();


}
