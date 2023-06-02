import model.Aposta;
import model.Partida;
import model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteApostas {
    private Usuario usuario;
    private Partida partida;

    @BeforeEach
    public void iniciaObjetos(){
        this.usuario = new Usuario("teste@gmail.com", "50122059018","123456@" );
        this.partida = new Partida();
    }

    @Test
    public void cpfValido(){
        Assertions.assertEquals("50122059018", usuario.getCpf());
    }

    @Test
    public void cpfInvalido(){
        Usuario usuario1 = new Usuario("teste@gmail.com", "5012205901x","123456@" );
        //        Assertions.assertThrows(Exception.class, () -> new Usuario("teste@gmail.com", "5012205901x","123456@" ), "CPF Inválido");
        Assertions.assertEquals(usuario.getCpf(), usuario1.getCpf());
    }

    @Test
    public void emailValido(){
        Assertions.assertEquals("teste@gmail.com", usuario.getEmail());
    }

    @Test
    public void emailInvalido(){
        Usuario usuario1 = new Usuario("teste@", "50122059018","123456@" );
        Assertions.assertEquals(usuario.getEmail(), usuario1.getEmail());
    }

    @Test
    public void senhaValida(){
        Assertions.assertEquals("123456@", usuario.getPassword());
    }
    @Test
    public void senhaInvalida(){
        Usuario usuario1 = new Usuario("teste@gmail.com", "50122059018","123456" );
        Assertions.assertEquals(usuario.getPassword(), usuario1.getPassword());
    }

    @Test
    public void moedasInseridas(){
        Assertions.assertEquals(200.0f, usuario.getMoedas());
    }

    @Test
    public void criacaoPartida(){
        partida.setCampeonato("Brasileirão");
        partida.setTimeVisitante("Flamengo");
        partida.setTimeMandante("Vasco");

        Assertions.assertEquals("Brasileirão", partida.getCampeonato());
        Assertions.assertEquals("Flamengo", partida.getTimeVisitante());
        Assertions.assertEquals("Vasco", partida.getTimeMandante());
        Assertions.assertEquals("aposta_bloqueada", partida.getStatus());
    }

    @Test
    public void statusApostas(){
        partida.setCampeonato("Brasileirão");
        partida.setTimeVisitante("Flamengo");
        partida.setTimeMandante("Vasco");
        Assertions.assertEquals("aposta_bloqueada", partida.getStatus());
        partida.liberarApostas();
        Assertions.assertEquals("apostas_abertas", partida.getStatus());
    }

    @Test
    void realizarAposta() {
        partida.setCampeonato("Brasileirão");
        partida.setTimeVisitante("Flamengo");
        partida.setTimeMandante("Vasco");

        float saldoInicial = usuario.getMoedas();

        Aposta aposta = new Aposta();
        aposta.setGolsVisitante(2);
        aposta.setGolsMandate(1);
        aposta.setApostador(usuario);
        aposta.setPartida(partida);

        usuario.diminuirMoedas();

        Assertions.assertEquals(saldoInicial - 50, usuario.getMoedas());
    }

    @Test
    void custoAposta() {
        Assertions.fail("Métodos para verificar valor das apostas ainda não existem");
    }

    @Test
    void apostaValida(){
        partida.setCampeonato("Brasileirão");
        partida.setTimeVisitante("Flamengo");
        partida.setTimeMandante("Vasco");

        Aposta aposta = new Aposta();
        aposta.setGolsVisitante(1);
        aposta.setGolsMandate(0);
        aposta.setApostador(usuario);
        aposta.setPartida(partida);

        Assertions.assertTrue(aposta.enviar());
    }

    @Test
    void partidaBloqueada() {
        partida.setCampeonato("Brasileirão");
        partida.setTimeVisitante("Flamengo");
        partida.setTimeMandante("Vasco");

        Aposta aposta = new Aposta();
        aposta.setGolsVisitante(1);
        aposta.setGolsMandate(0);
        aposta.setApostador(usuario);
        aposta.setPartida(partida);

        Assertions.assertFalse(aposta.enviar());
    }

    @Test
    void saldoInsuficiente() {
        partida.setCampeonato("Brasileirão");
        partida.setTimeVisitante("Flamengo");
        partida.setTimeMandante("Vasco");

        usuario.diminuirMoedas();
        usuario.diminuirMoedas();
        usuario.diminuirMoedas();
        usuario.diminuirMoedas();

        Aposta aposta = new Aposta();
        aposta.setGolsVisitante(1);
        aposta.setGolsMandate(0);
        aposta.setApostador(usuario);
        aposta.setPartida(partida);

        Assertions.assertFalse(aposta.enviar());
    }

    @Test
    void golsNegativos(){
        partida.setCampeonato("Brasileirão");
        partida.setTimeVisitante("Flamengo");
        partida.setTimeMandante("Vasco");

        Aposta aposta = new Aposta();
        aposta.setGolsVisitante(-1);
        aposta.setGolsMandate(0);
        aposta.setApostador(usuario);
        aposta.setPartida(partida);

        Assertions.assertFalse(aposta.enviar());
}
}
