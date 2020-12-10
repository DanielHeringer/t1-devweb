package controller;

import dao.ConsultaDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import domain.Consulta;
import domain.Medico;
import domain.Paciente;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import util.Erro;

@WebServlet(urlPatterns = "/paciente/*")
public class PacienteController extends HttpServlet {

    private MedicoDAO medicoDAO;
    private PacienteDAO pacienteDAO;
    private ConsultaDAO consultaDAO;
    private Paciente paciente;
    

    @Override
    public void init() {
        medicoDAO = new MedicoDAO();
        pacienteDAO = new PacienteDAO();
        consultaDAO = new ConsultaDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	Boolean logado = (Boolean) request.getSession().getAttribute("logado");
    	paciente = (Paciente) request.getSession().getAttribute("paciente");
    	Erro erros = new Erro();
        if(logado!=null && logado && paciente != null){
            String action = request.getPathInfo();
            if (action == null) {
                action = "";
            }

            try {
                switch (action) {
                    case "/agendar":
                        apresentaFormAgendar(request, response);
                        break;
                    case "/insere":
                        agendar(request, response);
                        break;
                    default:
                        lista(request, response);
                        break;
                        
                }
            } catch (RuntimeException | IOException | ServletException e) {
                throw new ServletException(e);
            }   catch (ParseException ex) { 
                    Logger.getLogger(PacienteController.class.getName()).log(Level.SEVERE, null, ex);
                } 
        }
        else{
            response.sendRedirect(request.getContextPath());
        }
    }
    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Paciente paciente = (Paciente) request.getSession().getAttribute("paciente");
        List<Consulta> listaConsulta = consultaDAO.getAllPaciente(paciente);
        request.setAttribute("listaConsulta", listaConsulta);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/paciente/lista.jsp");
        dispatcher.forward(request, response);
    }
    
    
    private void apresentaFormAgendar(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        List<Medico> listaMedico = medicoDAO.getAll();
        request.setAttribute("listaMedico", listaMedico);
       RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/paciente/formulario.jsp");
       dispatcher.forward(request, response);
    }
    
    private void agendar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        request.setCharacterEncoding("UTF-8");
        Long medicoId = Long.parseLong(request.getParameter("medico"));
        
        java.util.Date date = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(request.getParameter("data")); 
        java.sql.Timestamp data = new java.sql.Timestamp(date.getTime());
        
        Consulta consulta = new Consulta(paciente.getId(), medicoId, data);
        consultaDAO.insert(consulta);
        
        response.sendRedirect(request.getContextPath()+ "/paciente");
    }

}
