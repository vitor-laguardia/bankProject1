import java.util.*;

class Bank
{
	private String name;
	private int id;
	private List<Agency> agencies = new ArrayList<Agency>();
	static int agencyId = 1;

	public Bank (String name, int id)
	{
		this.name = name;
		this.id = id;
	}
	
	public int openAgency ()
	{
		Agency ag = new Agency(agencyId++);
		agencies.add(ag);
		
		return agencyId;	
	}	

	public void deposit (int agencyId, int accountId, double value)
	{
		Agency ag; 
		ag = getAgency(agencyId);
		Account ac = null;
		if (ag != null)
			ac = ag.getAccount(accountId);
		
		if (ag == null)
			System.out.println("invalid operation: there is no agency " + agencyId);
		else if (ac == null)
			System.out.println("invalid operation: there is no account " + accountId + " at agency " + agencyId);
		else 
			ac.Deposit(value);
	}

	public void showBalance (int agencyId, int accountId)
	{
		Agency ag = getAgency(agencyId);
		Account ac = ag.getAccount(accountId);

		if (ag != null && ac != null)
			ac.ShowBalance();
	}

	public void ShowStatement (int agencyId, int accountId)
	{
		Agency ag = getAgency(agencyId);
		Account ac = ag.getAccount(accountId);

		if (ag != null && ac != null)
			ac.ShowStatement();
	}

	public int getId ()
	{
		return this.id;
	}

	public Agency getAgency (int agencyId)
	{
		for (Agency ag : this.agencies)
			if (ag.getId() == agencyId)
				return ag;

		return null;
	}
}
