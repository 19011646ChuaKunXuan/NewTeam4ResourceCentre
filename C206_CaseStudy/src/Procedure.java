
// - Leonard
public class Procedure {

	private String Category;
	private String Procedure;
	private String Date;

	public Procedure(String Category, String Procedure, String Date) {

		this.Category = Category;
		this.Procedure = Procedure;
		this.Date = Date;

	}

	public String getProcedure() {
		return Procedure;
	}

	public void setProcedure(String Procedure) {
		this.Procedure = Procedure;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String Category) {
		this.Category = Category;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String Date) {
		this.Date = Date;
	}

}
