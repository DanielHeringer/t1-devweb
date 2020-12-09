package controller;

import bean.ListaMedicosBean;
import domain.Medico;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/buscaPorEspecialidade"})
public class BuscaporEspecialidadeController extends HttpServlet {

    private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String especialidade = request.getParameter("term");

        Gson gsonBuilder = new GsonBuilder().create();
        List<String> medicos = new ArrayList<>();
        for (Medico medico : new ListaMedicosBean().getMedicos(especialidade)) {
        	System.out.println(medico);
        	medicos.add(medico.toString());
        }

        System.out.println(gsonBuilder.toJson(medicos));
        response.getWriter().write(gsonBuilder.toJson(medicos));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}