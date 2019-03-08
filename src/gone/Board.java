package gone;

import java.util.*;
import java.util.Map.Entry;

public class Board {
	
	/*
	 * fields representing the board and it's number of columns
	*/
	Map<Integer, Piece> boardConfiguration = new HashMap<Integer, Piece>();
	int columns;
	
	
	/*
	 * Constructor takes a hashmap representation of the board
	 */
	Board(Map<Integer, Piece> boardConfiguration, int columns) {
		this.boardConfiguration = boardConfiguration;
		this.columns = columns;
	}
	
	/**
	 * This routine represents the algorithm used to find how many turns it takes to apply the replacement rules until no more replacements can occur
	 */
	
	public int findIterations() {
		List<Integer> initialWhitePieces = this.findInitialWhitePieces();
		Piece tempPiece;						//placeholder piece used during iteration of list of initial white pieces
		int totalIterations = 0;							//highest number of iterations
		int pieceIterations = 0;							//# of iterations for the current white piece
		Iterator<Integer> iter = initialWhitePieces.iterator();	
		//run the depth first search recursion through every initial white piece
		while(iter.hasNext()) {
			tempPiece = getBoardConfig().get(iter.next());	
			pieceIterations = recurseAdjacents(tempPiece, tempPiece.adjacentSet(this.getPieceLocation(tempPiece), columns), pieceIterations);
			if(pieceIterations > totalIterations) {
				totalIterations = pieceIterations;
			}
		}
		return totalIterations;
	}
	
	/*
	 * helper routine to run DFS search through a white_piece to turn all adjacent pieces from black to white
	 * returns the number of iterations through list of adjacent pieces it took to flip all connect black pieces to white
	 */
	public int recurseAdjacents(Piece piece, int[] adjacents, int iterations) {
		Objects.requireNonNull(piece, "enter a piece that exists on the board");
		Objects.requireNonNull(adjacents, "enter a non null array of adjacent pieces");
		//set this piece to white
		piece.setWhite();
		//go through every piece in the adjacents list
		for(int index = 0; index < adjacents.length; index++) {
			if(!this.boardConfiguration.containsKey(adjacents[index])) continue;
			Piece currentPiece = getBoardConfig().get(adjacents[index]);
			//if the piece is not white, change it to black and 
			if(!currentPiece.isWhite()) {
				iterations = recurseAdjacents(currentPiece, currentPiece.adjacentSet(this.getPieceLocation(currentPiece), columns), iterations+1);
			}
			
		}
		return iterations;
	}
	
	/*
	 * returns a list of all the white pieces at the start of the game before pebble switching has occured
	 */
	
	public List<Integer> findInitialWhitePieces() {
		Map<Integer, Piece> board = this.boardConfiguration;
		//iterates through the entire board
		List<Integer> initialWhitePieces = new ArrayList<Integer>();
		for(int key : board.keySet()) {
			//if a piece is white, add it to the list
			if(board.get(key).isWhite())
				initialWhitePieces.add(key);
		}
		return initialWhitePieces;
	}

	/*
	 * returns the location/space of the piece
	 */
	public int getPieceLocation(Piece piece) {
		Objects.requireNonNull(piece, "enter a piece that is not null");
		int location = 0;
		for (Entry<Integer, Piece> entry : getBoardConfig().entrySet()) {
			if (Objects.equals(piece, entry.getValue())) {
				location = entry.getKey();
			}
		}
		return location;
	}

	/*
	 * checks to see if there are any black pieces
	 */
	 public boolean containsBlackPiece() {
		 boolean hasBlackPiece = false;
		 //iterate through every piece on the board
		 Map<Integer, Piece> board = this.boardConfiguration;
		 //return true if there is a black piece
		 for(int key : board.keySet()) {
			 if(!board.get(key).isWhite())
				 hasBlackPiece = true;
		 }
		 return hasBlackPiece;
	 }

	public Map<Integer, Piece> getBoardConfig(){
		return this.boardConfiguration;
	}

}