package leetcode;

import support.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LeetCodeMediumLevel {

    public static void main(String args[]) {


    }

    //142. Linked List Cycle II
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                break;
            }
            head = head.next;
        }
        return head;
    }
}

