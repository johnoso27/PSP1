package edu.uniandes.ecos.Vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Clase que representa la vista principal del programa
 *
 * @author JohnDany
 */
public class VistaPrincipal {

    /**
     * Métod que muestra la página de inicio de la aplicación.
     *
     * @param req llamado de la página
     * @param resp respuesta de la página
     * @throws ServletException
     * @throws IOException
     */
    public static void showHome(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.println("<h1>Programa PSP1</h1>");
        pw.write("<form  method=\"post\">\n"
                + "<div><h2>Conteo de líneas de código fuente</h2></div> \n"
                + "<div><input type=\"submit\" value=\"Calcular\"></div>\n"
                + "</form> ");
        pw.write("</html>");
    }

    /**
     * Método que muestra los resultados del conteo
     *
     * @param req llamado de la página
     * @param resp respuesta de la página
     * @param resultado del conteo de líneas de código fuente
     * @throws ServletException
     * @throws IOException
     */
    public static void showResults(HttpServletRequest req, HttpServletResponse resp, String resultado)
            throws ServletException, IOException {
        resp.getWriter().println("<b>Resultado del conteo:</b><br> " + resultado + "<br>");
    }

    /**
     * Método que controla la presentación de errores.
     *
     * @param req llamado de la página
     * @param resp respuesta de la página
     * @throws ServletException
     * @throws IOException
     */
    public static void error(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().println("Vaya se ha presentado un error!");
    }
}
