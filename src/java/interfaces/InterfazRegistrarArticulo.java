package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlAltaAutor;

public class InterfazRegistrarArticulo extends HttpServlet {
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
    out.println("<TITLE>Registrar Articulo</TITLE>");
    out.println("<META http-equiv=Content-Type content=\"text/html\">");
    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
    out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\" />");
    out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />");
    out.println("<link rel=\"stylesheet\" href=\"css/position.css\" />");

    out.println("</HEAD>");
    out.println("<BODY id=\"mydiv\">");
    //out.println("<div id=\"mydiv\">");
    out.println("<h1><a href=\"/SEng\">SEng Bytes & Bits</a></h1>");
    out.println("<h2>Registrar Articulo</h2>");
    String operacion = request.getParameter("operacion");
    if(operacion == null)
    { 
        input();
    }else if(operacion.equals("validar")){
       registro();
    }
  }
  public void input(){
    out.println("<p>Escriba todos los datos </p>");
    out.println("<form class =\"form-group\" data-abide method=\"GET\" action=\"AltaAutor\">");
        out.println("<div class=\"form-group\">");    
            out.println("<label for=\"autor\">Autor</label>");
            out.println("<input required class=\"form-control\" type=\"text\" name=\"autor\"/>");
        out.println("</div>");
       out.println("<div class=\"form-group\">");    
            out.println("<label for=\"revista\">Revista</label>");
            out.println("<input required class=\"form-control\" type=\"text\" name=\"revista\">");
        out.println("</div>");
        out.println("<div class=\"form-group\">");    
            out.println("<label for=\"si\">Autorizado</label>");
            out.println("<input required class=\"form-control\" type=\"radio\" value=\"1\" name=\"si\">");
            out.println("<input required class=\"form-control\" type=\"radio\" value=\"0\" name=\"no\">");
        out.println("</div>");
        out.println("<div class=\"form-group\">");    
            out.println("<label for=\"titulo\">Titulo</label>");
            out.println("<input required class=\"form-control\" type=\"text\" name=\"titulo\">");
        out.println("</div>");
        
        out.println("<div class=\"form-group\">");    
            out.println("<label for=\"titulo\">Fecha</label>");
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
    ca = new ControlAltaAutor();
    //La funcion trim() elimina espacios antes y despues del valor
    String autor = (thisRequest.getParameter("autor"));
    String titulo = (thisRequest.getParameter("titulo"));
    int idRevista = Integer.parseInt(thisRequest.getParameter("revista").trim());
    //Date fecha = (thisRequest.getParameter("fecha"));
    boolean registro = ca.Alta(autor, titulo, idRevista);
    if (registro){
      out.println("<div data-alert class=\"alert-box radius success\">");
      out.println("El articulo: " + titulo + " fue dado de alta");
      out.println("</div>");
      out.println("<a href=\"index.html\" class=\"button radius\">Terminar</a>");
      out.println("</div>");
      out.println("</BODY>");
      out.println("</HTML>");
    } else {
        out.println("falso");
       input();
    }
  }

}


