package inmobi;

import java.io.IOException;
import java.util.ArrayList;

public class CategoryIdentification {

	
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
                        if (eachcategory.contains(str.toLowerCase())){
                		if (!(topicCategories.contains(str))){
                		topicCategories.add(str);
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
