package servlets;


import persistency.CidadePersistency;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cidade;

@WebServlet(urlPatterns = {"/Cidades"})
public class Cidades extends HttpServlet {

    private CidadePersistency persistency = new CidadePersistency();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.println("<h1>Todas as cidades do Brasil!</h1>");
        pw.println("<ul>");
        ArrayList<Cidade> cidades = this.persistency.index();
        for (Cidade c : cidades) {
            pw.println("<li>");
            pw.println(c.getNome());
            pw.println("</li>");
        }
        pw.println("</ul>");
    }

}
