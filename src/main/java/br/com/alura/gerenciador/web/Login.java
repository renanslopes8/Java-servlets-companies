package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

public class Login implements JobInterface{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp){
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		if (usuario == null) {
			return "/WEB-INF/views/usuarioInvalido.jsp";
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
			return "/WEB-INF/views/index.jsp";
		}
	}
}
