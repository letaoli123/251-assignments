import java.util.*;

public class A2_Q1{
	
	public static int game_recursion(int[][] board) {

		return 0;
	}


	public static int numberOfMovesCheck (int[][] board){
		int numberOfMoves = 0;
		for(int j=0; j<board[0].length; j++){
			for(int i=0; i<board.length; i++){
				if(board[i][j] == -1){
					break;
				}
				if(board[i][j] == 0){
					if(isLegalMove(board, i-2, j, i-1, j)){numberOfMoves++;}	//Move from East
					if(isLegalMove(board, i+2, j, i+1, j)){numberOfMoves++;}	//Move from West
					if(isLegalMove(board, i, j+2, i, j+1)){numberOfMoves++;}	//Move from S-W
					if(isLegalMove(board, i-2, j-2, i-1, j-1)){numberOfMoves++;}	//Move from N-W
					if(isLegalMove(board, i, j-2, i, j-2)){numberOfMoves++;}	//Move from N-E
					if(isLegalMove(board, i+2, j+2, i+1, j+1)){numberOfMoves++;}	//Move from S-E
				}
			}
		}
		return numberOfMoves;
	}

	public static boolean isLegalMove (int[][] board, int i, int j, int i2, int j2){
		if(board[i][j] == -1 || i >= board.length || i < 0 || j >= board[0].length || j < 0){		//We are outside of the pyramid
			System.out.println("illegal move");
			return false;
		}if((board[i][j] * board[i2][j2]) <= 0){			//If there are zeros in the points, then move is illegal
			System.out.println("illegal move");
			return false;
		}else{
			return true;
		}
		
	}

	public static void main(String[] args){
		System.out.println("hello world");
		int[][] board = {
			{3,-1,-1,-1,-1},
			{1,6,-1,-1,-1,-1},
			{1,7,8,-1,-1,-1},
			{5,0,3,4,-1},
			{9,3,2,1,9}
		};
		int numberOfMoves = numberOfMovesCheck(board);
		System.out.println("number of moves: "+ numberOfMoves);

	}
}



