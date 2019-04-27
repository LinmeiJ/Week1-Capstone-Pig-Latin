import java.util.Scanner;

/******************** Author: Linmei Mills *********************************/
public class PigLatin {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {	
		
		boolean isUpper, isAllUpper;
		String userStr;
		String[] ch = {"a", "e", "i", "o", "u"};
		System.out.println("Welcome to the pig Latin Translator! \n");
		
		String userInput = "y";
		while(userInput.equalsIgnoreCase("y")) {
		
			userStr = getStrAndcheckEmptyStr();
			
			isUpper = Character.isUpperCase(userStr.charAt(0));
			isAllUpper =userStr.toUpperCase().equals(userStr);
			
			System.out.println();
			
			convertToPigLatin(userStr, ch, isUpper, isAllUpper);
			System.out.println(caseKeeper(userStr, ch, isUpper, isAllUpper));
			
			System.out.print("\nContinue(y/n): ");
			userInput = sc.nextLine();
			System.out.println();
		}
		System.out.println("Goodbye!");
	}
	
	
	public static String convertToPigLatin(String str, String[] chr, boolean isUpper, boolean isAllUpper) {
		final String AY = "ay";
		final String WAY = "way";
		int strIndex; 
		String newStr, strPart1, strPart2;
		
		str = str.toLowerCase();
		for(int i = 0; i < str.length(); i++) {
			
			for(int j = 0; j < chr.length; j++) {
				String stri = Character.toString(str.charAt(i));
				String strj = chr[j];
				
				if(stri.equalsIgnoreCase(strj) && i == 0) {  
						newStr = str.concat(WAY);
						return newStr;
				}
				else if(stri.equalsIgnoreCase(strj)){ 
						strIndex = i;
						strPart1 = str.substring(0,strIndex);
						strPart2 = str.substring(strIndex);
						newStr = strPart2 + strPart1 + AY;
						return newStr;
				}
			}
		}
		newStr = str.substring(1)+ str.charAt(0)+ AY;
		return newStr;
	}
	
	
	public static String caseKeeper(String str, String[] chr, boolean isUpper, boolean isAllUpper) {
		String newStrCased;
		newStrCased = convertToPigLatin(str, chr, isUpper, isAllUpper);
		
		if(isAllUpper){
			return "Pig Latin is: " + newStrCased.toUpperCase();
		}
		else if(isUpper) {
			return "Pig Latin is: " + newStrCased.substring(0,1).toUpperCase() + newStrCased.substring(1);
		}
		else
			return newStrCased;
	}
	
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
	
