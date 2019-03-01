package gone;

public class Board {
	//TODO: write remaining pseudo code
	
	/*
	 * The Board class stores the board configuration and then runs an algorithm that determines the number of turns it takes to replace every replaceable black piece with a white piece
	 * and if there are any black pieces left on the board by the end
	 */
	
	/*
	* hashmap<int, Player> boardConfiguration
	* The hashmap is a field that stores black and white pieces with a key denoting the location of the piece on the board
	* The value of the key denotes the space number starting from the top left 
	*/
	
	/*
	 * Constructor takes a hashmap representation of the board
	 * private Board(hashmap<int, Player>) {
	 */
	
	/**
	 * This routine represents the algorithm used to find how many turns it takes to apply the replacement rules until no more replacements can occur
	 * Rules are as follows:
	 * 		- Every black piece immediately adjacent to a white piece is replaced by a white piece (no diagonals)
	 * 		- Repeat until no more replacements can occur
	 * int findMaxTurns(List<Player_White> initialWhitePieces) {
	 * 		for each initial white piece
	 * 			run a depth first search through its list of adjacent pieces
	 * 			if there are any black pieces in its array of adjacent pieces:
	 * 				- replace the black piece(s) with a white piece
	 * 				- increase the number of turns taken by 1 for the root white piece 
	 * 		
	 *		return the highest number of turns it took to replace black pieces between all the white pieces
	 */
	
	/*
	 * List<Player_White> findInitialWhitePieces() {
	 * 		Go through every mapped value and check if it is a white piece
	 * 		If it is a white piece, store its key in a list 
	 * 		Return the list that represents all the initial white pieces
	 */
	
	/*
	 * boolean containsBlackPiece() {
	 * 		Go through the board and check if there are any black pieces
	 */
	

}
