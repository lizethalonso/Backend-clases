package Mesas;

public class SpotifyDescarga implements IServicioDescarga {

    @Override
    public String descargar(Usuario usuario,String cancion) {

        return "Estimado/a " + usuario.getId() + " se está descargando la canción " + cancion;
    }


}
