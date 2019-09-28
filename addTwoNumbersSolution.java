package sols;

import java.io.IOException;

public class addTwoNumbersSolution {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static String listNodeToString(ListNode node) {
		if (node == null) {
			return "[]";
		}

		String result = "";
		while (node != null) {
			result += Integer.toString(node.val) + ", ";
			node = node.next;
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		// build the number
		int num;
		int digit;
		String num1 = "";
		String num2 = "";
		ListNode trav;
		trav = l1;

		while (trav.next != null) {
			num1 += Integer.toString(trav.val);
			// System.out.println(trav.val);
			trav = trav.next;
		}

		num1 += Integer.toString(trav.val);
		// System.out.println(trav.val);

		String rnum1 = new StringBuilder(num1).reverse().toString();

		trav = l2;
		while (trav.next != null) {
			num2 += Integer.toString(trav.val);
			// System.out.println(trav.val);
			trav = trav.next;
		}
		num2 += Integer.toString(trav.val);
		// System.out.println(trav.val);

		String rnum2 = new StringBuilder(num2).reverse().toString();

		ListNode big;
		ListNode small;
		if (rnum1.length() > rnum2.length()) {
			// the bigger one needs to be head
			big = l1;
			small = l2;
			// we do the position arithmetic and just return the fuged list
		}

		else {
			big = l2;
			small = l1;
		}

		// Now we have a biuggest head\
		ListNode head = big;
		while (small != null) {
			// System.out.println(listNodeToString(head));
			// System.out.println("Big.next: "+ big.next.val);

			num = big.val + small.val;
			digit = num % 10;
			// System.out.println("Big Val: " + big.val);
			// System.out.println("num add: " + num);

			while (num > 9) {
				// System.out.println(listNodeToString(head));

				num = big.val + small.val;
				digit = num % 10;
				big.val = digit;
				if (big.next == null) {
					big.next = new ListNode(0);
					big.next.val += 1;
					big = big.next;

					if (small.next == null) {
						small.next = new ListNode(0);
					}
					small = small.next;
					num = big.val + small.val;
					// System.out.println(listNodeToString(head));
				} else {
					big.next.val += 1;
					big = big.next;

					if (small.next == null) {
						small.next = new ListNode(0);
					}
					small = small.next;
					num = big.val + small.val;
					// System.out.println(listNodeToString(head));
				}

			}

			if (small.next == null) {
				big.val = num;
				return head;
			}

			big.val = num;
			big = big.next;
			small = small.next;

		}

		return head;
	}

	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static ListNode stringToListNode(String input) {
		// Generate array from the input
		int[] nodeValues = stringToIntegerArray(input);

		// Now convert that list into linked list
		ListNode dummyRoot = new ListNode(0);
		ListNode ptr = dummyRoot;
		for (int item : nodeValues) {
			ptr.next = new ListNode(item);
			ptr = ptr.next;
		}
		return dummyRoot.next;
	}

	public static void main(String[] args) throws IOException {
		ListNode l1 = stringToListNode(
				"[9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9]");

		ListNode l2 = stringToListNode("[1]");

		ListNode l3 = stringToListNode(
				"[2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9]");

		ListNode l4 = stringToListNode(
				"[5,6,4,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9,9,9,9]");

		ListNode l5 = stringToListNode("[2,4,3]");
		ListNode l6 = stringToListNode("[5,6,4]");
		
		ListNode ret = new addTwoNumbersSolution().addTwoNumbers(l1, l2);
		
		String out = listNodeToString(ret);
		System.out.print(out + "\n\n");

		ret = new addTwoNumbersSolution().addTwoNumbers(l3, l4);
		out = listNodeToString(ret);
		System.out.print(out+ "\n\n");
		
		ret = new addTwoNumbersSolution().addTwoNumbers(l5, l6);
		out = listNodeToString(ret);
		System.out.print(out+ "\n\n");

	}

}