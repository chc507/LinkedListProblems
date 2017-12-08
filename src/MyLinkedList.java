import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyLinkedList {
    ListNode head = null;

    //insert
    public void addNode(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode current = head;
            //stop at the last node
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(val);
        }
    }

    //remove the nth node, starting with 1
    public boolean deleteNode(int index) {
        if (index < 1 || getLength() < index) {
            return false;
        }

        //remove head
        if (index == 1) {
            head = head.next;
        } else {
            int current = 1;
            ListNode prev = head;
            ListNode pointer = prev.next;
            while (pointer != null) {
                //move pointer
                if (current == index) {
                    prev.next = pointer.next;
                    return true;
                }
                prev = pointer;
                pointer = pointer.next;
                current++;
            }
        }
        return false;
    }

    //length of the list # of nodes
    private int getLength() {
        int length = 0;
        ListNode pointer = head;
        while (pointer != null) {
            length++;
            pointer = pointer.next;
        }
        return length;
    }

    //print list
    public void printList() {
        ListNode pointer = head;
        while (pointer != null) {
            System.out.println(pointer.val);
            pointer = pointer.next;
        }
    }


    //sort LinkedList
    //Bubble sort, generate a Next pointer, next to the current
    //The next will travel through the end,
    //Then the current pointer will move one to the right
    public ListNode orderList() {
        ListNode next = null;
        ListNode current = head;
        while (current.next != null) {
            next = current.next;
            while (next != null) {
                if (next.val > current.val) {
                    swap(current, next);
                }
                next = next.next;
            }
            current = current.next;
        }
        return head;
    }

    private void swap(ListNode A, ListNode B) {
        int temp = A.val;
        A.val = B.val;
        B.val = temp;
    }

    //Delele duplicate
    //Use Map to check if there is duplicate <- Save time
    public void removeDuplicate(ListNode head) {
        Map<Integer, Boolean> map = new HashMap<>();
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            if (!map.containsKey(current.val)) {
                //remove
                prev.next = current.next;
            } else {
                map.put(current.val, true);
                prev = current;
            }
            current = current.next;
        }
    }

    // double iteration to save  space, but O(n)
    public void removeCompact(ListNode head) {
        ListNode p = head;
        ListNode q;
        while (p != null) {
            q = p;
            while (q.next != null) {
                if (q.next.val == p.val) {
                    q.next = q.next.next;
                } else {
                    q = q.next;
                }
            }
            p = p.next;
        }
    }


    //PrintListReverse
    public void printListReverse(ListNode head) {
        if (head != null) {
            printListReverse(head.next);
            System.out.print(head.val + " ");
        }
    }

    //The last K elements in LinkedList
    //traverse the list twice, the first time, get length, the second time, find n - k element
    //simplify as using two pointer, sp, fp, fp =  sp + k - 1; when the fast pointer reach the end,
    //return the slow pointer

    public ListNode findLastKNodes(ListNode head, int k) {
        if (k < 1 || k > getLength()) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


    //Find the mid point of the singly linked-list
    ///two pointer, one fast, one slow
    public ListNode getMidNode(ListNode head) {
        ListNode p = head; //fast
        ListNode q = head;
        while (p != null && p.next != null && p.next.next == null) {
            q = q.next;
            p = p.next.next;
        }
        return q;
    }

    //Reverse Linkedlist

    public ListNode reverseList(ListNode head) { //check stands. then move to next
        ListNode newHead = head;
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            //TODO: lOOK AT HERE, YOU
            ListNode next = current.next;
            if (next == null) { //reach the end;
                newHead = current;
            }
            current.next = prev;
            //move to next;
            prev = current;
            current = next;
        }
        return newHead;
    }


    //Delete certain nodes without knowing the head node
    //main issue, you can not have previous node
    //if deleted point is the last node, you can not get the pointer to it. you can not have prev
    public boolean deleteNodeWoHead(ListNode n){
        if (n == null || n.next == null) {
            return false;
        } else {
            int temp = n.val;
            n.val = n.next.val;
            n.next.val = temp; //swap data n and n+1
            n.next = n.next.next;
            return true;
        }
    }
}
