package br.edu.ifg.sentinela.balanceamento;
import br.edu.ifg.sentinela.model.Sentinela;
import java.util.*;
public interface BalanceadorCarga { void atualizarSentinelas(Collection<Sentinela> nodes); Optional<String> atribuirServico(UUID id); }
