import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void adicionarConta(Conta conta) {
		this.contas.add(conta);
	}

	public void exibirContas() {
		if (!contas.isEmpty()) {
		  System.out.println(this.toString());
		} else {
		  System.out.println("O banco ainda não possui contas abertas!");
		}
	  }

	@Override
	public String toString() {
		return "Contas{" +
			"contas=" + contas +
		'}';
	}

}
