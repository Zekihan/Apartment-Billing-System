package apartmentbillingsystem;


public class ApartmentBillingApp {

	public static void main(String[] args) {
		FileIO fileRead = new FileIO("HW1-BillingInfo-2018-10-01.csv");
		String[][] lines = fileRead.readLines();
		
		
		for(int i=0; i<lines.length; i++) {
			for(int j=0; j<lines[0].length; j++) {
				System.out.println(lines[i][j]); 
			}
		}
	}
		
	
}
