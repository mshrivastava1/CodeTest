package removeNthNodeFromEnd;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		this.val = x;
		this.next = null;
	}
}

public class RemoveNthNodeFromEnd {

	public ListNode head;

	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		if(head==null || n<1){
			return head;
		}
		
		int len = 0;
		
		ListNode temp = head;
		
		while(temp!=null){
			len++;
			temp = temp.next;
		}
		
		int fromStart = len - n;
		
		if(fromStart==0){
			return head.next;
		}
		
		temp = null;
		for(int i=0;i<fromStart;i++){
			if(temp==null){
				temp = head;
			}else{
				temp = temp.next;
			}	
		}
		
		temp.next = temp.next.next;
		
		return head;
		
	}

	public void print(ListNode node) {

		if (node == null) {
			return;
		}
		ListNode temp = node;

		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RemoveNthNodeFromEnd list = new RemoveNthNodeFromEnd();

		list.head = new ListNode(1);
		list.head.next = new ListNode(2);
		list.head.next.next = new ListNode(3);
		list.head.next.next.next = new ListNode(4);
		list.head.next.next.next.next = new ListNode(5);

		int n = 2;
		list.head = list.removeNthFromEnd(list.head, n);

		list.print(list.head);
	}

}
