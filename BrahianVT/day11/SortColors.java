

/**
  SortColors
  Given an array with n objects colored red, white or blue, sort them in-place so 
  that objects of the same color are adjacent, with the colors in the order red, white and blue  
  Here, we will use the integers 0,1,2 to represent the color red, white and blue respectively
  
  Note: You are not suppose to use the library's sort funcion for this problem

  Example
  Input: [2,0,2,1,1,0]
  Output: [0,0,1,1,2,2]
  
  Solution
  The straightforward solution is implement a sort method so  the time complexity will be
   O(n log n)
   
   But it can be better because in or specific case we already know all the posibles values
   so we can resolve this linearly.
   
   We need three variable to store the elements at the start,midle and the end of the array.
   and just compare three cases:
    1 if the element at middle is 0 swap between start- middle and increment the indexes
	2 if the element at middle is 1 just increment the corresponding index
	3 if the element at middle is 2 swap between middle- end and increment the index at the middle and reduce the index at the end.
   
   Here need to iterate always that m <= e.
   
   a = [2,0,2,1,1,0]  
   
   s = 0, m = 0, e = 5  store the indexes for start, middle and end.
   m[0] = 2 , [0,0,2,1,1,2] ,e = 4
   m[0] = 0 , [0,0,2,1,1,2] , s = 1 , m = 1
   m[1] = 0 , [0,0,1,1,2,2] , s = 2 , m = 2
   m[2] = 1 , [0,0,1,1,2,2] , m = 3
   m[3] = 1 , [0,0,1,1,2,2] , m = 4   
   m[4] = 2 , [0,0,1,1,2,2] ,e = 3
   
   @author Brahian VT
	
*/
public class SortColors{
	
	public void sortColors(int[] nums){
		int start, mid, end = nums.length -1;
		
		int aux = 0;
		while(mid <= end){
			if(nums[mid] < 1){
				aux = nums[0];
				nums[0] = nums[mid];
				nums[mid] = aux;
				start ++; mid++;
			} else if(nums[mid] == 1){
				mid++;
			} else{
				aux = nums[mid];
				nums[mid] = nums[end];
				nums[end] = aux;
				end --;
			}
		}
	}
	
}