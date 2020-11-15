package home_search;

import static org.mockito.Mockito.*;

public class mockEmailHolder {
    private webEmailservice emailservice=mock(webEmailservice.class);
	//private webEmailservice emailservice=new webEmailservice();
	public mockEmailHolder(Search home)
	{
		home.setemail(emailservice);
	}
	
	
	public webEmailservice getEmail()
	{
		return emailservice;
		
	}
	public void setEmail(webEmailservice emailservice)
	{
		this.emailservice=emailservice;
		
	}
  
}
