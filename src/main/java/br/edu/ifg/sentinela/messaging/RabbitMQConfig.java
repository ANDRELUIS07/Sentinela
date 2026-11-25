package br.edu.ifg.sentinela.messaging;
import org.springframework.context.annotation.*;
import org.springframework.amqp.core.*;
@Configuration @Profile({"coordenador","sentinela"})
public class RabbitMQConfig {
 @Bean DirectExchange exchange(){return new DirectExchange("sentinela",true,false);}
 @Bean Queue resultados(){return new Queue("sentinela.resultados",true);}
 @Bean Queue heartbeats(){return new Queue("sentinela.heartbeats",true);}
 @Bean Binding resultadosBinding(DirectExchange exchange){return BindingBuilder.bind(resultados()).to(exchange).with("resultados");}
 @Bean Binding heartbeatsBinding(DirectExchange exchange){return BindingBuilder.bind(heartbeats()).to(exchange).with("heartbeats");}
}
