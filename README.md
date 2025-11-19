# Guessing Game (Java)

A CLI number guessing game built using Java and Maven. It includes a
clean domain layer, a console UI, and JSON-backed score tracking. Unit
tests are included.

## ✅ Features

-   Random number generation
-   Win/Loss tracking
-   Persistent score history stored in `PlayerScoreHistory.json`
-   Console-based UI
-   Clear domain separation (`domain`, `ui`, `persistence`)
-   Maven build + test support

## 📂 Project Structure

    gg/
    ├─ pom.xml
    ├─ PlayerScoreHistory.json
    ├─ src/
    │  ├─ main/java/com/guessinggame/
    │  │  ├─ App.java
    │  │  ├─ domain/
    │  │  ├─ ui/
    │  │  └─ persistence/
    │  └─ test/java/com/guessinggame/
    └─ target/

### Key Classes

-   App.java --- program entry\
-   Game.java --- core game logic\
-   Player.java --- player data model\
-   OutCome.java --- enum for WIN/LOSE\
-   ConsoleUI.java --- console input/output\
-   PlayerScoreHistory.java --- JSON persistence\
-   GameTest / PersistenceTest --- JUnit tests

## ▶️ Running the Game

### Run directly via Maven:

``` sh
cd gg
mvn clean compile exec:java -Dexec.mainClass="com.guessinggame.App"
```

### Build JAR:

``` sh
mvn package
java -jar target/gg-1.0-SNAPSHOT.jar
```

## 📝 Score Tracking

Player stats are stored in a JSON file:

``` json
{
  "john": { "wins": 3, "losses": 1 }
}
```

## ⚙️ Requirements

-   Java 11+
-   Maven 3+

## 🧪 Running Tests

``` sh
mvn test
```

## ✅ Future Improvements

-   Difficulty levels\
-   Leaderboard\
-   GUI or improved UI\
-   CLI flags (`--attempts=5`)

## 📄 License

MIT License
