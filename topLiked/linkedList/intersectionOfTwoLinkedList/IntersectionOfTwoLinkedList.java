package intersectionOfTwoLinkedList;


class ListNode{
	int val;
	ListNode next;
	
	ListNode(int x){
		this.val = x;
		this.next = null;
	}
}
public class IntersectionOfTwoLinkedList {

	public ListNode headA;
	public ListNode headB;
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if(headA==null && headB==null){
			return null;
		}
		
		if(headA==null||headB==null){
			return null;
		}
		
		ListNode tempA = headA;
		ListNode tempB = headB;
		
		while(tempA!=tempB){
			if(tempA==null && tempB==null){
				return null;
			}
			
			if(tempA==null){
				tempA = headB;
			}
			if(tempB==null){
				tempB = headA;
			}
			tempA = tempA.next;
			tempB = tempB.next;
		}
		
		return tempA;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IntersectionOfTwoLinkedList list = new IntersectionOfTwoLinkedList();
		
		list.headA = new ListNode(0);
		list.headA.next = new ListNode(9);
		list.headA.next.next = new ListNode(1);
		list.headA.next.next.next = new ListNode(2);
		list.headA.next.next.next.next = new ListNode(4);
		
		list.headB = new ListNode(3);
		list.headB.next = list.headA.next.next.next;
		
		System.out.println((list.getIntersectionNode(list.headA, list.headB)).val);
	}

}
