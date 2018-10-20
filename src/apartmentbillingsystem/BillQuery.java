package apartmentbillingsystem;

import java.util.ArrayList;

public class BillQuery {
	
	public double totalUnpaidBill(Apartment a) {
		double unpaid=0;
		ArrayList<Bill> bills = getUnpaid(getBills(a));
		for (int i = 0; i < bills.size(); i++) {
			unpaid += bills.get(i).getAmount();
		}
		return unpaid;
	}
	public double totalUnpaidCertainTypeBill(Apartment a,String type) {
		double unpaid=0;
		ArrayList<Bill> bills = getUnpaidType(getBills(a), type);
		for (int i = 0; i < bills.size(); i++) {
			unpaid += bills.get(i).getAmount();
		}
		return unpaid;
	}
	private ArrayList<Bill> getBills(Apartment a) {
		Flat[][] apartment = a.getApartment();
		ArrayList<Bill> bills = new ArrayList<Bill>();
		for (int i = 0; i < a.getNumberOfFlats(); i++) {
			for (int j = 0; j < a.getNumberOfFloors(); j++) {
				for (int k = 0; k < apartment[i][j].getBillList().size(); k++) {
					bills.add(apartment[i][j].getBillList().get(k));
				}
			}
		}
		return bills;
	}
	private ArrayList<Bill> getDesiredBills(ArrayList<Bill> bills,String a){
		ArrayList<Bill> desiredBills = new ArrayList<Bill>();
		if (a.equals("unpaid")) {
			desiredBills = getUnpaid(bills);
		}
		else if(a.equals("unpaidType")) {}
		else if(a.equals("floor")) {}
		else if(a.equals("unpaidRemInfo")) {}
		else if(a.equals("paid")) {}
		else if(a.equals("")) {}
		else if(a.equals("")) {}
		
		
		return desiredBills;
		
	}
	private ArrayList<Bill> getUnpaid(ArrayList<Bill> bills) {
		ArrayList<Bill> unpaid = new ArrayList<>();
		for (int i = 0; i < bills.size(); i++) {
			if (!(bills.get(i).isPaid())) {
				unpaid.add(bills.get(i));
			}
		}
		return unpaid;
	}
	private ArrayList<Bill> getUnpaidType(ArrayList<Bill> bills,String type) {
		ArrayList<Bill> unpaidType = new ArrayList<>();
		for (int i = 0; i < bills.size(); i++) {
			if ((!(bills.get(i).isPaid()))&&(bills.get(i).getType().equals(type))) {
				unpaidType.add(bills.get(i));
			}
		}
		return unpaidType;
	}
	private ArrayList<Bill> getFloor(ArrayList<Bill> bills) {
		ArrayList<Bill> unpaid = new ArrayList<Bill>();
		for (int i = 0; i < bills.size(); i++) {
			if (bills.get(i).getFlatId().) {
				unpaid.add(bills.get(i));
			}
		}
		return unpaid;
	}
	private ArrayList<Bill> getPaidBefore(ArrayList<Bill> bills,String date) {
		ArrayList<Bill> unpaid = new ArrayList<>();
		for (int i = 0; i < bills.size(); i++) {
			if (!(bills.get(i).isPaid())) {
				unpaid.add(bills.get(i));
			}
		}
		return unpaid;
	}
	private ArrayList<Bill> getUnpaidAfter(ArrayList<Bill> bills,String date) {
		ArrayList<Bill> unpaid = new ArrayList<>();
		for (int i = 0; i < bills.size(); i++) {
			if (!(bills.get(i).isPaid())) {
				unpaid.add(bills.get(i));
			}
		}
		return unpaid;
	}
	private ArrayList<Bill> getNRoom(ArrayList<Bill> bills) {
		ArrayList<Bill> unpaid = new ArrayList<>();
		for (int i = 0; i < bills.size(); i++) {
			if (!(bills.get(i).isPaid())) {
				unpaid.add(bills.get(i));
			}
		}
		return unpaid;
	}
	private ArrayList<Bill> getSQGreater(ArrayList<Bill> bills) {
		ArrayList<Bill> unpaid = new ArrayList<>();
		for (int i = 0; i < bills.size(); i++) {
			if (!(bills.get(i).isPaid())) {
				unpaid.add(bills.get(i));
			}
		}
		return unpaid;
	}
	

}
