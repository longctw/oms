package info.ilong.product.service;

import java.util.List;

import info.ilong.oms.pojo.Product;
import info.ilong.utils.EasyUIResult;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.ProductQuery;

public interface ProductService {
	
	/***
	 * 根据ID查询一条产品记录
	 * @param id
	 * @return
	 */
	public Product getProductById(int id);
	
	/**
	 * 按条件查询所有产品列表
	 * @param id
	 * @return Product
	 */
	public EasyUIResult getProductList(int page, int rows, ProductQuery query);
	
	/**
	 * 向产品表插入一条数据
	 * @param Product
	 * @return
	 */
	public OmsResult insertProduct(Product pro, List<Integer> proRel);
	
	/**
	 * 更新一条已存在的信息
	 * @param Product
	 * @return
	 */
	public OmsResult updateProduct(Product product, List<Integer> proRel);
	
	/**
	 * 删除一条信息
	 * @param id
	 * @return
	 */
	public OmsResult deleteProduct(int id);
}
