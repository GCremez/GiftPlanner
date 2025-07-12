# Gift Planner

Gift Planner is a Java application to help you manage gifts, recipients, and occasions, track budgets, and mark gifts as purchased. It is designed with clean architecture principles and demonstrates advanced Java practices, including JDBC, SOLID, and Big O analysis.

## Features
- **CRUD Operations** for Gifts, Recipients, and Occasions
- **Budget Tracking** per occasion or recipient
- **Mark Gifts as Purchased**
- **Simple CLI Interface** (Swing UI optional)
- **Clean Architecture**: Separation of model, repository, service, controller, and UI layers

## Project Structure
```
GiftPlanner/
  ├── src/main/java/
  │     ├── model/         # Entity classes (Gift, Recipient, Occasion)
  │     ├── repository/    # DAO interfaces and JDBC implementations
  │     ├── service/       # Business logic (budget, purchase, validation)
  │     ├── controller/    # CRUD controllers
  │     ├── util/          # Utilities (e.g., DatabaseUtil)
  │     └── ui/            # CLI or Swing UI
  ├── pom.xml              # Maven build file
  └── README.md            # Project documentation
```

## Setup Instructions
1. **Requirements:**
   - Java 17+
   - Maven
   - SQLite or H2 (embedded DB)

2. **Build the Project:**
   ```sh
   mvn clean install
   ```

3. **Run the CLI:**
   ```sh
   mvn exec:java -Dexec.mainClass="ui.MainCLI"
   ```

4. **Database:**
   - The app uses an embedded database (SQLite/H2). No setup required; DB file will be created automatically.

## Usage
- Use the CLI to add, view, update, or delete gifts, recipients, and occasions.
- Track budgets and mark gifts as purchased.
- Get feedback for actions (e.g., "Gift added", "Budget exceeded").

## Architecture Overview
- **Model:** POJOs for Gift, Recipient, Occasion
- **Repository:** DAO pattern with JDBC (no ORM)
- **Service:** Business logic (budget, purchase, validation)
- **Controller:** Handles user requests, calls services
- **UI:** CLI or Swing (kept separate from core logic)

## Big O Notes
- **ArrayList:** O(1) get, O(n) remove
- **HashMap:** O(1) put/get (used for fast categorization)
- **JDBC Queries:** O(n) per query (unless indexed)
- **Budget Calculation:** O(n) per recipient/occasion
- **Caching:** In-memory budget cache (O(1) access, O(n) memory)

## Java Concepts Demonstrated
- Clean Architecture & SOLID Principles
- DAO Pattern & JDBC
- Collections (List, Map, Set)
- Generics & Interfaces
- Exception Handling
- MVC (with UI)
- Test-driven development (JUnit)

## Testing
- JUnit tests for core services and repositories
- Manual testing for CLI/UI

## License
MIT 