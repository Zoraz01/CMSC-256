/**
 * Zoraz Haseeb
 * (04/09/2021)
 * cmsc 256-001
 **/

package cmsc256;

import java.util.Arrays;

public class ArrayUtilities {

	/**
	* Determines the maximum value in the given array of integers
	 * @param nums	array of integers
	 * @return		element with the largest value
	 */
	public static int findMax(int[] nums) {
		// for loop iterates through the array until it finds a max number and assigns it to the max variable
		int max = 0;
		for (int i =0;i < nums.length;i++)
			if(nums[i]> max)
				max = nums[i];

		return max;
	}

	/**
	 * Determines the index of the maximum value in the given array of integers
	 * @param nums	array of integers
	 * @return		index of the element with the largest value
	 */
	public static int findIndexOfMax(int[] nums) {
		// for loop iterates through loop until it finds the max using findMax method. The index of the max is stored
		int maxIndex = 0;
		for (int i =0;i < nums.length;i++)
			if(nums[i]== findMax(nums))
				maxIndex = i;
		return maxIndex;
	}

	/**
	 *  Determines the correct sequence of digits in a matrix of transmissions where
	 *  each row represents a single transmission of single digit characters where
	 *  there may be incorrectly transmitted digits.
	 *
	 * @param multiples	2D array representing multiple rows of single digits
	 * @return			array of the most commonly occurring digit by column
	 */
	public static byte[] extractCorrectArray(byte[][] multiples) {
		// create an array for each row in 2d array
		byte[] temp1 = new byte[5];
		byte[] temp2 = new byte[5];
		byte[] temp3 = new byte[5];
		byte[] temp4 = new byte[5];
		byte[] temp5 = new byte[5];
		byte[] temp6 = new byte[5];
		//For loop iterates through each row and assigns the elements in the array to the temp 1d arrays
		for (int i = 0; i < multiples.length;i++){
			for (int j =0; j < multiples[0].length;j++){
				if( j == 0 ){
					temp1[i] = multiples[i][j];
				}
				if( j ==1){
					temp2[i] = multiples[i][j];
				}
				if ( j == 2){
					temp3[i] = multiples[i][j];
				}
				if ( j == 3){
					temp4[i] = multiples[i][j];
				}
				if ( j == 4){
					temp5[i] = multiples[i][j];
				}
				if ( j == 5){
					temp6[i] = multiples[i][j];
				}
			}
		}
		//Finds most popular element in temp1 array
		int n = temp1.length;

		int countOfMax = 1;
		int temp = temp1[0];
		int count =1;
		for(int i =1;i < temp1.length;i++){
			if(temp1[i] == temp1[i - 1]){
				count++;
			}
			else{
				if(count > countOfMax){
					countOfMax = count;
					temp = temp1[i-1];
				}
				count = 1;
			}
		}
		if( count > countOfMax ){
			countOfMax = count;
			temp = temp1[ n -1];
		}

		//Finds most popular element in temp2 array
		int m = temp2.length;
		int temps2 = temp2[0];
		int count2 =1;
		int countOfMax2 = 1;

		for(int i =1;i < temp2.length;i++){
			if(temp2[i] == temp2[i - 1]){
				count2++;
			}
			else{
				if(count2 > countOfMax2){
					countOfMax2 = count2;
					temps2 = temp2[i-1];
				}
				count2 = 1;
			}
		}
		if( count2 > countOfMax2 ){
			countOfMax2 = count2;
			temps2 = temp2[ m -1];
		}

		//Finds most popular element in temp3 array
		int o = temp3.length;
		int temps3 = temp3[0];
		int count3 =1;
		int countOfMax3 = 1;

		for(int i =1;i < temp3.length;i++){
			if(temp3[i] == temp3[i - 1]){
				count3++;
			}
			else{
				if(count3 > countOfMax3){
					countOfMax3 = count3;
					temps3 = temp3[i-1];
				}
				count3 = 1;
			}
		}
		if( count3 > countOfMax3 ){
			countOfMax3 = count3;
			temps3 = temp3[ m -1];
		}

		//Finds most popular element in temp4 array
		int p = temp4.length;
		int temps4 = temp4[0];
		int count4 =1;
		int countOfMax4 = 1;

		for(int i =1;i < temp4.length;i++){
			if(temp4[i] == temp4[i - 1]){
				count4++;
			}
			else{
				if(count4 > countOfMax4){
					countOfMax4 = count4;
					temps4 = temp4[i-1];
				}
				count4 = 1;
			}
		}
		if( count4 > countOfMax4 ){
			countOfMax4 = count4;
			temps4 = temp4[ p -1];
		}
		//Finds most popular element in temp5 array
		int q = temp5.length;
		int temps5 = temp5[0];
		int count5 =1;
		int countOfMax5 = 1;

		for(int i =1;i < temp5.length;i++){
			if(temp5[i] == temp5[i - 1]){
				count5++;
			}
			else{
				if(count5 > countOfMax5){
					countOfMax5 = count5;
					temps5 = temp5[i+1];
				}
				count5 = 1;
			}
		}
		if( count5 > countOfMax5 ){
			countOfMax5 = count5;
			temps5 = temp5[q-1];
		}

		//Finds most popular element in temp6 array
		int r = temp6.length;
		int temps6 = temp6[0];
		int count6 =1;
		int countOfMax6 = 1;

		for(int i =1;i < temp6.length;i++){
			if(temp6[i] == temp6[i - 1]){
				count6++;
			}
			else{
				if(count6 > countOfMax6){
					countOfMax6 = count6;
					temps6 = temp6[i+1];
				}
				count6 = 1;
			}
		}
		if( count6 > countOfMax6 ){
			countOfMax6 = count6;
			temps6 = temp6[r -1];
		}

		// Correct array is initialized and then correct values assigned
		byte[] correctArray = new byte[6];
		correctArray[0] = (byte) temp;
		correctArray[1] = (byte) temps2;
		correctArray[2] = (byte) temps3;
		correctArray[3] = (byte) temps4;
		correctArray[4] = (byte) temps5;
		correctArray[5] = (byte) temps6;

		return correctArray;
	}

