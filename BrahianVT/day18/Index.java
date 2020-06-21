

/**
	Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher,
	write a function to compute the researcher's h-index.
	According to the definition of h-index on Wikipedia: "A scientist has index h if h of his
	N papers have at least h citations each, and the other N − h papers have no more than h citations each."

   Example:
	Input: citations = [0,1,3,5,6]
	Output: 3 
	Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had 
             received 0, 1, 3, 5, 6 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each one and the remaining 
             two with no more than 3 citations each, her h-index is 3.
	
	
	Solution
	There are two ways of solve that:
	the first is iterate the whole array and check if there are the citations neeed to match the condition at every index and return the hightest value
	But cause the input array is already sorted we can use binary search to find that value.
	
	So with the input a = [0,1,3,5,6] and start = 0, end  = 5; and m = 2

		First caculate if the element at the middle match the condition just if the element a[m] is less than a.length - m;
		with that we make sure that the condition matched and after that just iterate in the second half to find if there is another
		value that match the condition because we need to return always the hightest value.
		
		Otherwise look at the first half to search for a element that match the condition 
		
		at the end you will get the result in the variable start so just return the result of a.length - start and you will get
		the final element.
		 a = [0,1,3,5,6] and start = 0, end  = 5; and m = 2   
		 a[2] < 5 -2   = 3 < 3 : start = 0 end = 2, m = 1
		 a[1] < 5 -1   = 1 < 4 : start = 2 end = 2, m = 1
		 
		 here just return (5 - 2) = 3 and that's all.
		 
		
	@author Brahian VT
*/

public class Index{
	
	
	  public int hIndex(int[] c) {
		  
		  int start = 0, end = c.length;
		  int len = end;
		  while(start < end){
			  int middle = (start + end) / 2;
			  
			  if(c[middle] < len - middle){
				  start = middle + 1;
			  }else{
				  end = middle - 1;
			  }
		  }
		  return len -1;
	  }
}