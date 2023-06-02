import model.Usuario;
import org.junit.Test;

import static org.junit.Assert.*;

public class TesteApostas {



    @Test
    public void cpfInvalido(){
        Usuario usuario = new Usuario();
        usuario.setCpf("501.220.590-1a");
        assertEquals("501.220.590-18", usuario.getCpf());
    }


}
