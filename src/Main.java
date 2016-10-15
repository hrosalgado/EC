import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main{
	public static void main(String [] args){
		// Get data from the dataset (author and content)
		HashMap<String, List<String>> data = Dataset.readFiles();
		
		List<String> authors = data.get("Authors");
		List<String> contents = data.get("Contents");
		
		// Clean content (punctuation marks)
		contents = Dataset.stem(contents);
		
		// Clean content (stop words)
		contents = Dataset.stopWord(contents);
		
		for(String s : contents){
			System.out.println("Line: " + s);
		}
		
		// Take word occurrences
		HashMap<String, Integer> occurrences = Dataset.occurrences(contents);
		
		for(Map.Entry<String, Integer> entry : occurrences.entrySet()) {
		    System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}