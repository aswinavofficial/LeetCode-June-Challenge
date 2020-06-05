import java.util.*;
/**
  There are "2N" possible new employees a company is planning to interview. The cost of flying the
   i-th person to a city "A" is conts[i][0], and the cost of flying the i-th person to
   city B is consts[i][1].

   Return the minimum cost to fly every person to a city such that exactly N people arrive in each city
	
	
	Input: [[10,20],[30,200],[400,50],[30,20]]
    Output: 110
    Explanation: 
    The first person goes to city A for a cost of 10.
    The second person goes to city A for a cost of 30.
    The third person goes to city B for a cost of 50.
     The fourth person goes to city B for a cost of 20.
     The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.

  @author Brahian VT
*/


class CityScheduling {
	
	// First Aproach
	// Use a TreeSet to store the difference in money between travel to city A or City B to every Person
	// TreeSet is the implementation of a red-black Tree  basically a self-balance binary tree.
	
	
	public int twoCitySchedCost(int[][] costs){
		// order on base in the absolute value
		TreeSet<String> info = new TreeSet<String>(new Comparator<String>(){
			
			public int compare(String o1, String o2){
				int absDelta1 = Integer.parseInt(o1.split(",")[1]);
				int absDelta2 = Integer.parseInt(o2.split(",")[1]);
			
				int comp = Math.abs(absDelta2) - Math.abs(absDelta1);
				if(comp != 0) return comp;
				else return absDelta1;
			}
		});
	
		for(int i = 0; i < costs.length; i++){
			// we want to store 0a,200,500,300
			String aOrB = "a";
			if(costs[i][0] <= costs[i][1]) aOrB = i + aOrB;
			int diff = costs[i][0] - costs[i][1];
			info.add(aOrB +","+ diff +","+ costs[i][0] +","+ costs[i][1]);
		}
		
		// iterate the TreeSet that is sorted on the diff  absolute value
		java.util.Iterator<String> iter = info.iterator();
		
		int cityA = 0, cityB = 0, total = 0;
		
		while(iter.hasNext()){
			String aux[] = iter.next().split(",");
			// if the element is from "a" add the value for city A, if still there is a space 
			 if(aux[0].contains("a")){
				 if(cityA * 2 < costs.length){
					 total+= Integer.parseInt(aux[2]); cityA++;
				 } else {
					 total+= Integer.parseInt(aux[3]); cityB++;
				 }
			 } else {
				 if(cityB *2 < costs.length){
					 total+= Integer.parseInt(aux[3]); cityB++;
				 } else {
					 total+= Integer.parseInt(aux[2]); cityA++; 
				 }
			 }
		}
		
		return total;
	}
	
	// Second approach
	public int twoCitySchedCost2(int[][] costs){
		/*
		 Here first sort the list on base of the difference to travel for cityA or cityB
		 (cityA - cityB) here basically the negatives results means that is best for that person 
		  travel to cityA otherwise it will be .better travel to cityA.
		  So the people with the greatest negative value will be send to city b
		*/	
		Arrays.sort(costs, (p1, p2) -> (p1[0] - p1[1]) -(p1[0] - p2[1]));
	
		/* Once sorted just sum up all the value to travel to cityB to the first half 
		   and the second half will be for the cityB */
		 int tol = 0;  
		 for(int i = 0; i < costs.length/2; i++){
			 tol+=costs[i][1];
			 tol+=costs[i + costs.length/2][0];
		 }
		 
		 return tol;
	}
	
}