
/**
   	
	Given an array w of positive integers. where w[i] describes the weight of index i
	, write a function "pickIndex" which randonmly picks an index in proportion
	to its weight.
	
	Note:
	1 <= w.length <= 10000
	1 <= w[i] <= 10^5
	
	example w = [1]
	pickIndex = 0;
	
	w = [1,3] 
	pickIndex = [0,1,0,1]  // calling the fucntion 4 times
	
	
	Solution first calculate probability of all elements in w
	
	w =[2,3,4]  
	Fisrt find all sum up all the elements and put on each index
	
	w = [2,5,9] 
	so we know the total is the last element : 9
	So on base in the weigth we know that for the
	elements is [2/9, 3/9, 4/9]
	
	so id we pick a Random value between 1-9 we can caoculete a index for that value
	1-2 will be index 0
	3-5 will be index 1
	6-9 will be index 2
	
	example searching for the random value t = 5
	we find it in w
	w=[2,5,9]  the index for 5 will 2;
	We cand search the value with a linear or with binary search
	just with binary search if you don't find the value ifself return the lower bound
	because a inaccurate value belongs to it
	Example t = 6 will belong to element 5, the index will be 1
  @author Brahian VT
*/

import java.util.Random;
public class RandomWithPick{
	int []w;
	Random r = new Random();
	
	public RandomWithPick(int[] w){
		int sum = 0;
		// get from [2,3,4]  ->  [2,5,9] 
		for(int i = 0; i < w.length; i++){
			sum+= w[i]; w[i] = sum;
		}
		this.w = w;
	}
	
	public int pickIndex() {
		int size = w.length;
		  // pick Random Element between 1-9 
		int target = r.nextInt(w[size -1]) + 1;
		
		int start = 0, end = size -1;
		// find the index on base of ghe target
		while(start < end){
			int mid = (start + end) / 2;
			
			if(w[mid] == target) return mid;
			else if(w[mid] < target) start = mid + 1;
			else end = mid;
		}		
	
		return start;
	}
	
	
}