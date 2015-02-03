package edu.uniandes.ecos.Controlador;

import edu.uniandes.ecos.Modelo.ContadorDeLineas;
import edu.uniandes.ecos.Modelo.RespuestaContador;
import edu.uniandes.ecos.Vista.VistaPrincipal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Clase que controla el contador de líneas de código
 *
 * @author JohnDany
 */
public class ControladorContadorLineasCodigo extends HttpServlet {

    /**
     * Clase principal del programa
     *
     * @param args argumentos del método principal
     */
    public static void main(String[] args) {
       //String s = ejecutarConteo();        
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new ControladorContadorLineasCodigo()), "/*");
        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(ControladorContadorLineasCodigo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        VistaPrincipal.showHome(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            VistaPrincipal.showResults(req, resp, this.ejecutarConteo());
        } catch (Exception ex) {
            Logger.getLogger(ControladorContadorLineasCodigo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que ejecuta el conteo de las líneas de codigo fuente
     *
     * @return la respeusta en una cadena.
     */
    private String ejecutarConteo() {
        System.out.println("Se inició conteo del Programa PSP0...");
        ContadorDeLineas contador = new ContadorDeLineas();
        RespuestaContador respuesta = contador.ContarLineasCodigoFuente("src/main/java/ArchivosFuente/psp0", ".java");
        String retorno = "Se inició conteo del Programa PSP0...<br>";

        if (respuesta == null) {
            retorno = retorno + "No se pudo realizar el conteo";
        } else if (respuesta.getError() != null && !respuesta.getError().isEmpty()) {
            retorno = retorno + "Error " + respuesta.getError() + "\n";
        } else {
            retorno = retorno + "Programa PSP0:<br>Cantidad de líneas: " + respuesta.getCantidadLineas() + "\n"
                    + "<br>Cantidad de archivos: " + respuesta.getCantidadArchivos() + "\n";
        }

        System.out.println("Se inició conteo del Programa PSP1...");
        respuesta = null;
        respuesta = contador.ContarLineasCodigoFuente("src/main/java/edu/uniandes/ecos", ".java");
        retorno = retorno + "<br><br>Se inició conteo del Programa PSP1...<br>";
        if (respuesta == null) {
            retorno = retorno + "No se pudo realizar el conteo";
        } else if (respuesta.getError() != null && !respuesta.getError().isEmpty()) {
            retorno = retorno + "Error " + respuesta.getError() + "\n";
        } else {
            retorno = retorno + "Programa PSP1:<br>Cantidad de líneas: " + respuesta.getCantidadLineas() + "\n"
                    + "<br>Cantidad de archivos: " + respuesta.getCantidadArchivos() + "\n";
        }

        return retorno;
    }
}
