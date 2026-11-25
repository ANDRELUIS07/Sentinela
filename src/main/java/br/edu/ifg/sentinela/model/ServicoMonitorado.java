package br.edu.ifg.sentinela.model;
import java.util.UUID;
public record ServicoMonitorado(UUID id, String nome, String urlSaude, EstadoServico estado, long ultimaLatencia) {}
