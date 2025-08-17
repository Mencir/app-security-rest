package pe.edu.idat.app_security_rest.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @RestController
    @RequestMapping("/api/v1/security")
    public class TestController {

        @GetMapping("/hello")
        public String hello() {
            return "¡Hola! Has accedido con autenticación básica.";
        }

        @GetMapping("/admin")
        public String admin() {
            return "Bienvenido ADMIN, solo usuarios con rol ADMIN pueden entrar aquí.";
        }

        @GetMapping("/user")
        public String user() {
            return "Bienvenido USER, este endpoint es solo para usuarios con rol USER.";
        }
    }
}