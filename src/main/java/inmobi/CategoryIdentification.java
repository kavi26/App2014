/*
 * 
 */
package main.java.inmobi;

import java.io.IOException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoryIdentification.
 */
public class CategoryIdentification {

	
	/**
	 * Cat tag.
	 *
	 * @param topicLine the topic line
	 * @param catList the cat list
	 * @return the array list
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws NullPointerException the null pointer exception
	 */
	public  ArrayList<String> catTag(String topicLine, ArrayList<String> catList) throws IOException, NullPointerException {
		
		
		
			    String[] nameText = topicLine.split(",");
				ArrayList<String> alltrendsCategories = new ArrayList<String>();
				String trendingTopic = nameText[0];
				String trendText = nameText[2].concat(nameText[7]);
				trendText = trendText.replaceAll("\"","");
				
                //String trendText = nameText[2].concat(nameText[7]);	
                trendText = trendText.replaceAll("[\\d[^\\w\\s]]+", " ").replaceAll("(\\s{2,})", " ");
                trendText = trendText.replaceAll("\\p{Punct}|\\d", "");
                String[] textWords = trendText.split(" ");
                ArrayList<String> topicCategories = new ArrayList<String>();
                
                for(String str : textWords){
                	for(String eachcategory: catList){
                		String[] main = eachcategory.split(",");
                		for(int i=0; i<main.length; i++){
                         if(main[i].equals(str.toLowerCase())){
                		if (!(topicCategories.contains(main[0]))){
                		topicCategories.add(main[0]);
                	}
                	}
                }
                }
                }
                
                String topicAllCategories = trendingTopic;
                for (String eachCat : topicCategories){
                	topicAllCategories = topicAllCategories.concat("," + eachCat);
                	
                }
                
                alltrendsCategories.add(topicAllCategories);
                
                return alltrendsCategories;
		}
}
