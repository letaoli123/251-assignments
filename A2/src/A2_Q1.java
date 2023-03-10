import java.util.*;

public class A2_Q1{

	//[0][3] = Dad points
	//[0][4] = Kid points
	//[1][4] = Point difference
	//[1][3] = Turn: If 0, Dad turn, if 1, then kid turn
	public static int game_recursion(int[][] board) {
		int numberOfMoves = numberOfMovesCheck(board);
		//System.out.println("Current Board: \n" + Arrays.deepToString(board));
//		//System.out.println("Board[0][3] = " + board[0][3] + "board[0][4] = " + board[0][4]);
		int pointDifference = 2147483647;
		if(board[0][3] == -1 && board[0][4] == -1){	//If both points are -1, then set to zero to track points, start of game
			//System.out.println("Start of game");
			board[0][3] = 0;
			board[0][4] = 2147483647;			//Current score difference
			board[1][4] = 2147483647;	//Set maximum point difference
			board[1][3] = 0;	//Set Dad turn
		}
		List<Integer> scoreList = new ArrayList<Integer>();
		if(numberOfMoves == 0){			//End of game scenario
			//System.out.println("End of game");

//			if(pointDifference < board[1][4] && pointDifference >= 0){
//				board[1][4] = pointDifference;
//				return pointDifference;
//			}
			//System.out.println("Point difference: " + pointDifference);

			return 0;
		}
		for(int row=0; row<board.length; row++){
			for(int col=0; col<board[0].length; col++){
				if(board[row][col] == -1){
//					//System.out.println("there is a -1 at int row: "+ row + " int col: "+ col);
					break;
				}
				if(board[row][col] == 0){
					if(isLegalMove(board, row, col-2, row, col-1)){	//Move from West
						//System.out.println("Move from West");
						int[][] copyBoard = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
						int score = moveFromWest(copyBoard, row, col);
						int recursionPoint = game_recursion(copyBoard);
						pointDifference = score + recursionPoint;
						board[0][4] = pointDifference;
						scoreList.add(pointDifference);
						if(board[0][4] < board[1][4] && board[0][4] >= 0) {
							board[1][4] = pointDifference;
						}

					}
					if(isLegalMove(board, row, col+2, row, col+1)){	//Move from East
						//System.out.println("Move from East");
						int[][] copyBoard = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
						int score = moveFromEast(copyBoard, row, col);
						int recursionPoint = game_recursion(copyBoard);
						pointDifference = score + recursionPoint;
						board[0][4] = pointDifference;
						if(board[0][4] < board[1][4] && board[0][4] >= 0) {
							board[1][4] = pointDifference;
						}
						scoreList.add(pointDifference);

					}
					if(isLegalMove(board, row+2, col, row+1, col)){	//Move from S-W
						//System.out.println("Move from S-W");
						int[][] copyBoard = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
						int score = moveFromSW(copyBoard, row, col);
						int recursionPoint = game_recursion(copyBoard);
						pointDifference = score + recursionPoint;
						board[0][4] = pointDifference;
						if(board[0][4] < board[1][4] && board[0][4] >= 0) {
							board[1][4] = pointDifference;
						}
						scoreList.add(pointDifference);
					}
					if(isLegalMove(board, row-2, col-2, row-1, col-1)){	//Move from N-W
						//System.out.println("Move from N-
						int[][] copyBoard = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
						int score = moveFromNW(copyBoard, row, col);
						int recursionPoint = game_recursion(copyBoard);
						pointDifference = score + recursionPoint;
						board[0][4] = pointDifference;
						if(board[0][4] < board[1][4] && board[0][4] >= 0) {
							board[1][4] = pointDifference;
						}
						scoreList.add(pointDifference);
					}
					if(isLegalMove(board, row-2, col, row-1, col)){	//Move from N-E
						//System.out.println("Move from N-E");
						int[][] copyBoard = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
						int score = moveFromNE(copyBoard, row, col);
						int recursionPoint = game_recursion(copyBoard);
						pointDifference = score + recursionPoint;
						board[0][4] = pointDifference;
						if(board[0][4] < board[1][4] && board[0][4] >= 0) {
							board[1][4] = pointDifference;
						}
						scoreList.add(pointDifference);
					}
					if(isLegalMove(board, row+2, col+2, row+1, col+1)){	//Move from S-E
						//System.out.println("Move from S-E");
						int[][] copyBoard = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
						int score = moveFromSE(copyBoard, row, col);
						int recursionPoint = game_recursion(copyBoard);
						pointDifference = score + recursionPoint;
						board[0][4] = pointDifference;
						if(board[0][4] < board[1][4] && board[0][4] >= 0) {
							board[1][4] = pointDifference;
						}
						scoreList.add(pointDifference);
					}
				}
			}
		}
//		if(board[0][4] < board[1][4] && board[0][4] >= 0){
//			board[1][4] = pointDifference;
//			return pointDifference;
//		}
		//Get maximum value from scoreList
		if(board[1][3] == 0){
			//System.out.println("scoreList: " + scoreList);
			int max = Collections.max(scoreList);
			return max;
		}
		else{
			//System.out.println("scoreList: " + scoreList);
			int min = Collections.min(scoreList);
			return min;
		}
	}


