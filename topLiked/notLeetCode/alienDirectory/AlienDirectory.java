package alienDirectory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class Graph{
	int vertices;
	LinkedList<Integer>[] adjacent;
	
	Graph(int v){
		
		this.vertices =v;
		
		this.adjacent = new LinkedList[v];
		
		for(int i=0;i<v;i++){
			this.adjacent[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int vertex, int edge){
		this.adjacent[vertex].add(edge);
	}
}
public class AlienDirectory {

	
	public void printOrder(String[] words, int numberOfAlphabates){
		
		Graph graph = createGraph(words, numberOfAlphabates);
		
		topologicalSort(graph);
	}
	public Graph createGraph(String[] words, int numberOfAlphabates){
		
		Graph graph = new Graph(numberOfAlphabates);
		
		for(int i=0;i<words.length-1;i++){
			String word1 = words[i];
			String word2 = words[i+1];
			
			for(int j=0;j<Math.min(word1.length(), word2.length());j++){
				
				if(word1.charAt(j)-'a'!=word2.charAt(j)-'a'){
					graph.adjacent[word1.charAt(j)-'a'].add(word2.charAt(j)-'a');
					break;
				}
			}
		}
		
		return graph;
	}
	
	public void topologicalSort(Graph graph){
		
		boolean[] visited = new boolean[graph.vertices];
		
		Stack<Integer> stack = new Stack<Integer>();
		
		topologicalSortUtil(graph,0,visited,stack);
		
		while(!stack.isEmpty()){
			
			System.out.println((char)('a'+stack.pop())+" ");
		}
	}
	
	
	private void topologicalSortUtil(Graph graph, int i, boolean[] visited, Stack<Integer> stack) {
		
		visited[i] = true;
		
		Iterator<Integer> it = graph.adjacent[i].listIterator();
		
		while(it.hasNext()){
			if(!visited[it.next()]){
				topologicalSortUtil(graph,it.next(),visited,stack);
			}
		}
		
		stack.push(i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = {"baa", "abcd", "abca", "cab", "cad"};
		
		AlienDirectory obj = new AlienDirectory();
		
		obj.printOrder(words, 3);
	}

}
