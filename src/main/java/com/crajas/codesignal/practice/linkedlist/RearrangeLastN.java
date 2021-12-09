package com.crajas.codesignal.practice.linkedlist;

/**
 * Note: Try to solve this task in O(list size) time using O(1) additional space, since this is what you'll be asked during an interview.
 * 
 * Given a singly linked list of integers l and a non-negative integer n, move the last n list nodes to the beginning of the linked list.
 * 
 * Example
 * 
 * For l = [1, 2, 3, 4, 5] and n = 3, the output should be
 * solution(l, n) = [3, 4, 5, 1, 2];
 * For l = [1, 2, 3, 4, 5, 6, 7] and n = 1, the output should be
 * solution(l, n) = [7, 1, 2, 3, 4, 5, 6].
 * Input/Output
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] linkedlist.integer l
 * 
 * A singly linked list of integers.
 * 
 * Guaranteed constraints:
 * 0 <= list size <= 105,
 * -1000 <= element value <= 1000.
 * 
 * [input] integer n
 * 
 * A non-negative integer.
 * 
 * Guaranteed constraints:
 * 0 <= n <= list size.
 * 
 * [output] linkedlist.integer
 * 
 * Return l with the n last elements moved to the beginning.
 * 
 * @author rcmohan@gmail.com
 *
 */
public class RearrangeLastN {
	ListNode<Integer> solution(ListNode<Integer> l, int n) {
		ListNode<Integer> head = new ListNode<Integer>(-1);
		head.next = l;

		if (l != null && l.next != null) {
			ListNode<Integer> newhead = l;
			ListNode<Integer> oldtail = head;
			int size = 0;
			while (oldtail.next != null) {
				oldtail = oldtail.next;
				size++;
			}
			if (n != size) {
				int newheadpos = 0;
				for (int i = 1; i < size - n; ++i) {
					newhead = newhead.next;
					newheadpos++;
				}
				if (newheadpos != size - 1) {
					oldtail.next = head.next;
					head.next = newhead.next;
					newhead.next = null;
				}
			}
		}
		return head.next;
	}

}
