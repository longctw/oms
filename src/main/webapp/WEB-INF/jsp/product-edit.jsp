<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="contentAddForm" class="itemForm" method="post">
		<input type="hidden" name="categoryId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>标题:</td>
	            <td style="width:350px"><input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input></td>
	            <td>编号:</td>
	            <td><input class="easyui-textbox" type="text" name="proId" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>描述:</td>
	            <td colspan="3"><input class="easyui-textbox" name="sellPoint" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
	        </tr>
	        <tr>
	        </tr>
	         <tr>
	            <td>产品状态:</td>
	            <td>
					<select id="relation" class="easyui-combobox" name="relation" style="width:200px;">   
					    <option value="">---请选择品类---</option>
					    <option value="1">产品</option>
					    <option value="2">零件</option>
					</select>
				</td>
	            <td>材料:</td>
	            <td><input class="easyui-textbox" type="text" name="material" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>单位:</td>
	            <td><input class="easyui-textbox" type="text" name="unit" style="width: 280px;"></input></td>
	            <td>型号:</td>
	            <td><input class="easyui-textbox" type="text" name="models" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>规格:</td>
	            <td><input class="easyui-textbox" type="text" name="specific" style="width: 280px;"></input></td>
	            <td>维修内容:</td>
	            <td><input class="easyui-textbox" type="text" name="fixContent" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>产地:</td>
	            <td><input class="easyui-textbox" type="text" name="origin" style="width: 280px;"></input></td>
	            <td>厂家:</td>
	            <td><input class="easyui-textbox" type="text" name="producer" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>采购/成本价:</td>
	            <td><input class="easyui-textbox" type="text" name="inPrice" style="width: 280px;"></input></td>
	            <td>销售价:</td>
	            <td><input class="easyui-textbox" type="text" name="outPrice" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>类别:</td>
	            <td><input class="easyui-textbox" type="text" name="type" style="width: 280px;"></input></td>
	            <td>条码:</td>
	            <td><input class="easyui-textbox" type="text" name="barcode" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>图号:</td>
	            <td><input class="easyui-textbox" type="text" name="imageNo" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>图片:</td>
	            <td colspan="3">
	            	 <a href="javascript:void(0)" class="easyui-linkbutton picFileUpload" style="width:200px">上传图片</a>
	                 <input type="hidden" name="image"/>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="contentAddPage.submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="contentAddPage.clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var contentAddEditor ;
	$(function(){
		//contentAddEditor = TT.createEditor("#contentAddForm [name=content]");
		TT.initPicUpload();
		$("#contentAddForm [name=deptIds]").val($("#contentCategoryTree").tree("getSelected").id);
	});
	
	var contentAddPage  = {
			submitForm : function (){
				if(!$('#contentAddForm').form('validate')){
					$.messager.alert('提示','表单还未填写完成!');
					return ;
				}
				//contentAddEditor.sync();
				
				$.post("/user/update",$("#contentAddForm").serialize(), function(data){
					if(data.status == 200){
						$.messager.alert('提示','新增内容成功!');
    					$("#contentList").datagrid("reload");
    					TT.closeCurrentWindow();
					}
				});
			},
			clearForm : function(){
				$('#contentAddForm').form('reset');
				//contentAddEditor.html('');
			}
	};
</script>
