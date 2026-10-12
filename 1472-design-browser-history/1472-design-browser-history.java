class ListNode {
    String val;
    ListNode prev, next;

    public ListNode(String val) {
        this.val = val;
    }
}

class BrowserHistory {
    private ListNode cur;

    public BrowserHistory(String homepage) {
        cur = new ListNode(homepage);
    }
    
    public void visit(String url) {
        cur.next = new ListNode(url);
        cur.next.prev = cur;
        cur = cur.next;
    }
    
    public String back(int steps) {
        while (steps > 0 && cur.prev != null) {
            cur = cur.prev;
            steps--;
        }
        return cur.val;
    }
    
    public String forward(int steps) {
        while (steps > 0 && cur.next != null) {
            cur = cur.next;
            steps--;
        }
        return cur.val;
    }
}   