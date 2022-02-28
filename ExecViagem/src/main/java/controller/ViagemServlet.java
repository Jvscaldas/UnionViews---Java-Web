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
		String botao = request.getParameter("botao");

		Viagem v = new Viagem();
		Onibus o = new Onibus();

		GenericDao gDao = new GenericDao();
		IViagemDao vDao = new ViagemDao(gDao);
		String erro = "";
		String saida = "";

		try {
			if (botao.equals("Descrição Viagem")) {
				v = valido(id, botao);
				v = vDao.consultaViagem(v);
			}
			if (botao.equals("Descrição Ônibus")) {
				v = valido(id, botao);
				v = vDao.consultaOnibus(v);
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("viagem.jsp");
			request.setAttribute("viagem", v);
			request.setAttribute("onibus", o);;
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
	}

	private Viagem valido(String id, String botao) throws IOException {
		Viagem v = new Viagem();

		if (botao.equals("Descrição Viagem")) {
			if (id.equals("")) {
				throw new IOException("Preencher Código");
			} else {
				v.setCodigo(Integer.parseInt(id));
			}
		}

		if (botao.equals("Descrição Ônibus")) {
			if (id.equals("")) {
				throw new IOException("Preencher Código");
			} else {
				v.setCodigo(Integer.parseInt(id));
			}
		}

		return v;

	}
}
