public class Operacao {
    private String nome;
    private double valor;

    public Operacao(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
	public String toString() {
		return "Operacao{" +
				"Nome='" + this.nome + '\'' +
				", valor=" + this.valor +
				'}';
	}

    public double getValor() {
        return this.valor;
    }
}
