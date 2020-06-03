
/**

	Day 2 June, Problem in leetCode
	Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.	
	Input: head = [4,5,1,9], node = 5
	Output: [4,1,9]
	Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

	Input: head = [4,5,1,9], node = 1
    Output: [4,5,9]
    Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
	

 @author Brahian VT
*/

public class DeleteNode{
	// as input remember is the node to  delete
	public void deleteNode(ListNode node){
		
		if(node.next != null){
			node.val = node.next.val;
			node.next = node.next.next;
		}
	}
}

/*
* Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 
 */