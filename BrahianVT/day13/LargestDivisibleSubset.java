
/**
  Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
  Si % Sj = 0 or Sj % Si = 0.

   If there are multiple solutions, return any subset is fine.

   Example 1:

   Input: [1,2,3]
   Output: [1,2] (of course, [1,3] will also be ok)
   
   Example 2:
   Input: [1,2,4,8]
   Output: [1,2,4,8]

    Solution:
	
	We know that if a > b so a % b will be always different from zero.
		
	So first sort the elements to make sure than n% n-1 can be equals to zero
	a = [1,2,4,10,8]
	Create a array so store how many elements match the condition
	In the begin just store with ones

	counts = [1,1,1,1,1]
	
	calculate the counts for every element in "a" processing all  previous elements that match the conditions in the array a
	The equation is the next counts[i] = max(count[i], counts[i-1] + 1) 
	example:	
	a = [1,2,4,10,8]
	counts = [1,1,1,1,1]
	i = 1, j = 0;
	2%1 == 0
	counts[1] = max(1, 2); counts = [1,2,1,1,1]
	i = 2, j = 1;
	4%2 == 0
	counts[2] = max(1, 3); counts = [1,2,3,1,1]
	4%1 == 0
	counts[2] = max(3, 2); counts = [1,2,3,1,1]
	
	And so on, you will end up with this
	counts = [1,2,3,3,4]
	The hightest element is the last element in the subset
	so maxIndex = 4 the element at index 4 is also 4 that means there are 4 elements that match  the condition
	
	Just to get all the elements iterate from that element to the start:
	use two variables:
	temp = a[maxIndex];   a[4] = 8
    currentCount = counts[maxIndex]; counts[4] = 4;
	
	just test if  temp % a[i] && currentCount == counts[i]
	if the condition is true get the element at index i 
	decrease currentCount by one and asign to temp the element at index i
	and you will end up with all the elements.
	
  @author Brahian VT
**/
import java.util.*;
public class LargestDivisibleSubset{

	public List<Integer> largestDivisibleSubset(int[] nums) {
		int s = nums.length;
		// sort the elements
		Arrays.sort(nums);
		
		// count all the values divisibles by previous numbers
		int[] counts  = new int[s];
		Arrays.fill(counts, 1);
		// find all the counts and the elements with more counts and its index
		int maxIndex = 0, maxCount = 0;
		for(int i = 1; i < s; i++){
			for(int j = i -1; j >= 0; j--){
				if(nums[i]% nums[j] == 0){
					counts[i] = Math.max(counts[i], counts[j] + 1);
					if(counts[i] > maxCount){ 
					maxIndex = i; maxCount = counts[i];
					}
				}
			}
		}
		
		// Find all the elements to the subset
		List<Integer> res = new ArrayList<>();
		int temp = nums[maxIndex];
		int currentCount = counts[maxIndex];
		
		for(int i = maxIndex; i>= 0; i--){
			if(temp % nums[i] == 0 && currentCount == counts[i]){
				res.add(nums[i]);
				temp = nums[i];
				currentCount--;
			}
		}
		
		return res;
	}
	
}