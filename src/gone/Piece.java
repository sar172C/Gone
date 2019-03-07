package gone;

import java.util.Map;

public class Piece {
	//TODO Write remaining pseudo-code
	//int[] adjacent spaces
	int[] adjacentSpaces;
	boolean isWhite;

	/*
	 * private Piece(){
	 * 		adjacent spaces= blank integer array
	 * }
	 */
	private Piece() {
		adjacentSpaces = new int[4];
	}


	// private Player_Black(board space, number of columns){
	private Piece(int space, int columns, Piece[] boardConfig) {
		//	adjacent spaces = get adjacent pieces(board space, number of columns)
		adjacentSpaces = adjacentSet(space, columns, boardConfig);
	}

	/*
	 * pieces should be able to:
	 * 
	 * Check adjacency to other objects
	 */
	//(Integer Array) getAdjacentSpaces(board space, number of columns) {
	int[] adjacentSet(int space, int columns, Piece[] boardConfig) {
		//output = array to hold board spaces
		int[] output = new int[4];
		//if there is a piece at (This pieces space minus number of columns), and that space to array
		if((space-columns) > 0) {
			if(!(boardConfig[space-columns].equals(null))) {
				output[0] = space-columns;
			}
		}
		//if there is a piece at (This pieces space plus number of columns), add that space to array
		if((space+columns) < boardConfig.length) {
			if(!(boardConfig[space+columns].equals(null))) {
				output[1] = space+columns;
			}
		}
		//if there is a piece at (This space +1) add space to array
		if(!(boardConfig[space+1].equals(null))) {
			output[2] = space+1;
		}
		//if there is a piece at (this space -1) add to array
		if(!(boardConfig[space-1].equals(null))) {
			output[3] = space-1;
		}
	}


	// Check if piece is white
	boolean isWhite(){
		//piece is not white, return false
		return isWhite;
	}




}
