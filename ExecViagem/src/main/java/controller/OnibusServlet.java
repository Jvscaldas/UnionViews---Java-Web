package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Onibus;
import persistence.GenericDao;
import persistence.IOnibusDao;
import persistence.OnibusDao;

@WebServlet("/onibus")
public class OnibusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OnibusServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String botao = request.getParameter("botao");
		
		Onibus o = new Onibus();
		
		GenericDao gDao = new GenericDao();
		IOnibusDao oDao = new OnibusDao(gDao);
		String erro = "";
		String saida = "";
	
		try {
			if (botao.equals("Buscar")) {
				o = valido(id, nome, botao);
				o = oDao.consultaOnibus(o);
			}
		} catch (SQLException | ClassNotFoundException | IOException e){
			erro = e.getMessage();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("onibus.jsp");
			request.setAttribute("onibus", o);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
		
	}
	
	private Onibus valido(String id, String nome, String botao) throws IOException {
		Onibus o = new Onibus();
		
		if (botao.equals("Descrição Ônibus")) {
			if (id.equals("")) {
				throw new IOException("Preencher Código");
			} else {
				o.setPlaca(id);
			}

		}
		
		return o;
		
	}

}
