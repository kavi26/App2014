package inmobi;

import java.util.ArrayList;

public class TopProductPush {

	public static ArrayList<Integer> productMatrixToRelevant(String[][] productMatrix, String trendingTopic){
		// TODO Auto-generated method stub
		
		ArrayList<Integer> indexOfRelevantProducts = new ArrayList<Integer>();
		String[] trend = trendingTopic.split(",");
		// String topicName = trend[0];
		
		
		for(int i=0; i<productMatrix.length; i++){
			for (String str: trend){
				if (str.equalsIgnoreCase(productMatrix[i][1])){
                   indexOfRelevantProducts.add(i);					
				}
			}
			
		}
		return indexOfRelevantProducts;

	}

}
