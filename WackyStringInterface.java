package cmsc256;

/**
 * This is an interface for a class that represents a string,
 * defined as a sequence of characters. It provides methods
 * that
 */
public interface WackyStringInterface {

	/**
	 * Sets the value of the current string.
	 *
	 * @param string
	 *            The value to be set
	 */
	public void setWackyString(String string);

	/**
	 * Returns the current string
	 *
	 * @return Current string
	 */
	public String getWackyString();


	/**
	 * Returns the number occurrences of VCU or Rams in this string
	 *
	 * @return Number of times either "VCU" all caps, 
	 * 				or "Rams". case insensitive occur in this string
	 */
	public int countVCURams();



	/**
	 * Returns true if the instance string contains "rams" starting at index 0 or 1 in the 
	 * string, such as with "ramsxxx" or "xramsxx" but not "xxramsxx".
	 */
	public boolean hasRams();



	/**
	 * Consider the prefix string made of the first N chars of the string. 
	 * Does that prefix string appear somewhere else in the string? 
	 *
	 * @return true  	if the first n digits of this string are 
	 * 					present elsewhere in the string
	 * 	        		Returns false otherwise.
	 */
	public boolean hasRepeatingPrefix(int numChars);


	/**
	 * Convert this string to a numerically altered version with 
	 * the following substitutions:
	 * 		Upper and lower case 'i' are replaced with number 1
	 * 		Upper and lower case 'e' are replaced with number 3
	 * 		Upper and lower case 's' are replaced with number 5
	 * 		Upper and lower case 'o' are replaced with number 0
	 *
	 * @return	String  	containing altered instance string
	 */
	public String makeNumberSubstitutions();


	/**
	 * Returns a version of the instance string where all occurrences of the 
	 * word "not" have been removed. 
	 * If there is a space after the "not" remove it, too.
	 *
	 * @return 	String  		the altered string with "not" removed
	 */
	public String removeNot();
}
