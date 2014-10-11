package inmobi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class farzi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
      
		FileReader productdataset = new FileReader("D://Users/vineek/Desktop/amazon-meta.txt");
		BufferedReader productbw = new BufferedReader(productdataset);
		
		String line;
		
		while((line = productbw.readLine()) != "Id:	1000"){
			System.out.println(line);
		}
	}

}
