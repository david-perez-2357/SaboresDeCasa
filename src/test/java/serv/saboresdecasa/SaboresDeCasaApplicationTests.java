package serv.saboresdecasa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import serv.saboresdecasa.model.Bebida;
import serv.saboresdecasa.repository.BebidaRepository;

import java.util.List;

@SpringBootTest
class SaboresDeCasaApplicationTests {

    @Autowired
    private BebidaRepository bebidaRepository;

    @Test
    void contextLoads() {
        List<Bebida> bebidas = bebidaRepository.findAll();
        for (Bebida bebida : bebidas) {
            System.out.println(bebida.getNombre());
        }
    }

}
