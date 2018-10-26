package info.ilong.order.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import info.ilong.oms.pojo.OrderDetail;
import info.ilong.order.service.OrderDetailService;
import info.ilong.utils.EasyUIResult;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.OrderDetailQuery;

@Controller
@RequestMapping("/orderdetail")
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;
	
	@RequestMapping("{id}")
	@ResponseBody
	public OrderDetail getOrderDetailById(@PathVariable int id){
		return orderDetailService.getOrderDetailById(id);
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIResult orderList(int page, int rows, OrderDetailQuery query){
		EasyUIResult result = orderDetailService.getOrderDetailList(page, rows, query);
		return result;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public OmsResult insertOrderDetail(OrderDetail orderDetail){
		return orderDetailService.insertOrderDetail(orderDetail);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public OmsResult updatOrderDetail(OrderDetail orderDetail){
		return orderDetailService.updateOrderDetail(orderDetail);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public OmsResult deleteOrderDetail(String ids){
		if (StringUtils.isNotEmpty(ids)){
			String[] idArr = ids.split(",");
			for(String idStr : idArr){
				int id = Integer.parseInt(idStr);
				orderDetailService.deleteOrderDetail(id);
			}
		}
		return OmsResult.ok();
	}
}
