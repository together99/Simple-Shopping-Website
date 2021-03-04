package register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import po.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String Conpassword=request.getParameter("Conpassword");
		User user=new User();
		user.setUsername(username);
		user.setPassword(Conpassword);
		UserDao userDao=new UserDao();
		
		//String tokenform=request.getParameter("token");
		//String tokensession=(String)request.getSession().getAttribute("token");
		if(!password.equals(Conpassword)) {
			out.println("<br><h2 style=\"color: orange;text-align: center;\">");
			out.println("两次密码不一致，请重新输入！");
			out.println("</h2>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("RegIndex");
			requestDispatcher.include(request, response);
		}
		
		//if(tokenform.equals(tokensession)) {
			request.getSession().removeAttribute("token");
			if(userDao.insertUser(user)==0) {
				out.println("<script type=\"text/javascript\">");
				out.println("window.alert('注册失败，请重新注册！(*^_^*) ');");
				out.println("</script>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("RegIndex");
				requestDispatcher.include(request, response);
			}else {
				
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
				requestDispatcher.include(request, response);
				response.setContentType("text/html;charset=utf-8");
				out.println("<script type=\"text/javascript\">");
				out.println("window.alert('注册成功，请登录！(*^_^*)');");
				out.println("</script>");
			}
		}
	/*else {
			out.println("<script type=\"text/javascript\">");
			out.println("window.alert('(*^_^*) ');");
			out.println("</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
