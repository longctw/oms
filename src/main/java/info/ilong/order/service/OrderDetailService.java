package info.ilong.order.service;

import info.ilong.oms.pojo.OrderDetail;
import info.ilong.utils.EasyUIResult;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.OrderDetailQuery;

public interface OrderDetailService {

	/**
	 * 根据主键查询订单明细
	 * @param id
	 * @return
	 */
	public OrderDetail getOrderDetailById(int id);
	
	/**
	 * 按条件查询订单明细列表
	 * @param page
	 * @param rows
	 * @param query
	 * @return
	 */
	public EasyUIResult getOrderDetailList(int page, int rows, OrderDetailQuery query);
	
	/**
	 * 向数据库中插入一条订单明细信息
	 * @param order
	 * @return
	 */
	public OmsResult insertOrderDetail(OrderDetail orderDetail);
	
	/**
	 * 更新一条订单明细信息
	 * @param order
	 * @return
	 */
	public OmsResult updateOrderDetail(OrderDetail orderDetail);
	
	/**
	 * 跟局id删除一条订单明细
	 * @param id
	 * @return
	 */
	public OmsResult deleteOrderDetail(int id);
}
