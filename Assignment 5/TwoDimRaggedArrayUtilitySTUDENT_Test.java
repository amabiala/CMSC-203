import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


class TwoDimRaggedArrayUtilitySTUDENT_Test {

	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
		private double[][] dataSetSTUDENT = {{35.5,33,32,31},{27.4,28},{89,76,54}};
		
		private File inputFile,outputFile;

		@Before
		public void setUp() throws Exception {
			outputFile = new File("TestOut.txt");
		}

		@After
		public void tearDown() throws Exception {
			dataSetSTUDENT = null;
			inputFile = outputFile = null;
		}

		/**
		 * Student Test getTotal method
		 * Return the total of all the elements in the two dimensional array
		 */
		@Test
		public void testGetTotal() {
			assertEquals(405.9,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT),.001);
		}

		/**
		 * Student Test getAverage method
		 * Return the average of all the elements in the two dimensional array
		 */
		@Test
		public void testGetAverage() {
			assertEquals(45.1,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT),.001);	
		}

		/**
		 * Student Test getRowTotal method
		 * Return the total of all the elements of the row.
		 * Row 0 refers to the first row in the two dimensional array
		 */
		@Test
		public void testGetRowTotal() {
			assertEquals(55.4,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,1),.001);
		}


		/**
		 * Student Test getColumnTotal method
		 * Return the total of all the elements in the column. If a row in the two dimensional array
		 * doesn't have this column index, it is not an error, it doesn't participate in this method.
		 * Column 0 refers to the first column in the two dimensional array
		 */
		@Test
		public void testGetColumnTotal() {
			assertEquals(31.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,3),.001);
		}


		/**
		 * Student Test getHighestInArray method
		 * Return the largest of all the elements in the two dimensional array.
		 */
		@Test
		public void testGetHighestInArray() {
			assertEquals(89.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),.001);	
		}
		

		/**
		 * Test the writeToFile method
		 * write the array to the outputFile File
		 * then read it back to make sure formatted correctly to read
		 * 
		 */
		@Test
		public void testWriteToFile() {
			double[][] array=null;
			try {
				TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT, outputFile);
			} catch (Exception e) {
				fail("This should not have caused an Exception");
			}
			// now read from the output file
			try {
				array = TwoDimRaggedArrayUtility.readFile(outputFile);
				assertEquals(35.5, array[0][0], .001);
				assertEquals(33, array[0][1], .001);
				assertEquals(32, array[0][2], .001);
				assertEquals(31, array[0][0], .001);
				assertEquals(27.4, array[1][0], .001);
				assertEquals(28, array[1][1], .001);
				assertEquals(89, array[2][0], .001);
				assertEquals(76, array[2][1], .001);
				assertEquals(54, array[2][0], .001);
			
				
			} catch (FileNotFoundException e) {
				fail("This should not have caused an Exception");
			}
				
		}


}
