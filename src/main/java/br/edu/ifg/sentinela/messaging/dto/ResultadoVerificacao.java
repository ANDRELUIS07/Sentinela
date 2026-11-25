package br.edu.ifg.sentinela.messaging.dto;
import java.util.UUID;
import java.time.Instant;
public record ResultadoVerificacao(UUID tarefaId, UUID rodadaId, UUID servicoId, String sentinelaId, boolean sucesso, long latencia, Instant horario) {}
