package com.crajas.codesignal.practice.linkedlist;


/**
 * You're given 2 huge integers represented by linked lists. Each linked list element is a number from 0 to 9999 that represents a number with exactly 4 digits. The represented number might have leading zeros. Your task is to add up these huge integers and return the result in the same format.
 * 
 * Example
 * 
 * For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
 * solution(a, b) = [9876, 5434, 0].
 * 
 * Explanation: 987654321999 + 18001 = 987654340000.
 * 
 * For a = [123, 4, 5] and b = [100, 100, 100], the output should be
 * solution(a, b) = [223, 104, 105].
 * 
 * Explanation: 12300040005 + 10001000100 = 22301040105.
 * 
 * Input/Output
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] linkedlist.integer a
 * 
 * The first number, without its leading zeros.
 * 
 * Guaranteed constraints:
 * 0 <= a size <= 104,
 * 0 <= element value <= 9999.
 * 
 * [input] linkedlist.integer b
 * 
 * The second number, without its leading zeros.
 * 
 * Guaranteed constraints:
 * 0 <= b size <= 104,
 * 0 <= element value <= 9999.
 * 
 * [output] linkedlist.integer
 * 
 * The result of adding a and b together, returned without leading zeros in the same format.
 * 
 * @author rcmohan@gmail.com
 *
 */
public class AddTwoLargeNumbers {

	ListNode<Integer> solution(ListNode<Integer> a, ListNode<Integer> b) {
		if (a == null)
			return b;
		if (b == null)
			return a;

		a = reverse(a);
		b = reverse(b);

		ListNode<Integer> c = new ListNode<Integer>(-1);

		int carry = 0;
		ListNode<Integer> head = c;
		while (a != null && b != null) {
			c.next = new ListNode<Integer>(a.value + b.value + carry);
			c = c.next;
			if (c.value > 9999) {
				carry = 1;
				c.value = c.value % 10000;
			} else {
				carry = 0;
			}
			a = a.next;
			b = b.next;
		}
		if (a != null) {
			addRest(c, a, carry);
		} else if (b != null) {
			addRest(c, b, carry);
		} else if (carry == 1) {
			c.next = new ListNode<Integer>(1);
		}

		c = head.next;

		return reverse(c);
	}

	void addRest(ListNode<Integer> c, ListNode<Integer> a, int carry) {
		while (a != null) {
			c.next = new ListNode<Integer>(a.value + carry);
			c = c.next;
			if (c.value > 9999) {
				carry = 1;
				c.value = c.value % 10000;
			} else {
				carry = 0;
			}

			a = a.next;
		}
		if (carry == 1) {
			c.next = new ListNode<Integer>(1);
		}

	}

	ListNode<Integer> reverse(ListNode<Integer> a) {
		if (a.next != null) {
			ListNode<Integer> p, q, r;
			p = a;
			q = p.next;
			while (q.next != null) {
				r = q.next;
				q.next = p;
				p = q;
				q = r;
				if (r != null)
					r = r.next;
			}
			a.next = null;
			q.next = p;
			return q;
		} else {
			return a;
		}
	}

	void print(ListNode<Integer> p, ListNode<Integer> q, ListNode<Integer> r) {
		if (r != null) {
			System.out.printf("%d %d %d;\n", p.value, q.value, r.value);
		} else if (q != null) {
			System.out.printf("%d %d null;\n", p.value, q.value);
		}

	}

	void printlist(ListNode<Integer> l) {
		while (l != null) {
			System.out.printf("[%d]->", l.value);
			l = l.next;
		}
		System.out.println();
	}

}
