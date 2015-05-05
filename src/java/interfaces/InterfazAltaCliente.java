package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlAltaCliente;
public class InterfazAltaCliente extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlAltaCliente ca;
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
    out.println("<TITLE>Suscripcion</TITLE>");
    out.println("<META http-equiv=Content-Type content=\"text/html\">");
    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
    out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\" />");
    out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />");
    out.println("<link rel=\"stylesheet\" href=\"css/position.css\" />");
    out.println("</HEAD>");
    out.println("<BODY id=\"mydiv\">");
    //out.println("<div id=\"mydiv\">");
    out.println("<h1><a href=\"/SEng\">SEng Bytes & Bits</a></h1>");
    out.println("<h2>Dar de alta Cliente</h2>");
    String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
        iniciarAlta(false);
    }else if(operacion.equals("validar")){
       validarAlta(false);
    }
  }
  public void iniciarAlta(boolean error){
    out.println("<p>Escriba todos los datos.</p>");
    if (error){
      out.println("<div data-alert class=\"alert-box warning radius\">");
      out.println("Error en idAutor y/o idEditorial");
      out.println("<a href=\"#\" class=\"close\">&times;</a>");
      out.println("</div>");
    }
    out.println("<form class =\"form-group\" data-abide method=\"GET\" action=\"AltaCliente\">");
        out.println("<div class=\"form-group\">");    
            out.println("<label for=\"nombre\">Nombre</label>");
            out.println("<input required class=\"form-control\" type=\"text\" name=\"nombre\"/>");
        out.println("</div>");
       out.println("<div class=\"form-group\">");    
            out.println("<label for=\"direccion\">Direccion</label>");
            out.println("<input required class=\"form-control\" type=\"text\" name=\"direccion\">");
        out.println("</div>");
        out.println("<div class=\"form-group\">");    
            out.println("<label for=\"usuario\">Usuario</label>");
            out.println("<input required class=\"form-control\" type=\"text\" name=\"usuario\">");
        out.println("</div>");
        out.println("<div class=\"form-group\">");    
            out.println("<label for=\"password\">Paassword</label>");
            out.println("<input required class=\"form-control\" type=\"password\" name=\"password\">");
        out.println("</div>");
        out.println("<div class=\"form-group\">");    
            out.println("<label for=\"copias\">Numero de Copias</label>");
            out.println("<input required class=\"form-control\" type=\"text\" name=\"copias\">");
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
    ca = new ControlAltaCliente();
    //La funcion trim() elimina espacios antes y despues del valor
    String nombre = (thisRequest.getParameter("nombre"));
    String direccion = (thisRequest.getParameter("direccion"));
    String usuario = (thisRequest.getParameter("usuario"));
    String password = (thisRequest.getParameter("password"));
    int copia = Integer.parseInt(thisRequest.getParameter("copias").trim());
    boolean seAlta = ca.Alta(nombre, direccion,usuario, password, copia);
    if (seAlta){
      out.println("<p>Autor dado de Alta</p>");
      out.println("<div data-alert class=\"alert-box radius success\">");
      out.println("El Cliente " + nombre + " fue dado de alta.");
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