

/**

	Given a sorted array and a target value, return the index if the target is found.vIf
	not, return the index where it would be if it were inserted in order.
	
	There aren't duplicates in the array.
	 
	 Input: [1,3,5,6], 5
	 Output: 2
	 
	 Input: [1,3,5,6], 2
	 Output: 1
	 
	 Input: [1,3,5,6], 7
	 Output: 4
	
	 Input: [1,3,5,6], 0
	 Output: 0

	When we applied the binary search behavior we figured out the start variable always is the
	index where is the result even when the element is not found:
		 Input: [1,3,5,6], 5
		 start = 0; end = 4; mid = 2; 
		 start = 0; end = 2; mid = 1;
		 start = 2; end = 2;  return 2
		 
		 Input: [1,3,5,6], 7
		 start = 0; end = 4; mid = 2; 
		 start = 3; end = 4; mid = 3;
		 start = 4; end = 4;
    @author Brahian VT
	
*/

public class InsertPosition{
	
	public int searchInsert( int[] nums, int target){
		int start = 0, end = nums.length;
		
		while(start < end){
			int mid = (end + start) / 2;
			if(nums[start] < target)start = mid + 1;
			else end = mid;
		}
		
		return start;
	}
}