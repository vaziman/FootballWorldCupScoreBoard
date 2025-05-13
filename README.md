**Football World Cup ScoreBoard**

Java library that simulates a live scoreboard for the Football World Cup. It supports creating matches, updating scores, removing matches, and retrieving a sorted summary of ongoing games.

**Contents**
- Tech Stack(#tech-stack)
- Features(#features)
- Running the Project(#running-the-project)
- Usage Example(#usage-example) 
- Notes(#notes)


**Tech Stack**
- Java 17
- Maven
- JUnit 5


**Features**
- Start a new game (initial score 0–0)
- Update the score of an existing game
- Finish a game (removes it from the scoreboard)
- Retrieve a summary of games sorted by:
  - Total score (descending)
  - Time of addition (most recent first)


**Running the Project**
To run all tests and verify the implementation:

`mvn clean test`


**Usage Example**

```java
ScoreBoard board = new ScoreBoard();

board.startGame("Mexico", "Canada");
board.updateScore("Mexico", "Canada", 0, 5);

board.startGame("Spain", "Brazil");
board.updateScore("Spain", "Brazil", 10, 2);

List<Match> summary = board.getSummary();
summary.forEach(System.out::println);
```


**Notes**
Matches are identified by the combination of homeTeam and guestTeam.

Sorting uses a sequential ID (sequenceId) assigned at match creation time to ensure deterministic ordering without relying on timestamps or artificial delays.

