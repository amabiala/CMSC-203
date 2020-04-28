import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class TwoDimRaggedArrayUtility {

	public TwoDimRaggedArrayUtility() {
		
	}
	
	public static double getAverage(double [][] data) {
		
		int indexes = 0;
		double total = 0;
	
		
		for (int i = 0; i < data.length; i++) {
			for (int j=0; j < data[i].length; i++) {
				indexes +=1;
				total+= data[i][j];
			}
			
		}
		
		double average = total / (double) indexes;
		return average;
		
	}
	
	public static double getColumnTotal (double[][] data, int col) {
		
		double total = 0;
		for (int i=0; i < data.length; i++) {
			total+= data[i][col];
		}
		return total;
	}
	
	public static double getHighestInArray(double[][] data) {
		double max = 0.0;
	
		for (int i = 0; i < data.length; i++) {
			for (int j=0; j < data[i].length; i++) {
				if ( max < data[i][j])
					max = data[i][j];
			}
			
		}
		
		return max;
		
	}
		
	public static double getHighestInColumn(double[][] data, int col) {
		double max = 0.0;
		
		for (int i = 0; i < data.length; i++) {
			
			if ( max < data[i][col])
					max = data[i][col];
			
		}
		
		return max;
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double max = 0.0;
		int index = 0 ;
		for (int i = 0; i < data.length; i++) {
			
			if ( max < data[i][col]) {
					max = data[i][col];
					index = i;
			}
			
		}
		
		return index;
	}
	
	public static double getHighestInRow(double[][] data, int row) {
		double max = 0.0;
		for (int i = 0; i < data.length; i++) {
			
			if ( max < data[row][i])
					max = data[row][i];
			
		}
		
		return max;
	}
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		double max = 0.0;
		int index = 0 ;
		for (int i = 0; i < data.length; i++) {
			
			if ( max < data[row][i]) {
					max = data[row][i];
					index = i;
			}
			
		}
		
		return index;
	}
	
	public static double getLowestInArray(double[][] data) {
		double min = 0.0;
	
		for (int i = 0; i < data.length; i++) {
			for (int j=0; j < data[i].length; i++) {
				if ( min > data[i][j])
					min = data[i][j];
			}
			
		}
		
		return min;
		
	}
	
	public static double getLowestInColumn(double[][] data, int col) {
		double min = 0.0;
		
		for (int i = 0; i < data.length; i++) {
			
			if ( min > data[i][col])
					min = data[i][col];
			
		}
		
		return min;
	}
	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double min = 0.0;
		int index = 0 ;
		for (int i = 0; i < data.length; i++) {
			
			if ( min > data[i][col]) {
					min = data[i][col];
					index = i;
			}
			
		}
		
		return index;
	}
	
	public static double getLowestInRow(double[][] data, int row) {
		double min = 0.0;
		for (int i = 0; i < data.length; i++) {
			
			if ( min < data[row][i])
					min = data[row][i];
			
		}
		
		return min;
	}
	
	public static int getLowestInRowIndex(double[][] data, int row) {
		double min = 0.0;
		int index = 0 ;
		for (int i = 0; i < data.length; i++) {
			
			if ( min > data[row][i]) {
					min = data[row][i];
					index = i;
			}
			
		}
		
		return index;
	}
	
	public static double getRowTotal(double[][] data, int row) {
		double total = 0.0;
		for (int i = 0; i < data.length; i++) {
				total += data[row][i];
		}
		
		return total;
	}
	
public static double getTotal(double [][] data) {
		
		double total = 0;
	
		
		for (int i = 0; i < data.length; i++) {
			for (int j=0; j < data[i].length; i++) {
				total+= data[i][j];
			}
			
		}
		
		return total;
	}

	public static double[][] readFile(File file) throws FileNotFoundException {
		
		String[][] array = new String[10][10];
		Scanner input =  new Scanner(file);
		int row =  0, col = 0;
		
		while(input.hasNextLine()) {
			String[] currentrow = input.nextLine().split(" ");
			for (col = 0; col < currentrow.length; col++)
				array[row][col] = currentrow[col];
			row++;
		}
		
		double[][] data = new double[row][];
		for(int i=0; i < row; i++) {
			data[i] = new double[array[i].length];
			
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
				data[i][j] = Double.parseDouble(array[i][j]);
			}
			
			System.out.println();
			
		}
		
		input.close();
		
		return data;
	}
	
	
	public static void writeToFile(double[][] data, File outputFile) throws IOException {
		
		PrintWriter file = new PrintWriter(outputFile);
		
		for (int i=0; i < data.length; i++) {
			for (int j=0; j < data[i].length; j++) {
				file.print(data[i][j] + " ");
			}
			file.println();
		}
		
		file.close();
		
	}
}


