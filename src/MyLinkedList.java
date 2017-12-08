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
        while  (pointer != null) {
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
                    swap(current,next);
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
        Map<Integer,Boolean> map = new HashMap<>();
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

    // double iteration to save  space
    public void removeCompact(ListNode head) {
        ListNode pointer = head;

    }


}
