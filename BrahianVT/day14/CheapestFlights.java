
import java.util.*;

/**
  There are "n" cities connected by  "m" flights. Each flight starts from city u and arrives at v with price w.
  Now given all the cities and flights, together with startting city "src" and destination "dst"
  You should  find the cheapest price from src to dst with up to K stops, If does not exist the route return -1;
  
  Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation: 
The graph looks like this:

        0 
       ' '
     100  '
	 '     500
	'        '
  1 ---100 -- 2
  
  The cheapest price from city 0 to city 2 with at
  most 1 stop costs 200, as marked red in the picture.
  
  Example 2:
	Input: 
	n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
	src = 0, dst = 2, k = 0
	
	Output: 500
	
	Solution:
	Here wu use two classes to represent the Pair which represent the city and the cost 
	of the graph.
	Class City to store the city with the distFromSrc and cost from the src to that city.
   
    Use a heap to store the path, and for every step :
	Check id the current top element in heap is the city dst. If so return its costFromStc;
	Push every adjacent edge into the heap if the distance is less than k.
	If it is larger than k, no more neighbor get pushed into the heap.
	If until the end, return -1.
   	
    
 @author Brahian VT
*/
class Pair{
	int city, cost;
	Pair(int city, int cost){
		this.city = city;
		this.cost = cost;
	}
}

class City{
	int city, distFromSrc, costFromStc;
	City(int city, int distFromSrc, int costFromStc){
		this.city = city;
		this.distFromSrc = distFromSrc;
		this.costFromStc = costFromStc;
	}
}


public class CheapestFlights{
		
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
		//DFS
		
		if(n <= 0 || flights == null || flights.length == 0 || k < 0) return -1;
		
		List<List<Pair>> graph = new ArrayList<>();
		this.buildGraph(graph, n, flights);
		
		// custom comparator To store the city in ascending order based on the costFromStc
		Queue<City> pQueue = new PriorityQueue<>((City c1, City c2) -> c1.costFromStc - c2.costFromStc);
		pQueue.offer(new City(src, 0, 0));
		
		int totalCost = 0;
		
		while(!pQueue.isEmpty()){
			City top = pQueue.poll();
			
			// get the city from the queue and if it is the dst return it
			if(top.city == dst){ return top.costFromStc; }
			if(top.distFromSrc > k){
				continue;
			}
			
			List<Pair> neighbors = graph.get(top.city);
			
			for(Pair neighbor: neighbors){
				pQueue.offer(new City(neighbor.city, top.distFromSrc + 1, top.costFromStc + neighbor.cost));
			}
		}
		
		return -1;
	}
	
	// store the graph in a list of lists
	
	/*
	  with flights: [0,1,100],[1,2,100],[0,2,500]
	  will return graph  [P{1,100}-P{2,500} , P{2,100}] 
	*/
	private void buildGraph(List<List<Pair>> graph, int n, int[][] flights){
		for(int i = 0; i < n; i++){
			graph.add(new ArrayList<>());
		}
		
		for(int[] flight: flights){
			graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
		}
	}
	
}