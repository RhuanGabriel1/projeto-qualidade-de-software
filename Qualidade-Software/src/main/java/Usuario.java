
public class Usuario {

	private String email;
	private String cpf;
	private String password;
	private float moedas;


	public Usuario() {
		super();
		this.moedas = 200f;
	}

	public Usuario(String email, String cpf, String password) throws Exception {
		super();
		this.email = email;
		this.cpf = cpf;
		this.password = password;
		this.moedas = 200f;

		validateCPF();
		validateEmail();
		validatePassword();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception {
		this.email = email;
		validateEmail();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean temSaldoSuficiente() {
		return this.moedas >= Aposta.CUSTO_APOSTA;
	}

	public float getMoedas() {
		return this.moedas;
	}

	public void diminuirMoedas() {
		this.moedas = this.moedas - Aposta.CUSTO_APOSTA;
	}

	private void validateEmail() throws Exception {
		if (!this.email.contains("@")) {
			throw new Exception("Email inv�lido");
		}
	}

	private void validateCPF() throws Exception {
		if (this.cpf == null || this.cpf.length() != 11 || !this.cpf.matches("\\d+")) {
			throw new Exception("CPF inválido");
		}
	}

	private void validatePassword() throws Exception {
		if (!this.password.matches(".*[!?.*,@].*")) {
			throw new Exception("Senha inválida");
		}
	}

}





