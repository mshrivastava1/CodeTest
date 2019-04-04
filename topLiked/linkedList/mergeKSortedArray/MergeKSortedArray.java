package mergeKSortedArray;

import java.awt.List;

class ListNode{
	int val;
	ListNode next;

	
	ListNode(int x){
		this.val =x;
		this.next=null;
	}
}
public class MergeKSortedArray {

	 public ListNode mergeKLists(ListNode[] lists) {
	       
		 if(lists.length==0){
			 return null;
		 }
		 
		 if(lists.length==1){
			 return lists[0];
		 }
		 
		 ListNode result = merge(lists[0], lists[1]);
		 
		 if(lists.length==2){
			 return result;
		 }
		 for(int i=2;i<lists.length;i++){
			 result = merge(result, lists[i]);
		 }
		 
		 return result;
	    }
	 
	 public ListNode merge(ListNode a, ListNode b){
		 
		 if(a==null && b==null){
			 return null;
		 }

		 if(a==null){
			 return b;
		 }
		 if(b==null){
			 return a;
		 }
		 ListNode temp1 = a;
		 ListNode temp2 = b;
		 ListNode result = null;
		 ListNode head = null;
		 while(temp1!=null && temp2!=null){
			 if(temp1.val<temp2.val){
				 ListNode node = new ListNode(temp1.val);
				 if(head==null){
					 head = node;
					 result=node;
				 }else{
					 result.next = node;
					 result=result.next;
				 }
				 
				 temp1=temp1.next;
			 }else if(temp1.val>temp2.val){
				 ListNode node = new ListNode(temp2.val);
				 if(head==null){
					 head = node;
					 result=node;
				 }else{
					 result.next = node;
					 result=result.next;
				 }
				 
				 temp2 = temp2.next;
			 }else{
				 ListNode node1 = new ListNode(temp2.val);
				 ListNode node2 = new ListNode(temp1.val);
				 if(head==null){
					 head = node1;
					 result=node1;
					 result.next = node2;
					 result = result.next;
				 }else{
					 result.next = node1;
					 result=result.next;
					 result.next = node2;
					 result = result.next;
				 }
				 
				 temp1=temp1.next;
				 temp2=temp2.next;
			 }
		 }
		
		 if(temp1==null){
			 result.next = temp2;
		 }
		 else{
			 result.next = temp1;
		 }
		 return head;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
