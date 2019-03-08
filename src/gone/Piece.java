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
	public Piece() {
		adjacentSpaces = new int[4];
	}


	// private Player_Black(board space, number of columns){
	public Piece(int space, int columns, boolean isWhite) {
		//	adjacent spaces = get adjacent pieces(board space, number of columns)
		this.isWhite = isWhite;
		adjacentSpaces = adjacentSet(space, columns);
	}

	/*
	 * pieces should be able to:
	 * 
	 */
	//(Integer Array) getAdjacentSpaces(board space, number of columns) {
	int[] adjacentSet(int space, int columns) {
		int end = columns*columns;
		//output = array to hold board spaces
		int[] output = new int[4];
		//if there is a piece at (This pieces space minus number of columns), and that space to array
		if((space-columns) > 0) {
				output[0] = space-columns;
			}	
		if((space-columns) > 0) output[0] = space-columns;
		else output[0] = -1;
		//if there is a piece at (This pieces space plus number of columns), add that space to array
			output[1] = space+columns;
		if((space+columns) < end) output[1] = space+columns;
		else output[1] = -1;
		//if there is a piece at (This space +1) add space to array
			output[2] = space+1;

		if((space+1) < end) output[2] = space+1;
		else output[2] = -1;
		//if there is a piece at (this space -1) add to array
			output[3] = space-1;
		if((space-1) >= 0) output[3] = space-1;
		else output[3] = -1;
		return output;
	}


	// Check if piece is white
	boolean isWhite(){
		//piece is not white, return false
		return isWhite;
	}
	
	void setWhite() {
		isWhite = true;
	}




}