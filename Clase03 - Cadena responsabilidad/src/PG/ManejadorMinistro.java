package PG;

public class ManejadorMinistro extends Manejador{
    public ManejadorMinistro(Integer nivelAcceso) {
        super(nivelAcceso);
    }

    @Override
    public String comprobarDocumento(Documento documento) {
        if (documento.getTipo() != 3) {
            if (getSiguienteManejador() != null){
                System.out.println("Sr. Ministro, estamos descargando el documento " +
                        documento.getContenido() + " de categoría " +
                        documento.getTipo() + " para su lectura");
                return getSiguienteManejador().comprobarDocumento(documento);
            }
        } else {
            System.out.println("Lo sentimos, el Ministro no se encuentra autorizado " +
                    "para leer documentos de categoría " + documento.getTipo());
            if (getSiguienteManejador() != null) {
                return getSiguienteManejador().comprobarDocumento(documento);
            }
        }return null;
    }
}
