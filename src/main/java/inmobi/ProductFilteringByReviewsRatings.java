package main.java.inmobi;

import java.util.ArrayList;
import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductFilteringByReviewsRatings.
 */
public class ProductFilteringByReviewsRatings {

	/**
	 * Filter by reviews.
	 *
	 * @param productMatrix the product matrix
	 * @param indexOfRelevantProducts the index of relevant products
	 * @return the array list
	 */
	public  ArrayList<String> filterByReviews(String[][] productMatrix, ArrayList<Integer> indexOfRelevantProducts) {
		
		ArrayList<String> listOfRecommendedProducts = new ArrayList<String>();
		HashMap<String, ArrayList<Integer>> categoryAllProducts = new HashMap<String, ArrayList<Integer>>();
		ArrayList<String> tagCategories = new ArrayList<String>();
		//list of unique categories
		for(int i:indexOfRelevantProducts){
		   if (!(tagCategories.contains(productMatrix[i][1]))){
			   tagCategories.add(productMatrix[i][1]);
		   }
		}
		
		for(String category: tagCategories){
			ArrayList<Integer> thisCategoryIndex = new ArrayList<Integer>();
			for(int i:indexOfRelevantProducts){
				if(category.equalsIgnoreCase(productMatrix[i][1])){
					thisCategoryIndex.add(i);
				}
			}
			categoryAllProducts.put(category,thisCategoryIndex);
		}
		
		for (String category : categoryAllProducts.keySet()){
              ArrayList<Integer> allProductsForthis = categoryAllProducts.get(category);
              for(int i: allProductsForthis){
            	  if (Double.parseDouble(productMatrix[i][2])>= 4.5 && Integer.parseInt(productMatrix[i][3])>=10){
            		  String idCategoryRatingReview = productMatrix[i][0]+ ","+ productMatrix[i][1] + ","+ 
            	                                      productMatrix[i][2] + ","+ productMatrix[i][3]+
            	                                      "," + productMatrix[i][4];
            		  listOfRecommendedProducts.add(idCategoryRatingReview);
            	  }
              }
		}
		
		return listOfRecommendedProducts;
		

	}

}
