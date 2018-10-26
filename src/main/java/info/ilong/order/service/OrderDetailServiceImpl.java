package info.ilong.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import info.ilong.oms.mapper.OrderDetailMapper;
import info.ilong.oms.pojo.OrderDetail;
import info.ilong.oms.pojo.OrderDetailExample;
import info.ilong.oms.pojo.OrderDetailExample.Criteria;
import info.ilong.utils.EasyUIResult;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.OrderDetailQuery;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	private OrderDetailMapper odMapper;
	
	@Override
	public OrderDetail getOrderDetailById(int id) {
		OrderDetail orderDetail = odMapper.selectByPrimaryKey(id);
		return orderDetail;
	}

	@Override
	public EasyUIResult getOrderDetailList(int page, int rows, OrderDetailQuery query) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		
		OrderDetailExample example = new OrderDetailExample();
		Criteria criteria = example.createCriteria();
		query.addCriteria(criteria);
		
		List<OrderDetail> odList = odMapper.selectByExample(example);
		//对结果进行包装
		PageInfo<OrderDetail> pageInfo = new PageInfo<OrderDetail>(odList);
		//构造相应结果 
		EasyUIResult result = new EasyUIResult(pageInfo.getTotal(), odList);
		return result;
	}

	@Override
	public OmsResult insertOrderDetail(OrderDetail orderDetail) {
		odMapper.insert(orderDetail);
		return OmsResult.ok();
	}

	@Override
	public OmsResult updateOrderDetail(OrderDetail orderDetail) {
		odMapper.updateByPrimaryKeySelective(orderDetail);
		return OmsResult.ok();
	}

	@Override
	public OmsResult deleteOrderDetail(int id) {
		// TODO 添加删除状态字段
		return null;
	}

}
