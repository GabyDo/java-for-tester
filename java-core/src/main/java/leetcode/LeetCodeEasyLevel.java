package leetcode;

import support.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCodeEasyLevel {
    public static void main(String args[]){
        int[] dummy = new int[] {7,1,5,3,6,4};
        int a = maxProfit2(dummy);
        System.out.println();
        Set<Character> set = new HashSet<>();

    }

    //409. Longest Palindrome:Đọc xuôi ngược đều giống như nhau
    public int longestPalindrome(String s) {
        if (s == null) {
            return 0;
        }
        int count =0;
        Set<Character> set = new HashSet<>();

        for (Character a: s.toCharArray()) {
            if(!set.add(a)) {
                count += 2;
                set.remove(a);
            } else {
                set.add(a);
            }
        }
        int middle = set.size() >= 1 ? 1:0;
        return count + middle;
    }

    //121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int max = 0;
        int sellValue;
        for (int i = 0; i < prices.length -1; i++) {
            for (int j = i + 1; j < prices.length; j++ ) {
                sellValue = prices[j] - prices[i];
                if (sellValue > max) {
                    max = sellValue;
                }
            }
        }
        return max;
    }

    public static int maxProfit2(int[] prices) {
        int minBuy = prices[0];
        int profit = 0;

        if (prices.length == 1 || prices == null) {
            return 0;
        }

        for (int i = 1; i < prices.length; i++) {

            if ((prices[i] - minBuy) > profit) {
                profit = prices[i] - minBuy;
            }

            if (minBuy > prices[i]) {
                minBuy = prices[i];
            }


        }

        return profit;
    }

    //876. Middle of the Linked List
    public ListNode middleNode(ListNode head) {
        ListNode[] list = new ListNode[100];
        int i = 0;
        while (head != null) {
            list[i] = head;
            i++;
            head = head.next;

        }
        return list[i/2];
    }

    //206. Reverse Linked List
    public ListNode reverseList(ListNode head) {

        ListNode  reverse;
        if (head == null) {
            return head;
        }

        ListNode  nextNode = head.next;
        head.next = null;
        while (nextNode != null) {
            ListNode thirdNode = nextNode.next;
            nextNode.next = head;
            head = nextNode;
            nextNode = thirdNode;
        }

        return head;
    }


    //21. Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merge = null;
        ListNode head;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        //input of head
        if(list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        merge = head;

        // comback second element of list 1
        while (list1 != null && list2!= null) {
            if (list1.val < list2.val) {
                merge.next = list1;
                list1 = list1.next;
            } else {
                merge.next = list2;
                list2 = list2.next;
            }
            merge = merge.next;
        }

        if(list1 == null) {
            merge.next = list2;
        } else {
            merge.next = list1;
        }

        return head;
    }
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;


        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
    //1. Two Sum
    public static int[] twoSum(int[] nums, int target) {
        int l =  nums.length;
        int[] outPut = new int[2];
        int a;
        for (int i = 0;i < l ; i ++) {
            a = nums[i];
            for (int j = i+1; j <l; j++) {
                if (a + nums[j] == target) {
                    outPut = new int[] {i,j};
                    break;
                }
            }

        }
        return outPut;

    }

   //392. Is Subsequence
    public boolean isSubsequence(String s, String t) {
        int currentPos = 0;
        int index;
        //s is subsequence
        for (Character sChar : s.toCharArray()) {
            index = t.indexOf(sChar, currentPos);
            if (index == -1) {
                return false;
            } else {
                currentPos = index + 1;
            }
        }
        return true;
    }

    //205. Isomorphic Strings
    public boolean isIsomorphic(String s, String t) {
        int l = s.length();
        Map<Character, Character> dic = new HashMap();

        for (int i = 0; i< l; i++) {

            if (dic.containsKey(s.charAt(i))) {
                if (dic.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if ( dic.containsValue(t.charAt(i))) {
                    return false;
                } else {
                    dic.put(s.charAt(i), t.charAt(i));
                }
            }
        }
        return true;
    }

    //724. Find Pivot Index
    public int pivotIndex(int[] nums) {
        int l = nums.length;
        int[] sumLefts = new int[l];
        int[] sumRights = new int[l];
        sumLefts[0] = nums[0];
        sumRights[l - 1] = nums[l - 1];

        for (int i = 1; i < l; i++) {
            int tempLeft = nums[i] + sumLefts[i - 1];
            sumLefts[i] = tempLeft;
        }

        for (int i = l - 2; i >= 0; i--) {
            int tempRight = nums[i] + sumRights[i + 1];
            sumRights[i] = tempRight;
        }

        for (int j = 0; j < l; j++) {
            if (j == 0 && l >= 2 && sumRights[1] == 0) {
                return 0;
            } else {
                if (j == (l - 1) && l >= 2 && sumLefts[l - 2] == 0) {
                    return l - 1;
                } else {

                    if (j != 0 && j != (l - 1) && (sumLefts[j - 1] == sumRights[j + 1])) {
                        return j;
                    }
                }
            }
        }
        return -1;
    }

    //1480. Running Sum of 1d Array
    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length] ;
        int total = 0;
        for( int i = 0; i < nums.length; i++) {
            total = total + nums[i];
            runningSum[i] = total;
        }

        return  runningSum;
    }

}
