


/**
  Given a 2D board and a list of words from the dictionary, find all words in the board.

  Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example:

Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Note:

All inputs are consist of lowercase letters a-z.
The values of words are distinct.


Output: ["eat","oath"]	

	Solution 
	
	The naive solution is search for all the strings in the list words
	Due to each  work can be found horizontally or vertically or a mix of both
	We need to iterate the board and start to search in the first position where we find the first letter.
	so with  "oath" we will nedd to check all the letters where there are the o's and from that point start to
	search for the whole word. This is a litle bit inefficient 
	because we nedd to iterate over the entire board depending on how many word you have in the list.
	
	So  the best way to resulve is usen a trie structure
	
	So in the result we will use recursion and a trie
	so we will check multiple words at the same time
	
	Complexity Time:O(m * n * wl * l)
	So first create the trie with all the words
	
    	/ o -a -t -h  , word = oath
	root  - p -e -a  , word = eat
	  \	\ e- a- t , word = eat
	   \ r - a - i -n , word = rain
	   
	 This is a representation just remember each element is itself a trie node and in every element we can have from a- z
	 so every trieNode have a array of 26 slots to store any possible character.
	 
	 so with board
	 board = [
  ['o','a','a','n'],				
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']]
  
  with the first word: oath 
    o | a | a | n | 
	e | t | a | e | 
	i | h | k | r | 
	i | f | l | v | 

	# | a | a | n | 
	e | t | a | e | 
	i | h | k | r | 
	i | f | l | v | 

	# | # | a | n | 
	e | t | a | e | 
	i | h | k | r | 
	i | f | l | v | 

	# | # | a | n | 
	e | # | a | e | 
	i | h | k | r | 
	i | f | l | v | 

	# | # | a | n | 
	e | # | a | e | 
	i | # | k | r | 
	i | f | l | v | 
	
	we found it so store it in a list res = [oath]
	reset the board to start and apply the same logic for each word 
	
	and ind the end we will get the solution ["eat","oath"]	
  @author Brahian VT
**/


import java.util.*;
public  class WordSearchII{
	
	
	public List<String> findWords(char[][] board, String[] words) {
        
        List<String> res = new ArrayList<>();
        
        TrieNode root = buildTrie(words);
		
		for(int i = 0; i < board.length; i++){
			
			for(int j = 0; j < board[0].length; j++){
				dfs(board,i,j, res, root);
			}
		}
		
		return res;
	}
	
	private void dfs(char[][] board, int i, int j, List<String> res, TrieNode p){

		char c = board[i][j];	
		
		if( p.next[c - 'a'] == null || board[i][j] == '$') return ;
		

		int index = c - 'a';
		p = p.next[index];
		
		if(p.word != null){
			res.add(p.word);
			p.word = null;
		}
		
		board[i][j] = '$';
		
		if(i > 0)dfs(board, i-1, j, res, p);
		if(j > 0)dfs(board, i, j-1, res, p);
		if(i < board.length -1 )dfs(board, i+1, j, res, p);
		if(j < board[0].length -1 )dfs(board, i, j+1, res, p);
		
		board[i][j] = c;
	}
	private TrieNode buildTrie(String[] words){
		TrieNode root = new TrieNode();
		
		for(String w : words){
			TrieNode p = root;
			
			for(char c: w.toCharArray()){
				int index = c - 'a';
				
				if(p.next[index] == null) p.next[index] = new TrieNode();
				
				p = p.next[index];
			}
			p.word = w;
		}
		
		return root;
	}
	class TrieNode{
		String word;
		TrieNode[] next = new TrieNode[26];
	}
}