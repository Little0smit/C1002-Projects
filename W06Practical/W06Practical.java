
public class W06Practical {

	// square contents representation
  
		private static final int EMPTY = 0 ;
  		private static final int WHITEROOK = 1 ;  
  		private static final int WHITEBISHOP = 2;
  		private static final int BLACKROOK = 3;
  		private static final int BLACKBISHOP = 4;
	//

	public static void fillStartArray(int[][] chessBoard) {
	//Set the pieces onto the board
		chessBoard[0][0] = WHITEROOK;
		chessBoard[0][2] = WHITEBISHOP;
		chessBoard[0][5] = WHITEBISHOP;
		chessBoard[0][7] = WHITEROOK;

		chessBoard[7][0] = BLACKROOK;
		chessBoard[7][2] = BLACKBISHOP;
		chessBoard[7][5] = BLACKBISHOP;
		chessBoard[7][7] = BLACKROOK;
	}

	public static void showBoard(int[][] chessBoard){
	//Print the current board to the user
		System.out.println();
		for(int row = 7; row >-1; row--){
			System.out.print(" ");
			for(int col = 0; col <8; col++){
				switch (chessBoard[row][col]) {
				case EMPTY:
					System.out.print("__|");
					break;
				case WHITEROOK:
					System.out.print("WR|");
					break;
				case WHITEBISHOP:
					System.out.print("WB|");
					break;
				case BLACKROOK:
					System.out.print("BR|");
					break;
				case BLACKBISHOP:
					System.out.print("BB|");
					break;
				default:
					System.out.print("??|");
				}
			}
			System.out.print(" " + (row + 1));
			System.out.println();
		}
		System.out.println(" AA BB CC DD EE FF GG HH");
	}

	public static void showStats(boolean whiteToPlay, int movesMade, boolean endGame){
	//Print current moves and who's go to user	
		System.out.println("There have been " + movesMade + " moves played");
 		if (endGame)
			System.out.println("Game Over");
		else if (whiteToPlay)
			System.out.println("White's move");
		else
			System.out.println("Black's move");
	}

	public static int getColInt(String colChar){
		int colInt = 0;
		switch (colChar) {
			case "a":
				colInt = 1;
				break;
			case "b":
				colInt = 2;
				break;
			case "c":
				colInt = 3;
				break;
			case "d":
				colInt = 4;
				break;
			case "e":
				colInt = 5;
				break;
			case "f":
				colInt = 6;
				break;
			case "g":
				colInt = 7;
				break;
			case "h":
				colInt = 8;
				break;
			default:
				colInt = 0;	
		}
		return colInt;
	}

	public static boolean makeMove(int[][] chessBoard, int movePiece, int startRow, int startCol, int endRow, int endCol, boolean whiteToPlay){
		if (whiteToPlay){
			if (movePiece == 1){ 
			//Check it is a White piece selected
				if (startCol == endCol || startRow == endRow){
					//Test Print
					if (validMove(chessBoard, movePiece, startRow-1, startCol-1, endRow-1, endCol-1)){
						System.out.println("Valid Move");
						return true;
					}	
				} else
				System.out.println("Invalid Move, try again");
				return false;
			} else if (movePiece == 2){
			//Check it is a White piece selected
				if ((endCol - startCol == endRow - startRow) || ((endCol - startCol)+(endRow - startRow) == 0 )){
					//Test Print
					if (validMove(chessBoard, movePiece, startRow-1, startCol-1, endRow-1, endCol-1)){
						System.out.println("Valid Move");
						return true;
					}
				} else
				System.out.println("Invalid Move, try again");

			} else {
				return false;
			}	
		} else {
			if (movePiece == 3){
			//Check it is a White piece selected
				if (startCol == endCol || startRow == endRow){
					//Test Print
					if (validMove(chessBoard, movePiece, startRow-1, startCol-1, endRow-1, endCol-1)){
						System.out.println("Valid Move");
						return true;
					}
				} else {
				System.out.println("Invalid Move, try again");
				return false;
				}
			} else if (movePiece == 4){ 
			//Check it is a Black piece selected
				if ((endCol - startCol == endRow - startRow) || ((endCol - startCol)+(endRow - startRow) == 0 )){
					//Test Print
					if (validMove(chessBoard, movePiece, startRow-1, startCol-1, endRow-1, endCol-1)){
						System.out.println("Valid Move");
						return true;
					}
				} else
				System.out.println("Invalid Move, try again");
				return false;	
			} else {
				return false;
			}
		}
		return false;
	}	
	
