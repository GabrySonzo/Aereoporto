package it.itispaleocapa.sonzognig;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    
    @Test
    void getCodiceClienteTest() {
        Cliente cliente = new Cliente("nome", "cognome", "italia", "roma", LocalDate.of(2000, 1, 1));
        assertEquals(1, cliente.getCodiceCliente());
    }
}
