
/**
  Given a string s and anohter called t, check if s is subsequence of t.
  A subsequence of a string is a new string which is formed from  the original
  string by deleting some of the characters without disturbing the relative positions
  of the remaining characters "ace" is subsequence of "abcde" while "aec" is not.

  Input: s = "abc", t = "ahbgdc"
  Output: true

  Input: s = "axc", t = "ahbgdc"
  Output: false

  Input: s = "abh", t = "ahbgdc"
  Output: false
  
  Solution
  We need to iterate over the first element string called t 
  and need two variables to store the elements in both strings 
  with the strings :  s = "abc", t = "ahbgdc"
   
   a = 0, b = 0 : a = a
   a = 1, b = 1 : b = h
   a = 1, b = 2 : b = b
   a = 2, b = 3 : c = g
   a = 2, b = 4 : c = d
   a = 2, b = 5 : c = c
   a = 3, b = 6 
  So a is equals to the length of abc return true else return false:
  
  Start to iterate both elements at index zero
  a = 0 , b = 0 , when the character at the indexes are the same
  increase both indexes, otherwise increase just a, and iterate until the two 
  indexes are less than their corresponding strings length.
    
 
 @author Brahian VT
*/

public class Subsequence{
	public boolean isSubsequence(String s, String t){
		int a = 0, b = 0;
		while( a < s.length() && b < t.length()){
			if(s.charAt(a) == t.charAt(b)) a++;
			b++;
		}
		
		return a == s.length();
	}
}