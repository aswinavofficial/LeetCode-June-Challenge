/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class DeleteNode {
    public void deleteNode(ListNode node) {
        
        ListNode current = node;
        ListNode temp = node;
        while(current !=null) {
            
            if(current.next !=null) {
                
                temp = current;
                
                current.val = current.next.val;
                 current = current.next;
                 
            }
            else {
                current = null;
                temp.next = null;
            }
            
           
        }
        
    }
}
