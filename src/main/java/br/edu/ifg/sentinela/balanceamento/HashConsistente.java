package br.edu.ifg.sentinela.balanceamento;
import br.edu.ifg.sentinela.model.Sentinela;
import java.util.*;
import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
public class HashConsistente implements BalanceadorCarga {
 private final NavigableMap<Long,String> anel=new TreeMap<>();
 private long hash(String s) { try { return ByteBuffer.wrap(MessageDigest.getInstance("SHA-256").digest(s.getBytes(StandardCharsets.UTF_8))).getLong(); } catch(NoSuchAlgorithmException e){throw new IllegalStateException(e);} }
 public synchronized void atualizarSentinelas(Collection<Sentinela> nodes) { anel.clear(); nodes.stream().sorted(Comparator.comparing(Sentinela::id)).forEach(n->{ for(int i=0;i<Math.min(10000,(int)Math.ceil(100*n.peso()));i++) anel.put(hash(n.id()+":"+i),n.id()); }); }
 public synchronized Optional<String> atribuirServico(UUID id) { if(anel.isEmpty())return Optional.empty(); var e=anel.ceilingEntry(hash(id.toString())); return Optional.of((e==null?anel.firstEntry():e).getValue()); }
}
