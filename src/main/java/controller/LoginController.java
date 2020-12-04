package controller;

import dao.MedicoDAO;
import dao.PacienteDAO;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Medico;
import domain.Paciente;
import javax.swing.JOptionPane;
import util.Erro;

@WebServlet(name = "Index", urlPatterns = { "/dologin.jsp", "/logout.jsp" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            
            doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Erro erros = new Erro();
		if (request.getParameter("bOK") != null) {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			if (login == null || login.isEmpty()) {
				erros.add("Login não informado!");
			}
			if (senha == null || senha.isEmpty()) {
				erros.add("Senha não informada!");
			}
			if (!erros.isExisteErros()) {
                            if(login.equals("admin") && senha.equals("admin")){
                                //LOGIN ADMIN
                                request.getSession().setAttribute("isAdmin", true);                                
                                request.getSession().setAttribute("logado", true);
                                response.sendRedirect("admin/");
                            }
                            else{
                                Medico medico = this.loginMedico(login, senha);
                                if(medico != null){
                                    //LOGIN MEDICO
                                    request.getSession().setAttribute("medico", medico);                              
                                    request.getSession().setAttribute("logado", true);
                                    request.getSession().setAttribute("isAdmin", false);
                                    response.sendRedirect("logado/medico/");
                                }
                                else{
                                    Paciente paciente = this.loginPaciente(login, senha);
                                    if(paciente != null){
                                        //  LOGIN PACIENTE
                                        request.getSession().setAttribute("paciente", paciente);                              
                                        request.getSession().setAttribute("logado", true);
                                        request.getSession().setAttribute("isAdmin", false);  
                                        response.sendRedirect("logado/paciente/");
                                    }
                                    else{
                                        erros.add("Senha incorreta!");
                                        this.voltaLogin(request, response, erros);
                                    }
                                }
                                
                            }	
			}
                        else{
                            this.voltaLogin(request, response, erros);
                        }
		}
	}
        
        protected void voltaLogin(HttpServletRequest request, HttpServletResponse response, Erro erros)
                throws ServletException, IOException{
            
            request.getSession().invalidate();

            request.setAttribute("mensagens", erros);

            String URL = "/login.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(URL);
            rd.forward(request, response);
        }
        
        protected Paciente loginPaciente(String paci_email, String paci_senha){
            PacienteDAO pacienteDAO = new PacienteDAO();
            Paciente paciente = pacienteDAO.login(paci_email, paci_senha);
            return paciente;
        }
        
        protected Medico loginMedico(String medi_email, String medi_senha){
            MedicoDAO medicoDAO = new MedicoDAO();
            Medico medico = medicoDAO.login(medi_email, medi_senha);
            return medico;
        }
}