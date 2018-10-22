package info.ilong.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import info.ilong.oms.pojo.Product;
import info.ilong.product.service.ProductService;
import info.ilong.utils.EasyUIResult;
import info.ilong.utils.OmsResult;
import info.ilong.utils.pojo.ProductQuery;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("{id}")
	@ResponseBody
	public Product getProductById(@PathVariable int id){
		return productService.getProductById(id);
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIResult productList(int page, int rows, ProductQuery query){
		EasyUIResult result = productService.getProductList(page, rows, query);
		return result;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public OmsResult insertProduct(Product product, String relIds){
		List<Integer> relList = new ArrayList<Integer>();
		if (StringUtils.isNotEmpty(relIds)){
			String[] ids = relIds.split(",");
			for(String id : ids){
				int relIdInt = Integer.parseInt(id);
				relList.add(relIdInt);
			}
		}
		return productService.insertProduct(product, relList);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public OmsResult updateProduct(Product product, String relIds){
		List<Integer> relList = new ArrayList<Integer>();
		if (StringUtils.isNotEmpty(relIds)){
			String[] ids = relIds.split(",");
			for(String id : ids){
				int relIdInt = Integer.parseInt(id);
				relList.add(relIdInt);
			}
		}
		return productService.updateProduct(product, relList);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public OmsResult deleteUser(String ids){
		if (StringUtils.isNotEmpty(ids)){
			String[] idArr = ids.split(",");
			for(String idStr : idArr){
				int id = Integer.parseInt(idStr);
				productService.deleteProduct(id);
			}
		}
		return OmsResult.ok();
	}
}
