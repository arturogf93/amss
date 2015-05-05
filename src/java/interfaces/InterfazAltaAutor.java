package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlAltaAutor;

public class InterfazAltaAutor extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlAltaAutor ca;

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
    out.println("<TITLE>Alta Autor</TITLE>");
    out.println("<META http-equiv=Content-Type content=\"text/html\">");
    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
    out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\" />");
    out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />");
    out.println("<link rel=\"stylesheet\" href=\"css/position.css\" />");

    out.println("</HEAD>");
    out.println("<BODY id=\"mydiv\">");
    //out.println("<div id=\"mydiv\">");
    out.println("<h1><a href=\"/SEng\">SEng Bytes & Bits</a></h1>");
    out.println("<h2>Dar de Alta Autor</h2>");
    String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
        iniciarAlta(false);
    }else if(operacion.equals("validar")){
       validarAlta(false);
    }
  }
  public void iniciarAlta(boolean error){
    out.println("<p>Indique el Autor y Editorial </p>");
    if (error){
      out.println("<div data-alert class=\"alert-box warning radius\">");
      out.println("Error en idAutor y/o idEditorial");
      out.println("<a href=\"#\" class=\"close\">&times;</a>");
      out.println("</div>");
    }
    out.println("<form class =\"form-group\" data-abide method=\"GET\" action=\"AltaAutor\">");
        out.println("<div class=\"form-group\">");    
            out.println("<label for=\"autor\">Autor</label>");
            out.println("<input required class=\"form-control\" type=\"text\" name=\"autor\"/>");
        out.println("</div>");
       out.println("<div class=\"form-group\">");    
            out.println("<label for=\"editorial\">Editorial</label>");
            out.println("<input required class=\"form-control\" type=\"text\" name=\"editorial\">");
        out.println("</div>");
            out.println("<input type=\"hidden\" name=\"operacion\" value=\"validar\"/>");
            out.println("<input type=\"submit\" value=\"Enviar\"name=\"B1\" class=\"button radius success\">");
            out.println("<a href=\"index.html\" class=\"button radius\">Cancelar</a>");
    out.println("</form>");

    //out.println("</div>");
    out.println("</BODY>");
    out.println("</HTML>");
  }

  public void validarAlta(boolean error){
    out.println("validar");
    ca = new ControlAltaAutor();
    //La funcion trim() elimina espacios antes y despues del valor
    int autor = Integer.parseInt(thisRequest.getParameter("autor").trim());
    int editorial = Integer.parseInt(thisRequest.getParameter("editorial").trim());
    boolean seAlta = ca.Alta(autor, editorial);
    if (seAlta){
      out.println("<p>Autor dado de Alta</p>");
      out.println("<div data-alert class=\"alert-box radius success\">");
      out.println("El autor " + autor + " fue dado de alta. Enhorabuena");
      out.println("</div>");
      out.println("<a href=\"index.html\" class=\"button radius\">Terminar</a>");
      out.println("</div>");
      out.println("</BODY>");
      out.println("</HTML>");
    } else {
        out.println("falso");
       iniciarAlta(true);
    }
  }

}