	/**
	 *  Calculates the number of errors in a matrix of transmissions where
	 *  each row represents a single transmission of single digit characters.
	 *
	 * @param matrix	2D array representing multiple rows of single digits
	 * @return			number of errors in matrix
	 */
	public static int countErrors(byte[][] matrix) {
		// correct array is initialized for comparison
		byte [] correctArray = extractCorrectArray(matrix);
		int count = 0;
		//Count is incremented every time the element doesn't match
		for(int i =0; i < matrix.length;i++){
			for(int j = 0; j < matrix[0].length;j++){
				if(correctArray[j] != matrix[i][j]){
					count++;
				}
			}
		}
		return count;
	}

	/**
	 *  Calculates the overall error rate in a matrix of transmissions where
	 *  each row represents a single transmission of single digit characters.
	 *
	 * @param matrix	2D array representing multiple rows of single digits
	 * @return			rate of errors in matrix as a percentage (0 - 100%)
	 */
	 public static double errorRate(byte[][] matrix) {
	 	// for loop to count the amount of elements in 2d array
	 	double count = 0;
		 for(int i =0; i < matrix.length;i++) {
			 for (int j = 0; j < matrix[0].length; j++) {
				 count++;
			 }
		 }

		 // percentage is found after dividing the amount of errors by the amount of elements.
		 int error = countErrors(matrix);
		 double errorRate = (error / count) * 100.00;
		 double rounded = Math.round(errorRate * 100) / 100.0;
		return rounded;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] testFindMax = {1, 42, 35, 50, 75, -6, 89, 4, 12};
		System.out.println("Testing findMax: Expected is 89 - Observed is "
				+  ArrayUtilities.findMax(testFindMax));
		System.out.println("Testing findIndexOfMax: Expected is 6 - Observed is "
				+  ArrayUtilities.findIndexOfMax(testFindMax));

		byte[][] testTransmission = {
									{5, 2, 9, 3, 7, 5},
									{5, 2, 1, 3, 7, 5},
									{5, 2, 1, 3, 1, 1},
									{5, 4, 4, 3, 7, 5},
									{7, 2, 1, 8, 7, 5}
									};
		int[] correctRow = {5, 2, 1, 3, 7, 5};
		System.out.println("Testing extractCorrectArray:\n  Expected is "
				+ Arrays.toString(correctRow) +	"\n  Observed is "
				+  Arrays.toString(ArrayUtilities.extractCorrectArray(testTransmission)));

		System.out.println("Testing countErrors: Expected is 7 - Observed is "
				+ ArrayUtilities.countErrors(testTransmission));

		System.out.println("Testing errorRate: Expected is approx. 23.33% - Observed is "
				+ ArrayUtilities.errorRate(testTransmission) + "%");
	}

}
