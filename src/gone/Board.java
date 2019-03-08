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
	private Board(HashMap<Integer, Piece> boardConfiguration, int columns) {
		this.boardConfiguration = boardConfiguration;
		this.columns = columns;
	}
	
	/**
	 * This routine represents the algorithm used to find how many turns it takes to apply the replacement rules until no more replacements can occur
	 */
	
	public int findIterations() {
		List<Piece> initialWhitePieces = this.findInitialWhitePieces();
		Piece tempPiece = new Piece();						//placeholder piece used during iteration of list of initial white pieces
		int totalIterations = 0;							//highest number of iterations
		int pieceIterations = 0;							//# of iterations for the current white piece
		Iterator<Piece> iter = initialWhitePieces.iterator();	
		//run the depth first search recursion through every initial white piece
		while(iter.hasNext()) {
			tempPiece = iter.next();	
			pieceIterations = recurseAdjacents(tempPiece, tempPiece.adjacentSet(this.getPieceLocation(tempPiece), columns));
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
	public int recurseAdjacents(Piece piece, int[] adjacents) {
		Objects.requireNonNull(piece, "enter a piece that exists on the board");
		Objects.requireNonNull(adjacents, "enter a non null array of adjacent pieces");
		//set this piece to white
		piece.setWhite();
		int iterations = 0;
		//go through every piece in the adjacents list
		for(int index = 0; index < adjacents.length; index++) {
			Piece currentPiece = this.boardConfiguration.get(adjacents[index]);
			//if the piece is not white, change it to black and 
			if(!currentPiece.isWhite()) {
				recurseAdjacents(currentPiece, currentPiece.adjacentSet(this.getPieceLocation(currentPiece), columns));
			}
		}
		return iterations++;
	}
	
	/*
	 * returns a list of all the white pieces at the start of the game before pebble switching has occured
	 */
	
	public List<Piece> findInitialWhitePieces() {
		Map<Integer, Piece> board = this.boardConfiguration;
		//iterates through the entire board
		List<Piece> initialWhitePieces = new ArrayList<Piece>();
		for(int key : board.keySet()) {
			//if a piece is white, add it to the list
			if(board.get(key).isWhite())
				initialWhitePieces.add(board.get(key));
		}
		return initialWhitePieces;
	}

	/*
	 * returns the location/space of the piece
	 */
	public int getPieceLocation(Piece piece) {
		Objects.requireNonNull(piece, "enter a piece that is not null");
		for (Entry<Integer, Piece> entry : this.boardConfiguration.entrySet()) {
			if (Objects.equals(piece, entry.getValue())) {
				return entry.getKey();
			}
		}
		return -1;
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

	

}
