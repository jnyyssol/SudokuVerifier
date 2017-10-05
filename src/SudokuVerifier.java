
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		return 0;
		
		//check
	}
	
	public int checkLengthDigit(String canditateSolution)
	{
		if (canditateSolution.length() > 81)
			return -1;
		
		for (char c : canditateSolution.toCharArray()) {
			if (!Character.isDigit(c))
				return -1;
		}
		
		return 0;
	}
	
	public int[][] formGrids(String canditateSolution) {
		
		int grid[][] = new int[9][9];
		int rowno = 0;
		
		for(int i = 0; i < 81; i++) {
			if (i % 9 == 0 && rowno < 8) 
			{
				rowno++;
			}
			grid[i % 9][rowno] = Character.getNumericValue(canditateSolution.toCharArray()[i]);
		}
		return grid;
	}
	
	public int rowCheck(int[][] theGrid) {
		
		for(int row=0; row < 9; row++) {
			for(int col=0; col < 9; col++) {
				for(int spot=0; spot < 9; spot++) {
					if(theGrid[row][col] == theGrid[row][spot] && spot != col) {
						return -3;
					}
				}
			}
		}
		return 0;
	}
	
	public int columnCheck(int[][] theGrid) {
		
		for(int col=0; col < 9; col++) {
			for(int row=0; row < 9; row++) {
				for(int spot=0; spot < 9; spot++) {
					if(theGrid[row][col] == theGrid[spot][col] && spot != row) {
						return -4;
					}
				}
			}
		}
		return 0;
	}
	
	//doesn't work
	
	public int subGridCheck(int[][] theGrid) {
		
		int skip = 0;
		int[] ingrid = new int[9];
		int realrow = 0;
		int ingspot = 0;
		
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<27; j++) {
				skip++;
				if (skip % 3 == 0) {
					j = j+6;
				}
				
				ingrid[ingspot] = theGrid[j % 3][realrow];
				ingspot++;
				
				if (skip % 3 == 0) {
					skip=0;
					realrow++;
				}
				
			}
			for (int j=0; j<9; j++) {
			      for (int k=0; k<9; k++) {
			    	  if (k!=j && ingrid[k] == ingrid[j]) {
			    		  return -2; 
			    	  }
			      }
			}
			ingspot = 0;
		}
		
		return 0;
	}
}






