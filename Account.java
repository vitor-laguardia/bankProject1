import java.util.*;

class Account
{
	private int id;
	private int password;
	private double balance = 0;
	private List<Operation> operations = new ArrayList<Operation>();
	private Agency agency;
	private ArrayList<Client> clients = new ArrayList<Client>();

	public Account (int id, int password, Agency agency, Client firstHolder)
	{
		this.id = id;
		this.password = password;
		this.agency = agency;
		this.clients.add(firstHolder); //check
	}
	
	public void AddHolder (Client newHolder)
	{
		if (newHolder.getAgency().getClient(newHolder.getCpf()) != null)
			this.clients.add(newHolder);	
		else
			System.out.println("This client does not exists in this Agency");
	}

	public void Deposit (double value)
	{
		balance += value;
		System.out.println(value + " deposit made successfully");
		Calendar c = Calendar.getInstance();
		Operation op = new Operation(c, "Deposit", value );
		operations.add(op);
	}

	public void ShowBalance ()
	{
		System.out.println("current balance: " + balance);
	}

	public void ShowStatement ()
	{
		for (Operation op : operations)
			System.out.println(op);
	}

	public Agency getAgency ()
	{
		return this.agency;
	}

	public int getId ()
	{
		return this.id;
	}
}
