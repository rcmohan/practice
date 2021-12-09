package com.crajas.codesignal.practice.linkedlist;


/**
 * Note: Your solution should have O(l1.length + l2.length) time complexity, since this is what you will be asked to accomplish in an interview.
 * 
 * Given two singly linked lists sorted in non-decreasing order, your task is to merge them. In other words, return a singly linked list, also sorted in non-decreasing order, that contains the elements from both original lists.
 * 
 * Example
 * 
 * For l1 = [1, 2, 3] and l2 = [4, 5, 6], the output should be
 * solution(l1, l2) = [1, 2, 3, 4, 5, 6];
 * For l1 = [1, 1, 2, 4] and l2 = [0, 3, 5], the output should be
 * solution(l1, l2) = [0, 1, 1, 2, 3, 4, 5].
 * Input/Output
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] linkedlist.integer l1
 * 
 * A singly linked list of integers.
 * 
 * Guaranteed constraints:
 * 0 <= list size <= 104,
 * -109 <= element value <= 109.
 * 
 * [input] linkedlist.integer l2
 * 
 * A singly linked list of integers.
 * 
 * Guaranteed constraints:
 * 0 <= list size <= 104,
 * -109 <= element value <= 109.
 * 
 * [output] linkedlist.integer
 * 
 * A list that contains elements from both l1 and l2, sorted in non-decreasing order.
 * 
 * @author rcmohan@gmail.com
 *
 */
public class MergeTwoLinkedLists {
	ListNode<Integer> solution(ListNode<Integer> l1, ListNode<Integer> l2) {

		ListNode<Integer> head = new ListNode<>(-1);
		ListNode<Integer> t = head;

		while (l1 != null && l2 != null) {
			if (l1.value < l2.value) {
				t.next = new ListNode<>(l1.value);
				t = t.next;
				l1 = l1.next;
			} else {
				t.next = new ListNode<>(l2.value);
				t = t.next;
				l2 = l2.next;
			}
		}
		while (l1 != null) {
			t.next = new ListNode<>(l1.value);
			t = t.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			t.next = new ListNode<>(l2.value);
			t = t.next;
			l2 = l2.next;
		}
		return head.next;
	}
}
