package br.edu.ifg.sentinela;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import br.edu.ifg.sentinela.balanceamento.*;
import br.edu.ifg.sentinela.coordenador.*;
import br.edu.ifg.sentinela.model.*;
import br.edu.ifg.sentinela.messaging.dto.Heartbeat;
import java.time.*;
import java.util.*;
class AlgoritmosTest {
 @Test void quorumIgnoraDuplicados(){var q=new GerenciadorQuorum();assertEquals(EstadoServico.SUSPEITO,q.registrarVoto("A",false));assertEquals(EstadoServico.SUSPEITO,q.registrarVoto("A",false));assertEquals(EstadoServico.FORA_DO_AR,q.registrarVoto("B",false));}
 @Test void hashDeterministico(){var h=new HashConsistente();var a=new Sentinela("A",1,0,Instant.EPOCH);var b=new Sentinela("B",2,0,Instant.EPOCH);var id=UUID.randomUUID();h.atualizarSentinelas(List.of(a,b));var dono=h.atribuirServico(id);h.atualizarSentinelas(List.of(b,a));assertEquals(dono,h.atribuirServico(id));h.atualizarSentinelas(List.of(a));assertEquals("A",h.atribuirServico(id).orElseThrow());}
 @Test void heartbeatExpira(){var g=new GerenciadorHeartbeat();g.receber(new Heartbeat("A",1,0,Instant.EPOCH),Instant.EPOCH);assertEquals(1,g.ativas(Instant.EPOCH.plusSeconds(5)).size());assertTrue(g.ativas(Instant.EPOCH.plusSeconds(6)).isEmpty());}
}
