package br.edu.ifg.sentinela.balanceamento;
import br.edu.ifg.sentinela.model.Sentinela;
import java.util.*;
public class RoundRobin implements BalanceadorCarga {
 private List<String> ids=List.of(); private int indice;
 public synchronized void atualizarSentinelas(Collection<Sentinela> nodes){ids=nodes.stream().map(Sentinela::id).sorted().toList();indice=0;}
 public synchronized Optional<String> atribuirServico(UUID id){if(ids.isEmpty())return Optional.empty();String s=ids.get(indice);indice=(indice+1)%ids.size();return Optional.of(s);}
}
