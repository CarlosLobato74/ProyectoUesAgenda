
package dominio;

public class Cliente {
    
    private int idUser;
    private int idAgenda;
    private String descripcion;
    private String fecha;
    private String hora;
    
    
    public Cliente() {
        
    }

    public Cliente(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Cliente(int idAgenda, String descripcion, String fecha, String hora) {
        this.idAgenda = idAgenda;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
    }
    
    
    
    
    /*Para agregar un evento */
    public Cliente(String descripcion, String fecha, String hora) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
    }
    /*Para editar un evento*/   
    public Cliente(int idUser, int idAgenda, String descripcion, String fecha, String hora) {
        this.idUser = idUser;
        this.idAgenda = idAgenda;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
    }
    
    
/*Metodos get and set*/
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
/*el metodo toString*/
    @Override
    public String toString() {
        return "Cliente{" + "idUser=" + idUser + ", idAgenda=" + idAgenda + ", descripcion=" + descripcion + ", fecha=" + fecha + ", hora=" + hora + '}';
    }

    
    
    
    
}
