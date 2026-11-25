package br.edu.ifg.sentinela.worker;
import java.net.*;
import java.net.http.*;
import java.time.*;
import br.edu.ifg.sentinela.messaging.dto.*;
public class VerificadorHTTP {
 private final HttpClient client=HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(2)).build();
 public ResultadoVerificacao verificar(TarefaVerificacao t){long inicio=System.nanoTime();boolean ok=false;try{var req=HttpRequest.newBuilder(URI.create(t.url())).timeout(Duration.ofSeconds(2)).GET().build();ok=client.send(req,HttpResponse.BodyHandlers.discarding()).statusCode()==200;}catch(InterruptedException e){Thread.currentThread().interrupt();}catch(Exception e){ok=false;}return new ResultadoVerificacao(t.id(),t.rodadaId(),t.servicoId(),t.sentinelaId(),ok,(System.nanoTime()-inicio)/1000000,Instant.now());}
}
