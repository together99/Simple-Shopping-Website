package cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.OrdersDao;
import po.Cart;
import po.Goods;
import po.Orders;
import po.OrdersItem;

/**
 * Servlet implementation class OrderSev
 */
@WebServlet("/OrderSev")
public class OrderSev extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSev() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String operation = request.getParameter("operation");
		if ("submitOrders".equals(operation)) {
			submitOrders(request,response);
		}
		if ("showUserOrders".equals(operation)) {
			 showUserOrders(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void showUserOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		List<Orders> userOrders=OrdersDao.findOrdersById(userId);
		request.setAttribute("UserOrders", userOrders);
		request.getRequestDispatcher("listOrders.jsp").forward(request, response);
	}
	public void submitOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		//PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		//System.out.println("id: u u u u "+userId);
		Cart cart = (Cart) session.getAttribute("cart");
		OrdersItem item=new OrdersItem();
		
		HashMap<Goods, Integer> cgoods=cart.getCGoods();
		//double totalPrice=cart.getTotalPrice();
		for(Goods key:cgoods.keySet()) {
			item.setGoods(key);
			item.setNum(cgoods.get(key));
			item.setTotalPrice(key.getPrice()*cgoods.get(key));
			OrdersDao.addOrder(item, userId, "已发货");
		}
		//int userId = (int)session.getAttribute("userId");
		List<Orders> userOrders=OrdersDao.findOrdersById(userId);
		for(Orders o:userOrders){
			System.out.println(o.getOrdersId());
			System.out.println(o.getItems().getGoods().getName());
		}
		System.out.println("size of order:"+userOrders.size());
		request.setAttribute("UserOrders", userOrders);
		session.removeAttribute("cart");//提交订单后，清空session中的购物车
		request.getRequestDispatcher("pay.jsp").forward(request, response);
		//request.setAttribute("message", "付款成功，请等待店家发货！<span style='font-size: 18px;'><br/><br/>也可点击“我的订单”，查看您的订单信息</span>");
		//request.getRequestDispatcher("listOrders.jsp").forward(request, response);
		
	}
}
