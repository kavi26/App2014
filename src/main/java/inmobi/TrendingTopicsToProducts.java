package main.java.inmobi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class TrendingTopicsToProducts.
 */
public class TrendingTopicsToProducts {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws NullPointerException the null pointer exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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
		
		String newTrend = "Karva Chauth,1,regional,3,4,5,6,Punjabi women perform rituals food Android as they cricket htc's bowler captain celebrate Karwa Chauth. (Source: PTI). An Indian woman gets her hand decorated with henna ahead of the Hindu festival Karva Chauth in Allahabad, India. (Source: AP). Indian Hindu married women perform rituals on";
		
		// taking input trend as csv string
		CategoryIdentification taggingTrendClass = new CategoryIdentification();
		
		ArrayList<String> trendTag = taggingTrendClass.catTag(newTrend, listOfCat);
		System.out.println(trendTag);
		
		// Got trendTag. Use to find Relevant Products
		
		// first extract {id,category,rating,#review} tuple from data
		AllProducts usefulProductInfo = new AllProducts();
		String[][] productInfoMatrix =  usefulProductInfo.productsForTags();
		System.out.println(productInfoMatrix[267][3]);
		
		// use productInfoMatrix to get relevant products
		
		TopProductPush getRelevantProducts = new TopProductPush();
		ArrayList<Integer> rowIndexofProducts = getRelevantProducts.productMatrixToRelevant(productInfoMatrix, trendTag);
		System.out.println(rowIndexofProducts.get(0));
		
		// use this list of rowIndexOfProducts to Filter the Products using reviews and rating
		
		ProductFilteringByReviewsRatings proFilter = new ProductFilteringByReviewsRatings();
		ArrayList<String> recommendedProducts = proFilter.filterByReviews(productInfoMatrix, rowIndexofProducts);
		
		for (String product: recommendedProducts){
		System.out.println(product);
	}

}
}