	public static int numberOfMovesCheck (int[][] board){
		//System.out.println("numberOfMovesCheck");
		int numberOfMoves = 0;
		for(int row=0; row<board.length; row++){
			for(int col=0; col<board[0].length; col++){
//				//System.out.println("board[col][i]= " + board[row][col]);
				if(board[row][col] == -1){
//					//System.out.println("there is a -1 at int row: "+ row + " int col: "+ col);
					break;
				}
				if(board[row][col] == 0){
					//System.out.println("there is a 0 at int row: "+ row + " int col: "+ col);
					if(isLegalMove(board, row, col-2, row, col-1)){numberOfMoves++;}	//Move from West
					if(isLegalMove(board, row, col+2, row, col+1)){numberOfMoves++;}	//Move from East
					if(isLegalMove(board, row+2, col, row+1, col)){numberOfMoves++;}	//Move from S-W
					if(isLegalMove(board, row-2, col-2, row-1, col-1)){numberOfMoves++;}	//Move from N-W
					if(isLegalMove(board, row-2, col, row-1, col)){numberOfMoves++;}	//Move from N-E
					if(isLegalMove(board, row+2, col+2, row+1, col+1)){numberOfMoves++;}	//Move from S-E
				}
			}
		}
		return numberOfMoves;
	}
	public static int numberOfZeros (int[][] board){
		int numberOfZeros = 0;
		for(int row=0; row<board.length; row++){
			for(int col=0; col<board[0].length; col++){
				if(board[row][col] == 0){
					numberOfZeros++;
				}
			}
		}
		return numberOfZeros;
	}

