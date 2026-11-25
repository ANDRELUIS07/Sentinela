package br.edu.ifg.sentinela.messaging.dto;
import java.util.UUID;
import java.time.Instant;
public record TarefaVerificacao(UUID id, UUID rodadaId, UUID servicoId, String sentinelaId, String url, Instant prazo) {}
