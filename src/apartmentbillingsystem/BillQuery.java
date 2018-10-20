package apartmentbillingsystem;

import java.util.ArrayList;

public class BillQuery {
	Apartment a;
	
	
	
	public BillQuery(Apartment a) {
		this.a = a;
	}
	public double totalUnpaidBill() {
		double unpaid=0;
		ArrayList<Bill> bills = getUnpaid(getBills());
		for (int i = 0; i < bills.size(); i++) {
			unpaid += bills.get(i).getAmount();
		}
		return unpaid;
	}
	public double totalUnpaidCertainTypeBill(String type) {
		double unpaid=0;
		ArrayList<Bill> bills = getUnpaidType(getBills(), type);
		for (int i = 0; i < bills.size(); i++) {
			unpaid += bills.get(i).getAmount();
		}
		return unpaid;
	}
	public double totalFloorBill(int floor) {
		double unpaid=0;
		ArrayList<Bill> bills = getFloor(getBills(),floor);
		for (int i = 0; i < bills.size(); i++) {
			unpaid += bills.get(i).getAmount();
		}
		return unpaid;
	}
	
	
	
	
	
	
	private ArrayList<Bill> getBills() {
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
	private ArrayList<Bill> getFloor(ArrayList<Bill> bills, int floor) {
		ArrayList<Bill> retFloor = new ArrayList<Bill>();
		Flat[][] apartment = a.getApartment();
		for (int i = 0; i < a.getNumberOfFlats(); i++) {
			for (int j = 0; j < a.getNumberOfFloors(); j++) {
				if (apartment[i][j].getFloorNo()==(floor-1)) {
					for (int k = 0; k < apartment[i][j].getBillList().size(); k++) {
						retFloor.add(bills.get(i));					
					}
					
				}
				
			}
		}
		return retFloor;
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
