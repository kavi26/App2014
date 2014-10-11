package inmobi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AllProducts {

	@SuppressWarnings({ "unused", "resource" })
	public  String[][] productsForTags() throws IOException {
		// TODO Auto-generated method stub
		
		FileReader productdataset = new FileReader("D://Users/vineek/Desktop/amzdata.txt");
		BufferedReader productbw = new BufferedReader(productdataset);
		String eachLine;
		int count = 0;
		int numberOfProducts = 0;
		String[][] allProductsTagsRating = new String[1000][4];
		while((eachLine = productbw.readLine()) != null && count < 1000){
			// for each product find its category
			if (eachLine.contains("Id")){
				String[] idLine = eachLine.split(" ");
				allProductsTagsRating[count][0] = (idLine[idLine.length-1]);
			}
			else if (eachLine.contains("group")){
				String[] groupLine = eachLine.split(" ");
				allProductsTagsRating[count][1] = (groupLine[groupLine.length-1]);
				
			}
			else if (eachLine.contains("avg rating")){
				
				String[] ratingLine = eachLine.split(" ");
			    allProductsTagsRating[count][2] = ratingLine[ratingLine.length-1];
			    allProductsTagsRating[count][3] = ratingLine[ratingLine.length-8]; // number of reviews
			}
			
		    if (eachLine.isEmpty()){
		    	count++;
		    }
		    
		    
		   }
		
		return allProductsTagsRating;
		
		//return allProductsTagsRating;
		}
}
