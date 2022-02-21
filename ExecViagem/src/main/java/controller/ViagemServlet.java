package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Viagem;
import persistence.GenericDao;
import persistence.IViagemDao;
import persistence.ViagemDao;

@WebServlet("/viagem")
public class ViagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViagemServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String botao = request.getParameter("botao");

		Viagem v = new Viagem();

		GenericDao gDao = new GenericDao();
		IViagemDao vDao = new ViagemDao(gDao);
		String erro = "";
		String saida = "";

		try {
			if (botao.equals("Descrição Viagem")) {
				v = valido(id, nome, botao);
				v= vDao.consultaViagem(v);
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("viagem.jsp");
			request.setAttribute("viagem", v);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
	}

	private Viagem valido(String id, String nome, String botao) throws IOException {
		Viagem v = new Viagem();
		
		if(botao.equals("Descrição Viagem")) {
			if (id.equals("")) {
				throw new IOException("Preencher Código");
			} else {
				v.setCodigo(Integer.parseInt(id));
			}
		}
		
		return v;
		
	}
	
}
