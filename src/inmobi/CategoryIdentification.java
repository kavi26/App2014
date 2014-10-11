package inmobi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CategoryIdentification {

	
	public static void main(String[] args) throws IOException, NullPointerException {
		// TODO Auto-generated method stub
		
		try {
			
			// file for writing output
			File file = new File("D://Users/vineek/Desktop/topicAndCategories.txt");
			
			// if file dosen't exists create
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter outfw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter outbw = new BufferedWriter(outfw);
			
			
			// reading Topic and Text File
			FileReader topicText = new FileReader("D://Users/vineek/Desktop/topic_text.csv");
			BufferedReader brTopic = new BufferedReader(topicText);
			String topicLine;
			String[] nameText;
			
			ArrayList<String> categoryList = new ArrayList<String>();
			FileReader categories = new FileReader("D://Users/vineek/Desktop/categories_new.txt");
			BufferedReader brcat = new BufferedReader(categories);
			String category;
			
			while((category = brcat.readLine()) != null){
				categoryList.add(category);
			}
			
			while((topicLine = brTopic.readLine()) != null){
				
				nameText = topicLine.split(",");
				
				String trendingTopic = nameText[0];
				String trendText = nameText[2].concat(nameText[6]);
				trendText = trendText.replaceAll("\"","");
                //String trendText = nameText[2].concat(nameText[7]);	
                trendText = trendText.replaceAll("[\\d[^\\w\\s]]+", " ").replaceAll("(\\s{2,})", " ");
                trendText = trendText.replaceAll("\\p{Punct}|\\d", "");
                String[] textWords = trendText.split(" ");
                ArrayList<String> topicCategories = new ArrayList<String>();
                
                for(String str : textWords){
                	for(String eachcategory: categoryList){
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
                System.out.println(topicAllCategories);
                outbw.write(topicAllCategories);
                outbw.close();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
