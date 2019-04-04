package reverseLinkedList;



class ListNode{
	int val;
	ListNode next;
	
	ListNode(int x){
		this.val = x;
		this.next = null;
	}
}
public class ReverseLinkedList {

	ListNode head;
	 public ListNode reverseList(ListNode head){
		 
		 ListNode prev = null;
		 ListNode next = null;
		 ListNode temp = head;
		 while(temp!=null){
			 next = temp.next;
			 temp.next = prev;
			 prev = temp;
			 temp = next;
		 }
		 
		 head = prev;
		 
		 return head;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReverseLinkedList list = new ReverseLinkedList();
		
		list.head = new ListNode(1);
		list.head.next = new ListNode(2);
		list.head.next.next = new ListNode(3);
		list.head.next.next.next = new ListNode(4);
		list.head.next.next.next.next = new ListNode(5);
		
		ListNode result = list.reverseList(list.head);
		
		list.print(result);
		
	}

}
