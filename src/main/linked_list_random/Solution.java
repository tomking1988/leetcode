package linked_list_random;

import java.util.Random;

/**
 * Created by xin on 8/14/2016.
 */
public class Solution {

    ListNode head;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int memory = this.head.val;
        Random random = new Random();
        ListNode current = this.head;
        double count = 1.0;
        while(current.next != null){
            current = current.next;
            count = count + 1.0;
            double threshold = 1 / count;
            if(random.nextDouble() <= threshold){
                memory = current.val;
            }
        }
        return memory;
    }

    public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
    }
}
