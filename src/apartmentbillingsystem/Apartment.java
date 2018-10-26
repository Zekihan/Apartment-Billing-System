package apartmentbillingsystem;

public class Apartment {

	private Flat[][] apartment ;
	private int numberOfFloors;
	private int numberOfFlats;

	
	public Apartment(Flat[][] apartment) {
		this.setApartment(apartment);
		this.numberOfFloors = apartment.length;
		this.numberOfFlats = apartment[0].length;
	}

	public Flat[][] getApartment() {
		return apartment;
	}

	public void setApartment(Flat[][] apartment) {
		this.apartment = apartment;
	}
	

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public int getNumberOfFlats() {
		return numberOfFlats;
	}

	public void setNumberOfFlats(int numberOfFlats) {
		this.numberOfFlats = numberOfFlats;
	}

	@Override
	public String toString() {
		String printable = "";
		for (int i = 0;i<numberOfFloors;i++) {
			for (int j = 0;j<numberOfFlats;j++) {
				printable += apartment[i][j];
			}
		}
		return printable;
	}
	
	
}

