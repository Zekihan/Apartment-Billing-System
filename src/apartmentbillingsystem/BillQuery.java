package apartmentbillingsystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

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
		System.out.println(unpaid);
		return unpaid;
	}
	public double totalUnpaidCertainTypeBill(String type) {
		double unpaid=0;
		ArrayList<Bill> bills = getUnpaidType(getBills(), type);
		for (int i = 0; i < bills.size(); i++) {
			unpaid += bills.get(i).getAmount();
		}
		System.out.println(unpaid);
		return unpaid;
	}
	public double totalFloorBill(int floor) {
		double total=0;
		ArrayList<Bill> bills = getFloor(getBills(),floor);
		for (int i = 0; i < bills.size(); i++) {
			total += bills.get(i).getAmount();
		}
		System.out.println(total);
		return total;
	}
	public ArrayList<Bill> unpaidRemainingTime(){
		ArrayList<Bill> bills = getUnpaid(getBills());
		for (int i = 0; i < bills.size(); i++) {
			String deadline = bills.get(i).getDeadlineDate();
			int rem = timeDiff(deadline,new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
			if (rem>=0) {
				System.out.println(bills.get(i).toString()+"Remaining Time"+rem);
			}
		}
		return bills;
	}
	public ArrayList<Bill> paidBefore(String date){
		ArrayList<Bill> bills = getPaid(getBills());
		for (int i = 0; i < bills.size(); i++) {
			String deadline = bills.get(i).getDeadlineDate();
			int rem = timeDiff(deadline,date);
			if (rem>=0) {
				System.out.println(bills.get(i).toString()+"Remaining Time"+rem);
			}
		}
		
		return bills;
		
	}
	public ArrayList<Bill> unpaidPassedType(String type){
		int number = 0;
		double amount = 0;
		ArrayList<Bill> bills = getUnpaidType(getBills(),type);
		for (int i = 0; i < bills.size(); i++) {
			String deadline = bills.get(i).getDeadlineDate();
			int rem = timeDiff(deadline,new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
			if (rem<0) {
				amount += bills.get(i).getAmount();
				number++;
			}
		}
		System.out.println("amount"+amount+"number"+number);
		return bills;
	}
	public void avgRoomBill(int floor) {
		System.out.println(getNRoom(getBills(),floor));
	}
	public void avgSQBill(int sq) {
		System.out.println(getSQGreater(getBills(),sq));
	}
	

	
	private int timeDiff(String firstDate,String secondDate) {
		int diffDays=0;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date deadlineDate;
		
		try {
			deadlineDate = dateFormat.parse(firstDate);
		    java.util.Date currentDate = dateFormat.parse(secondDate);
		    long diffInMillies = currentDate.getTime() - deadlineDate.getTime();
		    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		 
		    diffDays = (int) (diff );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return diffDays;
		
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
	
	private ArrayList<Bill> getUnpaid(ArrayList<Bill> bills) {
		ArrayList<Bill> unpaid = new ArrayList<>();
		for (int i = 0; i < bills.size(); i++) {
			if (!(bills.get(i).isPaid())) {
				unpaid.add(bills.get(i));
			}
		}
		return unpaid;
	}
	private ArrayList<Bill> getPaid(ArrayList<Bill> bills) {
		ArrayList<Bill> unpaid = new ArrayList<>();
		for (int i = 0; i < bills.size(); i++) {
			if (bills.get(i).isPaid()) {
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
	
	private double getNRoom(ArrayList<Bill> bills,int room) {
		double total = 0;
		int number=0;
		Flat[][] apartment = a.getApartment();
		for (int i = 0; i < a.getNumberOfFlats(); i++) {
			for (int j = 0; j < a.getNumberOfFloors(); j++) {
				if (apartment[i][j].getNoOfRooms()==(room)) {
					for (int k = 0; k < apartment[i][j].getBillList().size(); k++) {
						total += bills.get(i).getAmount();
						number++;				
					}
					
				}
				
			}
		}
		return total/number;
	}
	private double getSQGreater(ArrayList<Bill> bills,int sq) {
		double total = 0;
		int number=0;
		Flat[][] apartment = a.getApartment();
		for (int i = 0; i < a.getNumberOfFlats(); i++) {
			for (int j = 0; j < a.getNumberOfFloors(); j++) {
				if (apartment[i][j].getSqrMeter()==(sq)) {
					for (int k = 0; k < apartment[i][j].getBillList().size(); k++) {
						total += bills.get(i).getAmount();
						number++;
					}
					
				}
				
			}
		}
		return total/number;
	}
	

}
