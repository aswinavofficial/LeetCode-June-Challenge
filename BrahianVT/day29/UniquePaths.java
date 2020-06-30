

/**

	A robot is located at the top-left corner, of a "m x n" grid (marked with a S )
	
	The robot can only move either down or right at any point time. The robot is trying to
	reach the bottom-right corner of the grid ( market with  a F ).
	
	How many possible unique paths are there?
	
	Example 1:

	Input: m = 3, n = 2
	Output: 3
	Explanation:
	From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
	1. Right -> Right -> Down
	2. Right -> Down -> Right
	3. Down -> Right -> Right
	
	
	Example 2:
	Input: m = 7, n = 3
	Output: 28
	
	
	Solution if can be resolve using recursion but the performace will be slow.
	So we will use Dynamic Programming 
	
	Solution 
	For exmaple having this example
	input m = 2, n = 2
	R 1
	1 S       Result = (0,1) + (1,0) = 2
	
	So here we now that just when the col is 0 the value is one because we already know that
	there is just possible path the same for the row 0.
	
	And when for  exmaple we reaach at position (1,1) there are two posibilities when we come from
	the above row and from the previous column. so in this position we will have two possibles path.
	
	And that's all just keep doing this until reaach the last element and return it.
	
	input m = 3, n = 3
	R 1 1
	1  		Here is the start we know the first row and column is 1 because just there is a single path
	1   R   for the rest just result[i][j] = result[i-1][j] + result[i][j -1] 
			result[1][1] = result[0][1] + result[1][0]

	Fill  all the matrix:
	R 1 1
	1 2 3		
	1 3 6  So the result is 6
	@author Brahian VT
**/

public class UniquePaths{
	
	public int uniquePaths(int m, int n){
		
		int[][] result = new int[n][m];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(i > 0 && j > 0)
					result[i][j] = result[i-1][j] + result[i][j-1];
				else
					result[i][j] = 1;
			}
		}
		
		return result[n-1][m-1];
	}
}