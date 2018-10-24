package apartmentbillingsystem;

public class Bill {
	
	private int billId;
	private int flatId;
	private int amount;
	private String type;
	private boolean isPaid;
	private String deadlineDate;
	private String lastUpdateDate;
	
	public Bill(String[] BillInfoArr) {
		this.billId = Integer.parseInt(BillInfoArr[0]);
		this.flatId = Integer.parseInt(BillInfoArr[1]);
		this.amount = Integer.parseInt(BillInfoArr[2]);
		this.type = BillInfoArr[3];
		this.isPaid = Boolean.parseBoolean(BillInfoArr[4]);
		this.deadlineDate = BillInfoArr[5];
		this.lastUpdateDate = BillInfoArr[6];
	}

	public int getBillId() {
		return billId;
	}

	public int getFlatId() {
		return flatId;
	}

	public int getAmount() {
		return amount;
	}

	public String getType() {
		return type;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public String getDeadlineDate() {
		return deadlineDate;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", flatId=" + flatId + ", amount=" + amount + ", type=" + type + ", isPaid="
				+ isPaid + ", deadlineDate=" + deadlineDate + ", lastUpdateDate=" + lastUpdateDate + "]";
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	

	
}
