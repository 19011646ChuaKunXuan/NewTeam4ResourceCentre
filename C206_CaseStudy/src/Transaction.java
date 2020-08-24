
public class Transaction extends Customer{
	
	//Soon Chuan
	private String handlingStaff;
	private String itemTransacted;
	private String actionTaken;
	private String product;	

	public Transaction(String customername, int customernumber, String handlingStaff, String product, String itemTransacted, String actionTaken) {
		
		super(customername, customernumber);
		this.handlingStaff = handlingStaff;
		this.itemTransacted = itemTransacted;
		this.actionTaken = actionTaken;
		this.product = product;
		
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

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	
	//linking to customer
	public void setCustomerName(String customername) {
		super.addName(customername);
	}
	
	public String getCustomerName() {
		return super.getName();
	}
	
	public void setCustomerNumber(int customernumber) {
		super.addNumber(customernumber);
	}
	
	public int getCustomerNumber() {
		return super.getNumber();
	}
	
}

	
	
	
	
	
	

