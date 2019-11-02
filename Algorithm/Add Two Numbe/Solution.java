package com.test.node;

/**
 * 2019-11-2
 * 
 * @author willl https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Solution {

	private ListNode add(ListNode l1, ListNode l2, ListNode node, int sum) {
		if (l1 == null && l2 == null) {
			return node;
		}

		if (l1 != null) {
			sum += l1.val;
		}

		if (l2 != null) {
			sum += l2.val;
		}

		ListNode next = new ListNode(0);
		if (node != null) {
			sum += node.val;
			if (sum >= 10) {
				node.val = sum - 10;
				next.val = 1;
			} else {
				node.val = sum;
			}
		} else {
			return node;
		}

		/**
		 * If the both of the list's next element is null will not generate a new
		 * element and add it to result list.
		 */
		if ((l1 != null || l2 != null) || (l1 == null && l2 == null)) {
			if ((l1 != null || l2 != null) || (l1 == null && l2 == null) && (l1 != null && l1.next != null)
					|| (l2 != null && l2.next != null) || next.val > 0) {
				next.next = node.next;
				node.next = next;
			}
		}

		if (l1 != null && l2 != null) {
			return this.add(l1.next, l2.next, node.next, 0);
		} else if (l1 == null && l2 != null) {
			return this.add(null, l2.next, node.next, 0);
		} else if (l1 != null && l2 == null) {
			return this.add(l1.next, null, node.next, 0);
		}
		return null;
	}

	/**
	 * A method for the start the program.
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		ListNode sum = new ListNode(0);
		ListNode head = sum;
		this.add(l1, l2, sum, 0);
		return head;
	}

	/**
	 * A method to test cases.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode();
		ListNode l2 = new ListNode(0);
		ListNode sum = new ListNode();
		Solution s = new Solution();
		l1.val = 5;
//		ListNode l1Next1 = new ListNode(4);
//		l1.next = l1Next1;
//		ListNode l1Next2 = new ListNode(3);
//		l1Next2.next = null;
//		l1Next1.next = l1Next2;

		l2.val = 5;
//		ListNode l2Next1 = new ListNode(6);
//		l2.next = l2Next1;
//		ListNode l2Next2 = new ListNode(4);
//		l2Next2.next = null;
//		l2Next1.next = l2Next2;

//		l1.val = 1;
//		ListNode l1Next1 = new ListNode(8);
//		l1.next = l1Next1;
//		l1Next1.next = null;

//		ListNode l1Next2 = new ListNode(3);
//		l1Next2.next = null;
//		l1Next1.next = l1Next2;

//		l2.val = 0;
//		ListNode l2Next1 = new ListNode(6);
//		l2.next = l2Next1;
//		ListNode l2Next2 = new ListNode(4);
//		l2Next2.next = null;
//		l2Next1.next = l2Next2;

		sum = s.addTwoNumbers(l1, l2);
	}
}
