<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="padding:10px 10px 10px 10px">
	<form id="contentEditForm" class="itemForm" method="post">
		<input type="hidden" name="deptIds"/>
		<input type="hidden" name="id"/>
	    <table cellpadding="5">
	        <tr>
	            <td>员工号:</td>
	            <td><input class="easyui-textbox" type="text" name="empId" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>姓名:</td>
	            <td><input class="easyui-textbox" type="text" name="fullname" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>登录名:</td>
	            <td><input class="easyui-textbox" type="text" name="username" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	         <tr>
	            <td>性别:</td>
	            <td>
					<select id="gender" class="easyui-combobox" name="gender" style="width:200px;">   
					    <option value="0">未知</option>   
					    <option value="1">男</option>   
					    <option value="2">女</option>   
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>出生日期：</td>
	            <td>
	                <input id="birthday" type="text" class="easyui-datebox"  name="birthday" style="width:200px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>邮箱：</td>
	            <td><input class="easyui-textbox" type="text" name="email" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>电话：</td>
	            <td><input class="easyui-textbox" type="text" name="telephone" style="width: 280px;"></input></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="contentEditPage.submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="contentEditPage.clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">

var contentEditPage = {
		submitForm : function(){
			if(!$('#contentEditForm').form('validate')){
				$.messager.alert('提示','表单还未填写完成!');
				return ;
			}
			//contentEditEditor.sync();
			
			$.post("/user/update",$("#contentEditForm").serialize(), function(data){
				if(data.status == 200){
					$.messager.alert('提示','新增内容成功!');
					$("#contentList").datagrid("reload");
					TT.closeCurrentWindow();
				}
			});
		},
		clearForm : function(){
			
		}
};

</script>