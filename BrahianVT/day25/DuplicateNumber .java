
/**

	Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. 
	Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3

	
	
	There is only one duplicate number in the array, but it could be repeated more than once.
 
 	So for example if the array  a = [1,3,4,2,2] just can contain the elements between 1: 4 because here n + 1  = 5 so n = 4
	
	Solution:
	 Floyd's Tortoise and Hare (Cycle Detection) algorithem
	 
	 Here the idea is use this approach where try to find where init a cycle in a linked kist but here 
	 using the array list
	 
	 Because here all the elements in  1 <= a[i] <= n in this case n = 4 all the elements a the ith index will have a element 
	 example 
	 a[0] = 1  here use the result as new index
	 a[1] = 3
	 a[3] = 2
	 a[2] = 4
	 a[4] = 2
	 
	 here is the cycle a[3] = 2 and a[4] = 2
	  a = [1,3,4,2,2] 
	  
	 Here to find the elements we nedd two pointers slow = a[0] and fast = a[0]
	 
	 Here start in the first element to compare values
	 slow = 1 ans fast = 1
	  
	  After that here need to start compare
	  slow = a[slow]  fast = a [a[fast]]
	  slow = a[1] fast = a[a[1]]
	  slow = 3 fast = a[3] = 2
	 
	  Here just need to find the intersection when slow and fast are the same:
		
	  a[3] = 2  fast = a[a[2]] = a[4] = 2
	  a[2] = 4  fast = a[a[2]] = a[4] = 2
	  
	  a[4] = 2  fast = a[a[2]] = a[4] = 2
	  
	  Here both are equals
		
	  Now we need to just iterate in a slow way for both but just reseting to fast
	
	 slow[4] = 2;
	 fast = nums[0] = 1
	 
	 slow = nums[slow]   fast = nums[fast]
	 
	 slow = nums[2] = 4  fast = nums[1] = 3
	 slow = nums[4] = 2  fast = nums[3] = 2
	 
	  Here both are the same just return either slow or fast
	 
	
	 
	 
 @author Brahian VT 
*/

public class DuplicateNumber{
	
	public int findDuplicate(int[] nums){
		
		int slow = nums[0], fast = [0];
		
		for(int i = 0; i < nums.length; i++){
			slow = nums[slow];
			fast = nums[nums[fast]];
			
			if(slow == fast){
				// reset fast 
				  while( slow != fast){
					  slow = nums[slow];
					  fast = fast[fast];
				  }
				  return slow;
			}
		}
	}
} 