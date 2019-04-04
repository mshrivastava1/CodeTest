package mix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import javafx.scene.shape.Cylinder;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {

		if(tasks==null || tasks.length<1){
			return 0;
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(char c:tasks){
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b)->b-a);
		
		queue.addAll(map.values());
		int cycle = 0;
		while(!queue.isEmpty()){
			
			List<Integer> list = new ArrayList<Integer>();
			
			for(int i=0;i<=n;i++){
				if(!queue.isEmpty()){
					list.add(queue.remove());
				}
			}
			
			for(int i:list){
				if(--i>0){
					queue.add(i);
				}
			}
			
			cycle += queue.isEmpty()?list.size():n+1;
		}
		
		return cycle;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] tasks = {'A','A','A','B','B','C'};
		int n = 2;
		
		TaskScheduler task = new TaskScheduler();
		
		
		System.out.println(task.leastInterval(tasks, n));
	}

}
