package com.ipn.mx.utilerias;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Utilerias {
    public void enviarEmail(String correoDestinatario, String asunto, String texto){
        try{
            Properties p =new Properties();
            p.setProperty("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.starttls.required", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", "languages3chool@gmail.com");
            p.setProperty("mail.smtp.auth", "true");
      
            Session s = Session.getDefaultInstance(p);
            MimeMessage mensaje= new MimeMessage(s);
            mensaje.setFrom(new InternetAddress("languages3chool@gmail.com"));
            mensaje.addRecipients(Message.RecipientType.TO, correoDestinatario);
            
            mensaje.setSubject(asunto);
            mensaje.setText(texto);
            
            Transport t = s.getTransport("smtp");
            t.connect("smtp.gmail.com", "languages3chool@gmail.com","Sch00!!!");
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Utilerias u = new Utilerias();
        String cd= "angel_andrade_98@hotmail.com.mx";
        String asunto = "Confirmacion de registro en PachAcademy";
        String texto = "Estimado, "+ "Angel" +" "+ "Andrade"
            +"\nHemos confirmado su registro y le informamos que usted ha sido registrado como un Alumno"
            +" de nuestra institucion PachAcademy exitosamente."
            +"\n\n\n\n Por favor, no responder a este correo gracias.";
        u.enviarEmail(cd, asunto, texto);
    }
    
}
