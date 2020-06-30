
/**
  Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
One must use all the tickets once and only once.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
			 
			 
	Solution
	
	The problem us related to graphs so first we need the adjacent list
	In this case we will use a hash map using has key the first airport and as
	value all the airports linked to it , we will use a min priorityqueue to 
	Store the values because it must be sorted
	Here 
	l = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
	    Map<String, PriorityQueue<String>> targets = new HashMap<>();
	targets: 	
	key  | value
    MUC  -> [LHR]
    JFK  -> [MUC]
	SFO  -> [SJC]
	LHR  -> [SFO]	
	
	So once we have the adjacent list: we need to use the Eulerian Path to find the result.
	
	Fisrt keep going forward until you get stuck. the remainig tickets form cycles which
	are found on the way back and get merged into that main path.
	
	By writing down the path backwards when retreating  from recursion, merging the cycles
	into the main path is easy because the end part of the path has already been written.
	
	Example with this adjecent list:
	targets: 	
	key  | value
    MUC  -> [LHR]
    JFK  -> [MUC]
	SFO  -> [SJC]
	LHR  -> [SFO]	
	
	go with recursion to the function travel with the first airport of the problem "JFK"
	So we will look first in that key and we will find the path backwards.

	airport = JFK	
	 look at the hashMap for the key "JFK" it it contains the key 
	 go through recursion taking as key the first value and delete it from the map
	
	airport = JFK	go recursion
	
	airport = MUC	go recursion
	key  | value
    MUC  -> [LHR]
    JFK  -> null
	SFO  -> [SJC]
	LHR  -> [SFO]	
	
	airport = LHR	go recursion
	key  | value
    MUC  -> null
    JFK  -> null
	SFO  -> [SJC]
	LHR  -> [SFO]	
	
	airport = SFO	go recursion
	key  | value
    MUC  -> null
    JFK  -> null
	SFO  -> [SJC]
	LHR  -> null
	
	airport = SJC	go recursion
	key  | value
    MUC  -> null
    JFK  -> null
	SFO  -> null
	LHR  -> null
	
	here when we don't find the key just store the airport you can see the solution is backwards
	res = [SJC]	
	res = [SFO, SJC]
	res = [LHR, SFO, SJC]	
	res = [MUC, LHR, SFO, SJC]
	res = [JMK, MUC, LHR, SFO, SJC]
  @author Brahian VT
*/
public class ReconstructItinerary{
	
}