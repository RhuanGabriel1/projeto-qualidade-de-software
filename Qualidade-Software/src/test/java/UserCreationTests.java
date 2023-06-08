import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserCreationTests {

    private Usuario usuario;

    @BeforeEach
    public void initObjects() throws Exception {
        this.usuario = new Usuario("teste@gmail.com", "50122059018","123456@" );
    }

    @Test
    public void validatedCpfTest(){
        Assertions.assertDoesNotThrow( () -> new Usuario("teste@gmail.com", "50122059018","123456@" ), "CPF Inválido");
    }

    @Test
    public void invalidatedCpfTest() throws Exception {
        Assertions.assertThrows(Exception.class, () -> new Usuario("teste@gmail.com", "5012205901x","123456@" ), "CPF Inválido");
    }

    @Test
    public void validatedEmailTest(){
        Assertions.assertDoesNotThrow( () -> new Usuario("teste@gmail.com", "50122059018","123456@" ), "Email inválido");
    }

    @Test
    public void invalidatedEmailTest() throws Exception {
        Assertions.assertThrows(Exception.class, () -> new Usuario("testegmail.com", "50122059018","123456@" ), "Email inválido");
    }

    @Test
    public void validatedPasswordTest(){
        Assertions.assertDoesNotThrow( () -> new Usuario("teste@gmail.com", "50122059018","123456@" ), "Senha inválida");
    }
    @Test
    public void invalidatedPasswordTest() throws Exception {
        Assertions.assertThrows(Exception.class, () -> new Usuario("teste@gmail.com", "50122059018","123456" ), "Senha inválida");
    }

    @Test
    public void insertedCoinsTest(){
        Assertions.assertEquals(200.0f, usuario.getMoedas());
    }

}
