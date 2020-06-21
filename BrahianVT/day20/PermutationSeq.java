

/**

The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314" 
 Solution 
  With n = 3, k = 3
  
  123
  132
  ----
  213
  231
  ----
  312
  321
  
  Here we can divide based on : the most significant bit
  here we have 3 groups:
  
  The way to get the first element is first subtract one from k because start from index zero k = 2
  so get the first element k/(n-1)! = 2/2! = 1
  get the element at index 1 fronm the list[1,2,3] and the first is  res = [2] and delete from the original list [1,3]
  
  with 2 we know the element we want is in the second group so the next will be in the second group
  213
  231
  
  to get the next element we need to update k = k % (n-1)! 
  k = 2%2 = 0
  
  Second element k/(n-1)! = 0/1 = 0  at index zero from [1,3] is 1 so res = [2,1] an original is [1]
  update k = 0%1 = 0 
  get the last element k/(n-1)!= 0/1 = 0  get the last element at index 0 and r=[2,1,3]
 
   @author Brahian VT 
**/
import java.util.*;
import java.util.stream.*;
public class PermutationSeq{

	public String getPermutation(int n, int k) {
		List<Integer> numbers = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
		
		int[] factorials = new int[numbers.size()];
		
		// need the previous factorial for each element in numbers
		factorials[0] = 1;
		for(int i = 1; i < factorials.length; i++){
			factorials[i] = i * factorials[i];
		}
		k--;
		StringBuilder res = new StringBuilder();
		
		for(int i = factorials.length -1; i >= 0 ; i++){
			int index = k / factorials[i];
			res.append(numbers.get(index));
			numbers.remove(index);
			k = k % factorials[i];
		}
		
		return res.toString();
	}
}