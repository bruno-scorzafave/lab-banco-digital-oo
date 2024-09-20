import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected Banco banco;
	protected List<Operacao> listaDeOperacoes;

	public Conta(Cliente cliente, Banco banco) {
		this.banco = banco;
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.listaDeOperacoes = new ArrayList<>();
		banco.adicionarConta(this);
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
    	this.listaDeOperacoes.add(new Operacao("Saque", -valor));
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
    	this.listaDeOperacoes.add(new Operacao("Deposito", valor));
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
    	this.listaDeOperacoes.add(new Operacao("Transferencia", -valor));
	}

	public void ultimasOperacoes() {
		System.out.println("=== Ultimas Operacoes ===");
		System.out.println("Saldo acrescido:" + this.listaDeOperacoes.stream().limit(5).map(n -> n.getValor()).reduce(0d, Double::sum));
		this.listaDeOperacoes.stream().limit(5).forEach(System.out::println);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "Conta{" +
				"Agencia='" + this.agencia + '\'' +
				", numero=" + this.numero +
				", titular=" + this.cliente.getNome() +
				'}';
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Banco: %s", this.banco.getNome()));
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
