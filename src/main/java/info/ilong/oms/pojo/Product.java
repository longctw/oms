package info.ilong.oms.pojo;

import java.util.Date;
import java.util.List;

public class Product {
    private Integer id;

    private String title;

    private String descrition;

    private String proId;

    private String material;

    private String models;

    private String specific;

    private String fixContent;

    private String orgin;

    private String producer;

    private String unit;

    private Integer inprice;

    private Integer outprice;

    private Integer relation;

    private String type;

    private String barcode;

    private String imageNo;

    private String image;

    private Date created;

    private Date updated;

    private Integer status;

    private Integer categoryId;

    private String bak1;

    private String bak2;

    private String bak3;

    private String bak4;

    private String bak5;
    
    private List<Product> pieceList;
    
    private List<Product> toolList;
    
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition == null ? null : descrition.trim();
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models == null ? null : models.trim();
    }

    public String getSpecific() {
        return specific;
    }

    public void setSpecific(String specific) {
        this.specific = specific == null ? null : specific.trim();
    }

    public String getFixContent() {
        return fixContent;
    }

    public void setFixContent(String fixContent) {
        this.fixContent = fixContent == null ? null : fixContent.trim();
    }

    public String getOrgin() {
        return orgin;
    }

    public void setOrgin(String orgin) {
        this.orgin = orgin == null ? null : orgin.trim();
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer == null ? null : producer.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getInprice() {
        return inprice;
    }

    public void setInprice(Integer inprice) {
        this.inprice = inprice;
    }

    public Integer getOutprice() {
        return outprice;
    }

    public void setOutprice(Integer outprice) {
        this.outprice = outprice;
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getImageNo() {
        return imageNo;
    }

    public void setImageNo(String imageNo) {
        this.imageNo = imageNo == null ? null : imageNo.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1 == null ? null : bak1.trim();
    }

    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2 == null ? null : bak2.trim();
    }

    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3 == null ? null : bak3.trim();
    }

    public String getBak4() {
        return bak4;
    }

    public void setBak4(String bak4) {
        this.bak4 = bak4 == null ? null : bak4.trim();
    }

    public String getBak5() {
        return bak5;
    }

    public void setBak5(String bak5) {
        this.bak5 = bak5 == null ? null : bak5.trim();
    }

	public List<Product> getPieceList() {
		return pieceList;
	}

	public void setPieceList(List<Product> pieceList) {
		for (Product piece : pieceList){
			if (piece.getRelation() == 1){
				return ;
			}
		}
		
		if (relation == 1){
			this.pieceList = pieceList;
		}
	}

	public List<Product> getToolList() {
		return toolList;
	}

	public void setToolList(List<Product> toolList) {
		for (Product tool : toolList){
			if (tool.getRelation() == 2){
				return ;
			}
		}
		
		if (relation == 1){
			this.toolList = toolList;
		}
	}
	
	public String getPiece(){
		StringBuffer result = new StringBuffer();
		
		if (pieceList != null && pieceList.size()>0){
			for (int i = 0; i < pieceList.size(); i++){
				result.append(pieceList.get(i).getTitle());
				if ((i + 1) != pieceList.size()){
					result.append(",");
				}
			}
		}
		
		return result.toString();
	}
	
	public String getTool(){
		StringBuffer result = new StringBuffer();
		
		if (toolList != null && toolList.size()>0){
			for (int i = 0; i < toolList.size(); i++){
				result.append(toolList.get(i).getTitle());
				if ((i + 1) != toolList.size()){
					result.append(",");
				}
			}
		}
		
		return result.toString();
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getCategoryName(){
		if (category != null){
			return category.getName();
		}
		return "";
	}
}