
public class HolidayBonus {

	public HolidayBonus() {
		
	}
	
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		
		double bonus[] = new double[data.length];
		
		for (int i=0; i < bonus.length; i++) {
			for (int j=0; j < data[i].length; j++) {
				if (data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j))
					bonus[i] += high;
				else if (data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j))
					bonus[i] += low;
				else 
					bonus[i] += other;
			}
		}
		
		return bonus;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		
		double[] bonus = calculateHolidayBonus(data, high, low, other);
		double total = 0.0;
		for (int i=0; i < bonus.length; i++)
			total += bonus[i];
		return total;
		
	}
	
}
