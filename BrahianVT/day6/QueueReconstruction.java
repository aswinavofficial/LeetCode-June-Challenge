
/**
  Queue Reconstruction by Height
  
  Suppose you have a random list , Each element represent a person that has a pair
  of Integers (h,k), where h is the height of the person and k is the number
  of people in front of this person who have a height greater than or equal to h.
  
  Write a function to reconstruct the array
  
  Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
  
  We can see at the start of the array are the elements with less people in front of them
  So remember satisfies the property about k for example:
  this two would be right:
  
  [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]] = [[5,0], [7,0], [6,1], [5,2], [4,4], [7,1]]
  
  However, what we want is the first because there are more success cases for example [5,2] in the 
  second list has k = 2, with this we know there are 2 or more and is fine.
  but in the first is more accurate.
  
  Another Example
  5,0], [7,0], [9,0], [5,2] will become ->   5,0], [7,0], [5,2], [9,0]
  
  Assumptions: the input always will be a valid list able to reconstruct
 So,you never will get as input array like this :

  [7,0], [4,4], [7,5] in the last element is invalid because k is 5 but just are 3 elements in the list.
  --------------------------------

	Solutions
	
   [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]	
   
   First need to sort the list by height in a descending way and k in ascending way
	The array sorted will be :
   
   [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]	
	
	After that insert the element on a queue or list in base of the k value.
	
	Insert the first one at index 0 so the new  list will have;
	[7,0]
	[7,0],[7,1]
	[7,0],[6,1],[7,1]
	[5,0],[7,0],[6,1],[7,1]
	[5,0],[7,0],[5,2],[6,1],[7,1]
	[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]  -> after insert the last element you will get the result
	
  @author Brahian VT
*/
 import java.util.Arrays;
 import java.util.List;
 import java.util.ArrayList;
public class QueueReconstruction{
	
	// time complexity O(n2)
	public int[][] reconstructQueue(int[][] people) {
	   // first sort the array 
	   
	   Arrays.sort(people, (p1, p2) -> {
		   int comp = p2[0] - p1[0];
		   return (comp == 0)? p1[1] - p2[1]: comp;
	   });
	   
	   // create thr final list
		List<int[]> res = new ArrayList<>();
		
		for(int person[]: people){
			res.add(person[1], person);
		}
		
		return res.toArray(new int[res.size()][]);
	}
	
}