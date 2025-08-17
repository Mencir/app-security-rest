package pe.edu.idat.app_security_rest.model;


public class Logmessage {
    private String origen;
    private String mensaje;
    private String nivel;

    public Logmessage() {}

    public Logmessage(String origen, String mensaje, String nivel) {
        this.origen = origen;
        this.mensaje = mensaje;
        this.nivel = nivel;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "origen='" + origen + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}