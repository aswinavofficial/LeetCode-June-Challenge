
/**
	
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99

  
  
  Solution 
  having the input = [2, 2, 3, 2]
      
  The best way of do it is using bitwise operations
  
  So let's visualize the inour in binary elements
	
   We can see just one sequence is different so that the element we need to find:
    
	ones = 0  //varible to store elements appears just one time
	twos = 0  //varible to store elements appears two times
  
  10
  10
  11
  10
    
	So iterate the array and caculate ones:
	i = 0     xor operation
	ones = a[i] ^ twos 
   ^00 
	10
	---
	10
	now complement and & operation with two.
	10
   ~11
   ----
    10 -> ones
	
	calculate the twos
	twos = a[i] ^ ones
   ^00
    10
   ----
    10
	
	now complement and & operation with ones.
	10
   ~01
   ----
    00 -> twos
	
	after first iteration ones = 2, twos = 0 and that's correct because
	2 is the first element and just is one element so far.
	i = [1]
	ones = 10 ^ 10 = 00 & ^11 = 00 = 0
	twos = 00 ^ 10 = 10 & ^11 = 10 = 2
	
	i = [2]
	ones = 00 ^ 10 = 10 & ^01 = 00 = 0
	twos = 10 ^ 10 = 00 & ^11 = 00 = 0
	
	i = [3]
	ones = 00 ^ 11 = 11 & ^11 = 11 = 3
	twos = 00 ^ 11 = 11 & ^00 = 00 = 0
	
	return the variable one and thats all.
  @author Brahian VT
*/

public class SingleNumberII{
	
	public int singleNumber(int[] nums) {
		int ones = 0, twos = 0;
		
		for(int i = 0; i < nums.length; i++){
			ones = (ones ^ nums[i]) & ~twos;
			twos = (twos ^ nums[i]) & ~ones; 
		}
		
		return ones;
	}
}