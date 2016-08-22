package tweets;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetTweets
 */
public class GetTweets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTweets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	      response.setContentType("text/html");

	      // Actual logic goes here.
	      PrintWriter out = response.getWriter();

		doGet(request, response);
		String username=request.getParameter("handler");
		TwitterHandler call=new TwitterHandler();
		ArrayList<String> a1=new ArrayList<String>();
				a1.addAll(call.retrieve(username,7));
		out.println("<h1>Tweest are</h1>");
		for(String print1:a1)
		{
			out.println("<br/>");
			out.print(print1.toString());///tweest ouput
		}
		TwitterHandler.getSharedFriendsBetWeenTwoUsers("", "");
		List<Long> common = null;
		//common.addAll(GetStatus.getSharedFriendsBetWeenTwoUsers("a", "a"));
		//out.println(common.toString());		
		
	}

}
