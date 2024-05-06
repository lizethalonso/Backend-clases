package PG;

public class ManejadorPresidente extends Manejador{
    public ManejadorPresidente(Integer nivelAcceso) {
        super(nivelAcceso);
    }

    @Override
    public String comprobarDocumento(Documento documento) {
        System.out.println("Sr. Presidente, estamos descargando el documento " +
                    documento.getContenido() + " de categoría " +
                    documento.getTipo() + " para su lectura");
        System.out.println("----------------------------------------------------------------------------------------");
        return "Final de la cadena";
    }
}
