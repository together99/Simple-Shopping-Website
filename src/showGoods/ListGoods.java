package showGoods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsDao;
import po.Goods;

/**
 * Servlet implementation class ListGoods
 */
@WebServlet("/ListGoods")
public class ListGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListGoods() {
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
		
		Collection<Goods> goods=GoodsDao.findAllGoods();
		out.println("<ul>");
		for(Goods good:goods) {
			out.println("<li>");
			String url=request.getContextPath()+"/Pur?id="+good.getId();
			out.println("<img src='FindImgById?id="+good.getId()+"' style=\"width: 100px;height: 70px;\"/>");
			out.println(good.getName()+"   "+good.getPrice()+"Ôª&nbsp&nbsp&nbsp<a href='"+url+"'>µã»÷¹ºÂò</a></br>");
			out.println("</li>");
		}
		out.println("</ul>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
