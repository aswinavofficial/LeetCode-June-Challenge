
/**
  Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

	Solution
	
	the way of resulve that is applying the nth Catalan number so 
	in order to calculate all ways to generate unique structures od bst's, we need calculate all the previous element is that catalan number
	
	With Input: 3 we have 3 nodes 1,2,3
	so for example with the first node as root we will have:
		1 
	   / \      With 1 we already know that there is not lower element so just you can have 2 posibilities in the right.     
      0  23 
					so the result will be calculated with C0 * C2  where C is the number of elements in each branch.
	    2
	   / \      With 2 we already know that there is one  element lower and one highter, so just have 1 posibilities in the right.    
      1  3 		so the result will be calculated with C1 * C1  where C is the number of elements in each branch.
	  
	    3
	   / \      With 3 we already know that there is not  element highter  so just have 2 posibilities in the left.    
      12  0 	so the result will be calculated with C2 * C1  where C is the number of elements in each branch.
	  
	  
	  the result will be the addition of all the results:  C0 * C2   +  C1 * C1 + C2 * C1
	  
	  so we need the third catalan number
	  
	  the catalan numbers are : 1,1,5,14,42  we will count from  zero  so wuth n = 5 the result will be 42
	  
	  so we need an array to calculate all the catalan numbers.
	  
	  res = [0,0,0,0] n = 3
	  and with i from 1 to n
	  
	  res += * res[n -i] * res[i - 1] 
 @author Brahian VT
*/

public class UniqueBinaryTrees{
	 public int numTrees(int n) {
		 
		 int [] res = new int[n +1];
			
		//initialize the first two elements 
		res[0] = res[1] = 1;
		
		for(int level = 2; level <= n; level++){
			for(int root = 1; root<= level; root++){
				res[level]+= res[level - root] * res[root -1];
			}
		}
				
		return res[n];
	 }
}