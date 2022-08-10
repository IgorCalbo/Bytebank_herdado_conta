
public class ContaPoupanca extends Conta{

	public ContaPoupanca(int agencia, int numero) {
		super(numero, agencia);
	}

	@Override
	public void deposita(double valor) {
		super.saldo += valor;	
	}
	
}
