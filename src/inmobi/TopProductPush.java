package inmobi;

import java.util.ArrayList;

public class TopProductPush {

	public  ArrayList<Integer> productMatrixToRelevant(String[][] productMatrix, ArrayList<String> trendingTopic){
		// TODO Auto-generated method stub
		
		ArrayList<Integer> indexOfRelevantProducts = new ArrayList<Integer>();
		for (String trend : trendingTopic){
			String[] trendFields = trend.split(",");
		// String topicName = trend[0];
		
			for(int i=0; i<productMatrix.length; i++){
			for (String str: trendFields){
				if (str.equalsIgnoreCase(productMatrix[i][1])){
                   indexOfRelevantProducts.add(i);					
				}
			}
			
		}
		}
		return indexOfRelevantProducts;

	}

}
