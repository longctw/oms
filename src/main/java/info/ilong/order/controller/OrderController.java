package info.ilong.order.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import info.ilong.oms.pojo.Order;
import info.ilong.order.service.OrderService;
import info.ilong.utils.EasyUIResult;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.OrderQuery;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("{id}")
	@ResponseBody
	public Order getOrderById(@PathVariable int id){
		return orderService.getOrderById(id);
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIResult orderList(int page, int rows, OrderQuery query){
		EasyUIResult result = orderService.getOrderList(page, rows, query);
		return result;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public OmsResult insertOrder(Order order){
		return orderService.insertOrder(order);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public OmsResult updatOrder(Order order){
		return orderService.updateOrder(order);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public OmsResult deleteOrder(String ids){
		if (StringUtils.isNotEmpty(ids)){
			String[] idArr = ids.split(",");
			for(String idStr : idArr){
				int id = Integer.parseInt(idStr);
				orderService.deleteOrder(id);
			}
		}
		return OmsResult.ok();
	}
}
