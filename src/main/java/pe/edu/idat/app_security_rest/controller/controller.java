package pe.edu.idat.app_security_rest.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/api/v1/security/hello")
    public String hello() {
        return "¡Hola! Has accedido con autenticación básica.";
    }
}