
import java.util.Scanner;

/******************** Author: Linmei Mills *********************************/
public class PigLatin {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
//		boolean isUp;
//		boolean isAllUp;
		String userInput;
		System.out.println("Welcome to the pig Latin Translator! \n");
		
	//while loop to ask use whether contunue
		String userContinue = "y";
		while(userContinue.equalsIgnoreCase("y")) {
			System.out.println("Enter a line to be translated: ");
			userInput = sc.nextLine();
			String punctuation = "";
			 //comma or period
			
			String[] arr = userInput.split(" ");
			String pigLatin = "";
			for(int i = 0; i < arr.length; i++) {
				punctuation= checkPunctuation(arr[i]);
				arr[i] = removePunctuation(arr[i]);
				String word = checkLetterCase(userInput, arr[i]);
				pigLatin += word + " "; 
			}
			 // check if the last index is empty
			pigLatin = pigLatin.substring(0, pigLatin.length()); // remove the last space
			
			pigLatin = pigLatin.substring(0, pigLatin.length());
			System.out.println(pigLatin + punctuation);
			
			System.out.println("Translate another line? (y/n): ");
			userContinue = sc.nextLine();
		}
		System.out.println("Goodbye!");
	}
	
	public static String checkPunctuation(String userStr) {
		String endStr;
		if((userStr.substring(userStr.length() - 1).contentEquals("."))){ //not contain, check the word for ech ending!!!
			endStr= ".";
		}else if(userStr.contains(",")) {
			endStr = ",";
		}else {
			endStr = "";
		}	
		return endStr;
	}
	
	public static String removePunctuation(String userStr) {
		if(userStr.contains(".")) {
			return userStr = userStr.substring(0, userStr.length()-2);	
		}else if(userStr.contains(",")) {
			return userStr = userStr.substring(0, userStr.length()-2);
		}else {
			return userStr;
		}
	}
	
	/*****************String method:  checkLetterCase() ***************************/
	public static String checkLetterCase(String userStr, String word) {
		String pigLatin;
		if((userStr.toUpperCase()).equals(userStr)){
			pigLatin = translateStr(word).toUpperCase();
			return pigLatin;
		}
		
		else if(Character.isUpperCase(userStr.charAt(0))){
			pigLatin = translateStr(word);
			return pigLatin.substring(0,1).toUpperCase() + pigLatin.substring(1);
		}
		
		return pigLatin = translateStr(word).toLowerCase();
	}
	
	public static String translateStr(String word) {
		final String AY = "ay";
		final String WAY = "way";
		String[] vowels = {"a", "e", "i", "o", "u"};
		String newStr;
		word = word.toLowerCase(); //convert string to lower case
		for(int i =0; i < word.length(); i++) {
			for(int j = 0; j < vowels.length; j++) {
				String letter = Character.toString(word.charAt(i));
				String vowel = vowels[j];
				if(letter.equalsIgnoreCase(vowel) && i == 0) {
					return newStr = word.concat(WAY);
				}
				else if(letter.equalsIgnoreCase(vowel)) {
					int letterIndex = i;
					String wordSplitL= word.substring(0, letterIndex + 1);
					String wordSplitR= word.substring(letterIndex);
					return newStr =  wordSplitR + wordSplitL + AY;
				}
			}
		}
		return newStr = word.substring(1) + word.charAt(0) + AY ;
	}
}












