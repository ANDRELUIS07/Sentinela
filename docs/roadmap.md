# Roadmap de 14 dias

| Dias | Entrega |
|---|---|
| 1–3 | Git, Docker, Swarm e RabbitMQ |
| 4–6 | Coordenador e worker |
| 7–9 | Hash, heartbeat, reatribuição e quórum |
| 10 | Painel |
| 11–12 | Testes e métricas |
| 13–14 | Relatório e demonstração |

Checkpoint dia 4: revisar escopo se RabbitMQ no Swarm não funcionar.

- [ ] Validar build e CI
- [ ] Validar mensageria
- [ ] Implementar filas direcionadas, ACK e DLQ
- [ ] Implementar coordenador e API
- [ ] Implementar worker e heartbeat
- [ ] Integrar balanceamento e quórum
- [ ] Reatribuir e deduplicar tarefas
- [ ] Persistir estado
- [ ] Implementar painel
- [ ] Implantar três sentinelas
- [ ] Coletar métricas e finalizar relatório
