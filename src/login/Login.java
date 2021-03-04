package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import po.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		request.setAttribute("username", username);
		HttpSession session=request.getSession();
		String checkcode=(String) session.getAttribute("checkcode");
		String code=request.getParameter("check");
		UserDao userDao=new UserDao();
		User user=(User)request.getAttribute("user");
		
		System.out.println("it is acccc "+user);
		if(checkcode.equals(code)) {
			int state=userDao.findUser(user);
			if(state==1) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Helper");
				requestDispatcher.forward(request, response);
			}
			if(state==0) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
				requestDispatcher.include(request, response);
				out.println("<script type=\"text/javascript\">");
				out.println("window.alert('您还没有注册！请注册(*^_^*) ');");
				out.println("</script>");
				out.println("<br><h2 style=\"color: blue;text-align: center;\">");
				//out.println("�û��������ڣ����������� (*^_^*) ��");
				out.println("</h2>");
			}
			else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
				requestDispatcher.include(request, response);
				out.println("<script type=\"text/javascript\">");
				out.println("window.alert('密码错误，请重新输入 (*^_^*) ');");
				out.println("</script>");
				out.println("<br><h2 style=\"color: blue;text-align: center;\">");
				out.println("密码错误，请重新输入 (*^_^*) ！");
				out.println("</h2>");
				
			}
			
			
		}
		else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.include(request, response);
			out.println("<script>");
			out.println("window.alert('验证码不正确(*^_^*) ！');");
			out.println("</script>");
			out.println("<br><h2 style=\"color: blue;text-align: center;\">");
			out.println("请重新输入验证码(*^_^*) ��");
			out.println("</h2>");
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
