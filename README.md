# AndroidStudioGame
Introduction:
The game is a Java-based application with a straightforward graphical user interface that allows users to select from three different games. The game requires players to solve puzzles, answer questions, and play different roles to win points or lives. The game controller can add players to the game and track their progress throughout the game. The application is built using Java programming language and uses a database with multiple tables to organize game data.

User Interface:
The game has a user-friendly interface that allows users to select from three different games. Each game has its set of rules and instructions that are displayed to the user before the game starts. Users can also enter the names of the players in the room for easier point tracking. Once the game starts, users can solve puzzles, answer questions, or play roles to win points or lives. The game controller can add points or lives to the players' scores based on their performance.

Game 1:
Game 1 requires players to solve puzzles and answer questions to win points. After each puzzle or question, the game controller can add points to the players' scores based on their performance. At the end of the game, a message is displayed to show who won (that is, who had the most points), and the user can return to the main menu.

Image 1            |  Image 2
:-------------------------:|:-------------------------:
![image](https://user-images.githubusercontent.com/67857389/226103125-664b005e-5173-4c7d-8b9e-b29adf3f810e.png)  |  ![image](https://user-images.githubusercontent.com/67857389/226103133-4b002de7-cdd9-45c5-9a37-68dfe949e89c.png)
:-------------------------:|:-------------------------:
![image](https://user-images.githubusercontent.com/67857389/226103137-a85e9f80-ff15-459b-a182-7c1e28bcf61b.png) | ![image](https://user-images.githubusercontent.com/67857389/226103139-12f40439-9493-4e6f-bd3d-d0cbf6c44808.png)
:-------------------------:|:-------------------------:
![image](https://user-images.githubusercontent.com/67857389/226103510-63f0da19-ca82-41c9-bd50-f90d3d846a83.png) | ![image](https://user-images.githubusercontent.com/67857389/226103517-63b6b056-ff03-4f22-bf47-9edff45e9631.png)
:-------------------------:|:-------------------------:
![image](https://user-images.githubusercontent.com/67857389/226103525-69ad5659-9d68-4f06-b13c-ebcd70914766.png) | ![image](https://user-images.githubusercontent.com/67857389/226103531-4aa48a4f-8122-462e-9b99-d16a197477d7.png)

Game 2:
Game 2 is a spy-themed game that generates a spy based on the entered names. The other players receive a random location that the spy does not know. The spy wins if they guess the location, and the other players win if they discover the spy. After the game, the user returns to the main menu.

![image](https://user-images.githubusercontent.com/67857389/226103543-27710694-568b-4bd3-a855-14c179fb81ef.png)

Game 3:
Game 3 is similar to Game 1, but instead of a score, players have lives tracked by the game controller. Whoever loses three lives has lost. After the game, the user returns to the main menu.

Database:
The application uses a database with multiple tables to store game data. The database is organized into two tables to make it easier to manage game data for the two games that use the base. The tables contain information about players, their scores, lives, and other game-related data.

