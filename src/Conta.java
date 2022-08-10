public abstract class Conta {
	
	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int totalContas; // pra ter um contexto global, n�o a cada instancia
	// o totalContas se torna da classe e n�o do objeto conta

	public Conta(int agencia, int numero) {
		Conta.totalContas++;
		//System.out.println("O total de contas � " + Conta.totalContas);
		this.agencia = agencia;
		this.numero = numero;
		//System.out.println("estou criando uma conta " + this.numero);
	}

	public abstract void deposita(double valor);

	public boolean saca(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		} else {
			return false;
		}
	}

	public boolean transfere(double valor, Conta destino) {
		if (this.saca(valor)) {
			destino.deposita(valor);
			return true;
		}
		return false;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		if (numero <= 0) {
			System.out.println("valor de numero n�o pode ser menor ou igual a 0");
			return;
		}
		this.numero = numero;
	}

	public int getAgencia() {
		return this.agencia;
	}

	public void setAgencia(int agencia) {
		if (agencia <= 0) {
			System.out.println("valor de ag�ncia n�o pode ser menor ou igual a 0");
			return;
		}
		this.agencia = agencia;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public static int getTotalContas() {
		return Conta.totalContas;
	}

}
