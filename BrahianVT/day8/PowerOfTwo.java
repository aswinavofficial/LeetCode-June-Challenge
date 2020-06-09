
/**
	Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false

	Solution: Here use bitwise operators
	just check if the value is positive to apply it
	
	having as input 5: 
	101    and (5-1) = 4
	 11
    -----
     001    apply the and operator
	 if the result is one is not  power of two. 
  @author Brahian VT
*/

class PowerOfTwo{
	
	public boolean isPowerOfTwo(int v){
		return ( v <= 0)?false:(v & (v-1) == 0);
	}
	
	// Another approach can be
	/*int i = 1; 
		while(i< v){ i*=2; }
		return i == v;
		
	*/
}