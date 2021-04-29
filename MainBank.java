
public class MainBank {

	public static void main(String[] args) {
		
		//UM EMPRESARIO ENDINHEIRADO CONSTRUINDO UM NOVO BANCO
		
		Bank caixa = new Bank("Caixa Federal", 104);
		
		//abrindo 5 agencias
		for(int i=0; i<5; i++)
			caixa.openAgency();
		
		//acessando a primeira agencia aberta
		Agency ag01Caixa = caixa.getAgency(1);
		
		//UM FUNCIONARIO DESTE BANCO COM ACESSO AO SISTEMA DA AGENCIA
		
		//cadastrando dois clientes com cpfs validos
		ag01Caixa.ClientRegister("Rodrigo", "08264574602");
		ag01Caixa.ClientRegister("Vivian", "13039639650");
		
		//abrindo uma nova conta e adicionando um segundo titular nela
		ag01Caixa.OpenAccount(123456, "13039639650");
		ag01Caixa.AddHolder(1, "08264574602");
		
		//cadastrando um cliente com cpf invalido
		ag01Caixa.ClientRegister("Jose das Couves", "24707715218");
		//e tentando abrir uma conta com este cadastro
		ag01Caixa.OpenAccount(000000, "24707715218");
		
		//recadastrando o cliente com um cpf valido
		ag01Caixa.ClientRegister("Jose das Couves", "24707715281");
		//e abrindo uma conta para ele
		ag01Caixa.OpenAccount(000000, "24707715281");
		
		//UM CLIENTE DO BANCO COM ACESSO A UM CAIXA ELETRONICO
		
		//realizando sucessivas operacoes de deposito
		//validas e invalidas
		caixa.deposit(1, 1, 520.00);
		caixa.deposit(10, 1, 80.00);
		caixa.deposit(1, 1, 80.00);
		caixa.deposit(1, 4, 100.00);
		//seguidas de um pedido de saldo e um de extrato
		caixa.showBalance(1, 1);
		caixa.ShowStatement(1, 1);
	}
}
