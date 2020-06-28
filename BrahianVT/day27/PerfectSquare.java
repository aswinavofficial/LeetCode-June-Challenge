
/**

	Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
	
	Example 1:

	Input: n = 12
	Output: 3 
	Explanation: 12 = 4 + 4 + 4.
	Example 2:

	Input: n = 13
	Output: 2
	Explanation: 13 = 4 + 9.

	Solution there is a theorem called Lagrange's four-square
		
	It says that having a natural number N
	is can be reresented as : N = a^2 + b^2 + c^2 + d^2
	
	These numbers between a-d can be the same numbers
	So the result will be between 1-4 
	
	is 1 when: the number N is itself a perfert square
	is 4 when : N = 4^a(8b + 7)
	fot the case 2: having the number N if you divide it by 2 will have let's say a = N - i;  b = N - (N-i)
	if  both numbers a and b are perfect squares 2 is the answers
	the last case just return 3
	
	Example n = 12
	
	First if the bumber is pow of two 
	with this : if(Math.ceil(Math.sqrt(12)) == Math.floor(Math.sqrt(12)))
		        if(Math.ceil(3.46) == Math.floor(3.46)) = 3 != 4
			
	So discard 2 now check is 		
	n = 4^a(8b + 7)
	so first  remove the 4^a term , check it the number n is dividible by 4 and reduce it till the smallest number divisible by 4 
	 while n%4 == 0 -> n/=4  
	  12 % 4 == 0 , n = 12/4 = 3
	  3 % 4 == 1 
	  
	Now check if n%8 == 7, if it ia true return 4
	n = 3 , 3%8 = 3 != 7 ao go to the next step

	although the number was 12 at the beginning,  we can use the new number 3 al will be the same
	
	So tried to find if two numbers sum up to n are pow of 2
	
	here we will use a looop incrementing a variable i by i*i because need square numbers
	 i = 1;
	 base =(int) Math.sqrt(n-i*i) and if base * base == (n-i*i) return 2
	 base = Math.sqrt(3 - 1) = 1.4 = 1  and 1 * 1 == 3-1
	 with i = 2 due to i * i > 3 break the loop.
	 
	 And finally just return the last option 3
	
	  
	@author Brahian VT
*/


public class PerfectSquare {
	
	 public int numSquares(int n) {
		 
		if(Math.floor(Math.sqrt(n)) == Math.ceil(Math.sqrt(n)))  return 1;
		
		//remove the 4^a term 
		while(n%4 == 9) n/=4;
		
		if(n%8 == 7) return 4;
		
		for(int i = 1; i<= n; i++){
			
			int num1 =(int) Math.sqrt(n-i*i);
			if(num1 * num1 == n-i*i) return 3;
		}
		
		return 2;
	 }
}