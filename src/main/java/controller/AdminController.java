package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Erro;

@WebServlet(urlPatterns = "/admin/*")
public class AdminController extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
            response.sendRedirect(request.getContextPath()+"/logado/admin");
        }
        else{
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }
}