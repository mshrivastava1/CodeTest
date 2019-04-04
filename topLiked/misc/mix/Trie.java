package mix;

import java.util.HashMap;
import java.util.Map;

class TrieNode{
	
	Map<Character, TrieNode> childrens;
	boolean endOfWord;
	
	TrieNode(){
		
		childrens = new HashMap<Character, TrieNode>();
		endOfWord = false;
	}
}
public class Trie {

	TrieNode root;
	
	Trie(){
		this.root = new TrieNode();
	}
	public void insert(String word){
		
		if(word==null || word.isEmpty()){
			return;
		}
		
		TrieNode current = root;
		
		
		for(char c:word.toCharArray()){
			
			TrieNode child = current.childrens.get(c);
			if(child==null){
				child = new TrieNode();
				current.childrens.put(c, child);
			}
			current=child;
		}
		
		current.endOfWord = true;
	}
	
	public boolean search(String word){
		
		if(word==null || word.isEmpty()){
			return false;
		}
		
		TrieNode current = root;
		for(char c:word.toCharArray()){
			TrieNode child = current.childrens.get(c);
			if(child==null){
				return false;
			}
			
			current = child;
		}
		
		if(!current.endOfWord){
			return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = {"cat", "dog", "rat", "mat", "hen", "elephant"};
		
		Trie dataStructure = new Trie();
		
		for(String word: words){
			
			dataStructure.insert(word);
		}
		
		System.out.println(dataStructure.search("god"));
	}

}
