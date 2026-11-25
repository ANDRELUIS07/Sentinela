package br.edu.ifg.sentinela.coordenador;
import java.time.*;
import java.util.*;
import br.edu.ifg.sentinela.model.Sentinela;
import br.edu.ifg.sentinela.messaging.dto.Heartbeat;
public class GerenciadorHeartbeat {
 private final Map<String,Sentinela> nodes=new HashMap<>();
 public synchronized void receber(Heartbeat h, Instant recebido){nodes.put(h.sentinelaId(),new Sentinela(h.sentinelaId(),h.capacidade(),h.carga(),recebido));}
 public synchronized List<Sentinela> ativas(Instant agora){return nodes.values().stream().filter(n->Duration.between(n.ultimoHeartbeat(),agora).compareTo(Duration.ofSeconds(6))<0).toList();}
}
