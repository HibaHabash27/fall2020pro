package home_search;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class webEmailservice {
	
	final String senderEmailID = "rahafnawas6@gmail.com";
	final String senderPassword = "2324roro";
	final String emailSMTPserver = "smtp.gmail.com"; 			
	final String emailServerPort = "465";
	String receiverEmailID = null;
	static String emailSubject = "Test Mail";
	static String emailBody ;
	
	
	
	public void sendMail(String mail,ArrayList<home_information> arrayList)
	{
		
		System.out.println("send an email");
		
		 
		  this.receiverEmailID=mail; 
		
		  this.emailSubject="test ";
		  // Body
		  for(home_information list1 : arrayList)
		  {
			this.emailBody=this.emailBody+list1.type+" "+list1.material+" "+list1.placement+" "+list1.price+" "+list1.numberOfBathroom1+" "+list1.numberOfBedroom+"\n";  
		  }
		
		  Properties props = new Properties();
		  props.put("mail.smtp.user",senderEmailID);
		  props.put("mail.smtp.host", emailSMTPserver);
		  props.put("mail.smtp.port", emailServerPort);
		  props.put("mail.smtp.starttls.enable", "true");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.socketFactory.port", emailServerPort);
		  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.socketFactory.fallback", "false");
		  SecurityManager security = System.getSecurityManager();
		  try{  
		  Authenticator auth = new SMTPAuthenticator();
		  Session session = Session.getInstance(props, auth);
		  MimeMessage msg = new MimeMessage(session);
		  msg.setText(emailBody);
		  msg.setSubject(emailSubject);
		  msg.setFrom(new InternetAddress(senderEmailID));
		  msg.addRecipient(Message.RecipientType.TO,
		  new InternetAddress(receiverEmailID));
		  Transport.send(msg);
		  System.out.println("Message send Successfully:)"); }
		  
		  catch (Exception mex){
		  mex.printStackTrace();}
		
		  
		  }
		  public class SMTPAuthenticator extends javax.mail.Authenticator
		  {
		  public PasswordAuthentication getPasswordAuthentication()
		  {
		  return new PasswordAuthentication(senderEmailID, senderPassword);
		  }
		  } 
		  

	
	
	}


