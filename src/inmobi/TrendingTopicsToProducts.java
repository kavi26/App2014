package inmobi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TrendingTopicsToProducts {

	@SuppressWarnings({ })
	public static void main(String[] args) throws NullPointerException, IOException {
		// TODO Auto-generated method stub
        // read categories
		ArrayList<String> listOfCat = new ArrayList<String>();
		FileReader catfw = new FileReader("D://Users/vineek/Desktop/categories_new.txt");
		@SuppressWarnings("resource")
		BufferedReader catbr = new BufferedReader(catfw);
		String newCat;
		while((newCat = catbr.readLine())!= null){
			listOfCat.add(newCat);
		}
		
		String newTrend = "Amitabh Bachan,h, Book actor travel, w,w,w,w,food";
		
		// taking input trend as csv string
		CategoryIdentification taggingTrendClass = new CategoryIdentification();
		
		ArrayList<String> trendTag = taggingTrendClass.catTag(newTrend, listOfCat);
		//System.out.println(trendTag);
		
		// Got trendTag. Use to find Relevant Products
		
		// first extract {id,category,rating,#review} tuple from data
		AllProducts usefulProductInfo = new AllProducts();
		String[][] productInfoMatrix =  usefulProductInfo.productsForTags();
		//System.out.println(productInfoMatrix[0][1]);
		
		// use productInfoMatrix to get relevant products
		
		TopProductPush getRelevantProducts = new TopProductPush();
		ArrayList<Integer> rowIndexofProducts = getRelevantProducts.productMatrixToRelevant(productInfoMatrix, trendTag);
		//System.out.println(rowIndexofProducts.get(0));
		
		// use this list of rowIndexOfProducts to Filter the Products using reviews and rating
		
		ProductFilteringByReviewsRatings proFilter = new ProductFilteringByReviewsRatings();
		ArrayList<String> recommendedProducts = proFilter.filterByReviews(productInfoMatrix, rowIndexofProducts);
		
		System.out.println(recommendedProducts.get(0));
	}

}