	public static boolean validMove(int[][] chessBoard, int movePiece, int startRow, int startCol, int endRow, int endCol){
	//Test if there are any pieces in the way of the move
		if (movePiece == WHITEROOK){ 
		//If the piece moving is a White Rook 
			if ((endCol - startCol) == 0){
			//moving rows (up and down)
				if (startRow > endRow){
				//if moving down
					for (int n = startRow - 1; n > endRow - 1; n--){
						//check there are no pieces in the way//
						if (chessBoard[n][startCol] == WHITEROOK || chessBoard[n][startCol] == WHITEBISHOP){
							System.out.println("Error, piece is in the way");
							// System.out.println("moving down");
							// System.out.println(chessBoard[n][startCol]);
							return false;
						} else if ( n > endRow && (chessBoard[n][startCol] == BLACKROOK || chessBoard[n][startCol] == BLACKBISHOP )){
						//if a black piece is in the way before final piece.
							System.out.println("Error, piece is in the way. You cannot move over black pieces.");
							return false;
						}
					}
					
				} else {
				//if moving up
					for (int n = startRow + 1; n < endRow + 1; n++){
					//check there are no pieces in the way//
						if (chessBoard[n][startCol] == WHITEROOK || chessBoard[n][startCol] == WHITEBISHOP){
							System.out.println("Error, piece is in the way");
							// System.out.println("moving up");
							// System.out.println( n+ "," +startCol );
							// System.out.println(chessBoard[n][startCol]);
							return false;
						} else if ((chessBoard[n][startCol] == BLACKROOK || chessBoard[n][startCol] == BLACKBISHOP )&&  n < endRow){
						//if a black piece is in the way before final piece.
							System.out.println("Error, piece is in the way. You cannot move over black pieces.");
							return false;
						}
					}
					return true;
				}
			} else {
			//moving columns (left and right)
				if (startCol > endCol){
				//if moving Left
					for (int n = startCol - 1; n > endCol - 1; n--){
						//check there are no pieces in the way//
						if (chessBoard[startRow][n] == WHITEROOK || chessBoard[startRow][n] == WHITEBISHOP){
							System.out.println("Error, piece is in the way");
							// System.out.println("moving left");
							// System.out.println(startRow+ "," + n );
							// System.out.println(chessBoard[startRow][n]);
							return false;
						} else if ((chessBoard[startRow][n] == BLACKROOK || chessBoard[startRow][n] == BLACKBISHOP) && n > endCol){
						//if a black piece is in the way before final piece.
							System.out.println("Error, piece is in the way. You cannot move over black pieces.");
							return false;
						}
					}
					return true;
				} else {
				//if moving Right
					for (int n = startCol +1; n < endCol + 1; n++){
						//check there are no pieces in the way//
						if (chessBoard[startRow][n] == WHITEROOK || chessBoard[startRow][n] == WHITEBISHOP){
							System.out.println("Error, piece is in the way");
							// System.out.println("moving right");
							// System.out.println(startRow + "," + n);
							// System.out.println(chessBoard[startRow][n]);
							return false;
						} else if ((chessBoard[startRow][n] == BLACKROOK || chessBoard[startRow][n] == BLACKBISHOP) && n < endCol){
						//if a black piece is in the way before final piece.
							System.out.println("Error, piece is in the way. You cannot move over black pieces.");
							return false;
						}
					}
					return true;
				}
			}
			return true;
		} else if (movePiece == WHITEBISHOP){
		//If the piece moving is a White Bishop 
			if (startRow < endRow && startCol < endCol){
			//If moving up and right
				int dist = endRow-startRow;
				for (int n = 1; n < dist + 1; n++){
					//Check there are no pieces in the way//
					if (chessBoard[startRow + n][startCol + n] == WHITEROOK || chessBoard[startRow + n][startCol + n] == WHITEBISHOP){
						System.out.println("Error, piece is in the way. Try again.");
						System.out.println((startRow + n) + "," + (startCol + n) + " = " + chessBoard[startRow + n][startCol + n]);
						return false;
					} else if ((chessBoard[startRow + n][startCol + n] == BLACKROOK || chessBoard[startRow + n][startCol + n] == BLACKBISHOP) && n < dist){
					//if a black piece is in the way before final piece.
						System.out.println("Error, piece is in the way. You cannot move over black pieces.");
						return false;
					}

				}
				
			} else if (startRow > endRow && startCol < endCol){
			//If moving down and right
				int dist = startRow - endRow;
				for (int n = 1; n < dist + 1; n++){
					//Check there are no pieces in the way//
					if (chessBoard[startRow - n][startCol + n] == WHITEROOK || chessBoard[startRow - n][startCol + n] == WHITEBISHOP){
						System.out.println("Error, piece is in the way. Try again.");
						System.out.println((startRow - n) + "," + (startCol + n) + " = " + chessBoard[startRow - n][startCol + n]);
						return false;
					} else if ((chessBoard[startRow - n][startCol + n] == BLACKROOK || chessBoard[startRow - n][startCol + n] == BLACKBISHOP) && n < dist){
					//if a black piece is in the way before final piece.
						System.out.println("Error, piece is in the way. You cannot move over black pieces.");
						return false;
					}
				}
				
			} else if (startRow > endRow && startCol > endCol){
			//If moving down and left
				int dist = startRow - endRow;
				for (int n = 1; n < dist + 1; n++){
					//Check there are no pieces in the way//
					if (chessBoard[startRow - n][startCol - n] == WHITEROOK || chessBoard[startRow - n][startCol - n] == WHITEBISHOP){
						System.out.println("Error, piece is in the way. Try again.");
						System.out.println((startRow - n) + "," + (startCol - n) + " = " + chessBoard[startRow - n][startCol - n]);
						return false;
					} else if ((chessBoard[startRow - n][startCol - n] == BLACKROOK || chessBoard[startRow - n][startCol - n] == BLACKBISHOP) && n < dist){
					//if a black piece is in the way before final piece.
						System.out.println("Error, piece is in the way. You cannot move over black pieces.");
						return false;
					}
				}
				
			} else if (startRow < endRow && startCol > endCol){
			//If moving up and left
				int dist =  endRow - startRow;
				for (int n = 1; n < dist + 1; n++){
					//Check there are no pieces in the way//
					if (chessBoard[startRow + n][startCol - n] == WHITEROOK || chessBoard[startRow + n][startCol - n] == WHITEBISHOP){
						System.out.println("Error, piece is in the way. Try again.");
						System.out.println((startRow + n) + "," + (startCol - n) + " = " + chessBoard[startRow + n][startCol - n]);
						return false;
					} else if ((chessBoard[startRow + n][startCol - n] == BLACKROOK || chessBoard[startRow + n][startCol - n] == BLACKBISHOP) && n < dist){
					//if a black piece is in the way before final piece.
						System.out.println("Error, piece is in the way. You cannot move over black pieces.");
						return false;
					}
				}	
			}
			return true;
		} else if (movePiece == BLACKROOK){
		//If the piece moving is a Black Rook 
			if ((endCol - startCol) == 0){
			//moving rows (up and down)
				if (startRow > endRow){
				//if moving down
					for (int n = startRow - 1; n > endRow - 1; n--){
						//check there are no pieces in the way//
						if (chessBoard[n][startCol] == BLACKROOK || chessBoard[n][startCol] ==  BLACKBISHOP){
							System.out.println("Error, piece is in the way");
							// System.out.println("moving down");
							// System.out.println(chessBoard[n][startCol]);
							return false;
						} else if ( n > endRow && (chessBoard[n][startCol] == WHITEROOK || chessBoard[n][startCol] == WHITEBISHOP )){
						//if a white piece is in the way before final piece.
							System.out.println("Error, piece is in the way. You cannot move over white pieces.");
							return false;
						}
					}
					return true;
				} else {
				//if moving up
					for (int n = startRow + 1; n < endRow + 1; n++){
						//check there are no pieces in the way//
						if (chessBoard[n][startCol] == BLACKROOK || chessBoard[n][startCol] == BLACKBISHOP){
							System.out.println("Error, piece is in the way");
							// System.out.println("moving up");
							// System.out.println( n+ "," +startCol );
							// System.out.println(chessBoard[n][startCol]);
							return false;
						} else if ( n < endRow && (chessBoard[n][startCol] == WHITEROOK || chessBoard[n][startCol] == WHITEBISHOP )){
						//if a white piece is in the way before final piece.
							System.out.println("Error, piece is in the way. You cannot move over white pieces.");
							return false;
						}
					}
					return true;
				}
			} else {
			//moving columns (left and right)
				if (startCol > endCol){
				//if moving Left
					for (int n = startCol - 1; n > endCol - 1; n--){
						//check there are no pieces in the way//
						if (chessBoard[startRow][n] == BLACKROOK || chessBoard[startRow][n] == BLACKBISHOP){
							System.out.println("Error, piece is in the way");
							// System.out.println("moving left");
							// System.out.println(startRow+ "," + n );
							// System.out.println(chessBoard[startRow][n]);
							return false;
						} else if (  n > endCol && (chessBoard[startRow][n] == WHITEROOK || chessBoard[startRow][n] == WHITEBISHOP )){
						//if a white piece is in the way before final piece.
							System.out.println("Error, piece is in the way. You cannot move over white pieces.");
							return false;
						}
					}
					return true;
				} else {
				//if moving Right
					for (int n = startCol +1; n < endCol + 1; n++){
						//check there are no pieces in the way//
						if (chessBoard[startRow][n] == BLACKROOK ||chessBoard[startRow][n] == BLACKBISHOP){
							System.out.println("Error, piece is in the way");
							// System.out.println("moving right");
							// System.out.println(startRow + "," + n);
							// System.out.println(chessBoard[startRow][n]);
							return false;
						} else if (  n < endCol && (chessBoard[startRow][n] == WHITEROOK || chessBoard[startRow][n] == WHITEBISHOP )){
						//if a white piece is in the way before final piece.
							System.out.println("Error, piece is in the way. You cannot move over white pieces.");
							return false;
						}
					}
				}
			}
			return true;
		} else if (movePiece == BLACKBISHOP){
		//If the piece moving is a Black Bishop 
			if (startRow < endRow && startCol < endCol){
			//If moving up and right
				int dist = endRow-startRow;
				for (int n = 1; n < dist + 1; n++){
					//Check there are no pieces in the way//
					if (chessBoard[startRow + n][startCol + n] == BLACKROOK || chessBoard[startRow + n][startCol + n] == BLACKBISHOP){
						System.out.println("Error, piece is in the way. Try again.");
						System.out.println((startRow + n) + "," + (startCol + n) + " = " + chessBoard[startRow + n][startCol + n]);
						return false;
					} else if ((chessBoard[startRow + n][startCol + n] == WHITEROOK || chessBoard[startRow + n][startCol + n] == WHITEBISHOP) && n < dist){
					//if a white piece is in the way before final piece.
						System.out.println("Error, piece is in the way. You cannot move over white pieces.");
						return false;
					}

				}
				return true;
			} else if (startRow > endRow && startCol < endCol){
			//If moving down and right
				int dist = startRow - endRow;
				for (int n = 1; n < dist + 1; n++){
					//Check there are no pieces in the way//
					if (chessBoard[startRow - n][startCol + n] == BLACKROOK || chessBoard[startRow - n][startCol + n] == BLACKBISHOP){
						System.out.println("Error, piece is in the way. Try again.");
						System.out.println((startRow - n) + "," + (startCol + n) + " = " + chessBoard[startRow - n][startCol + n]);
						return false;
					} else if ((chessBoard[startRow - n][startCol + n] == WHITEROOK || chessBoard[startRow - n][startCol + n] == WHITEBISHOP) && n < dist){
					//if a white piece is in the way before final piece.
						System.out.println("Error, piece is in the way. You cannot move over white pieces.");
						return false;
					}
				}
				return true;
			} else if (startRow > endRow && startCol > endCol){
			//If moving down and left
				int dist = startRow - endRow;
				for (int n = 1; n < dist + 1; n++){
					//Check there are no pieces in the way//
					if (chessBoard[startRow - n][startCol - n] == BLACKROOK || chessBoard[startRow - n][startCol - n] == BLACKBISHOP){
						System.out.println("Error, piece is in the way. Try again.");
						System.out.println((startRow - n) + "," + (startCol - n) + " = " + chessBoard[startRow - n][startCol - n]);
						return false;
					} else if ((chessBoard[startRow - n][startCol - n] == WHITEROOK || chessBoard[startRow - n][startCol - n] == WHITEBISHOP) && n < dist){
					//if a white piece is in the way before final piece.
						System.out.println("Error, piece is in the way. You cannot move over white pieces.");
						return false;
					}
				}
				return true;
			} else if (startRow < endRow && startCol > endCol){
			//If moving up and left
				int dist =  endRow - startRow;
				for (int n = 1; n < dist + 1; n++){
					//Check there are no pieces in the way//
					if (chessBoard[startRow + n][startCol - n] == BLACKROOK || chessBoard[startRow + n][startCol - n] == BLACKBISHOP){
						System.out.println("Error, piece is in the way. Try again.");
						System.out.println((startRow + n) + "," + (startCol - n) + " = " + chessBoard[startRow + n][startCol - n]);
						return false;
					} else if ((chessBoard[startRow + n][startCol - n] == WHITEROOK || chessBoard[startRow + n][startCol - n] == WHITEBISHOP) && n < dist){
					//if a white piece is in the way before final piece.
						System.out.println("Error, piece is in the way. You cannot move over white pieces.");
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	public static boolean valid(int number){
		if (number > 8||number<1)
			return false;
		return true;
	}
	

	public static void playChess(int[][] chessBoard){
		// turn control
	    boolean whiteToPlay = true ;
	    
	    // game control
	    int movesMade = 0 ;
	    boolean endGame = false ;
	    boolean move = false;
	    int remainingBlack = 0;
	    int remainingWhite = 0;
	    
	    int startCol = 0;
	    int startRow = 0;
	    int endCol = 0;
	    int endRow = 0;

	    // user interface loop
	    String command = "" ;
	    do {

	    	showBoard(chessBoard) ;
	    	showStats(whiteToPlay, movesMade, endGame);
	    	if (endGame){
	    		System.out.println("Congratulations you have won!!");
	    		System.out.println("Enter Quit to exit");
	    	} else 
	    		System.out.print("Enter command (move or Quit): ");
	    	command = EasyIn.getString();
	    	if (command.equals("move")){
	    		if (endGame)
         			System.out.println("game over - cannot move!") ;
        		else {
        			do {
        				do {
		    				System.out.print("Enter Start Column (a-h): ");
		    				String startColC = EasyIn.getString();
		    				startCol = getColInt(startColC);
		    			} while (!valid(startCol));
		    			do {
		  	  			System.out.print("Enter Start Row (1-8): ");
		   	 			startRow = EasyIn.getInt();
		   	 		} while (!valid(startRow));
		   	 		do {
		  	  			System.out.print("Enter End Column (a-h): ");
		    				String endColC = EasyIn.getString();
		    				endCol = getColInt(endColC);
		    			} while (!valid(endCol));
		    			do{
		    				System.out.print("Enter End Row (1-8): ");
		    				endRow = EasyIn.getInt();
		    			} while (!valid(endRow));
		    			int movePiece = chessBoard[startRow-1][startCol-1];
		    			// //Test print to check input is working
		    			// System.out.println("Moving from (" + startCol + "," + startRow + ") to (" + endCol + "," + endRow + ")");
		    			// System.out.println("Moving piece: " + movePiece);
		    			// //End Test Block
		    			move = makeMove(chessBoard, movePiece, startRow, startCol, endRow, endCol, whiteToPlay);
		    			//If the move is valid, move the piece on the board and update stats
		    			if (move){
		    				if (whiteToPlay)
		    					whiteToPlay = false;
		    				else
		    					whiteToPlay = true;
		    				chessBoard[startRow - 1][startCol - 1] = EMPTY;
		    				chessBoard[endRow-1][endCol-1] = movePiece;
		    				movesMade++;
		    			}
		    			//Check for a victory
		    			remainingWhite = 0;
		    			remainingBlack = 0;
		    			for(int row = 0; row <8; row++){
							for(int col = 0; col <8; col++){
								if (chessBoard[row][col] == WHITEROOK || chessBoard[row][col] == WHITEBISHOP)
									remainingWhite++;
								else if (chessBoard[row][col] == BLACKROOK || chessBoard[row][col] == BLACKBISHOP)
									remainingBlack++;
							}
						}
						if (remainingWhite == 0 || remainingBlack == 0)
							endGame = true;
		    		} while (move == false);
	    		}
	    	}
	    	//command = "quit";
	    } while(!command.equals("Quit")) ;
	}

	public static void main (String args[]) {
		//create the array and make it empty
		int[][] chessBoard = new int[8][8] ;
		for (int row = 0; row < 8; row ++){
			for (int col = 0; col < 8; col++)
				chessBoard[row][col] = EMPTY ;
		}
		fillStartArray(chessBoard);
		playChess(chessBoard);
	}
 }
