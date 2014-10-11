package inmobi;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductFilteringByReviewsRatings {

	public static ArrayList<String> filterByReviews(String[][] productMatrix, int[] indexOfRelevantProducts) {
		
		ArrayList<String> listOfRecommendedProducts = new ArrayList<String>();
		HashMap<String, ArrayList<Integer>> categoryAllProducts = new HashMap<String, ArrayList<Integer>>();
		ArrayList<String> tagCategories = new ArrayList<String>();
		//list of unique categories
		for(int i=0; i < indexOfRelevantProducts.length; i++){
		   if (!(tagCategories.contains(productMatrix[i][1]))){
			   tagCategories.add(productMatrix[i][1]);
		   }
		}
		
		for(String category: tagCategories){
			ArrayList<Integer> thisCategoryIndex = new ArrayList<Integer>();
			for(int i=0; i < indexOfRelevantProducts.length; i++){
				if(category.equalsIgnoreCase(productMatrix[i][1])){
					thisCategoryIndex.add(i);
				}
			}
			categoryAllProducts.put(category,thisCategoryIndex);
		}
		
		for (String category : categoryAllProducts.keySet()){
              ArrayList<Integer> allProductsForthis = categoryAllProducts.get(category);
              for(int i: allProductsForthis){
            	  if (Integer.parseInt(productMatrix[i][2])>= 4 && Integer.parseInt(productMatrix[i][3])>=10){
            		  String idCategoryRatingReview = productMatrix[i][0]+ ","+ productMatrix[i][1] + ","+ 
            	                                      productMatrix[i][2] + ","+ productMatrix[i][3];
            		  listOfRecommendedProducts.add(idCategoryRatingReview);
            	  }
              }
		}
		
		return listOfRecommendedProducts;
		

	}

}
