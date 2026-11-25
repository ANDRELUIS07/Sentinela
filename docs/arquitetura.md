# Arquitetura planejada

```mermaid
flowchart LR
 P[Painel] --> C[Coordenador]
 C <--> R[RabbitMQ]
 R <--> A[Sentinela A]
 R <--> B[Sentinela B]
 R <--> D[Sentinela C]
 A --> T[Serviços HTTP]
 B --> T
 D --> T
```

Hash consistente com pesos, filas direcionadas por sentinela, ACK manual após confirmação de publicação e persistência, deduplicação por tarefa e rodada, heartbeat a cada 2 s e timeout de 6 s. Sem maioria, manter SUSPEITO. Coordenador e RabbitMQ são pontos únicos de falha nesta proposta.
