
package dominio;

public class Cliente {
    
    private int bookId;
    private String titulo;

    
    
    public Cliente() {
        
    }

    public Cliente(int bookId) {
        this.bookId = bookId;
    }

    public Cliente(String titulo) {
        this.titulo = titulo;
    }

    public Cliente(int bookId, String titulo) {
        this.bookId = bookId;
        this.titulo = titulo;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "cliente{" + "bookId=" + bookId + ", titulo=" + titulo + '}';
    }
    
    
       
    
    
    
}
