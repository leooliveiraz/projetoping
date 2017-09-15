package controllers;

import play.mvc.*;
import regras.RegraStatus;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    public static Result inicio() {
        return ok(inicio.render(RegraStatus.getListaPingsRecebidos()));
    }

}
