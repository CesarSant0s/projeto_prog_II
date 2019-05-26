package excepitonRepositorioArray;

public class QuantidadeIndisponívelException extends Exception {
	public QuantidadeIndisponívelException() {
		super("Estoque insuficiente!");
	}
}
