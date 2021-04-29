import java.util.*;

class Agency 
{
	private int id;
	private List<Client> clients = new ArrayList<Client>();
	private List<Account> accounts = new ArrayList<Account>();
	static int accountId = 0;

	public Agency (int id)
	{
		this.id = id;
		System.out.println("number " + id + " agency successfully created");
	}

	public void ClientRegister (String name, String cpf)
	{
		if(checkCpf(cpf))
		{
			Client client = new Client(name, cpf, this);
			clients.add(client);
			System.out.println("cpf client " + cpf + " successfully registered with the agency " + id);
		}
		else
			System.out.println("invalid operation: cpf " + cpf + " is not valid");
	}

	public int OpenAccount (int password, String holderCpf)
	{
		if (getClient(holderCpf) != null)
		{
			Account newAccount = new Account(++accountId, password, this, getClient(holderCpf));
			accounts.add(newAccount);
			System.out.println("number " + accountId +" account with cpf holder " + holderCpf + " successfully opened at Agency " + id);
		}
		else
			System.out.println("invalid operation: there is no customer registered with cpf " + holderCpf);

		return accountId;
	}

	public void AddHolder (int accountId, String holderCpf)
	{
		Account ac = getAccount(accountId);
		Client clt = getClient(holderCpf);

		if (ac != null && clt != null)
		{
			ac.AddHolder(clt);
			System.out.println("CPF holder " + holderCpf + " successfully added to agency number " + id + " account " + accountId);
		}
	}

	public void Deposit (int accountId, double value)
	{
		Account ac = getAccount(accountId);

		if (ac != null)
			ac.Deposit(value);
		
	}
	
	public void ShowBalance (int accountId)
	{
		Account ac = getAccount(accountId);

		if (ac != null)
			ac.ShowBalance();
	}
	
	public Client getClient (String cpf)
	{
		for ( Client clt : clients)
			if (clt.getCpf() == cpf)
				return clt;

		return null;
	}
	
	public Account getAccount (int accountId)
	{
		for ( Account acct : accounts)
			if ( acct.getId() == accountId)
				return acct;

		return null;
	}

	public int getId ()
	{
		return this.id;
	}

	public boolean checkCpf (String cpfString)
	{
		int j, k, rest, accumulator;
		int [] cpfArray = new int[11];	

		// String to int
		for (int i = 0; i < 11; i++)
			cpfArray[i] = Integer.parseInt(String.valueOf(cpfString.charAt(i)));

		//First verified digit
		accumulator = cpfRule(cpfString.length() - 2, cpfArray);		

		rest = accumulator % cpfString.length();

		if (rest == 0 | rest == 1)
			j = 0;
		else
			j = cpfString.length() - rest; 

		//Second verified digit
		accumulator = cpfRule(cpfString.length() - 1, cpfArray);		

		rest = accumulator % cpfString.length();

		if (rest == 0 | rest == 1)
			k = 0;
		else
			k = cpfString.length() - rest; 

		//check cpf
		if ( j == cpfArray[9] && k == cpfArray[10])
			return true;
		else
			return false;

	}

	public int cpfRule (int limit, int[] cpfArray)
	{
		int accumulator = 0;
		int multiplicator;
		
		if (limit == 9)
			multiplicator = 10;
		else
			multiplicator = 11;
		
		for (int i = 0; i < limit; i++)
		{
			accumulator += cpfArray[i] * multiplicator;
			multiplicator--;
		}
		
		return accumulator;
	}
}	
