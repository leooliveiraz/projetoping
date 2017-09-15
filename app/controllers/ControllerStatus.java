package controllers;

import models.StatusPing;
import play.mvc.Controller;
import play.mvc.Result;
import regras.RegraStatus;

public class ControllerStatus extends Controller {

    public static Result enviaPing() {
    	StatusPing statusPing = new StatusPing();
        return ok(RegraStatus.converteParaJson(statusPing));
    }
    
    public static Result recebePing(){
    	RegraStatus.recebePing("http://testes.empregosmogi.com/ping");	
		return TODO;
    	
    }

}
