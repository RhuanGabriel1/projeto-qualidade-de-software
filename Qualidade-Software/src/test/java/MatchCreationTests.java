import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MatchCreationTests {

    private Usuario usuario;
    private Partida partida;

    @BeforeEach
    public void initObjects() throws Exception {
        this.usuario = new Usuario("teste@gmail.com", "50122059018","123456@" );
        this.partida = new Partida("Brasileirão", "Flamengo", "Vasco");
    }

    @Test
    public void matchCreationChampionshipTest(){
        Assertions.assertDoesNotThrow( () -> new Partida("Brasileirão", "Flamengo", "Vasco"), "Nome de campeonato inválido");
    }

    @Test
    public void invalidatedMatchCreationChampionshipTest(){
        Assertions.assertThrows(Exception.class, () -> new Partida("", "Flamengo", "Vasco"), "Nome de campeonato inválido");
    }

    @Test
    public void matchCreationHomeTeamTest(){
        Assertions.assertDoesNotThrow( () -> new Partida("Brasileirão", "Flamengo", "Vasco"), "Nome de time mandante inválido");
    }

    @Test
    public void invalidatedMatchHomeTeamTest(){
        Assertions.assertThrows(Exception.class, () -> new Partida("Brasileirão", "Flamengo", ""), "Nome de time mandante inválido");
    }

    @Test
    public void matchCreationVisitingTeamTest(){
        Assertions.assertDoesNotThrow( () -> new Partida("Brasileirão", "Flamengo", "Vasco"), "Nome de time visitante inválido");
    }

    @Test
    public void invalidatedMatchVisitingTeamTest(){
        Assertions.assertThrows(Exception.class, () -> new Partida("Brasileirão", "", "Vasco"), "Nome de time mandante inválido");
    }

    @Test
    public void notOpenStatusBetTest(){
        Assertions.assertFalse( partida.estaDisponivelReceberApostas() );
    }

    @Test
    public void openStatusBetTest(){
        partida.liberarApostas();
        Assertions.assertTrue( partida.estaDisponivelReceberApostas() );
    }

}
