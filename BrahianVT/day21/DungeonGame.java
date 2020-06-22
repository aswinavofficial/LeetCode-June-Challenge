
/**

  The enemies jad captured the princess (P) and imprisoned her in the botton.right corner
  of a dungeon (g). The dungeon consist of M x N rooms.
  Our valient knight K was initially positioned in the top-left room and must fight his way through
  the dungeon to rescue the princess.
  
  The rooms with enemies has negetives values so the knight loses health and the space with
  positives values the knight earns health.
  
  The knight just can move either right or down.
  The knight can't has a health less than zero.

  Write a function to determine the minimum initial health so the knight is able to rescue 
  the princess.
  
   
  For example, given the dungeon below, the initial health of the knight 
  must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

   -2(K) -3    3  
   -5	 -10   1
    10	  30  -5(P)
 
   Solution a way to do is keep track the point health starting from the position[0][0]
   So you can go to the princess's location with all the posibles paths and return the one
   with the smallest health.
   But this solution is very inefficient 
   
   Another approach is start from the position's princess causes always is the same.
   and start to calculate from there example.
   
   
   So need to calculate the min health to move from that cell
   
    so will iterate from down to top 
	
	i = rows -1 j = cols-1
	 i = 2, j = 2
	 in the position's princess d[2][2] = -5 so in order to reach in this cell we need 
	 6 health points so.

	d[2][2] = min(1, 1- d[2][2]); with this pedending in the value of this cell calculate the 
	health points needed to have 1 health point so if the cell has a positive value just need 1 point 
    otherwise calculate 1- (-5) = 6 so replace 6 in that cell
	
	 -2(K) -3    3  
	 -5	 -10     1
     10	  30     6
	 
	for the element :  i = 2, j = 1 d[2][1] = max(1, d[i][ j + 1] - d[i][j])
	if the result is positive it means that we need that health point when we arrive that cell
    otherwise just store 1 because you do not need extra health.
	 
	d[2][1] = max(1, d[2][2] - d[2][1])  = d[i][ j + 1] - d[i][j] =  6 - 30 = -24 
  	that  mean we do not need extra health so put a one you can realize that because in this cell has 30
   

   	 -2(K) -3    3  
	 -5	 -10     1
     10	   1     6
	 
	the same logic here: 
	for i = 1, j = 2 d[1][2] = max(1, d[i + 1][j] - d[i][j]) = 6 - (-1) = 5 so put 5, that mean we need to reach
	to that cell with 5 points. and when you add 1 point from that cell we get 6 the required point to rescue the
    princess.	

	-2(K) -3     3  
	 -5	 -10     5
     10	   1     6
	 
	for i = 1, j = 1 d[1][1] = max(1, min(d[i+1][j], d[i][j+1]) - d[i][j])
	here is the same but remember in this position we can go down or right so we need the element with the smaller value
    [1][1] = max(1, min(1,5) - -(10)) = 1 + 10 = 11 
	
	
	-2(K) -3     3  
	 -5	  11     5
     10	   1     6
	 
	 This are the 4 case you can facet so do the same for the rest of the element and 
	 return the element at [0][0] and thas is the result.
  @author Brahian VT
*/

public class DungeonGame{
	    public int calculateMinimumHP(int[][] d) {
			// get  columns and rows
			int row = d.length, col = d[0].length;
			
			// iterate from down to top
			
			for(int i = row - 1; i >= 0; i++){
				for(int j = col -1; j >= 0; j++){
					
					if(i == row - 1 && j != col -1){
						d[i][j] = Math.max(1, d[i][j + 1]);
					}
					else if(j == row - 1 && i != row - 1){
						d[i][j] = Math.max(1, d[i +1][j]);
					}
					else if(i != row - 1 && j != col - 1){
						d[i][j] = Math.max(1, Math.min(d[i+1][j],d[i][j+1]) - d[i][j]);
					}
					else{
						d[i][j] = Math.max(1, 1 - d[i][j]);
					}
				}
			}
		
			return d[0][0];
		}	
}