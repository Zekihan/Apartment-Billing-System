package apartmentbillingsystem;

import java.util.ArrayList;
import java.util.Iterator;

public class BillQuery {
	
	public double totalUnpaidBill(Apartment a) {
		double unpaid=0;
		ArrayList<Bill> bills = getBills(a);
		for (int i = 0; i < array.length; i++) {
			if (!(bills[i].isPaid)) {
				unpaid += bills[i].getAmount;
			}
		}
		return unpaid;
		
	}
	private ArrayList<Bill> getBills(Apartment a) {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		for (int i = 0; i < a.getNumberOfFlats(); i++) {
			for (int j = 0; j < a.getNumberOfFloors(); j++) {
				for (int k = 0; k < a[i][j].listOfBills.length; k++) {
					bills.add(a[i][j].listOfBills[k]);
				}
			}
		}
		return bills;
	}

}
