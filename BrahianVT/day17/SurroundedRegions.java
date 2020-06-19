


/**  
  Start to find in the first and last row and columns respectively
  and just find all the elements "O" with all its neighbours and just change all the elements
  "O" that not match this statement and that all.  
  
    @author Brahian VT
*/

public class SurroundedRegions{
  
  
  public void solve(char[][] b) {
	int col = b.length;
	if(col == 0) return;
	int row = b[0].length;
	
	
	// check first and last columns
	for( int i = 0; i < col; i++){
		if( b[i][0] == 'O'){
			validate(b, i,0);
		}
		
		if( b[i][row-1] == 'O'){
			validate(b, i, row -1);
		}
	}
	
	// check first and last row
	for( int i = 0; i < row; i++){
		if( b[0][i] == 'O'){
			validate(b, 0, i);
		}
		
		if( b[col -1][0] == 'O'){
			validate(b, col -1, 0);
		}
	}
	
	for( int i = 0; i < row; i++){
		for(int j = 0; j < col; j++){
			if(b[i][j] == 'O')b[i][j] = 'X';
			
			if(b[i][j] == 'P')b[i][j] = 'O';
		}
	}
  }	

 // check if the element at b is "O" and find all its neighbours

   private void validate(char[][] b, int i, int j){
	   if( i>= 0 && i < b[i].length &&  j >= 0 && j < b.length && b[i][j] == 'O'){
		   b[i][j] = 'P';
		   validate(b, i + 1, j);
		   validate(b, i - 1, j);
		   validate(b, i, j -1);
		   validate(b, i, j + 1);
	   }else return;
   } 
}