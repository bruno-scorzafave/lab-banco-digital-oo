
public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente("Venilton");

		Banco nubank = new Banco("Nubank");
		
		Conta cc = new ContaCorrente(venilton, nubank);
		Conta poupanca = new ContaPoupanca(venilton, nubank);

		cc.depositar(500);
		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		cc.ultimasOperacoes();
		poupanca.imprimirExtrato();

		nubank.exibirContas();
	}

}
