/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        
        Node curr = head;
        while (curr != null) {
            // If there is no child, just move to the next node
            if (curr.child == null) {
                curr = curr.next;
                continue;
            }
            
            // If a child exists, find the tail of the child sublist
            Node childTail = curr.child;
            while (childTail.next != null) {
                childTail = childTail.next;
            }
            
            // Connect childTail to curr.next (if curr.next exists)
            childTail.next = curr.next;
            if (curr.next != null) {
                curr.next.prev = childTail;
            }
            
            // Connect curr to curr.child
            curr.next = curr.child;
            curr.child.prev = curr;
            
            // Clear the child pointer as required by the problem
            curr.child = null;
            
            // Proceed to the next node (which is now the old child head)
            curr = curr.next;
        }
        
        return head;
    }
}
