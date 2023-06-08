import java.util.ArrayList;

public class Partida {
	
	private String campeonato;
	private String timeVisitante;
	private String timeMandante;
	private String status;
	
	private ArrayList<Aposta> apostas;
	
	public Partida() {
		super();
		this.status = "aposta_bloqueada";
		this.apostas = new ArrayList<>();
	}

	public Partida(String campeonato, String timeVisitante, String timeMandante) throws Exception {
		this.campeonato = campeonato;
		this.timeVisitante = timeVisitante;
		this.timeMandante = timeMandante;

		validateNotNullCampeonato();
		validateNotNullTimeVisitante();
		validateNotNullTimeMandante();

		this.status = "aposta_bloqueada";
		this.apostas = new ArrayList<>();
	}

	public String getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(String campeonato) {
		this.campeonato = campeonato;
	}
	public String getTimeVisitante() {
		return timeVisitante;
	}
	public void setTimeVisitante(String timeVisitante) {
		this.timeVisitante = timeVisitante;
	}
	public String getTimeMandante() {
		return timeMandante;
	}
	public void setTimeMandante(String timeMandante) {
		this.timeMandante = timeMandante;
	}
	public String getStatus() {
		return this.status;
	}

	public void liberarApostas() {
		this.status = "apostas_abertas";
	}

	public boolean estaDisponivelReceberApostas() {
		if(this.status == "apostas_abertas"){
			return true;
		}
		else{
			return false;
		}
	}

	public int getNumeroApostas() {
		return this.apostas.size();
	}

	public boolean enviarAposta(Aposta aposta) {
		int apostas_anteriores = this.getNumeroApostas();
		this.apostas.add(aposta);
		aposta.getApostador().diminuirMoedas();
		return apostas_anteriores < this.getNumeroApostas();
	}


	private void validateNotNullCampeonato() throws Exception {
		if (this.campeonato == null || this.campeonato.isEmpty()) {
			throw new Exception("O nome do campeonato não pode ser vazio");
		}
	}

	private void validateNotNullTimeVisitante() throws Exception {
		if (this.timeVisitante == null || this.timeVisitante.isEmpty()) {
			throw new Exception("O time visitante não pode ser vazio");
		}
	}

	private void validateNotNullTimeMandante() throws Exception {
		if (this.timeMandante == null || this.timeMandante.isEmpty()) {
			throw new Exception("O time mandante não pode ser vazio");
		}
	}


}
