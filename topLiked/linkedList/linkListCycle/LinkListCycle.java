package linkListCycle;


class ListNode{
	int val;
	ListNode next;
	
	ListNode(int x){
		this.val = x;
		this.next = null;
	}
}
public class LinkListCycle {

	public ListNode head;
	public boolean hasCycle(ListNode head){
		if(head==null){
			return false;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast!=null && fast.next!=null){
			if(slow==fast.next){
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkListCycle list = new LinkListCycle();
		
		list.head = new ListNode(3);
		list.head.next = new ListNode(2);
		list.head.next.next = new ListNode(0);
		list.head.next.next.next = new ListNode(-4);
		//list.head.next.next.next.next = list.head.next;
		
		System.out.println(list.hasCycle(list.head));
	}

}
