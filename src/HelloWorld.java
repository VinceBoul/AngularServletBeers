// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Extend HttpServlet class

@WebServlet("/Test2")
public class HelloWorld extends HttpServlet {
 

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public HelloWorld(){
	  super();
  }
  
  public void init() throws ServletException
  {
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // Set response content type
      response.setContentType("text/html");
      RequestDispatcher rd = request.getRequestDispatcher("NewFile.jsp");
      rd.forward(request, response);
      
  }
  
  public void destroy()
  {
      // do nothing.
  }
}