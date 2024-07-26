package solutions.pack3;

public class MyLinkedListTricky_661090 extends MyLinkedList_661090 {
    public void q1_rotate_clockwise(int k) {
        if (k <= 0 || k>= size()) return;
        Node p = head;
        for (int i =0; i < k-1 ;i++) {
            p = p.next;
        }
        Node q = p.next;
        p.next = null;
        Node r = q;
        while(r.next!= null) {
            r = r.next;
        }
        r.next = head;
        head = q;
    }

    public void q2_reverse() {
        Node p = head;
        Node q = null;
        Node r = null;
        while (p!= null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        head = q;
    }

    public void q3_remove_dup() {
        Node p = head;
        while (p != null) {
            Node q = p;
            while(q.next != null) {
                if(q.next.data == p.data) {
                    q.next = q.next.next;
                }else {
                    q = q.next;
                }
            }
            p = p.next;
        }
    }

    public void q4_add_one() {
        Node p = head;
        Node q = null;
        while (p != null) {
            if(p.data != 9) {
                q = p;
            }
            p = p.next;
        }
        if(q == null) {
            q = new Node(0);
            q.next = head;
            head = q;
        }
        q.data++;
        p = q.next;
        while (p != null){
            p.data = 0;
            p = p.next;
        }
    }

    public boolean q5_isPalindrome() {
        Node p = head;
        Node q = head;
        while(q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }
        if( q != null) {
            p = p.next;
        }
        Node r = null;
        while(p != null) {
            Node t = r;
            r = p;
            p = p.next;
            r.next = t;
        }
        p = head;
        while (r != null) {
            if(r.data != p.data) {
                return false;
            }
            r = r.next;
            p = p.next;
        }
        return true;
    }
}
