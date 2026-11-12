public enum CharacterClass {
    MAGE("Mage", 100, 12),
    WIZARD("Wizard", 90, 15),
    ARCHMAGE("Archmage", 80, 20);

    private final String displayName;
    private final int maxHp;
    private final int maxMana;

    CharacterClass(String displayName, int maxHp, int maxMana) {
        this.displayName = displayName;
        this.maxHp = maxHp;
        this.maxMana = maxMana;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxMana() {
        return maxMana;
    }
}
