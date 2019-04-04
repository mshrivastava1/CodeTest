package mix;

public class DailyTemperatures {

	public int[] dailyTemperatures(int[] T) {

		if(T==null || T.length==0){
			return (new int[0]);
		}
		
		int[] result = new int[T.length];
		
		for(int i=0;i<T.length;i++){
			int j = i+1;
			int count = 0;
			while(j<T.length){
				if(T[i]<T[j]){
					count++;
					break;
				}
				count++;
				j++;
			}
			
			if(j==T.length){
				result[i] = 0;
			}else{
				result[i]=count;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
		
		DailyTemperatures obj = new DailyTemperatures();
		
		System.out.println(obj.dailyTemperatures(T));
	}

}
