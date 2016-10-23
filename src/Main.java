import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main{
	public static void main(String [] args){
		// Take the initial time
		long start = System.currentTimeMillis();
		
		// Get data from the dataset (author and content)
		HashMap<String, List<String>> data = Dataset.readFiles();
		
		List<String> authors = data.get("Authors");
		List<String> contents = data.get("Contents");
		
		// Clean content (punctuation marks)
		contents = Dataset.stem(contents);
		
		// Clean content (stop words)
		contents = Dataset.stopWord(contents);
		
		// Take word occurrences
		HashMap<String, Integer> occurrences = Dataset.occurrences(contents);
		
		// Take the words repeating more
		HashMap<String, Integer> mostRepeated = Dataset.mostRepeated(occurrences);
		
		// For each word, check if the word appears in each content and tick or not
		List<List<String>> saved = Dataset.saveRepetitions(authors, data.get("Contents"), mostRepeated);
		for(List<String> s : saved){
			System.out.println(s);
		}
		
		// Take the last time
		float time = (System.currentTimeMillis() - start) / 1000F;
		System.out.println("Time in seconds: " + time);
	}
}