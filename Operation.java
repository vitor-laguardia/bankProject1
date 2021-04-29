import java.util.Calendar;

class Operation
{
	Calendar timeAndDate;
	String description;
	double amountMoved;

	public Operation (Calendar data, String description, double value)
	{
		this.timeAndDate = data;
		this.description = description;
		this.amountMoved = value;
	}

	public String toString()
	{
		return this.timeAndDate.getTime() + "\t Description: " + this.description + "\t Amount Moved: " + this.amountMoved;
	}
}
	
