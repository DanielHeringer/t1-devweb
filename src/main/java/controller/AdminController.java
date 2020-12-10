package controller;

import dao.MedicoDAO;
import dao.PacienteDAO;
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

@WebServlet(urlPatterns = "/admin/*")
public class AdminController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private MedicoDAO medicoDAO;
    private PacienteDAO pacienteDAO;

    @Override
    public void init() {
        medicoDAO = new MedicoDAO();
        pacienteDAO = new PacienteDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	Boolean isAdmin = (Boolean) request.getSession().getAttribute("isAdmin");
    	Boolean logado = (Boolean) request.getSession().getAttribute("logado");
    	Erro erros = new Erro();
        if(logado!=null && logado && isAdmin != null && isAdmin){
            String action = request.getPathInfo();
            if (action == null) {
                action = "";
            }

            try {
                switch (action) {
                    case "/medico/cadastro":
                       apresentaFormCadastro(request, response);
                        break;
                    case "/medico/insercao":
                        insere(request, response);
                        break;
                    case "/medico/remocao":
                        remove(request, response);
                        break;
                    case "/medico/edicao":
                        apresentaFormEdicao(request, response);
                        break;
                    case "/medico/atualizacao":
                        atualize(request, response);
                        break;
                    case "/medico":
                        lista(request, response);
                        break;
                    case "/paciente/cadastro":
                       apresentaFormCadastroP(request, response);
                        break;
                    case "/paciente/insercao":
                        insereP(request, response);
                        break;
                    case "/paciente/remocao":
                        removeP(request, response);
                        break;
                    case "/paciente/edicao":
                        apresentaFormEdicaoP(request, response);
                        break;
                    case "/paciente/atualizacao":
                        atualizeP(request, response);
                        break;
                    case "/paciente":
                        listaP(request, response);
                        break;
                    default:
                        listas(request, response);
                        break;
                        
                }
            } catch (RuntimeException | IOException | ServletException e) {
                throw new ServletException(e);
            }   catch (ParseException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else{
            response.sendRedirect(request.getContextPath());
        }
    }


    private void listas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/index.jsp");
        dispatcher.forward(request, response);
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Medico> listaMedicos = medicoDAO.getAll();
        request.setAttribute("listaMedicos", listaMedicos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/medico/lista.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/medico/formulario.jsp");
       dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Medico medico = medicoDAO.get(id);
        request.setAttribute("medico", medico);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/medico/formulario.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String medi_crm = request.getParameter("crm");
        String medi_nome = request.getParameter("nome");
        String medi_email = request.getParameter("email");
        String medi_senha = request.getParameter("senha");
        String medi_telefone = request.getParameter("telefone");
        String medi_especialidade = request.getParameter("especialidade");

        Medico medico = new Medico(medi_email, medi_senha, medi_crm, medi_nome, medi_telefone, medi_especialidade);
        medicoDAO.insert(medico);
        response.sendRedirect(request.getContextPath()+ "/admin/medico");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long medi_id = Long.parseLong(request.getParameter("id"));
        String medi_crm = request.getParameter("crm");
        String medi_nome = request.getParameter("nome");
        String medi_email = request.getParameter("email");
        String medi_senha = request.getParameter("senha");
        String medi_telefone = request.getParameter("telefone");
        String medi_especialidade = request.getParameter("especialidade");

        Medico medico = new Medico(medi_id, medi_email, medi_senha, medi_crm, medi_nome, medi_telefone, medi_especialidade);
        medicoDAO.update(medico);
        response.sendRedirect(request.getContextPath()+"/admin/medico");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Medico medico = new Medico(id);
        medicoDAO.delete(medico);
        response.sendRedirect(request.getContextPath()+"/admin/medico");
    }
    
    
    /////PACIENTES
    
    private void listaP(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Paciente> listaPaciente = pacienteDAO.getAll();
        request.setAttribute("listaPaciente", listaPaciente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/paciente/lista.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormCadastroP(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/paciente/formulario.jsp");
       dispatcher.forward(request, response);
    }
    private void apresentaFormEdicaoP(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Paciente paciente = pacienteDAO.get(id);
        request.setAttribute("paciente", paciente); 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/paciente/formulario.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insereP(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        request.setCharacterEncoding("UTF-8");

        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("sexo");
        
        java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")); 
        Date data_nasc = new Date(date.getTime());
        
        Paciente paciente = new Paciente(nome, email, senha, telefone, cpf, sexo, data_nasc);
        pacienteDAO.insert(paciente);
        
        response.sendRedirect(request.getContextPath()+ "/admin/paciente");
    }

    private void atualizeP(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("sexo");
        
        java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")); 
        Date data_nasc = new Date(date.getTime());
        
        Paciente paciente = new Paciente(id, nome, email, senha, telefone, cpf, sexo, data_nasc);

        pacienteDAO.update(paciente);
        response.sendRedirect(request.getContextPath()+ "/admin/paciente");
    }

    private void removeP(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Paciente paciente = new Paciente(id);
        pacienteDAO.delete(paciente);
        response.sendRedirect(request.getContextPath()+ "/admin/paciente");
    }
}
