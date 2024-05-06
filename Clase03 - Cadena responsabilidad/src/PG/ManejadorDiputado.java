package PG;

public class ManejadorDiputado extends Manejador{
    public ManejadorDiputado(Integer nivelAcceso) {
        super(nivelAcceso);
    }

    @Override
    public String comprobarDocumento(Documento documento) {
        if (documento.getTipo() == super.getAcceso()) {
            if (getSiguienteManejador() != null) {
                System.out.println("Sr, Diputado, estamos descargando el documento " +
                        documento.getContenido() + " de categoría " +
                        documento.getTipo() + " para su lectura");
                return getSiguienteManejador().comprobarDocumento(documento);
            }
        } else {
            System.out.println("Lo sentimos, el Diputado no se encuentra autorizado " +
                    "para leer documentos de categoría " + documento.getTipo());
            if (getSiguienteManejador() != null) {
                return getSiguienteManejador().comprobarDocumento(documento);
            }
        }return null;
    }
}
