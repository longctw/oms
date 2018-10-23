<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="easyui-panel" title="Nested Panel" data-options="width:'100%',minHeight:500,noheader:true,border:false" style="padding:10px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west',split:false" style="width:250px;padding:5px">
            <ul id="contentCategoryTree" class="easyui-tree" data-options="url:'/category/list',animate: true,method : 'GET'">
            </ul>
        </div>
        <div data-options="region:'center'" style="padding:5px">
            <table class="easyui-datagrid" id="contentList" 
            data-options="toolbar:contentListToolbar,singleSelect:false,
            collapsible:true,pagination:true,method:'get',pageSize:20,url:'/product/list',queryParams:{relation:1},
            onDblClickRow:showPiece">
			    <thead>
			        <tr>
			            <th data-options="field:'proId',width:100">产品编号</th>
			            <th data-options="field:'title',width:150">名称</th>
			            <th data-options="field:'categoryName',width:100">分类</th>
			            <th data-options="field:'models',width:120">型号</th>
			            <th data-options="field:'orgin',width:120">产地</th>
			            <th data-options="field:'producer',width:100,">厂家</th>
			            <th data-options="field:'inprice',width:100,align:'center',formatter:TAOTAO.formatPrice">采购价</th>
			            <th data-options="field:'outprice',width:100,align:'center',formatter:TAOTAO.formatPrice">销售价</th>
			            <th data-options="field:'type',width:130,align:'center'">类别</th>
			        </tr>
			    </thead>
			</table>
        </div>
    </div>
</div>
<script type="text/javascript">
$(function(){
	var tree = $("#contentCategoryTree");
	var datagrid = $("#contentList");
	
	tree.tree({
		onClick : function(node){
			datagrid.datagrid('reload', {
				categoryId :node.id,
				relation:1
	        });
		}
	});
});
var contentListToolbar = [{
    text:'新增',
    iconCls:'icon-add',
    handler:function(){
    	var node = $("#contentCategoryTree").tree("getSelected");
    	if(!node){
    		$.messager.alert('提示','新增内容必须选择一个内容分类!');
    		return ;
    	}
    	TT.createWindow({
			url : "/user-add",
			width:"50%",
			height:"50%"
		}); 
    }
},{
    text:'编辑',
    iconCls:'icon-edit',
    handler:function(){
    	var ids = TT.getSelectionsIds("#contentList");
    	if(ids.length == 0){
    		$.messager.alert('提示','必须选择一个内容才能编辑!');
    		return ;
    	}
    	if(ids.indexOf(',') > 0){
    		$.messager.alert('提示','只能选择一个内容!');
    		return ;
    	}
		TT.createWindow({
			url : "/user-edit",
			onLoad : function(){
				var data = $("#contentList").datagrid("getSelections")[0];
				data.birthday = format2date(data.birthday);
				console.log(data);
				$("#contentEditForm").form("load",data);
			},
			width:"50%",
			height:"50%"
		});    	
    }
},{
    text:'删除',
    iconCls:'icon-cancel',
    handler:function(){
    	var ids = TT.getSelectionsIds("#contentList");
    	var names = TT.getSelectionsItems("#contentList","title");
    	if(ids.length == 0){
    		$.messager.alert('提示','未选中商品!');
    		return ;
    	}
    	$.messager.confirm('确认','确定删除 '+names+' 吗？',function(r){
    	    if (r){
    	    	var params = {"ids":ids};
            	$.post("/product/delete",params, function(data){
        			if(data.status == 200){
        				$.messager.alert('提示','删除内容成功!',undefined,function(){
        					$("#contentList").datagrid("reload");
        				});
        			}
        		});
    	    }
    	});
    }
}];

function showPiece(rowIndex, rowData){
	TT.createWindow({
		title : rowData.title + " 的零件",
		url : "/piece_list",
		onLoad : function(){
			 $('#pieceList').datagrid({
				toolbar:pieceListToolbar,
			    columns:[[
			        {field:'proId',title:'产品编号',width:100},
			        {field:'title',title:'名称',width:100},    
			        {field:'categoryName',title:'分类',width:100},  
			        {field:'models',title:'型号',width:100},  
			        {field:'orgin',title:'产地',width:100},  
			        {field:'producer',title:'厂家',width:100},  
			        {field:'inprice',title:'采购价',width:100,formatter:TAOTAO.formatPrice},  
			        {field:'outprice',title:'销售价',width:100,formatter:TAOTAO.formatPrice},  
			        {field:'type',title:'类别',width:100}
			    ]]    
			});
			$("#pieceList").datagrid({
				data:rowData.pieceList
			}); 
		},
		width:"50%",
		height:"50%"
	});
}

function format2date(d){
	var date = new Date(d);
	return date.format("yyyy-MM-dd");
}
</script>