package br.edu.ifg.sentinela.messaging.dto;
import java.time.Instant;
public record Heartbeat(String sentinelaId, double capacidade, double carga, Instant horario) {}