	public static boolean isLegalMove (int[][] board, int row, int col, int row2, int col2){
		if(row >= board.length || row < 0 || col >= board[0].length || col < 0  ){		//We are outside of the pyramid
//			//System.out.println("illegal move");
			return false;
		}if(((board[row][col] * board[row2][col2]) <= 0) || (board[row][col] == -1)){			//If there are zeros in the points, then move is illegal
//			//System.out.println("illegal move");
			return false;
		}else{
			return true;
		}
	}
	public static int moveFromWest(int [][] board, int row, int col){
		board[row][col] = board[row][col-2];
		int score = board[row][col-2] * board[row][col-1];
		if(board[1][3] == 0){	//If DAD TURN
			board[1][3] = 1;
		}else {	//If KID TURN
			board[1][3] = 0;
			score = score * -1; //If KID TURN, then score is negative
		}
		board[row][col-2] = 0;
		board[row][col-1] = 0;
		return score;
	}
	public static int moveFromEast(int [][] board, int row, int col){
		board[row][col] = board[row][col+2];
		int score = board[row][col+2] * board[row][col+1];
		if(board[1][3] == 0){	//If DAD TURN
			board[1][3] = 1;
		}
		else{	//If KID TURN
			board[1][3] = 0;
			score = score * -1; //If KID TURN, then score is negative
		}
		board[row][col+2] = 0;
		board[row][col+1] = 0;
		return score;
	}
	public static int moveFromSW(int [][] board, int row, int col){
		board[row][col] = board[row+2][col];
		int score = board[row+2][col] * board[row+1][col];
		if(board[1][3] == 0){	//If DAD TURN
			board[1][3] = 1;
		}
		else{	//If KID TURN
			board[1][3] = 0;
			score = score * -1; //If KID TURN, then score is negative
		}
		board[row+2][col] = 0;
		board[row+1][col] = 0;
		return score;
	}
	public static int moveFromNW(int [][] board, int row, int col){
		board[row][col] = board[row-2][col-2];
		int score = board[row-2][col-2] * board[row-1][col-1];
		if(board[1][3] == 0){	//If DAD TURN
			board[1][3] = 1;
		}
		else{	//If KID TURN
			board[1][3] = 0;
			score = score * -1; //If KID TURN, then score is negative
		}
		board[row-2][col-2] = 0;
		board[row-1][col-1] = 0;
		return score;
	}
	public static int moveFromNE(int [][] board, int row, int col){
		board[row][col] = board[row-2][col];
		int score = board[row-2][col] * board[row-1][col];
		if(board[1][3] == 0){	//If DAD TURN
			board[1][3] = 1;
		}
		else{	//If KID TURN
			board[1][3] = 0;
			score = score * -1; //If KID TURN, then score is negative
		}
		board[row-2][col] = 0;
		board[row-1][col] = 0;
		return score;
	}
	public static int moveFromSE(int [][] board, int row, int col){
		board[row][col] = board[row+2][col+2];
		int score = board[row+2][col+2] * board[row+1][col+1];
		if(board[1][3] == 0){	//If DAD TURN
			board[1][3] = 1;
		}
		else{	//If KID TURN
			board[1][3] = 0;
			score = score * -1; //If KID TURN, then score is negative
		}
		board[row+2][col+2] = 0;
		board[row+1][col+1] = 0;
		return score;
	}
	public static String toString(int[][] board) {
		String boardString = "";
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				boardString += board[row][col] + " ";
			}
			boardString += "\n";
		}
		return boardString;
	}

	public static void main(String[] args){
		//System.out.println("hello world");
		int[][] board = {
			{3,-1,-1,-1,-1},
			{1,6,-1,-1,-1},
			{1,7,8,-1,-1},
			{5,0,3,4,-1},
			{9,3,2,1,9}
		};
		int[][] noMovesBoard = {
				{3,-1,-1,-1,-1},
				{1,0,-1,-1,-1},
				{1,0,0,-1,-1},
				{5,0,0,0,-1},
				{9,0,2,0,9}
		};
		int[][] test1 = {
				{0,-1,-1,-1,-1},
				{1,1,-1,-1,-1},
				{1,1,1,-1,-1},
				{1,1,1,1,-1},
				{1,1,1,1,1}
		};
		int[][] smallBoard = {
				{0,-1,-1,-1,-1},
				{2,1,-1,-1,-1},
				{5,4,3,-1,-1},
				{-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1}
		};
//		int numberOfMoves = numberOfMovesCheck(board);
//		int noMoves = numberOfMovesCheck(noMovesBoard);
//		int numberOfMovesBIG = game_recursion(board);
//		System.out.println("number of moves BIG TEST INSHALLAH: "+ numberOfMovesBIG);
		int test1Moves = game_recursion(test1);
		System.out.println("most optimal: "+ test1Moves);
//		int smallBoardMoves = game_recursion(smallBoard);
//		System.out.println("Score difference: "+ smallBoardMoves);
//		//System.out.println("number of noMoves: "+ noMoves);

	}
}



