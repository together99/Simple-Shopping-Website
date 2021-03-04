package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GoodsDao;
import dao.UserDao;
import po.Goods;

/**
 * Servlet implementation class Helper
 */
@WebServlet("/Helper")
public class Helper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Helper() {
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
		//获得用户名
		String name=(String) request.getAttribute("username");
		//out.println("欢迎 "+name);
		int id=UserDao.findUserId(name);
		HttpSession session = request.getSession();
		session.setAttribute("userId", id);
		
		Collection<Goods> goods=GoodsDao.findAllGoods();
		request.setAttribute("goods", goods);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("showgoods.jsp");
		requestDispatcher.include(request, response);
		//RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListGoods");
		//requestDispatcher.include(request, response);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
