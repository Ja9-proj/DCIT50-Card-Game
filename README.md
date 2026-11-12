# Planned Features and Development Notes

This document tracks proposed features, development progress, and implementation notes for the group.

## Feature Tracker

The features below may be assigned to group members for development.

| Feature | Status | Developer |
|---|---|---|
| Stagger Meter | In Progress | James |
| Temporary Immunity After Rage Mode | In Progress | James |
| Player Picks Card | In Progress | Van |
| Multiple Bosses | Completed | Akel |

---

## Development Log

### November 12, 2026 — 3:00 AM | **Developer:** `Akel`

#### Difficulty Selection

Introduced a `Difficulty` enum to define the difficulty levels. Each level provides an immutable list of `Enemy` boss objects. This separates difficulty configuration from `Main`, replacing the three separate lists: `easyBosses`, `mediumBosses`, and `hardBosses`. Tingin ko, mas organized itong approach dahil nababawasan ang clutter sa `Main` at mas madaling i-maintain at i-extend ang difficulty options.

#### Battle Engine

Added the following methods:

| Method | Purpose |
|---|---|
| `drawBoss()` | Randomly selects a boss from the chosen difficulty. |
| `pause()` | Adds delays to improve the pacing and presentation of the terminal interface. Inshort kartehan haha |

The `pause()` method is complete and is intended for terminal presentation.

#### Console Output Formatting

Updated print statements to use formatted output `sotuf` for cleaner, more consistent terminal messages and shorter printing code.

**Updated classes:**

- `BuffCard`
- `DemiCard`
- `MagicCard`
- `PhysicalCard`
- `PureCard`
- `BattleEngine`

### November 13, 2026 — 7:31 AM | **Developer:** `Von`

#### Player Input Selection

Introduced Player `input` feature in `BattleEngine` to give players the freedom to choose which card to play first when they end their turn. This eliminates the automatic sequence of cards being dealt every turn, making the gameplay more immersive than before. The sequence of turns now goes as follows:

1. Player picks a card from the hand.
2. Card then applies its given attributes.
3. (Player turn loops until their hand is now empty)
4. Boss attacks Player.
5. Player replenishes hand with new cards after a turn.

The input feature is using the pre-existing `Scanner` method in `Main` to avoid instantiating duplicates inside the package. Scanner instantiation was obviously changed from inside of `Main` class to outside and made it `private`. 

Also added a list of options in `BattleEngine` for players to choose:
- `List of Cards`
- `'h' to show specific card stats`
- `'a' to show all card stats`
- `'s' to show match status`

#### Main

Added following methods:

| Method | Purpose |
|---|---|
| `startGame(BattleEngine engine,Player hero, Enemy boss, Deck masterDeck, Scanner in)` | Basically separates the `executeTurn` from `main` method to all the parameters that are needed for the `executeTurn` to work. |

--------------------------------

#### New "Damage Infliction" Card

Introduced a new card type that deals damage to the enemy with every turn that they do. After the player plays one, the effect deals damage before the boss attacks and its duration decreases each turn.

Added five infliction cards to the deck:
- `Venomous Bite`
- `Burning Mark`
- `Frostbite`
- `Cursed Wound`
- `Plague Strike`

#### Enemy

| Method | Purpose |
|---|---|
| `applyInflictDmg(int damage, int duration)` | Sets the damage and duration of the effect on the boss. |
| `isInflicted() ` | Infliction Checker. Deals the effect’s damage to the boss and decreases its remaining duration. |


**Updated classes:**

- `Main`
- `BattleEngine`
- `Enemy`
- `Deck`
- `InflictionCard` (Newly Added)
