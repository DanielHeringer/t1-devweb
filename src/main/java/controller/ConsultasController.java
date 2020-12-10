package controller;
import dao.ConsultaDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import domain.Consulta;
import domain.Medico;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = "/medico/*")
public class ConsultasController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ConsultaDAO dao;

    @Override
    public void init() {
        dao = new ConsultaDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        lista(request, response);
    
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Medico medico = (Medico) request.getSession().getAttribute("medico");
    	System.out.println(request);
    	List<Consulta> listaConsultas = dao.getAll(medico);
        request.setAttribute("listaConsultas", listaConsultas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/medico/lista.jsp");
        dispatcher.forward(request, response);
    }

    

}
