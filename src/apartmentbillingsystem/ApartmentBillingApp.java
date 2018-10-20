package apartmentbillingsystem;


public class ApartmentBillingApp {

	public static void main(String[] args) {

		ApartmentBillingManager apMngr = new ApartmentBillingManager();
		
		Apartment ap = apMngr.getApartment();
		System.out.println(ap.getNumberOfFloors());
		System.out.println(ap.getApartment()[2][1].getSqrMeter());
		System.out.println(ap.getApartment()[2][1].getBillList().get(0).getBillId());
		
	}
}
