## Turn-Based OOP Game Design Documentation

This document outlines the core structure, turn flow, and database integration of a simple turn-based game using object-oriented principles in Java. It focuses on concepts and responsibilities without diving into code details.

---

### 1. Overview

A turn-based game consists of alternating turns between players (human or AI), during which each player controls one or more units to perform actions (e.g., move, attack, use ability). The game continues until a win condition is met.

**Key Concepts:**

* **Player**: An entity controlling units.
* **Unit**: A game piece with attributes and actions.
* **Game Loop**: Manages turn order and checks win conditions.
* **Actions**: Discrete operations units can perform on their turn.
* **Database Layer**: Persists game state and settings using MySQL.

---

### 2. Core Components

#### Game

* **Responsibility:** Central coordinator for turn sequencing and win condition checks.
* **Holds:** List of players and game state (e.g., turn count).
* **Flow:** Repeats selecting the next player, allowing their turn, and evaluating end conditions.

#### Player

* **Responsibility:** Manages the player's units and executes the player's turn.
* **Holds:** A collection of units and a flag indicating human or AI control.
* **Flow:** On their turn, iterates through units to choose and execute an action.

#### Unit

* **Responsibility:** Encapsulates attributes (health, movement capacity, abilities) and determines available actions.
* **Holds:** Its state (e.g., position, health) and references to the owning player.
* **Flow:** Provides possible actions and applies chosen actions to update state.

#### Action

* **Responsibility:** Defines a specific operation (move, attack, defend, etc.).
* **Flow:** Validates prerequisites and updates the game state when executed.

---

### 3. Database Integration (MySQL Connector/J)

To persist game state (players, units, positions) and load/save configurations, integrate a MySQL database using Connector/J:

* **Responsibilities of Data Layer:**

    * Save and retrieve `GameState`, including current turn, player statuses, and unit details.
    * Store configuration settings (e.g., initial unit stats, map layouts).
    * Enable save/load functionality for resumed play.

* **Connection Management:**

    * Configure JDBC URL, username, and password via external properties or environment variables.
    * Use a **single** `DataSource` or connection pool for efficient resource management.

* **Data Access Objects (DAOs):**

    * Define interfaces such as `GameStateDAO`, `PlayerDAO`, `UnitDAO` to abstract CRUD operations.
    * Implement each DAO to execute SQL statements via `java.sql.Connection`, `PreparedStatement`, and `ResultSet`.

* **Transaction Handling:**

    * Wrap related operations (e.g., save all units for a turn) in a database transaction to ensure atomicity.

* **Schema Suggestions:**

    * **players**: `(player_id, name, is_ai, turn_order)`
    * **units**: `(unit_id, player_id, type, health, last_updated_turn)`
    * **game\_state**: `(state_id, current_turn, status, last_saved)`

---

### 4. Turn Flow

1. **Start Game**: Initialize players, units, and game settings (loaded from database).
2. **Turn Loop**:

    * Select the next active player.
    * For each unit owned by the player:

        * Determine valid actions based on the current game state.
        * Choose one action (via user input or AI logic).
        * Execute the action and update the game state.
        * Persist state changes to the database as needed.
        * Optionally end the turn early based on rules.
3. **Win Check**: After each turn, evaluate if a player meets the win conditions (e.g., only one player has surviving units).
4. **End**: Declare the winner, persist final state, and clean up resources.

---

### 5. Extensibility Points

* **New Unit Types**: Introduce new subclasses or compositions defining unique attributes or behaviors and store any new properties in additional database columns or tables.
* **Additional Actions**: Add new action types (e.g., spells, special moves) by defining their effects on the game state and persisting any custom action logs.
* **AI Strategies**: Implement different AI decision-making processes for unit actions and turn priorities without affecting the database layer.
* **User Interfaces**: Swap or layer on various UI implementations (console, GUI, networked client) without altering core logic or data access.

---

### 6. Summary

This documentation defines a clear separation between:

* **Game Management** (`Game`)
* **Player Orchestration** (`Player`)
* **Entity Behavior** (`Unit`)
* **Discrete Operations** (`Action`)
* **Persistence Layer** (MySQL via Connector/J)

By focusing on responsibilities and interactions, the design remains flexible and easy to extend while providing robust state persistence and retrieval.
