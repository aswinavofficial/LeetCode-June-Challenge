
/**


  You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. 
  You may assume that you have infinite number of each kind of coin.

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

 @author Brahian VT
 
*/

public class CoinChange2{
	
		// using DD
		
		// Complexity O( n * amount) ,n = number od coins
	    public int change(int amount, int[] coins) {
			
			int res[][] = new int [coins.length + 1][amount + 1];
			
			for(int i = 1; i < res.length; i++){
				res[i][0] = 1;
				
				for(in j = 0; j < res[i].length; j++){
					res[i][j] = res[i-1][j];
					if( j - coins[i -1] >= 0)
						res[i][j] += res[i][j - coins[i - 1]];
				}
			}
			
			return res[coins.length][amount];
		}
	
	
	// Using Recursion Too slow basically calculate all posible combinations
	// here we can use a map or matrix to store all values and avoid to recalculate previous values.
	
	public int change2(int[] coins, int index, int amount){
		if(amount == 0) return 1;
		if(amount < 0 || index == coins.length) return 0;
		
		return change2(coins, index, amount - coins[index]); + change2(coins, index+1, amount);
	}
}