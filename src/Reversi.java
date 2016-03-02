/** This class represents a game of Reversi.
 * @author Miles B Huff <a href="mailto:MilesBHuff@UGA.edu"><nohtml><</nohtml>email<nohtml>></nohtml></a>
 * @date   2016-02-29
 * @disclaimer
 *  The following code represents our own work.  We have neither received nor 
 *  given inappropriate assistance.  We have not copied or modified code from 
 *  any source, apart from the course webpage and the course-textbook.  We 
 *  recognize that any unauthorized assistance or plagiarism will be handled in 
 *  accordance with the University of Georgia's Academic Honesty Policy and the 
 *  policies of this course.  We recognize that our work is based upon an 
 *  assignment created by the Department of Computer Science at the University 
 *  of Georgia.  Any publishing or posting of source code for this project is 
 *  strictly prohibited unless we have written consent from the Department of 
 *  Computer Science at the University of Georgia.  This statement of academic 
 *  honesty is derived from the one given in the instructions for lab #2 in 
 *  CSCI1301.  
 * @see <a href="https://gist.github.com/mepcotterell/3564a8eaa32f49e3d460</a>
**/

public class Reversi
{ //0+
	private static boolean bDarkTurn  = true;  // Dark goes first
	private static int     iDarkType  = 1   ;  // Default to random CPU
	private static int     iLightType = 1   ;  // Default to random CPU
	
	////////////////////////////////////////////////////////////////////////////
	/** The main method.  
	 * @author Miles B Huff
	 * @param  saArgs Arguments passed into the program from the commandline.  
	**/
	public static void main(String[] saArgs)
	{ //1+
		// Check saArgs
		String[] sa = validateArgs(saArgs) ;
		
		// Create players
		for(int i = 0; i < sa.length; i++)
		{ //2+
			switch(sa[i])
			{ //3+
				case "Human":
					if(i == 0) Player oDark  = new Player.HumanPlayer ;
					else       Player oLight = new Player.HumanPlayer ;
					break ;
				case "RandomComputerPlayer":
					if(i == 0) Player oDark  = new Player.ComputerPlayer.RandomComputerPlayer ;
					else       Player oLight = new Player.ComputerPlayer.RandomComputerPlayer ;
					break ;
				case "IntelligentComputerPlayer":
					if(i == 0) Player oDark  = new Player.ComputerPlayer.IntelligentComputerPlayer ;
					else       Player oLight = new Player.ComputerPlayer.IntelligentComputerPlayer ;
					break ;
				default:
					System.out.println("If you're seeing this, something went wrong.  ") ;
					break ;
			} //3-
		} //2-

		// Instantiate a new game
		Board oGrid = new ReversiBoard ;
		System.out.println("Welcome to Reversi!  Moves should be entered in \"[row] [column]\" format.  ") ;
		
		// Core game-loop
		while(true)
		{ //2+
			// Figure out if there are any moves left.  If not, the game is over.  
			oGrid.calcMoves() ;
			if(!oGrid.canMove()) oGrid.endGame(oGrid.getScore()) ;

			// Refresh the gameboard
			System.out.println(oGrid.toString()) ;

			// Get player-input and change the grid with it
			if(bDarkTurn)
			{ //3+
				System.out.println("Enter your move, X player:  ") ;
				grid.update(oDark.getInput()) ;
			} else { //3=
				System.out.println("Enter your move, O player:  ") ;
				grid.update(oLight.getInput()) ;
			} //3-
			
			// Change whose turn it is
			if(bDarkTurn) bDarkTurn = false ;
			else          bDarkTurn = true  ;
		} //2-
    	} //1-

	////////////////////////////////////////////////////////////////////////////
	/** Validate and simplify input to just 2 args.  
	 * @author Miles B Huff
	 * @param  saArgs  Arguments passed into the program from the commandline.  
	**/
	private String[2] checkArgs(String[] saArgs)
	{ //1+
		//TODO
	} //1-
} //0-
