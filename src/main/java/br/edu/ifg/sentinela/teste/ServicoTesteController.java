package br.edu.ifg.sentinela.teste;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.concurrent.atomic.AtomicBoolean;
@RestController @Profile("teste")
public class ServicoTesteController {
 private final AtomicBoolean ativo=new AtomicBoolean(true);
 @GetMapping("/saude") public ResponseEntity<String> saude(){return ResponseEntity.status(ativo.get()?200:503).body(ativo.get()?"OK":"INDISPONIVEL");}
 @PostMapping("/derrubar") public void derrubar(){ativo.set(false);}
 @PostMapping("/restaurar") public void restaurar(){ativo.set(true);}
}
