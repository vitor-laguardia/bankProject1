import java.util.*;

class Client 
{
	private String name;
	private String cpf;
	private Agency agency;
	private List<Account> accounts = new ArrayList<Account>();

	public Client (String name, String cpf, Agency agency)
	{
		this.name = name;
		this.cpf = cpf;
		this.agency = agency;
	}
	
	public void AddEntitlement (Account newEntitlement)
	{
		if (newEntitlement.getAgency().getId() == this.agency.getId())
			newEntitlement.AddHolder(this);
		else
			System.out.println("This account do not exists in this agency");
	}

	public void ShowBalance (int accountId)
	{
		for (Account ac : accounts)
			if (ac.getId() == accountId)
				ac.ShowBalance();
	}

	public void ShowStatement (int accountId)
	{
		for (Account ac : accounts)
			if (ac.getId() == accountId)
				ac.ShowStatement();
	}

	public String getCpf () 
	{
		return this.cpf;
	}

	public Agency getAgency ()
	{
		return this.agency;
	}
}
