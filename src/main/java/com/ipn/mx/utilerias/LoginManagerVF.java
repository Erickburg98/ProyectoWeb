
package com.ipn.mx.utilerias;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginManagerVF {
    
    private final static String LOGIN_NAME_SESSION_ATTRIBUTE = "nombreUsuario";
    
    public void login(HttpServletRequest request, HttpServletResponse response, String nombreUsuario){
        HttpSession session = request.getSession(true);
        session.setAttribute(LOGIN_NAME_SESSION_ATTRIBUTE, nombreUsuario);   
    }
    
    public void Logout(HttpServletRequest request, HttpServletResponse response){
         HttpSession session = request.getSession(false);
         session.removeAttribute("nombreUsuario");
         if(session != null){
             session.invalidate();
        }
    }
    
    public boolean getLoginName(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(false);
        if(session == null){
            return false;
        }
        else{
            return session.getAttribute(LOGIN_NAME_SESSION_ATTRIBUTE) != null;
        }
    }
}
    

