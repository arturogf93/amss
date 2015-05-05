package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlVotar;
import javax.servlet.annotation.WebServlet;

public class InterfazVotar extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlVotar cv;

  //Es importante observar que todos los metodos definen la operacion GET para
  //que el metodo doGet sea el que se ejecuta al presionar el boton "Enviar". 
  public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {
    thisResponse = response;
    thisRequest = request;
    thisResponse.setContentType("text/html");
    out = thisResponse.getWriter();
    //Preparar el encabezado de la pagina Web de respuesta
    out.println("<!DOCTYPE HTML>");
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Votar Articulo</TITLE>");
    out.println("<META http-equiv=Content-Type content=\"text/html\">");
    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
    out.println("<link rel=\"stylesheet\" href=\"Interfaces/css/foundation.min.css\" />");
    out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\" />");
    out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />");
    out.println("<link rel=\"stylesheet\" href=\"css/position.css\" />");

    out.println("</HEAD>");
    out.println("<BODY id=\"mydiv\">");
    out.println("<h1><a href=\"/SEng\">SEng Bytes & Bits</a></h1>");
    out.println("<h2>Votar</h2>");
    String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
      iniciarVotacion(false);
    }else if(operacion.equals("validar")){
       validarVotacion(false);
    }
  }
  public void iniciarVotacion(boolean error){
    out.println("<p>Indique el idJuez, idEdicion, idArticulo </p>");
    if (error){
      out.println("<div data-alert class=\"alert-box warning radius\">");
      out.println("Error en idJuez, idEdicion y/o idArticulo");
      out.println("<a href=\"#\" class=\"close\">&times;</a>");
      out.println("</div>");
    }
    out.println("<form data-abide method=\"GET\" action=\"Votar\">");
    out.println("<p> Juez <input required type=\"text\" name=\"juez\" size=\"15\"></p>");
    out.println("<p> Edicion <input required type=\"text\" name=\"edicion\" size=\"15\"></p>");
    out.println("<p> Articulo <input required type=\"text\" name=\"articulo\" size=\"15\"></p>");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"validar\"/>");
    out.println("<input type=\"submit\" value=\"Enviar\"name=\"B1\" class=\"button radius success\">");
    out.println("<a href=\"index.html\" class=\"button radius\">Cancelar</a>");
    out.println("</form>");

    out.println("</div>");

    out.println("</BODY>");
    out.println("</HTML>");
  }

  public void validarVotacion(boolean error){
    cv = new ControlVotar();
    //La funcion trim() elimina espacios antes y despues del valor
    int juez = Integer.parseInt(thisRequest.getParameter("juez").trim());
    int edicion = Integer.parseInt(thisRequest.getParameter("edicion").trim());
    int articulo = Integer.parseInt(thisRequest.getParameter("articulo").trim());
    boolean seVoto = cv.votar(juez,edicion,articulo);
    if (seVoto){
      out.println("<p>Votacion</p>");
      out.println("<div data-alert class=\"alert-box radius success\">");
      out.println("<p>Gracias por Votar.</p>");
      out.println("</div>");
      out.println("<a href=\"index.html\" class=\"button radius\">Terminar</a>");
      out.println("</div>");

      out.println("</BODY>");
      out.println("</HTML>");
    } else {
       iniciarVotacion(true);
    }
  }

}
