import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Camron Franklin CMSC204 CRN 36096
 *
 */
public class MorseCodeConverter {
	
	/**
	 * empty constructor
	 */
	public MorseCodeConverter() {
		
	}
	
	/**
	 * Converts morse code tree to string
	 * @return string representation of morse code tree
	 */
	public static String printTree() {
		MorseCodeTree tree = new MorseCodeTree();
		String letters = "";
		
		for (String a: tree.toArrayList())
			letters += a + " ";
		
		return letters.substring(0, letters.length() - 1);
	}
	
	/**
	 * Translates morse code string to english
	 * @param code 
	 * @return String version of converted morse code phrase
	 */
	public static String convertToEnglish(String code) {
		MorseCodeTree tree = new MorseCodeTree();

		String result = "";
		String[] words = code.split("/");
		
		for (String word: words) {
			String[] letters = word.split(" ");
			for (String letter: letters)
				result += tree.fetch(letter);
			result += " ";
		}

		
		return result.substring(0, result.length() - 1);
	}
	
	/**
	 * Reads file and translates processed morse code string
	 * @param file file object to be processed
	 * @return String representation of converted morse code string
	 * @throws FileNotFoundException if file object is invalid
	 */
	public static String convertToEnglish(File file) throws FileNotFoundException {
		MorseCodeTree tree = new MorseCodeTree();
		String result = "";
		Scanner tr;
		
		try {
			tr = new Scanner(file);
			
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}
		while(tr.hasNext()) {
			String[] words = tr.nextLine().split("/");
		
			for(String word: words) {
		
				String[] letters = word.split(" ");
			
				for (String letter: letters)
					result += tree.fetch(letter);
			
				result += " ";
			}
		}
		tr.close();
		return result.substring(0, result.length() - 1);
	}

}
