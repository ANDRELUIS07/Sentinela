package br.edu.ifg.sentinela.model;
import java.time.Instant;
public record Sentinela(String id, double capacidade, double carga, Instant ultimoHeartbeat) {
 public double peso() { return Math.max(0, capacidade * (1-Math.clamp(carga,0,1))); }
}
