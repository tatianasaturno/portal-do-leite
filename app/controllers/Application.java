package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return redirect(routes.Application.login());
    }
    
    public static Result login() {
    	return ok(login.render());
    }
    
    public static Result home() {
    	return ok(home.render());
    }
    
    public static Result register() {
    	return ok(register.render());
    }

}
