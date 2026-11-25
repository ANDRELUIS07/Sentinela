package br.edu.ifg.sentinela.coordenador;
import java.util.*;
import br.edu.ifg.sentinela.model.EstadoServico;
public class GerenciadorQuorum {
 private final Map<String,Boolean> votos=new HashMap<>();
 public synchronized EstadoServico registrarVoto(String id, boolean sucesso){votos.putIfAbsent(id,sucesso);return avaliar();}
 public synchronized EstadoServico avaliar(){long falhas=votos.values().stream().filter(v->!v).count();long sucessos=votos.size()-falhas;return falhas>=2?EstadoServico.FORA_DO_AR:sucessos>=2?EstadoServico.NO_AR:EstadoServico.SUSPEITO;}
}
