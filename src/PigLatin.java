import java.util.Scanner;

/******************** Author: Linmei Mills *********************************/
public class PigLatin {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {	
		boolean isUpper, isAllUpper;
		String userStr;
		String[] ch = {"a", "e", "i", "o", "u"};
		System.out.println("Welcome to the pig Latin Translator! \n");
		
	//while loop to ask use whether contunue
		String userInput = "y";
		while(userInput.equalsIgnoreCase("y")) {
		
			userStr = getStrAndcheckEmptyStr();
			String[] splited = userStr.split("\\s+");
			String output = "";
			String plStr;
			
			// splitting string and send each word to get translated into Pig Latin.
			for(int i = 0; i < splited.length; i++) {
				isUpper = Character.isUpperCase(splited[i].charAt(0));
				isAllUpper =splited[i].toUpperCase().equals(splited[i]);
	
				plStr = caseKeeper(splited[i], ch, isUpper, isAllUpper);	
				output += plStr + " ";
			}
			System.out.println("Pig Latin is: " + output);
			
			System.out.print("\nContinue(y/n): ");
			userInput = sc.nextLine();
			System.out.println();
		}
		System.out.println("Goodbye!");
	}
	
	//slice out comma and period
	public static String getCommaAndPeriod(String splitStr) {
		String strEnd;
		if(splitStr.contains(".")) {
			strEnd = ".";
			splitStr = splitStr.substring(0, splitStr.length());
			
		}else if(splitStr.contains(",")) {
			strEnd = ",";
			splitStr =splitStr.substring(0, splitStr.length());
		}else {
			strEnd = "";
		}	
		return strEnd;
	}
	
	//tanslate string to pig Latin
	public static String convertToPigLatin(String str, String[] chr, boolean isUpper, boolean isAllUpper) {
		final String AY = "ay";
		final String WAY = "way";
		int strIndex; 
		String newStr, strPart1, strPart2;
		String strEnd = getCommaAndPeriod(str);
		str = str.toLowerCase();
		for(int i = 0; i < str.length(); i++) {
			
			for(int j = 0; j < chr.length; j++) {
				String stri = Character.toString(str.charAt(i));
				String strj = chr[j];
				
				if(stri.equalsIgnoreCase(strj) && i == 0) {  
						newStr = str.concat(WAY);
						
						return newStr + strEnd;
				}
				else if(stri.equalsIgnoreCase(strj)){ 
						strIndex = i;
						strPart1 = str.substring(0,strIndex);
						strPart2 = str.substring(strIndex);
						newStr = strPart2 + strPart1 + AY + strEnd;
						return newStr;
				}
			}
		}
		newStr = str.substring(1)+ str.charAt(0)+ AY + strEnd;
		return newStr;
	}
	
	/* Thie method is for making the Pig Latin word has the same capitalization pattern as from the orginal string.
	 * Returns a new string that is followed the capitalization pattern. 
	 * Note: Only If the first letter of the string user entered is in capital or the whole string is 
	 *	     in capital, then the translated Pig Latin follows the same capitalization rule(start w/
	 *		 a capital letter or all capital letters). Otherwise, all translated as lower case Pig Latin since
	 * 		 there is no specification to it (on the extended challenges).
	 */
	public static String caseKeeper(String str, String[] chr, boolean isUpper, boolean isAllUpper) {
		String newStrCased;
		newStrCased = convertToPigLatin(str, chr, isUpper, isAllUpper);
		
		if(isAllUpper){
			return newStrCased.toUpperCase();
		}
		else if(isUpper) {
			return newStrCased.substring(0,1).toUpperCase() + newStrCased.substring(1);
		}
		else
			return newStrCased;
	}
	
	
	//get user input
	public static String getStrAndcheckEmptyStr() {
		String userS;
		System.out.println("Enter a line to be translated: ");
		userS = sc.nextLine();
		while(userS.isEmpty()) {
			System.out.println("Entry is empty, try again: ");
			userS = sc.nextLine();
			continue;
		}
		return userS;
	}
	
}
	