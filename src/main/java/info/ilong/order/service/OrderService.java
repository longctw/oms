package info.ilong.order.service;

import info.ilong.oms.pojo.Order;
import info.ilong.utils.EasyUIResult;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.OrderQuery;

public interface OrderService {
	
	/**
	 * 根据主键查询订单信息
	 * @param id
	 * @return
	 */
	public Order getOrderById(int id);
	
	/**
	 * 按条件查询订单列表
	 * @param page
	 * @param rows
	 * @param query
	 * @return
	 */
	public EasyUIResult getOrderList(int page, int rows, OrderQuery query);
	
	/**
	 * 向数据库中插入一条订单信息
	 * @param order
	 * @return
	 */
	public OmsResult insertOrder(Order order);
	
	/**
	 * 更新一条订单信息
	 * @param order
	 * @return
	 */
	public OmsResult updateOrder(Order order);
	
	/**
	 * 跟局id删除一条订单
	 * @param id
	 * @return
	 */
	public OmsResult deleteOrder(int id);
}
