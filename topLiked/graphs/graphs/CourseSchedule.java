package graphs;

import java.util.ArrayList;

public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites){
		
		ArrayList<Integer>[] graph = new ArrayList[numCourses];
		
		for(int i=0;i<numCourses;i++){
			graph[i] = new ArrayList<Integer>();
		}
		
		/* for(int[] pre : prerequisites) {
	            graph[pre[1]].add(pre[0]);
	        }*/
		
		for(int i=0;i<prerequisites.length;i++){
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
		}
		
		boolean[] visited = new boolean[numCourses];
		boolean[] recusiveTrack = new boolean[numCourses];
		
		for(int i=0;i<numCourses;i++){
			if(!visited[i]){
				if(dfsUtil(graph,visited,recusiveTrack,i)){
					return false;
				}
			}
		}

		return true;
	}
	public boolean dfsUtil(ArrayList<Integer>[] graph, boolean[] visited, boolean[] recusiveTrack, int i) {

		visited[i] = true;
		recusiveTrack[i] = true;
		
		for(int k=0;k<graph[i].size();k++){
			int adj = graph[i].get(k);
			if(!visited[adj] && dfsUtil(graph, visited, recusiveTrack, adj)){
				return true;
			}else if(recusiveTrack[adj]){
				return true;
			}
		}
		
		recusiveTrack[i] = false;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numCourses = 3;
		int[][] prerequisites = {{1,0},{2,1},{2,0}};
		
		CourseSchedule obj = new CourseSchedule();
		
		System.out.println(obj.canFinish(numCourses, prerequisites));
		
	}

}
