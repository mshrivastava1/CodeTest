package sorting;

class ListNode{
	int val;
	ListNode next;
	
	public ListNode(int x){
		this.val = x;
		this.next = null;
	}
}
public class SortListMergeSort {
	
	public ListNode head;
	
	public ListNode sortList(ListNode head){
	
		if(head==null || head.next==null){
			return head;
		}
		
		ListNode slow=head;
		ListNode fast = head;
		ListNode prev = null;
		
		
		while(fast!=null && fast.next!=null){
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		prev.next = null;
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);
		
		return merge(l1,l2);
		
	}

	public ListNode merge(ListNode l1, ListNode l2) {
		
		
		ListNode l = new ListNode(0);
		ListNode p = l;
	 	
		while(l1!=null && l2!=null){
			if(l1.val<l2.val){
				p.next = l1;
				l1=l1.next;
			}else{
				p.next = l2;
				l2 = l2.next;
			}
			
			p =p.next;
		}
		
		if(l1!=null){
			p.next = l1;
		}
		
		if(l2!=null){
			p.next = l2;
		}
		
		return l.next;
	}
	
	
	public void printList(ListNode head){
		
		ListNode temp = head;
		
		while(temp!=null){
			System.out.print(temp.val + " ");
			temp=temp.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SortListMergeSort list = new SortListMergeSort();
		
		list.head = new ListNode(4);
		list.head.next = new ListNode(2);
		list.head.next.next = new ListNode(1);
		list.head.next.next.next = new ListNode(3);
		
		list.head = list.sortList(list.head);
		
		list.printList(list.head);
	}

}
 