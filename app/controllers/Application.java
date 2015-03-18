package controllers;

import java.util.List;

import models.dao.ApplicationDAO;
import models.Tema;
import play.*;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	private static ApplicationDAO dao = new ApplicationDAO();

    public static Result index() {
        return redirect(routes.Application.login());
    }
    
    public static Result login() {
    	return ok(login.render());
    }
    
    @Transactional
    public static Result home() {
    	List<Tema> temas = dao.getAllByClass(Tema.class);
    	return ok(home.render(temas));
    }
    
    public static Result register() {
    	return ok(register.render());
    }
    
    @Transactional
    public static Result details(Long id){
    	Tema temaSelecionado = dao.getElementById(Tema.class, id);
    	return ok(details.render(temaSelecionado));
    }

}
