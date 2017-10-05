import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891

	@Test 
	public void testSudokuVerifier_NumberCount()  {
		SudokuVerifier verify = new SudokuVerifier();
		
		String testr = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		assertEquals(0, verify.checkLengthDigit(testr));
	}
	
	@Test 
	public void testSudokuVerifier_noDigitFail()  {
		SudokuVerifier verify = new SudokuVerifier();
		
		String testr = "417369825632158947958724316825437169791586432346912758289643571573295684164875jjj";
		
		assertEquals(-1, verify.checkLengthDigit(testr));
	}
	
	@Test 
	public void testSudokuVerifier_testGridding()  {
		SudokuVerifier verify = new SudokuVerifier();
		
		String testr = "417369825632158947958724316825437169791586432346912758289643571573295684164875293";
		
		int[][] grid = verify.formGrids(testr);
		
		assertEquals(3, grid[8][8]);
	}
	
	@Test 
	public void testSudokuVerifier_testRow()  {
		SudokuVerifier verify = new SudokuVerifier();
		
		String testr = "417369825632158947958724316825437169791586432346912758289643571573295684164875293";
		
		int[][] grid = verify.formGrids(testr);
		
		assertEquals(0, verify.rowCheck(grid));
	}
	
	@Test 
	public void testSudokuVerifier_testColumnFail()  {
		SudokuVerifier verify = new SudokuVerifier();
		
		String testr = "417369825632158947958724316825437169791586432346912758289643571573295684164875293";
		
		int[][] grid = verify.formGrids(testr);
		
		grid[8][7] = 1;
		grid[8][8] = 1;
		
		assertEquals(-3, verify.rowCheck(grid));
	}
	
	@Test 
	public void testSudokuVerifier_subGridtest()  {
		SudokuVerifier verify = new SudokuVerifier();
		
		String testr = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		int[][] grid = verify.formGrids(testr);
		
		
		assertEquals(0, verify.subGridCheck(grid));
	}
	
	
}
