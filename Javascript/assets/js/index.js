// ─── VARIABLES ──────────────────────────────────────────────────────────────────
const gameArea = document.querySelectorAll('.gameBox');
const gamePlayer = document.querySelector('.gamePlayer');
const gameResert = document.querySelector('.gameResert');

console.log({ gameArea, gamePlayer, gameResert });

var gameActive = true; // PLAYING CONDITION
const winState = [
	[ 0, 1, 2 ],
	[ 3, 4, 5 ],
	[ 6, 7, 8 ],
	[ 0, 3, 6 ],
	[ 1, 4, 7 ],
	[ 2, 5, 8 ],
	[ 0, 4, 8 ],
	[ 2, 4, 6 ]
];
var gameState = [ '', '', '', '', '', '', '', '', '' ]; //  PLAYER CONDITIONS
var currentPlayer = 'X';

// ─── MASSAGES FOR GAME IS DRAW , WIN AND PLAYER TURN  ───────────────────────────────────────────────────────────────────
const winnerMass = () => {
	var winPlayer = currentPlayer === 'X' ? 'X' : '0';
	return `${currentPlayer} is win 👋≧◉ᴥ◉≦`;
};
const drawMass = () => `game is draw no one is win`;
const activeMass = () => `it's ${currentPlayer} turn`;

// ─── BASE () SEE DOWN BALOW    ──────────────────────────────────────────────────────────────────────────
gameArea.forEach((elements, index) => {
	// ADDING EVENT FOR EACH ELEMENT
	elements.addEventListener('click', () => indicateBox(index));
});

function indicateBox(index) {
	if (gameState[index] !== '' || !gameActive) {
		// IF USER CLICK BOX THAT HAVE ALREADY INPUT "OR" GAME IS FALSE THEN FUNCTION IS REUTRN
		return;
	}
	currentPlayer = currentPlayer === 'X' ? '0' : 'X';     // CHANGE THE PLAYER
	gamePlayer.innerText = activeMass();
	gameState[index] = currentPlayer;
	gameArea[index].innerText = currentPlayer;

	gameValidete();
}

function gameValidete() {            // GAME RESULT VALIDATION
	var gameEnd = false;

	const re = winState.map((elements) => {
		let a = gameState[elements[0]];
		let b = gameState[elements[1]];
		let c = gameState[elements[2]];

		if (a === '' || b === '' || c === '') {
			return true;
		}
		if (a === b && b === c) {
			gameEnd = true;
		}
	});

	if (gameEnd) {                 
		gamePlayer.innerHTML = winnerMass();
		gameActive = false;
		return;
    }
    
    let roundDraw = !gameState.includes("");
    if (roundDraw) {
        gamePlayer.innerHTML = drawMass();
        gameActive = false;
        return;
    }
}

gameResert.addEventListener('click', () => {                 // RESERT GAME WHEN CLICK
	gameArea.forEach((e) => {             
		console.log(e);
		e.innerHTML = '';
	});
	gameActive = true;
	gameState = [ '', '', '', '', '', '', '', '', '' ];
	gamePlayer.innerHTML = activeMass();
});
