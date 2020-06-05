
/**
  Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
  @author Brahian VT
*/
public class ReverseString{
	
	public void reverseString(char[] s) {
		int start = 0, end = s.length - 1;

		for(int i = 0; i < s.length/2; i++){
			char aux = s[end];
			s[start] = s[end];
			s[start] = aux;
			start++; end--;
		}	
	}
}