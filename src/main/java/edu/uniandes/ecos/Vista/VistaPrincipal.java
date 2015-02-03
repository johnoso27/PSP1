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
     * M�tod que muestra la p�gina de inicio de la aplicaci�n.
     *
     * @param req llamado de la p�gina
     * @param resp respuesta de la p�gina
     * @throws ServletException
     * @throws IOException
     */
    public static void showHome(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.println("<h1>Programa PSP1</h1>");
        pw.write("<form  method=\"post\">\n"
                + "<div><h2>Conteo de l�neas de c�digo fuente</h2></div> \n"
                + "<div><input type=\"submit\" value=\"Calcular\"></div>\n"
                + "</form> ");
        pw.write("</html>");
    }

    /**
     * M�todo que muestra los resultados del conteo
     *
     * @param req llamado de la p�gina
     * @param resp respuesta de la p�gina
     * @param resultado del conteo de l�neas de c�digo fuente
     * @throws ServletException
     * @throws IOException
     */
    public static void showResults(HttpServletRequest req, HttpServletResponse resp, String resultado)
            throws ServletException, IOException {
        resp.getWriter().println("<b>Resultado del conteo:</b><br> " + resultado + "<br>");
    }

    /**
     * M�todo que controla la presentaci�n de errores.
     *
     * @param req llamado de la p�gina
     * @param resp respuesta de la p�gina
     * @throws ServletException
     * @throws IOException
     */
    public static void error(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().println("Vaya se ha presentado un error!");
    }
}
