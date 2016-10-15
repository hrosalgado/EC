import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dataset{
	// Get authors and contents from dataset
	public static HashMap<String, List<String>> readFiles(){
		// To store authors and content
		List<String> authors = new ArrayList<String>();
		List<String> contents = new ArrayList<String>();
		
		// Data path
		String path = "C:/Users/MSI/Workspace Java/HotelReview/Resources/Before/";
		
		// Data folder
		File folder = new File(path);
		
		// Store all files of the folder
		File [] files = folder.listFiles();
		
		for(int i = 0; i < 1; i++){
			// File name
			String name = files[i].getName();
			
			try{
				// Read file
				BufferedReader reader = new BufferedReader(new FileReader(path + name));
				
				String currentLine;
				
				while((currentLine = reader.readLine()) != null){
					if(!currentLine.isEmpty()){
						// Take field (between <>)
						int startField = currentLine.indexOf('<');
						int endField = currentLine.indexOf('>');
						
						if(startField > 0 || endField > 0){
							String field = currentLine.substring(startField + 1, endField);
							String value = currentLine.substring(endField + 1);
							
							// Store author and content
							if(field.equals("Author")){
								authors.add(value);
							}else if(field.equals("Content")){
								contents.add(value);
							}
						}
					}
				}
				
				reader.close();
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		// To return authors and content both
		HashMap<String, List<String>> toRet = new HashMap<String, List<String>>();
		
		toRet.put("Authors", authors);
		toRet.put("Contents", contents);
		
		return toRet;
	}
	
	// Delete special characters
	public static List<String> stem(List<String> data){
		List<String> toRet = new ArrayList<String>();
		
		for(String s : data){
			String stemmed = s.replaceAll("[.|:|,|;|¡|!|¿|?|(|)|{|}|+|*|/|@|#|$|%|&|=]", "");
			stemmed = stemmed.trim();
			
			toRet.add(stemmed);
		}
		
		return toRet;
	}
	
	// Delete stop words
	public static List<String> stopWord(List<String> data){
		List<String> toRet = new ArrayList<String>();
		
		
		
		return toRet;
	}
}