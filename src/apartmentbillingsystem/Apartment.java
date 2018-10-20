package apartmentbillingsystem;

public class Apartment {

	private Flat[][] apartment ;

	public Apartment(Flat[][] apartment) {
		this.setApartment(apartment);
	}

	public Flat[][] getApartment() {
		return apartment;
	}

	public void setApartment(Flat[][] apartment) {
		this.apartment = apartment;
	}
	
	
}
