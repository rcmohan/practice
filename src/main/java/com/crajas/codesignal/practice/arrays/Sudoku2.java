package com.crajas.codesignal.practice.arrays;


/**
 * Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.
 * 
 * Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle according to the layout rules described above. Note that the puzzle represented by grid does not have to be solvable.
 * 
 * Example
 * 
 * For
 * 
 * grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
 *         ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
 *         ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
 *         ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
 *         ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
 *         ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
 *         ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
 *         ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
 *         ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
 * the output should be
 * solution(grid) = true;
 * 
 * For
 * 
 * grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
 *         ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
 *         ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
 *         ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
 *         ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
 *         ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
 *         ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
 *         ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
 *         ['.', '2', '.', '.', '3', '.', '.', '.', '.']]
 * the output should be
 * solution(grid) = false.
 * 
 * The given grid is not correct because there are two 1s in the second column. Each column, each row, and each 3 × 3 subgrid can only contain the numbers 1 through 9 one time.
 * 
 * Input/Output
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] array.array.char grid
 * 
 * A 9 × 9 array of characters, in which each character is either a digit from '1' to '9' or a period '.'.
 * 
 * [output] boolean
 * 
 * Return true if grid represents a valid Sudoku puzzle, otherwise return false.
 * @author rcmohan@gmail.com
 *
 */
public class Sudoku2 {
	boolean solution(char[][] grid) {
	    return rowcheck(grid) && subgridcheck(grid);    
	}

	boolean rowcheck(char[][] g) {
	    for(int i = 0; i < 9; ++i) {
	        boolean[] xcounts = new boolean[9];
	        boolean[] ycounts = new boolean[9];
	        for(int j = 0; j < 9; ++j) {
	            if(g[i][j] != '.') {
	                if(xcounts['9' - g[i][j]]) return false;
	                else xcounts['9' - g[i][j]] = true;
	            }        
	            if(g[j][i] != '.') {
	                if(ycounts['9' - g[j][i]]) return false;
	                else ycounts['9' - g[j][i]] = true;
	            }        
	        }        
	    }
	    return true;
	}

	boolean subgridcheck(char[][] g) {
	    for(int k = 0; k < 3; ++k) {
	        for(int l = 0; l < 3; ++l) {
	            boolean[] counts = new boolean[9];
	            for(int i = k *3; i < (k + 1) * 3; ++i) {
	                for(int j = l *3; j < (l + 1) * 3; ++j) {
	                    if(g[i][j] != '.') {
	                        if(counts['9' - g[i][j]]) return false;
	                        else counts['9' - g[i][j]] = true;
	                    }        
	                }
	            }
	        
	        }        
	    }
	    return true;
	}

}
