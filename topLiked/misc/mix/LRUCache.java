package mix;

import java.util.HashMap;
import java.util.Map;

class Node{
	int val;
	Node next;
	Node prev;
	
	Node(int x){
		this.val = val;
		this.next = this.prev = null;
	}
}

class LinkedList{
	
	Node head;
	Node tail;
	int capacity;
	int size;
	
	
	LinkedList(int capacity){
		this.capacity = capacity;
		this.size = 0;
	}
	
	Node addNode(int val){
		if(head==null){
			Node newNode = new Node(val);
			head=tail=newNode;
			size++;
			return head;
		}else if(size<capacity){
			this.size++;
		}else{
			tail.prev = tail;
			tail.next = null;
		}
		
		Node newNode = new Node(val);
		head.prev = newNode;
		newNode.next = head;
		head = newNode;
		
		return head;
	}
	
	void setTohead(Node node){
		
		if(head==null || head==node){
			return;
		}else if(node==tail){
			tail.prev = tail;
			head.prev = node;
			node.next = head;
			head = node;
		}else{
			Node temp = head;
			
			while(temp!=null){
				if(temp==node){
					break;
				}
				temp=temp.next;
			}
			
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			
			head.prev = node;
			node.next = head;
			head = node;
			
		}
	}
}
public class LRUCache {

	Map<Integer, Node> cache;
	
	LinkedList list;
	
	LRUCache(int capacity){
		this.cache = new HashMap<Integer, Node>();
		this.list = new LinkedList(capacity);
	}
	
	public int get(int key){
		
		if(this.cache.containsKey(key)){
			Node node = this.cache.get(key);
			this.list.setTohead(node);
			return key;
		}else{
			
			Node node = new Node(key);
			this.list.addNode(key);
			return key;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int cacheSize = 4;
        LRUCache cache = new LRUCache(cacheSize);
        cache.get(4);
        cache.get(2);
        cache.get(1);
        cache.get(1);
        cache.get(4);
        cache.get(3);
        cache.get(7);
        cache.get(8);
        cache.get(3);
	}

}
