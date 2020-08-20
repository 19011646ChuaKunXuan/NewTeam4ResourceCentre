
public class Transaction {
	
	//Soon Chuan
	private String handlingStaff;
	private String itemTransacted;
	private String actionTaken;
	private String customerName;
	private String product;
	
	public Transaction(String handlingStaff, String customerName, String product, String itemTransacted, String actionTaken) {

		this.handlingStaff = handlingStaff;
		this.customerName = customerName;
		this.product = product;
		this.itemTransacted = itemTransacted;
		this.actionTaken = actionTaken;
		
	}

	public String getHandlingStaff() {
		return handlingStaff;
	}

	public void setHandlingStaff(String handlingStaff) {
		this.handlingStaff = handlingStaff;
	}

	public String getItemTransacted() {
		return itemTransacted;
	}

	public void setItemTransacted(String itemTransacted) {
		this.itemTransacted = itemTransacted;
	}

	public String getActionTaken() {
		return actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	
	

	
	
	
	
	
	
}
