# Gift Planner

A Java application to help you plan, track, and manage gifts for recipients and occasions, with a focus on clean architecture, advanced Java practices, and Big O concepts.

---

## Features
- **CRUD for Gifts, Recipients, and Occasions**
- **Track Budgets** per occasion or recipient
- **Mark Gifts as Purchased**
- **Simple Frontend:** CLI or Swing UI

---

## Project Structure
```
GiftPlanner/
  ├── model/         # POJOs: Gift, Recipient, Occasion
  ├── repository/    # DAOs: GiftRepository, RecipientRepository, OccasionRepository
  ├── service/       # Business logic: GiftService, etc.
  ├── controller/    # Handles user input, calls services
  ├── util/          # Utility classes (DB connection, etc.)
  └── ui/            # CLI or Swing UI (optional)
```

---

## Database Schema (SQLite/H2)
- **Gift**: id, name, price, purchased, recipient_id, occasion_id
- **Recipient**: id, name, budget
- **Occasion**: id, name, date, budget

---

## Setup
1. **Java 17+ required**
2. **Clone the repository**
3. **Build with Maven or Gradle**
4. **Run the application**

### Example (Maven):
```sh
mvn clean install
java -jar target/gift-planner.jar
```

---

## Usage
- Add, view, update, and delete gifts, recipients, and occasions
- Assign gifts to recipients and occasions
- Set and track budgets
- Mark gifts as purchased
- View budget status and warnings

---

## Clean Architecture Principles
- **Separation of Concerns:** Each package/layer has a single responsibility
- **SOLID OOP Principles:** Classes are focused and loosely coupled
- **MVC Pattern:** UI is separated from business logic and data access

---

## Big O & Java Concepts
- **Collections:** List, Map, Set – understand their time complexities
- **DAO Pattern:** JDBC with PreparedStatements (O(n) per query, depending on index)
- **Caching:** Example: HashMap<String, List<Gift>> for O(1) access
- **Time Complexity Examples:**
  - ArrayList: O(1) get, O(n) remove
  - HashMap: O(1) put/get
- **Tradeoffs:** Memory vs. speed (e.g., caching budgets)

---

## Testing
- **JUnit** for core service and repository tests
- **Manual UI testing** for CLI/Swing

---

## Logging
- Uses Java Logger or log4j for application logging

---

## Learning Topics
- Clean Architecture
- OOP (SOLID)
- Collections & Generics
- Exception Handling
- JDBC & Transactions
- Java Memory Model
- Big O Notation

---

## Author
- [Your Name]

## License
- [Specify your license here] 