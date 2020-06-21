
/**

 
Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)

Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)
Example 1:
Input: "banana"
Output: "ana"

Example 2:
Input: "abcd"
Output: ""

Solution

s = banana
n = 6
Create the element with the hash. We need to create a array with each hash per element
to compute the Rolling Hash tha function f(s) = 26^0 + 26^1 ... + 26^n-1;
i the input String and i is the length.

hashValues has the same length of the input string.

The first element is 26^0 = 1

26 because there are 26 letters
tha hash is calculate with this 26^0 = 1
at index = 0 = 1

for the rest just compute with this equation:
hashValues[i]  = hashValues[i -1] * 26 % mod prime

hashValues[0] = 1
hashValues[1]  = (1 * 26) % 10000001 = 26
hashValues[2]  = (26 * 26) % 10000001 = 676
hashValues[3]  = (676 * 26) % 10000001 = 17576
hashValues[4]  = (17576 * 26) % 10000001 = 456976
hashValues[5]  = (456976 * 26) % 10000001 = 1881375

so we end up with:
hashValues = [26, 676, 17576, 456976, 1881375]

So we just need to search with binary search, the element with 
the longest subString, we will use this technique to
get the len of subString to search for duplicates
example

start = 0, end = 6 mid = 3;

So search for duplicates with all substring in the array with length 3
If we find a element just increase the len to check if there is another element
with a longer value oterwise find another with a smaller value.

The way of finding all this subString is with an algorithm called 
Rabin Karp algorithm
Example
s = banana, mid = 3

Here we will find the hash elements and the indexes we will fing in an hashTablr:
So first calculate the hash for the first "mid caracteres"
a = 97, b = 98 ...

subString = ban; int curr;
curr = (curr * 26 + s.charAt(i) - 97)) % prime
b: curr = ((0 * 26) + (98 - 97)) % 10000001 = 1
a: curr = ((1 * 26) + (97 - 97)) % 10000001 = 26
n: curr = ((26 * 26) + (110 - 97)) % 10000001 = 689

So curr = 676 that is the hash for "ban"
store it in the hashMap map = (689:{0})

Calculate the hash for the next subString
Start to find at index mid = 3 until reach to the end of the string.

First calculate the hash with Rolling Hash:
to achieve that need to substrat the hash of the first element and add the hash
of the next element:

curr = ((curr - hashValues[mid -1] * (s.charAt(i - mid) - 97)) % prime + prime) % prime; 
curr = (curr * 26 + ( s.charAt(i) - 97)) %prime;


curr = ((689 - 676 * (97 - 97)) % 10000001 + 10000001) % 10000001 = 13
curr = (13 * 26 + ( 97 - 97)) %10000001 = 338 

this hash curr is for the substring "ana" 
So look up at the hashMap 
i = 3  curr= 338  map = (689,{0})
is not present in the hashMap so add it:
map = (689:{0}, 338:{1})

calculete the hash for the next substring "nan"   i = 4

curr = ((338 - 676 * (97 - 97)) % 10000001 + 10000001) % 10000001 = 338
curr = (338 * 26 + ( 110 - 97)) %10000001 = 8801


8801 is not present in the map so add it : map = (689:{0}, 338:{1}, 8801:{2})
 
calculete the hash for the next substring "ana"   i = 5

curr = ((338 - 676 * (110 - 97)) % 10000001 + 10000001) % 10000001 = 13
curr = (13 * 26 + ( 97 - 97)) %10000001 = 338

Search for the hash curr: 338

so found it 338:{1} with that store e = 1 e is a list in this case of length one.
now can compere the substring to see if there are equals:

s.substring(i - mid + 1, (i - mid + 1) + mid) and  s.substring(e, mid + e);
s.substring(3,6) = "ana" and s.substring(0, 3) = "ana";

So match return it

this is the result found for len 3 now try to find for length longest that 3:

start = 4, end = 6 mid = 5; find with length of 5 but there no string
so return "ana" as the result  



@author Brahian VT
*/
import java.util.*;

public class LongestDuplicateSubStr{
	// mandatoty prime numner
	int prime = 10000001;
	
	int[]values ;
	
	public String longestDupSubstring(String s){
		int n = s.length(); int start = 0, end = n;
		
		values = new int[n];
		values[0] = 1;
		
		for(int i = 1; i < n; i++){
		values[i] = ( values[i-1]*26 ) % prime;
		}
		
		// binary search	
		String res = "";
		while(start < end){
			int mid = (start + end) / 2;
			
			String aux = rabinKarp(s, mid);
			
			if(aux.length() > res.length()){
				res = aux;  start = mid + 1;
			}else{ end = start; }
		}
		
		return res;
	}
	
	private String rabinKarp(String s, int mid){
		
		int n = s.length(); int curr = 0;
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for(int i = 0; i < mid; i++){
			curr =( curr * 26 + (s.charAt(i) - 97))% prime;
		}
		
		map.put(curr, new ArrayList<Integer>(Arrays.asList(0)));
		
		for(int i = mid; i < n; i++){
			char charInt = s.charAt(i - mid);
			curr = ((curr - values[mid -1] * (charInt -97 )) % prime + prime) % prime;
			curr = (curr * 26 + (s.charAt(i) - 97)) % prime;
			
			if(map.get(curr) != null){
				for(Integer index: map.get(curr)){
					String aux = s.substring(i- mid + 1 , (i - mid + 1) + mid);
					if(aux.equals(s.substring(index, mid + index))){
						return s.substring(index, mid + index);
					}
				}
			}else{
				map.put(curr, new ArrayList<>());
			}
			
			map.get(curr).add(i - mid + 1);
		}
			
		return "";
	}
}