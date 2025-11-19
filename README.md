# Guessing Game

A command-line number guessing game built with Java and Maven, featuring clean architecture with separation of concerns, persistent player statistics, and comprehensive test coverage.

## 🎮 Game Overview

The Guessing Game challenges players to guess a randomly generated secret number within a specified range. Players have 4 attempts per round to guess correctly. All game statistics are automatically saved and persist across sessions.

## ✨ Features

- **Custom Range Selection**: Players can define their own min/max range for each round
- **Multiple Attempts**: 4 chances per round to guess the correct number
- **Range Validation**: Automatic validation ensures guesses are within the specified range
- **Persistent Statistics**: Win/loss records are automatically saved to JSON
- **Returning Player Recognition**: The game remembers previous players and their stats
- **Clean Architecture**: Domain-driven design with clear separation of concerns
- **Comprehensive Testing**: Unit tests for domain logic and persistence layer

## 📁 Project Structure

```
gg/
├── pom.xml                          # Maven configuration
├── PlayerScoreHistory.json          # Persistent player data
├── README.md
├── src/
│   ├── main/java/com/guessinggame/
│   │   ├── application/
│   │   │   └── GameService.java     # Application orchestration layer
│   │   ├── domain/
│   │   │   ├── GameRules.java       # Core game logic & validation
│   │   │   ├── OutCome.java         # Win/Loss enumeration
│   │   │   ├── Player.java          # Player entity with stats
│   │   │   ├── PlayerStatsRepository.java  # Persistence interface
│   │   │   ├── Range.java           # Range value object
│   │   │   ├── Scores.java          # Score tracking model
│   │   │   ├── ScoreTracker.java    # Score aggregation
│   │   │   ├── SecretNumberGenerator.java  # Random number interface
│   │   │   └── UserInput.java       # Input interface
│   │   ├── infrastructure/
│   │   │   ├── JsonPlayerStatsRepository.java     # JSON persistence
│   │   │   └── RandomSecretNumberGenerator.java   # Random generator
│   │   ├── ui/
│   │   │   ├── ConsoleUI.java       # Console input handling
│   │   │   ├── ConsoleUO.java       # Console output handling
│   │   │   └── Main.java            # Application entry point
│   │   └── App.java                 # Legacy entry point
│   └── test/java/com/guessinggame/
│       ├── domain/
│       │   ├── GameRulesTest.java
│       │   ├── GameTest.java
│       │   └── ScoreTest.java
│       └── persistence/
│           └── PersistenceTest.java
└── target/                          # Compiled output
```

## 🏗️ Architecture

The project follows a clean architecture pattern with clear layer separation:

### Domain Layer
Contains core business logic and entities, completely independent of infrastructure:
- **GameRules**: Validates guesses and determines win/loss outcomes
- **Player**: Manages player identity and statistics
- **Range**: Encapsulates min/max range validation
- **Interfaces**: Defines contracts for external dependencies

### Application Layer
Orchestrates the game flow and coordinates between layers:
- **GameService**: Main application service managing game rounds and player interactions

### Infrastructure Layer
Handles external concerns like persistence and random number generation:
- **JsonPlayerStatsRepository**: JSON-based storage implementation
- **RandomSecretNumberGenerator**: Random number generation implementation

### UI Layer
Manages all user interaction through the console:
- **ConsoleUI**: Handles user input with validation
- **ConsoleUO**: Manages formatted output to console

## 🚀 Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

### Installation

1. Clone or download the project
2. Navigate to the project directory:
```bash
cd gg
```

### Running the Game

#### Option 1: Run directly with Maven
```bash
mvn clean compile exec:java -Dexec.mainClass="com.guessinggame.ui.Main"
```

#### Option 2: Build and run JAR
```bash
mvn clean package
java -jar target/gg-1.0-SNAPSHOT.jar
```

## 🎯 How to Play

1. **Enter your name** when prompted
2. **Set the range** for the secret number (e.g., 1 to 100)
3. **Make your guess** - you have 4 attempts per round
4. **Win or lose** - your stats are automatically saved
5. **Play again** or enter a negative number to quit

### Example Session

```
Enter your name:
> John
New player: John
Enter start range (Negative number quits):
> 1
Enter the end range (Negative number quits):
> 50
Generating secret
...
What is your guess?
> 25
Wrong! You have 3 tries left!
What is your guess?
> 30
Congratulations! You won!
```

## 💾 Score Persistence

Player statistics are automatically saved to `PlayerScoreHistory.json`:

```json
{
  "john": {
    "wins": 5,
    "losses": 2
  },
  "jane": {
    "wins": 3,
    "losses": 1
  }
}
```

The file is created automatically on first save and updated after each game session.

## 🧪 Testing

Run the full test suite:
```bash
mvn test
```

Run tests with coverage report:
```bash
mvn clean test jacoco:report
```

### Test Coverage
- **Domain Logic**: Complete coverage of game rules and validation
- **Persistence**: JSON serialization/deserialization
- **Player Stats**: Win/loss tracking and calculations

## 🔧 Configuration

The game is currently configured with:
- **4 attempts** per round (modifiable in `GameService.java`)
- **JSON persistence** (can be swapped with any `PlayerStatsRepository` implementation)
- **Console UI** (can be replaced with GUI by implementing interfaces)

## 🛠️ Development

### Key Design Patterns
- **Dependency Injection**: All dependencies are injected through constructors
- **Repository Pattern**: Abstract persistence layer allows easy switching of storage mechanisms
- **Strategy Pattern**: Game rules and number generation can be swapped
- **Interface Segregation**: Separate interfaces for input/output concerns

### Adding New Features

To add a difficulty level:
1. Create a `Difficulty` enum in the domain layer
2. Modify `GameService` to adjust attempts based on difficulty
3. Update `ConsoleUI` to prompt for difficulty selection

To add a new persistence mechanism:
1. Implement the `PlayerStatsRepository` interface
2. Inject the new implementation in `Main.java`

## 🐛 Known Issues

None currently reported. Please submit issues via the project repository.

## 🚀 Future Enhancements

- [ ] Multiple difficulty levels (easy/medium/hard)
- [ ] Global leaderboard functionality
- [ ] Hint system (odd/even, higher/lower)
- [ ] Timed mode for additional challenge
- [ ] GUI interface using JavaFX
- [ ] Multiplayer support
- [ ] Achievement system
- [ ] Sound effects and animations

## 📄 License

MIT License - feel free to use and modify as needed.

## 👥 Contributing

Contributions are welcome! Please ensure:
- All tests pass before submitting
- New features include corresponding tests
- Code follows the existing architecture patterns
- Documentation is updated accordingly

## 🙏 Acknowledgments

Built as a demonstration of clean architecture principles in Java, showcasing:
- Domain-driven design
- Test-driven development
- SOLID principles
- Separation of concerns
