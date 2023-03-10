import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> computerPositions = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		char [][] gameBoard = {
				{'1', '|','2', '|','3' }, 
				{'-', '+','-', '+','-' },
				{'4', '|','5', '|','6' },
				{'-', '+','-', '+','-' },
				{'7', '|','8', '|','9' }};
				
		
		printGameBoard(gameBoard);
		
		
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter Your Position (1-9)");
			int playerPosition = scan.nextInt();
			while(playerPositions.contains(playerPosition) || computerPositions.contains(playerPosition)) {
				System.out.println("Position Taken. Please Choose Another Position");
				playerPosition = scan.nextInt();
			}
			
			placePiece(gameBoard, playerPosition, "player");
			
			String result  = checkWinner();
			if(result.length()> 0) {
				printGameBoard(gameBoard);
				System.out.println(result);
				break;
				
			}
			
			Random random = new Random();
			int computerPosition = random.nextInt(9) +1;
			
			while(playerPositions.contains(computerPosition) || computerPositions.contains(computerPosition)) {
				System.out.println("Position Taken. Please Choose Another Position");
				computerPosition = random.nextInt(9) +1;
				
				
			}
			placePiece(gameBoard, computerPosition, "computer");
			printGameBoard(gameBoard);
			result  = checkWinner();
			if(result.length()> 0) {
				printGameBoard(gameBoard);
				System.out.println(result);
				break;
			}
			System.out.println(result);
		
			}
		
	}
	
	public static void printGameBoard(char [][] gameBoard) {
		for(char [] row: gameBoard) {
			for(char c: row) {
				System.out.print(c);
			}
			System.out.println();
		} 
	}
	
	public static void placePiece(char [][] gameBoard, int position, String user) {
		char symbol = ' ';
		
		if(user.equals("player")) {
			symbol = 'X';
			playerPositions.add(position);
		}else if(user.equals("computer")){
			symbol = 'O';
			computerPositions.add(position);
		}
		
		switch(position) {
			case 1: 
				gameBoard[0][0] = symbol;
				break;
			case 2: 
				gameBoard[0][2] = symbol;
				break;
			case 3: 
				gameBoard[0][4] = symbol;
				break;
			case 4: 
				gameBoard[2][0] = symbol;
				break;
			case 5: 
				gameBoard[2][2] = symbol;
				break;
			case 6: 
				gameBoard[2][4] = symbol;
				break;
			case 7: 
				gameBoard[4][0] = symbol;
				break;
			case 8: 
				gameBoard[4][2] = symbol;
				break;
			case 9: 
				gameBoard[4][4] = symbol;
				break;
			default:
				break;
			
			
		}
	}
	
	public static String checkWinner() {
		List topRow = Arrays.asList(1, 2, 3);
		List middleRow = Arrays.asList(4, 5, 6);
		List bottomRow = Arrays.asList(7, 8, 9);
		List leftColumn = Arrays.asList(1, 4, 7);
		List middleColumn = Arrays.asList(2, 5, 8);
		List rightColumn= Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(3, 5, 7);
		
		List<List> winningConditions = new ArrayList<List>();
		winningConditions.add(topRow);
		winningConditions.add(middleRow);
		winningConditions.add(bottomRow);
		winningConditions.add(leftColumn);
		winningConditions.add(middleColumn);
		winningConditions.add(rightColumn);
		winningConditions.add(cross1);
		winningConditions.add(cross2);
		
		for(List l: winningConditions) {
			if(playerPositions.containsAll(l)) {
				return "Congrats You Won!";
			}else if(computerPositions.containsAll(l)) {
				return "You Lost";
			}else if(playerPositions.size() + computerPositions.size() == 9) {
				return "CAT";
			}
		}
		
		
		return "";
	}

	

}
