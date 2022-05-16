
import com.ufes.autorizacaopagamento.business.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ProcessarPagamentoTest {

    private final ProcessaPagamentoService processarPagamentoService = new ProcessaPagamentoService();

    @Test
    @Disabled
    void pagamentoAceitoGerenteImediato() {
        //
        Double valor = 300.00;
        GerenteImediato gerenteImediato = new GerenteImediato(true);
        processarPagamentoService.addTratador(gerenteImediato);

        //
        String retorno = processarPagamentoService.processaAprovacao(valor);

        //
        assertEquals(System.getProperty("line.separator") + gerenteImediato.aprovarPagamento(300.00), retorno);
    }

    @Disabled
    @Test
    void valorPagamentoInvalidoMenorZero() {
        //
        Double valor = 0.0;

        //
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> processarPagamentoService.processaAprovacao(valor)
        );
        System.out.println(thrown.getMessage());

        assertTrue(thrown.getMessage().contains("Falha: Valor de pagamento inválido:\nO valor deve ser > 0"));

        //
    }


    @Test
    void valorPagamentoInvalidoMaiorEsperado() {
        //
        Double valor = 15000.01;

        assertAll("valorPagamentoInvalidoMaiorEsperado",
                () -> assertTrue(thrown.getMessage().contains("Falha: O pagamento é superior ao autorização e \\nnão pôde ser processado por nenhum superior hierárquico")),
                () -> assertThrows( IllegalArgumentException.class,() -> processarPagamentoService.processaAprovacao(valor) ));

    }

    @Disabled
    @Test
    void semTratadorInformado() {
        //
        Double valor = 1500.01;

        //
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> processarPagamentoService.processaAprovacao(valor)
        );
        System.out.println(thrown.getMessage());

        assertTrue(thrown.getMessage().contains("Falha: Nenhum superior hierarquico foi adicionado!"));
try{
        //
    }catch(e){
        
    }
}
