
package datos;

public class LogsUsuario {
    private String entradas;
    private String salidas;

    public LogsUsuario() {
    }

    public LogsUsuario(String entradas, String salidas) {
        this.entradas = entradas;
        this.salidas = salidas;
    }

    public String getEntradas() {
        return entradas;
    }

    public void setEntradas(String entradas) {
        this.entradas = entradas;
    }

    public String getSalidas() {
        return salidas;
    }

    public void setSalidas(String salidas) {
        this.salidas = salidas;
    }

    @Override
    public String toString() {
        return "LogsUsuario{" + "entradas=" + entradas + ", salidas=" + salidas + '}';
    }

    
    
    
    
    
}
