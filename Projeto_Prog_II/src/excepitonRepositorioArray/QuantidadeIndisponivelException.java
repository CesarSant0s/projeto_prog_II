package excepitonRepositorioArray;

public class QuantidadeIndisponivelException extends Exception {
	public QuantidadeIndisponivelException() {
		super("Estoque insuficiente!");
	}
}
