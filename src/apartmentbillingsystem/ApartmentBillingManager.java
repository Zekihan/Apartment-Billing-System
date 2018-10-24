package apartmentbillingsystem;

import java.util.ArrayList;

public class ApartmentBillingManager {
	
	private String[][] billInputArr;
	private String[][] flatInputArr;
	private Apartment apartment;
	
	public ApartmentBillingManager() {
		
		ReadCsv billInput = new ReadCsv("BillingInfo-2018-10-01.csv");
		ReadCsv flatInput = new ReadCsv("ApartmentInfo.csv");
		billInputArr = billInput.readCsv();
		flatInputArr = flatInput.readCsv();
		
		int flatNum =Integer.parseInt(flatInputArr[flatInputArr.length-1][0]) ;
		int floorNum = Integer.parseInt(flatInputArr[flatInputArr.length-1][1]);
		int flatPerFloor = flatNum/floorNum;
		
		
		Flat[][] apartmentArr = new Flat[floorNum][flatPerFloor];
		int flatNo = 0;
		for(int i=0; i<floorNum; i++) {
			for(int j=0; j<flatPerFloor; j++) {
				apartmentArr[i][j] = new Flat(flatInputArr[flatNo],searchBill(flatNo+1));
				flatNo++;
			}
		}
		this.apartment = new Apartment(apartmentArr);
	}
	
	
	public Apartment getApartment() {
		return apartment;
	}

	private ArrayList<Bill> searchBill(int flatNo) {
		ArrayList<Bill> billList = new ArrayList<Bill>();
		for(int i=0; i< billInputArr.length; i++) {
			int flatId = Integer.parseInt(billInputArr[i][1]);
			if(flatId == flatNo) {
				billList.add(new Bill(billInputArr[i]));
			}
		}
		return billList;
	}
	
	

}