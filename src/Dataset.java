import java.awt.Robot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Dataset{
	// Get authors and contents from dataset
	public static HashMap<String, List<String>> readFiles(){
		// To store authors and content
		List<String> authors = new ArrayList<String>();
		List<String> contents = new ArrayList<String>();
		
		// Data path
		// String path = "C:/Users/MSI/Workspace Java/HotelReview/Resources/Before/";
		String path = "C:/Users/MSI/Workspace Java/HotelReview/Test/";
		
		// Data folder
		File folder = new File(path);
		
		// Store all files of the folder
		File [] files = folder.listFiles();
		
		for(int i = 0; i < files.length; i++){
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
		// Stop words
		List<String> stopwords = new ArrayList<String>();
		stopwords.addAll(Arrays.asList("a", "about", "above", "above", "across", "after", "afterwards", "again", "against", "all", "almost", "alone", "along", "already", "also","although","always","am","among", "amongst", "amoungst", "amount",  "an", "and", "another", "any","anyhow","anyone","anything","anyway", "anywhere", "are", "around", "as",  "at", "back","be","became", "because","become","becomes", "becoming", "been", "before", "beforehand", "behind", "being", "below", "beside", "besides", "between", "beyond", "bill", "both", "bottom","but", "by", "call", "can", "cannot", "cant", "co", "con", "could", "couldnt", "cry", "de", "describe", "detail", "do", "done", "down", "due", "during", "each", "eg", "eight", "either", "eleven","else", "elsewhere", "empty", "enough", "etc", "even", "ever", "every", "everyone", "everything", "everywhere", "except", "few", "fifteen", "fify", "fill", "find", "fire", "first", "five", "for", "former", "formerly", "forty", "found", "four", "from", "front", "full", "further", "get", "give", "go", "had", "has", "hasnt", "have", "he", "hence", "her", "here", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "him", "himself", "his", "how", "however", "hundred", "ie", "if", "in", "inc", "indeed", "interest", "into", "is", "it", "its", "itself", "keep", "last", "latter", "latterly", "least", "less", "ltd", "made", "many", "may", "me", "meanwhile", "might", "mill", "mine", "more", "moreover", "most", "mostly", "move", "much", "must", "my", "myself", "name", "namely", "neither", "never", "nevertheless", "next", "nine", "no", "nobody", "none", "noone", "nor", "not", "nothing", "now", "nowhere", "of", "off", "often", "on", "once", "one", "only", "onto", "or", "other", "others", "otherwise", "our", "ours", "ourselves", "out", "over", "own","part", "per", "perhaps", "please", "put", "rather", "re", "same", "see", "seem", "seemed", "seeming", "seems", "serious", "several", "she", "should", "show", "side", "since", "sincere", "six", "sixty", "so", "some", "somehow", "someone", "something", "sometime", "sometimes", "somewhere", "still", "such", "system", "take", "ten", "than", "that", "the", "their", "them", "themselves", "then", "thence", "there", "thereafter", "thereby", "therefore", "therein", "thereupon", "these", "they", "thickv", "thin", "third", "this", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "top", "toward", "towards", "twelve", "twenty", "two", "un", "under", "until", "up", "upon", "us", "very", "via", "was", "we", "well", "were", "what", "whatever", "when", "whence", "whenever", "where", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whoever", "whole", "whom", "whose", "why", "will", "with", "within", "without", "would", "yet", "you", "your", "yours", "yourself", "yourselves", "the"));
		
		List<String> toRet = new ArrayList<String>();
		
		// To lower case
		data = convertToLowerCase(data);
		
		for(String line : data){
			String clean = "";
			String [] words = line.split(" ");
			
			for(String word : words){
				if(!stopwords.contains(word)){
					clean += word + " ";
				}
			}
			
			toRet.add(clean);
		}
		
		return toRet;
	}
	
	// To lower case
	public static List<String> convertToLowerCase(List<String> data){
		List<String> toRet = new ArrayList<String>();
		
		for(String s : data){
			toRet.add(s.toLowerCase());
		}
		
		return toRet;
	}
	
	// Take how many times each word appear
	public static HashMap<String, Integer> occurrences(List<String> data){
		HashMap<String, Integer> toRet = new HashMap<String, Integer>();
		
		for(String s : data){
			String [] words = s.split(" ");
			for(String word : words){
				if(!toRet.containsKey(word)){
					toRet.put(word, 1);
				}else{
					toRet.put(word, toRet.get(word) + 1);
				}
			}
		}
		
		return toRet;
	}
}