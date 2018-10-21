<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="easyui-panel" title="Nested Panel" data-options="width:'100%',minHeight:500,noheader:true,border:false" style="padding:10px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west',split:false" style="width:250px;padding:5px">
            <ul id="contentCategoryTree" class="easyui-tree" data-options="url:'/dept/list',animate: true,method : 'GET'">
            </ul>
        </div>
        <div data-options="region:'center'" style="padding:5px">
            <table class="easyui-datagrid" id="contentList" data-options="toolbar:contentListToolbar,singleSelect:false,collapsible:true,pagination:true,method:'get',pageSize:20,url:'/user/list',queryParams:{deptId:0}">
			    <thead>
			        <tr>
			            <!-- <th data-options="field:'id',width:30">ID</th> -->
			            <th data-options="field:'empId',width:120">员工编号</th>
			            <th data-options="field:'fullname',width:100">姓名</th>
			            <th data-options="field:'gender',width:120,formatter:TAOTAO.formatGender">性别</th>
			            <th data-options="field:'dept',width:120">部门</th>
			            <th data-options="field:'telephone',width:100,align:'center'">电话</th>
			            <th data-options="field:'email',width:100,align:'center'">邮箱</th>
			            <th data-options="field:'title',width:100,align:'center'">职位</th>
			            <th data-options="field:'birthday',width:130,align:'center',formatter:TAOTAO.formatDateTime">出生日期</th>
			            <th data-options="field:'lastLoginTime',width:130,align:'center',formatter:TAOTAO.formatDateTime">上次登陆时间</th>
			            <th data-options="field:'loginCount',width:130,align:'center'">登陆次数</th>
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
			//if(tree.tree("isLeaf",node.target)){
				datagrid.datagrid('reload', {
					deptId :node.id
		        });
			//}
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
    	var names = TT.getSelectionsItems("#contentList","fullname");
    	if(ids.length == 0){
    		$.messager.alert('提示','未选中商品!');
    		return ;
    	}
    	$.messager.confirm('确认','确定删除 '+names+' 吗？',function(r){
    	    if (r){
    	    	var params = {"ids":ids};
            	$.post("/user/delete",params, function(data){
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

function format2date(d){
	var date = new Date(d);
	return date.format("yyyy-MM-dd");
}
</script>