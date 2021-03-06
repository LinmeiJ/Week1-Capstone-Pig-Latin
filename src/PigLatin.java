
import java.util.Scanner;

/******************** Author: Linmei Mills *****************************/
/* Describtion: (What this program can do)
 * 1. It can take mutilple words as one string and translate them all in Pig Latin.
 * 2. It will only take string text(alphabets, periods and commas only).
 * 3. It takes punctuations: comma and period only, and also output them at corresponding postition.
 * 4. It keeps letter case in the same way as how user enterd: 
 * 		 For instance: 1)If a word in string is all capitalized, output is also all capital. 
 * 					   2)If the first letter of each word is capitalized, the first letter of
 * 					      each word in Pig Latin will also be capitalized. Otherwise, everything
 * 					      will be in lower case.
 * 5. It can translate words with contractions. 
 * 6. It can check if the user has actually entered text before translate.
 * 7. It asks user whether to continue use this program.
 */
public class PigLatin {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String userInput;
		System.out.println("Welcome to the pig Latin Translator! \n");

		String userContinue = "y";
		while (userContinue.equalsIgnoreCase("y")) {
			System.out.println("Enter a line to be translated: ");
			userInput = sc.nextLine();
			String pigLatin = "";
			userContinue = checkEmptyStr(userInput, userContinue, pigLatin);
		}
		System.out.println("Goodbye!");
	}
	

	public static String checkEmptyStr(String userInput, String userContinue, String pigLatin) {
		String punctuation;
		if(!(userInput.isEmpty()) && userInput.trim().length() > 0) {
			String[] arr = userInput.split(" ");
			
			for (int i = 0; i < arr.length; i++) {
				punctuation = checkPunctuation(arr[i]);
				arr[i] = removePunctuation(arr[i]);
				pigLatin = checkTextOnlyEntry(userInput, userContinue, punctuation, arr, pigLatin, i);
			}
			if(pigLatin != "y") {
				System.out.println(pigLatin);
				System.out.println("Translate another line? (y/n): ");
				userContinue = sc.nextLine();
				while(!Character.toString(userContinue.charAt(0)).matches("[ynYN]+")) {
					System.out.println("Please enter 'y' to continue or 'n' to quit.");
					userContinue = sc.nextLine();
				}
			}
		}else{
				System.out.println("Line is empty.");
				userContinue = "y";
		}
		return userContinue;
	}
	
	public static String checkPunctuation(String userStr) {
		String endStr;
		if ((userStr.substring(userStr.length() - 1).contentEquals("."))) {
			endStr = ".";
		} else if ((userStr.substring(userStr.length() - 1).contentEquals(","))) {
			endStr = ",";
		} else {
			endStr = "";
		}
		return endStr;
	}
	
	public static String removePunctuation(String userStr) {
		if (userStr.contains(".")) {
			return userStr = userStr.substring(0, userStr.length() - 1);
		} else if (userStr.contains(",")) {
			return userStr = userStr.substring(0, userStr.length() - 1);
		} else {
			return userStr;
		}
	}
	
	public static String checkTextOnlyEntry(String userInput, String userContinue, String punctuation, String[] arr,
			String pigLatin, int i) {
		String word;
		if(arr[i].matches("[a-zA-Z . ,]+")) {
			word = checkLetterCase(userInput, arr[i]);
			pigLatin += word + punctuation + " ";
			pigLatin = pigLatin.substring(0, pigLatin.length());
			return pigLatin;
			}else{
			System.out.println("Please enter a valid string.");
			return "y";
		}
	}
	
	public static String checkLetterCase(String userStr, String word) {
		String pigLatin;
		if ((word.toUpperCase()).equals(word)) {
			pigLatin = translateStr(word).toUpperCase();
			return pigLatin;
		}else if (Character.isUpperCase(word.charAt(0))) {
			pigLatin = translateStr(word);
			return pigLatin.substring(0, 1).toUpperCase() + pigLatin.substring(1);
		}
		return pigLatin = translateStr(word).toLowerCase();
	}

	public static String translateStr(String word) {
		final String AY = "ay";
		final String WAY = "way";
		String[] vowels = { "a", "e", "i", "o", "u" };
		String newStr;
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			for (int j = 0; j < vowels.length; j++) {
				String letter = Character.toString(word.charAt(i));
				String vowel = vowels[j];
				if (letter.equalsIgnoreCase(vowel) && i == 0) {
					return newStr = word.concat(WAY);
				} else if (letter.equalsIgnoreCase(vowel)) {
					int letterIndex = i;
					String wordSplitL = word.substring(0, letterIndex);
					String wordSplitR = word.substring(letterIndex);
					return newStr = wordSplitR + wordSplitL + AY;
				}
			}
		}
		return newStr = word.substring(1) + word.charAt(0) + AY;
	}
}
