package info.ilong.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import info.ilong.oms.mapper.CategoryMapper;
import info.ilong.oms.mapper.ProductMapper;
import info.ilong.oms.mapper.ProductRelMapper;
import info.ilong.oms.pojo.Category;
import info.ilong.oms.pojo.CategoryExample;
import info.ilong.oms.pojo.Product;
import info.ilong.oms.pojo.ProductExample;
import info.ilong.oms.pojo.ProductExample.Criteria;
import info.ilong.oms.pojo.ProductRel;
import info.ilong.oms.pojo.ProductRelExample;
import info.ilong.utils.EasyUIResult;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.ProductQuery;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProductRelMapper productRelMapper;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public Product getProductById(int id) {
		Product product = productMapper.selectByPrimaryKey(id);
		Integer relation = product.getRelation();
		
		if (relation == 1){
			ProductRelExample plExample = new ProductRelExample();
			plExample.createCriteria().andToolIdEqualTo(id);
			List<Product> pieceList = productRelMapper.selectPieceByToolId(id);
			
			for (Product pro : pieceList){
				List<Product> toolList = productRelMapper.selectToolByPieceId(pro.getId());
				pro.setToolList(toolList);
			}
			
			product.setPieceList(pieceList);
		}
		
		Category category = categoryMapper.selectByPrimaryKey(product.getCategoryId());
		product.setCategory(category);
		
		return product;
	}

	@Override
	public EasyUIResult getProductList(int page, int rows, ProductQuery query) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//查询商品信息，紧跟着分析信息的第一个select语句会被分页
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		query.addCriteria(criteria);
		Integer categoryId = query.getCategoryId();
		
		if (categoryId != null){
			List<Integer> cateList = new ArrayList<Integer>();
			recursiveQueryChildCate(cateList, categoryId);
			criteria.andCategoryIdIn(cateList);
		}
		
		List<Product> list = productMapper.selectByExample(example);
		
		for (Product pro : list){
			if (pro.getRelation() == 1){
				List<Product> pieceList = productRelMapper.selectPieceByToolId(pro.getId());
				for (Product piece : pieceList){
					List<Product> toolList = productRelMapper.selectToolByPieceId(pro.getId());
					piece.setToolList(toolList);
				}
			}else if (pro.getRelation() == 2){
				List<Product> toolList = productRelMapper.selectToolByPieceId(pro.getId());
				for (Product tool : toolList){
					List<Product> pieceList = productRelMapper.selectPieceByToolId(pro.getId());
					tool.setToolList(pieceList);
				}
			}
			
			Category category = categoryMapper.selectByPrimaryKey(pro.getCategoryId());
			pro.setCategory(category);
		}
		
		//对结果进行包装
		PageInfo<Product> pageInfo = new PageInfo<Product>(list);
		//构造相应结果 
		EasyUIResult result = new EasyUIResult(pageInfo.getTotal(), list);
		return result;
	}

	@Override
	public OmsResult insertProduct(Product pro, List<Integer> proRel) {
		productMapper.insert(pro);
		Integer relation = pro.getRelation();
		
		if (relation == 1){
			for (Integer pieceId : proRel){
				ProductRel pr = new ProductRel();
				pr.setToolId(pro.getId());
				pr.setPieceId(pieceId);
				productRelMapper.insert(pr);
			}
		}else if (relation == 1){
			for (Integer toolId : proRel){
				ProductRel pr = new ProductRel();
				pr.setToolId(toolId);
				pr.setPieceId(pro.getId());
				productRelMapper.insert(pr);
			}
		}
		
		return null;
	}

	@Override
	public OmsResult updateProduct(Product product, List<Integer> proRel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OmsResult deleteProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	private void recursiveQueryChildCate(List<Integer> cateList, int cateId){
		cateList.add(cateId);
		
		CategoryExample example = new CategoryExample();
		info.ilong.oms.pojo.CategoryExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(cateId);
		criteria.andStatusEqualTo(1);
		List<Category> list = categoryMapper.selectByExample(example);
		if (list != null && list.size() > 0){
			for (Category cate : list){
				recursiveQueryChildCate(cateList, cate.getId());
			}
		}
	}
}
