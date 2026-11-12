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
| Character Classes | Completed | Loui-3 |

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

### November 12, 2026 | **Developer:** `loui-3`

#### Character Classes

Added Mage, Wizard, and Archmage as selectable character classes before
difficulty selection. Choosing a class determines the player's starting and
maximum health and mana:

| Class | Starting/Maximum HP | Starting/Maximum Mana | Playstyle |
|---|---:|---:|---|
| Mage | 100 | 12 | Higher health provides more room to withstand boss attacks. |
| Wizard | 90 | 15 | A balanced option with moderate health and mana. |
| Archmage | 80 | 20 | Higher mana supports more mana-costly card plays, with less health as a trade-off. |

These are stat-based differences; the classes do not currently have unique
abilities or class-specific cards. The chosen class and its starting stats are
shown before the battle. This gives players a meaningful choice of resource
balance before they select a difficulty.