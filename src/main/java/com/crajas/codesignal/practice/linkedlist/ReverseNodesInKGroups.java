package com.crajas.codesignal.practice.linkedlist;

/**
 * Note: Your solution should have O(n) time complexity, where n is the number of elements in l, and O(1) additional space complexity, since this is what you would be asked to accomplish in an interview.
 * 
 * Given a linked list l, reverse its nodes k at a time and return the modified list. k is a positive integer that is less than or equal to the length of l. If the number of nodes in the linked list is not a multiple of k, then the nodes that are left out at the end should remain as-is.
 * 
 * You may not alter the values in the nodes - only the nodes themselves can be changed.
 * 
 * Example
 * 
 * For l = [1, 2, 3, 4, 5] and k = 2, the output should be
 * solution(l, k) = [2, 1, 4, 3, 5];
 * For l = [1, 2, 3, 4, 5] and k = 1, the output should be
 * solution(l, k) = [1, 2, 3, 4, 5];
 * For l = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] and k = 3, the output should be
 * solution(l, k) = [3, 2, 1, 6, 5, 4, 9, 8, 7, 10, 11].
 * Input/Output
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] linkedlist.integer l
 * 
 * A singly linked list of integers.
 * 
 * Guaranteed constraints:
 * 1 <= list size <= 104,
 * -109 <= element value <= 109.
 * 
 * [input] integer k
 * 
 * The size of the groups of nodes that need to be reversed.
 * 
 * Guaranteed constraints:
 * 1 <= k <= l size.
 * 
 * [output] linkedlist.integer
 * 
 * The initial list, with reversed groups of k elements.
 * 
 * @author rcmohan@gmail.com
 *
 */
public class ReverseNodesInKGroups {

	ListNode<Integer> solution(ListNode<Integer> l, int k) {
		if (k <= 1)
			return l;
		ListNode<Integer> head = new ListNode<>(0);
		head.next = l;
		ListNode<Integer> x = head;
		ListNode<Integer> tail = x.next;
		while (tail != null) {
			tail = x.next;
			int f = k;
			while (f-- > 0 && tail != null) {
				tail = tail.next;
			}
			if (f == -1) {
				reverse(x, tail);
				while (x.next != tail && x != null)
					x = x.next;
			}
		}
		return head.next;
	}

	ListNode<Integer> reverse(ListNode<Integer> head, ListNode<Integer> tail) {
		ListNode<Integer> p, q, r;
		p = head.next;
		q = p.next;
		while (q != tail) {
			r = q.next; 		// Head -> P1 -> Q2-> R3-> 4-> 5-> null
			p.next = r; 		// Head -> P1 -> R3-> 4-> 5-> null Q2 ->
			q.next = head.next; // Head -> Q2-> P1 -> R3-> 4-> 5-> null
			head.next = q; 		// Head -> Q2-> P1 -> R3-> 4-> 5-> null
			q = r; 				// Head -> 2-> P1 -> Q3-> 4-> 5-> null
		}
		return q;
	}
}
