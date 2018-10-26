package info.ilong.order.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import info.ilong.oms.mapper.OrderDetailMapper;
import info.ilong.oms.mapper.OrderMapper;
import info.ilong.oms.pojo.Order;
import info.ilong.oms.pojo.OrderDetail;
import info.ilong.oms.pojo.OrderDetailExample;
import info.ilong.oms.pojo.OrderExample;
import info.ilong.utils.EasyUIResult;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.OrderQuery;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private OrderDetailMapper odMapper;
	
	@Override
	public Order getOrderById(int id) {
		Order order = orderMapper.selectByPrimaryKey(id);
		
		OrderDetailExample example = new OrderDetailExample();
		info.ilong.oms.pojo.OrderDetailExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(id);
		
		List<OrderDetail> odList = odMapper.selectByExample(example);
		order.setOdList(odList);
		
		return order;
	}

	@Override
	public EasyUIResult getOrderList(int page, int rows, OrderQuery query) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		
		OrderExample example = new OrderExample();
		info.ilong.oms.pojo.OrderExample.Criteria criteria = example.createCriteria();
		query.addCriteria(criteria);
		
		List<Order> orderList = orderMapper.selectByExample(example);
		
		for (Order order : orderList){
			OrderDetailExample odExample = new OrderDetailExample();
			info.ilong.oms.pojo.OrderDetailExample.Criteria odCriteria = odExample.createCriteria();
			odCriteria.andOrderIdEqualTo(order.getId());
			List<OrderDetail> odList = odMapper.selectByExample(odExample);
			order.setOdList(odList);
		}
		
		//对结果进行包装
		PageInfo<Order> pageInfo = new PageInfo<Order>(orderList);
		//构造相应结果 
		EasyUIResult result = new EasyUIResult(pageInfo.getTotal(), orderList);
		return result;
	}

	@Override
	public OmsResult insertOrder(Order order) {
		Date currDate = new Date();
		order.setCreateDate(currDate);
		orderMapper.insert(order);
		return OmsResult.ok();
	}

	@Override
	public OmsResult updateOrder(Order order) {
		orderMapper.updateByPrimaryKeySelective(order);
		return OmsResult.ok();
	}

	@Override
	public OmsResult deleteOrder(int id) {
		// TODO 新增
		return null;
	}
	
}
