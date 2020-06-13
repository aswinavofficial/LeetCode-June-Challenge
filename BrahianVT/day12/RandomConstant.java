
/**
	Design a data structure that supports all following operations 
	in amortized time O(1)

	You should implements the next three operations
	1 Insert(val): Inserts an item val to the data structure if not already present
	2 Remove(val): Removes an item 
	3 getRandom: Return a random element from the data structure
	
	Note: Duplicates values are not allowed
	
	Condiderations :
	Due to need constime time n average for insert, delete and  random that is like
	a get or search, we can consider the next data structures
	
	Hash / HashMap:  insert: O(1) delete:O(1) get:O(n)
	Array/ list indexables: insert at the end:O(1) delete at the end: O(1): get:O(1)
	
	So basically here we need to use a combinations of both to resolve the problem
	
	Here we will store the elements in a hashMap and in arrayList
	with the hashMap resolve insert and delete operations,
	and with arraylist resolve getRandom.
	So in the hashMap store the value and the index for the arrayList
	and every time you need to call getRandom get the index from the map and pass it
	to the array.
	@author Brahian VT
*/
import java.util.*;
public class RandomConstant{
	private Map<Integer, Integer> map;
	private List<Integer> array;
	private Random r;
	public RandomConstant(){
		r = new Random();
		map = new HashMap<>();
		array = new ArrayList<>();
	}
	
	public boolean insert(int  val){
		if(map.containsKey(val)) return false;
		// Here val is the kay and the index will be the index
		int index = (array.size() == 0)?0:array.size() -1; 
		map.put(val, index );
		array.add(val);
		return true;
	}
	
	public boolean remove(int val){
		if(map.containsKey(val)){
			int index = map.get(val);
			int lastElementIndex = array.size() -1;
			Collections.swap(array, index, lastElementIndex);
			array.remove(val);
			map.remove(val);
			return true;
		}
		return false;
	}
	
	public int getRandom(){
		return array.get(r.nextInt(array.size()));
	}
}