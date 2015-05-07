package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlAltaAutor;

public class InterfazRegistrarRevista extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlAltaRevista ca;
 
  public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {
    thisResponse = response;
    thisRequest = request;
    thisResponse.setContentType("text/html");
    out = thisResponse.getWriter();
    out.println("<!DOCTYPE HTML>");
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Registrar Revista</TITLE>");
    out.println("<META http-equiv=Content-Type content=\"text/html\">");
    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
    out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\" />");
    out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />");
    out.println("<link rel=\"stylesheet\" href=\"css/position.css\" />");

    out.println("</HEAD>");
    out.println("<BODY id=\"mydiv\">");
    out.println("<h1><a href=\"/SEng\">SEng Bytes & Bits</a></h1>");
    out.println("<h2>Registrar Revista</h2>");
    
    String operacion = request.getParameter("operacion");
    if(operacion == null)
    { 
        input();
    }else if(operacion.equals("validar"))
    {
       registro();
    }
    
  }
  public void input(){
    out.println("<p>Escriba todos los datos </p>");
    out.println("<form class =\"form-group\" data-abide method=\"GET\" action=\"AltaRevista\">");
        out.println("<div class=\"form-group\">");    
            out.println("<label for=\"titulo\">Titulo</label>");
            out.println("<input required class=\"form-control\" type=\"text\" name=\"titulo\"/>");
        out.println("</div>");
       out.println("<div class=\"form-group\">");    
            out.println("<label for=\"numero\">Numero</label>");
            out.println("<input required class=\"form-control\" type=\"text\" name=\"numero\">");
        out.println("</div>");
        out.println("<div class=\"form-group\">");    
            out.println("<label for=\"fecha\">Fecha</label>");
            out.println("<input required class=\"form-control\" type=\"date\" name=\"fecha\">");
        out.println("</div>");
 
            out.println("<input type=\"hidden\" name=\"operacion\" value=\"validar\"/>");
            out.println("<input type=\"submit\" value=\"Enviar\"name=\"B1\" class=\"button radius success\">");
            out.println("<a href=\"index.html\" class=\"button radius\">Cancelar</a>");
    out.println("</form>");

    //out.println("</div>");
    out.println("</BODY>");
    out.println("</HTML>");
  }

  public void registro(){
    out.println("validar");
    ca = new ControlAltaRevista();
    String titulo = (thisRequest.getParameter("titulo"));
    int numero = Integer.parseInt(thisRequest.getParameter("numero"));
    boolean registro = ca.Alta(titulo, numero);
    if (registro){
      out.println("<div data-alert class=\"alert-box radius success\">");
      out.println("La Revista: " + titulo + " fue dado de alta");
      out.println("</div>");
      out.println("<a href=\"index.html\" class=\"button radius\">Menu</a>");
      out.println("</div>");
      out.println("</BODY>");
      out.println("</HTML>");
    } else {
        out.println("falso");
       input();
    }
  }

}


