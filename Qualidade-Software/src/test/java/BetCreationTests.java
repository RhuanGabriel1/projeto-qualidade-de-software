import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BetCreationTests {

    private Usuario usuario;
    private Partida partida;
    private Aposta aposta;


    @BeforeEach
    public void initObjects() throws Exception {
        this.usuario = new Usuario("teste@gmail.com", "50122059018","123456@" );
        this.partida = new Partida("Brasileirão", "Flamengo", "Vasco");
    }

    @Test
    public void openBetTest() {
        this.partida.liberarApostas();
        Assertions.assertDoesNotThrow( () -> new Aposta(2, 1, this.usuario, this.partida), "Aposta Inválida");
    }

    @Test
    public void notOpenBetTest() {
        Assertions.assertThrows(Exception.class, () -> new Aposta(2, 1, this.usuario, this.partida), "Aposta Inválida");
    }


    @Test
    public void notSignInUserTest(){
        Usuario usuario1 = new Usuario();
        Assertions.assertThrows(Exception.class, () -> new Aposta(2, 1, usuario1, this.partida), "Aposta Inválida");
    }

    @Test
    public void SignedUserAndBalanceInsufficientTest(){
        this.partida.liberarApostas();
        this.usuario.diminuirMoedas();
        this.usuario.diminuirMoedas();
        this.usuario.diminuirMoedas();
        this.usuario.diminuirMoedas();
        Assertions.assertThrows(Exception.class, () -> new Aposta(2, 1, this.usuario, this.partida), "Aposta Inválida");
    }

    @Test
    public void betCost() throws Exception {
        this.partida.liberarApostas();
        this.aposta = new Aposta(2, 1, this.usuario, this.partida);
        Assertions.assertEquals(50f, this.aposta.getValorAposta());
    }

    @Test
    public void invalidatedBetCost() throws Exception {
        this.partida.liberarApostas();
        this.aposta = new Aposta(2, 1, this.usuario, this.partida);
        Assertions.assertNotEquals(100f, this.aposta.getValorAposta());
    }

    @Test
    public void negativeHomeTeamGoalsNumber(){
        this.partida.liberarApostas();
        Assertions.assertThrows(Exception.class, () -> new Aposta(2, -1, this.usuario, this.partida), "Aposta Inválida");
    }

    @Test
    public void negativeVisitingTeamGoalsNumber(){
        this.partida.liberarApostas();
        Assertions.assertThrows(Exception.class, () -> new Aposta(-2, 1, this.usuario, this.partida), "Aposta Inválida");
    }

}
