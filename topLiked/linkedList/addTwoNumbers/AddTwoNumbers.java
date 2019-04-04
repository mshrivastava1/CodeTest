package addTwoNumbers;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		this.val = x;
		this.next = null;
	}
}

public class AddTwoNumbers {

	public ListNode head1;
	public ListNode head2;

	public ListNode addTwoNumbers(ListNode first, ListNode second) {

		if (first == null && second == null) {
			return first;
		} else if (first == null) {
			return second;
		} else if (second == null) {
			return first;
		}

		int carry = 0;

		ListNode result = null;
		ListNode prev = null;
		while (first != null || second != null) {

			int sum = carry + (first != null ? first.val : 0) + (second != null ? second.val : 0);

			carry = (sum >= 10) ? 1 : 0;

			sum = (sum % 10);

			ListNode temp = new ListNode(sum);
			if (result == null) {
				result = temp;
			} else {
				prev.next = temp;
			}

			prev = temp;

			if (first != null) {
				first = first.next;
			}

			if (second != null) {
				second = second.next;
			}
		}

		if (carry > 0) {
			prev.next = new ListNode(carry);

		}

		return result;
	}

	public void print(ListNode node){
		
		if(node==null){
			return;
		}
		ListNode temp = node;
		
		while(temp!=null){
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
	public static void main(String[] arg) {

		AddTwoNumbers list = new AddTwoNumbers();
		
		list.head1 = new ListNode(2);
		list.head1.next = new ListNode(4);
		list.head1.next.next = new ListNode(3);
		
		list.head2 = new ListNode(5);
		list.head2.next = new ListNode(6);
		list.head2.next.next = new ListNode(4);
		
		ListNode result = list.addTwoNumbers(list.head1, list.head2);
		
		list.print(result);
	}
}
