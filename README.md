# Sentinela

Sistema distribuído de monitoramento de disponibilidade de serviços, com balanceamento de carga por hash consistente, tolerância a falhas e confirmação por quórum. Desenvolvido com Java, Spring Boot, RabbitMQ e Docker Swarm.

**Status:** fundação inicial de desenvolvimento; integração distribuída pendente.

## Objetivos
- Verificar serviços HTTP a cada 5 segundos.
- Distribuir tarefas por hash consistente com pesos.
- Detectar falhas de sentinelas por heartbeat (2 s; timeout 6 s).
- Reatribuir serviços e confirmar falhas por quórum 2 de 3.

## Execução local
Requisitos: Java 21, Maven 3.9 e Docker.
```bash
mvn clean verify
docker compose up -d --build
```
Serviço de teste: http://localhost:8081/saude. Use POST /derrubar e POST /restaurar. RabbitMQ Management: http://localhost:15672. Credenciais de laboratório em .env.example.

## Documentação
- [Arquitetura](docs/arquitetura.md)
- [Diagrama de classes](docs/diagrama-classes.md)
- [Roadmap](docs/roadmap.md)
- [Contribuição](CONTRIBUTING.md)

## Contexto acadêmico
IFG — Câmpus Inhumas, Engenharia de Software, Sistemas Distribuídos, 2026.
