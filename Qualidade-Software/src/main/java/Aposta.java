
public class Aposta {
	
public static final float CUSTO_APOSTA = 50f;
	
	private int golsVisitante;
	private int golsMandate;
	private Usuario apostador;
	private Partida partida;
	
	public Aposta() {
		super();
	}

	public Aposta(int golsVisitante, int golsMandate, Usuario apostador, Partida partida) throws Exception {
		this.golsVisitante = golsVisitante;
		this.golsMandate = golsMandate;
		this.apostador = apostador;
		this.partida = partida;

		validateNotNegativeGoalsNumbers();
		setPartida(partida);
		setApostador(apostador);
		enviar();
	}

	public int getGolsVisitante() {
		return golsVisitante;
	}

	public void setGolsVisitante(int golsVisitante) {
		this.golsVisitante = golsVisitante;
	}

	public int getGolsMandate() {
		return golsMandate;
	}

	public void setGolsMandate(int golsMandate) {
		this.golsMandate = golsMandate;
	}

	public Usuario getApostador() {
		return apostador;
	}

	public void setApostador(Usuario apostador) {
		this.apostador = apostador;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public float getValorAposta() {
		return CUSTO_APOSTA;
	}

	public boolean enviar() throws Exception{
		if(this.partida.estaDisponivelReceberApostas() && this.apostador.temSaldoSuficiente()) {
			return this.partida.enviarAposta(this);
		}
		throw new Exception("Apostas bloqueada ou Saldo insuficiente");
	}

	private void validateNotNegativeGoalsNumbers() throws Exception{
		if(this.golsMandate<=0 || this.golsVisitante<=0){
			throw new Exception("Os gols devem ter valores válidos");
		}
	}
	

}
