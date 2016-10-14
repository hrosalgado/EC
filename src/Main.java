import java.util.HashMap;
import java.util.List;

public class Main{
	/*public static void readFiles(){
		// Store data: author and content
		List<String> authors = new ArrayList<String>();
		List<String> contents = new ArrayList<String>();
		
		String path = "C:/Users/MSI/Workspace Java/Hotel/Resources/Before/";
		
		File folder = new File(path);
		File [] files = folder.listFiles();
		
		for(int i = 0; i < files.length; i++){
			String name = files[i].getName();
			
			try{
				BufferedReader reader = new BufferedReader(new FileReader(path + name));
				String currentLine;
				
				while((currentLine = reader.readLine()) != null){
					if(!currentLine.isEmpty()){
						int startField = currentLine.indexOf('<');
						int endField = currentLine.indexOf('>');
						
						if(startField > 0 || endField > 0){
							String field = currentLine.substring(startField + 1, endField);
							String value = currentLine.substring(endField + 1);
							
							switch(field){
								case "Author":
									authors.add(value);
									break;

								case "Content":
									contents.add(value);
									break;
							}
						}
					}
				}
			}catch(IOException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		// Clean content
		String [] stopwords = {"a", "about", "above", "above", "across", "after", "afterwards", "again", "against", "all", "almost", "alone", "along", "already", "also","although","always","am","among", "amongst", "amoungst", "amount",  "an", "and", "another", "any","anyhow","anyone","anything","anyway", "anywhere", "are", "around", "as",  "at", "back","be","became", "because","become","becomes", "becoming", "been", "before", "beforehand", "behind", "being", "below", "beside", "besides", "between", "beyond", "bill", "both", "bottom","but", "by", "call", "can", "cannot", "cant", "co", "con", "could", "couldnt", "cry", "de", "describe", "detail", "do", "done", "down", "due", "during", "each", "eg", "eight", "either", "eleven","else", "elsewhere", "empty", "enough", "etc", "even", "ever", "every", "everyone", "everything", "everywhere", "except", "few", "fifteen", "fify", "fill", "find", "fire", "first", "five", "for", "former", "formerly", "forty", "found", "four", "from", "front", "full", "further", "get", "give", "go", "had", "has", "hasnt", "have", "he", "hence", "her", "here", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "him", "himself", "his", "how", "however", "hundred", "ie", "if", "in", "inc", "indeed", "interest", "into", "is", "it", "its", "itself", "keep", "last", "latter", "latterly", "least", "less", "ltd", "made", "many", "may", "me", "meanwhile", "might", "mill", "mine", "more", "moreover", "most", "mostly", "move", "much", "must", "my", "myself", "name", "namely", "neither", "never", "nevertheless", "next", "nine", "no", "nobody", "none", "noone", "nor", "not", "nothing", "now", "nowhere", "of", "off", "often", "on", "once", "one", "only", "onto", "or", "other", "others", "otherwise", "our", "ours", "ourselves", "out", "over", "own","part", "per", "perhaps", "please", "put", "rather", "re", "same", "see", "seem", "seemed", "seeming", "seems", "serious", "several", "she", "should", "show", "side", "since", "sincere", "six", "sixty", "so", "some", "somehow", "someone", "something", "sometime", "sometimes", "somewhere", "still", "such", "system", "take", "ten", "than", "that", "the", "their", "them", "themselves", "then", "thence", "there", "thereafter", "thereby", "therefore", "therein", "thereupon", "these", "they", "thickv", "thin", "third", "this", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "top", "toward", "towards", "twelve", "twenty", "two", "un", "under", "until", "up", "upon", "us", "very", "via", "was", "we", "well", "were", "what", "whatever", "when", "whence", "whenever", "where", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whoever", "whole", "whom", "whose", "why", "will", "with", "within", "without", "would", "yet", "you", "your", "yours", "yourself", "yourselves", "the"};
		
		List<String> modContents = new ArrayList<String>();
		
		for(int i = 0; i < contents.size(); i++){
			String content = contents.get(i).replaceAll("[.|:|,|;|¡|!|¿|?|(|)|{|}|+|*|/|@|#|$|%|&|=]", "");
			modContents.add(content);
		}
		
		for(int i = 0; i < modContents.size(); i++){
			List<String> modWords = new ArrayList<String>();
			
			String [] words = modContents.get(i).split(" ");
			
			List<String> wordsList = new ArrayList<String>();
			for(String word : words){
				wordsList.add(word.toLowerCase());
			}
			
			boolean flag = false;
			for(String word : wordsList){
				for(String stopword : stopwords){
					if(stopword.contentEquals(word)){
						flag = true;
					}
				}
				if(!flag){
					modWords.add(word);
				}else{
					flag = false;
				}
			}
		}
	}*/
	
	public static void main(String [] args){
		HashMap<String, List<String>> data = Dataset.readFiles();
	}
}