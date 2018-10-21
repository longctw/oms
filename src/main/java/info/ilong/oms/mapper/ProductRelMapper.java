package info.ilong.oms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import info.ilong.oms.pojo.Product;
import info.ilong.oms.pojo.ProductRel;
import info.ilong.oms.pojo.ProductRelExample;
import info.ilong.oms.pojo.ProductRelKey;

public interface ProductRelMapper {
    int countByExample(ProductRelExample example);

    int deleteByExample(ProductRelExample example);

    int deleteByPrimaryKey(ProductRelKey key);

    int insert(ProductRel record);

    int insertSelective(ProductRel record);

    List<ProductRel> selectByExample(ProductRelExample example);
    
    List<Product> selectPieceByToolId(Integer id);
    
    List<Product> selectToolByPieceId(Integer id);

    ProductRel selectByPrimaryKey(ProductRelKey key);

    int updateByExampleSelective(@Param("record") ProductRel record, @Param("example") ProductRelExample example);

    int updateByExample(@Param("record") ProductRel record, @Param("example") ProductRelExample example);

    int updateByPrimaryKeySelective(ProductRel record);

    int updateByPrimaryKey(ProductRel record);
}