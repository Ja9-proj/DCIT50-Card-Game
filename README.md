# Planned Features and Development Notes

This document tracks proposed features, development progress, and implementation notes for the group.

## Feature Tracker

The features below may be assigned to group members for development.

| Feature | Status | Developer |
|---|---|---|
| Stagger Meter | Planned | Unassigned |
| Temporary Immunity After Rage Mode | Planned | Unassigned |
| Boss Drop Rates and Loot System | Planned | Unassigned |
| Loot Inventory | Planned | Unassigned |
| Local File Storage | Planned | Unassigned |
| Multiple Bosses | Completed | Akel |

---

## Development Log

### November 11-12, 2026

**Developer:** Akel

#### Difficulty Selection

Introduced a `Difficulty` enum to define the difficulty levels. Each level provides an immutable list of `Enemy` boss objects.

This separates difficulty configuration from `Main`, replacing the three separate lists: `easyBosses`, `mediumBosses`, and `hardBosses`.

Tingin ko, mas organized itong approach dahil nababawasan ang clutter sa `Main` at mas madaling i-maintain at i-extend ang difficulty options.

#### Main Class

Kept changes to `Main` minimal to leave room for the group's upcoming implementations.

Alam kong may idaragdag pa kayong features, kaya basic structure pa lang muna ang nilagay ko at