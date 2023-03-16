# Rock-Paper-Scissors

<img src="https://user-images.githubusercontent.com/81508084/225538005-a77ecde7-5968-46bf-a19b-05b3df962faa.png" width="200" height="400"/> <img src="https://user-images.githubusercontent.com/81508084/225538005-a77ecde7-5968-46bf-a19b-05b3df962faa.png" width="200" height="400"/> <img src="https://user-images.githubusercontent.com/81508084/225538582-695f8a63-709e-4130-a929-d1e11aa4feb1.png" width="200" height="400"/>


* Android App to play Rock Paper Scissors Game
* 4 branches
	* [main](https://github.com/hansh0101/Rock-Paper-Scissors) - only View and Model, and no feature.
	* [mvc](https://github.com/hansh0101/Rock-Paper-Scissors/tree/mvc) - implemented in MVC pattern
	* [mvp](https://github.com/hansh0101/Rock-Paper-Scissors/tree/mvp) - implemented in MVP pattern
	* [mvvm](https://github.com/hansh0101/Rock-Paper-Scissors/tree/mvvm) - implemented in MVVM pattern
* Model
	* Pick
		* `Pick` class is enum class to show player's pick in Rock-Paper-Scissors game.
	* GameResult
		* `GameResult` class is enum class to show player's Rock-Paper-Scissors game result.
	* Player
		* `Player` class is data class that has player's `Pick` and `GameResult`.
	* Game
		* `Game` class has 2 players(player1(User) and player2(Opponent)).
		* When player1(User) set his/her `Pick`, then player2(Opponent)'s pick is decided by random function(with `shuffled()` in Kotlin Collections API).
		* Each player's `GameResult` is determined immediately by  `Pick` class's `checkGameResult()` method.
