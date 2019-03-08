package gone;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Map<Integer,Piece> boardconfig;
	@Before
	public void setUp() {
		/*
		 * 4x4 board
		 * B,W,W,E
		 * E,B,W,B
		 * B,B,E,W
		 * B,E,W,B
		 */
	
		boardconfig = new HashMap<Integer,Piece>();
		boardconfig.put(new Integer(0), new Piece(0, 4, false));
		boardconfig.put(new Integer(1), new Piece(1, 4, true));
		boardconfig.put(new Integer(2), new Piece(2, 4, true));
		boardconfig.put(new Integer(5), new Piece(4, 4, false));
		boardconfig.put(new Integer(6), new Piece(6, 4, true));
		boardconfig.put(new Integer(7), new Piece(7, 4, false));
		boardconfig.put(new Integer(8), new Piece(8, 4, false));
		boardconfig.put(new Integer(9), new Piece(9, 4, false));

		boardconfig.put(new Integer(11), new Piece(11, 4, true));
		boardconfig.put(new Integer(12), new Piece(12, 4, false));
		boardconfig.put(new Integer(14), new Piece(14, 4, true));
		boardconfig.put(new Integer(15), new Piece(15, 4, false));
	}
	

	@Test
	public void testFindInitialWhitePieces4x4() {
		Board board = new Board(boardconfig, 4);
		List<Integer> testCase = new ArrayList<Integer>() ;
		testCase.add(1);
		testCase.add(2);
		testCase.add(6);
		testCase.add(11);
		testCase.add(14);
		assertTrue(board.findInitialWhitePieces().equals(testCase));
	}
	
	@Test
	public void testAdjacents() {
		Board board = new Board(boardconfig, 4);
		int[] testCase = new int[] {-1,4,1,-1};
		int[] adjacents = board.getBoardConfig().get(0).adjacentSpaces;
		assertTrue(Arrays.equals(adjacents,testCase));
	}

	@Test
	public void testRecurse() {
		Board board = new Board(boardconfig, 4);
		Piece testPiece = board.getBoardConfig().get(1);
		System.out.println(board.recurseAdjacents(testPiece, testPiece.adjacentSpaces, 0));
	}
	
	@Test
	public void testFindIterations() {
		Board board = new Board(boardconfig, 4);
		System.out.println(board.findIterations());
	}
}
