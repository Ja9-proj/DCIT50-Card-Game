# Planned Features and Development Notes

This document tracks proposed features, development progress, and implementation notes for the group.

## Feature Tracker

The features below may be assigned to group members for development.

| Feature | Status | Developer |
|---|---|---|
| Stagger Meter | Completed | James |
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

## Development Log

### November 12, 2026 — 12:45 PM | **Developer:** `JAMES`

#### Boss Stagger / Stun Meter

Introduced a `Stagger Meter`. Where some `Card Type` can inflict Stagger Damage that affects the boss `Stagger Meter`. `Magic Card`, `Physical Card`, `Demi Card` are the Card type that are affected and each card a has a unique and different stagger damage. When the Stagger Meter is Full the next Card that will be Drawn can deal 20 pts of extra damage. Addition is that when the boss is stagger it cannot deal damage to the player.

#### Enemy Class

Added the following methods and Attributes:

| Method | Purpose |
|---|---|
| `takeDamage1()` | An additional helper method for the original takeDamage() method |
| `takeDamage()` | The method that analyze if it should apply the extra damage from, the stagger meter if its full or not |
| `endTurn()` | Checks out the current status of boss if its gonna skip and turns the stagger meter back to zero after being full |
| `addStaggerPTS()` | A method that add stagger damage to the stagger meter when the specific card is being drawn |
| `int getMaxStagger()` | Max Stagger Getter (Pre-Defined/ Changeable) |
| `int getStaggerMeter()` | Stagger Meter Getter |
| `int getBonusDamage()` | Extra Damage Getter |
| `int MaxStagger` | Attribute Enemy |
| `int staggerMeter` | Attribute Enemy |
| `int staggerTurns` | Attribute Enemy |
| `int bonusdamage` | Attribute Enemy |
| `boolean skipturn` | Attribute Enemy |
| `int Stagger Filler` | Attribute Added to the Card Types mentioned |

#### Classes Affected

- `DemiCard`
- `PhysicalCard`
- `MagicCard`
- `Enemy`
- `BattleEngine`



