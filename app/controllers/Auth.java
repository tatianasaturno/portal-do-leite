package controllers;

import java.util.List;

import models.Aluno;
import models.dao.ApplicationDAO;
import play.Logger;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Auth extends Controller{
	
	private static ApplicationDAO dao = new ApplicationDAO();
	private static Form<Aluno> form = Form.form(Aluno.class).bindFromRequest();
	
	@Transactional
	public static Result registrar(){
		Aluno aluno = form.get();
		
		if(form.hasErrors()){
			flash("fail");
			return badRequest(register.render());
		} else {
			/*Aluno novoAluno = new Aluno();
			novoAluno.setNome(aluno.field("nome").value());
			novoAluno.setUsername(aluno.field("username").value());
			novoAluno.setSenha(aluno.field("senha").value());*/
			
			dao.persist(aluno);
			Logger.debug("teste " + dao.getByAttributeName(Aluno.class, "username", "sasa").size());
			return ok(login.render());
		}
	}
	
	
	@Transactional
	public static Result logar(){
		Form<Aluno> aluno = form.bindFromRequest();
		
		if(aluno.hasErrors() || !validar(aluno.field("username").value(), aluno.field("senha").value())){
			flash("fail");
			return badRequest(login.render());
		} else {
			Aluno alunoAtual = dao.getByAttributeName(Aluno.class, "username", aluno.field("username").value()).get(0);
			session().clear();
			session("user", alunoAtual.getUsername());
			return ok();
		}
	}
	
	
	@Transactional
	public static Result deslogar() {
		session().clear();
		return redirect(routes.Application.login());
	}
	
	@Transactional
	private static boolean validar(String username, String senha) {
		List<Aluno> aluno = dao.getByAttributeName(Aluno.class, "username", username);
		Logger.debug("Tamanho " + aluno.size());
		
		if (aluno == null || aluno.isEmpty()) {
			return false;
		}
		
		if (!aluno.get(0).getSenha().equals(senha)) {
			return false;
		}
		
		return true;
	}
}
