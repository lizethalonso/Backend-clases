package Mesas;

public class ServicioDescargaProxy implements IServicioDescarga{
    private SpotifyDescarga spotifyDescarga;

    public ServicioDescargaProxy() {
        spotifyDescarga = new SpotifyDescarga();
    }

    @Override
    public String descargar(Usuario usuario, String cancion) {
        if (usuario.getTipoUsuario()==TipoUsuario.tipo.premium){
            return spotifyDescarga.descargar(usuario, cancion);
        }else{
            return "Lo sentimos, esta función está disponible sólo para " +
                    "usuarios premium";
        }
    }
}


