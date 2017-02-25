<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
<%@include file="/WEB-INF/jsp/include/easyui.jsp"%>
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	var url;
	var mesTitle;
	function addUser(){
		$('#dlg').dialog('open').dialog('setTitle','新增用户');
		$('#fm').form('clear');
		url = path+"/user/addUser";
		mesTitle = '新增用户成功';
	}
	
 	function editUser(){
	 	var row = $('#datagrid').datagrid('getSelected');
	 	if (row){
	 		var id = row.id;
		 	$('#dlg').dialog('open').dialog('setTitle','编辑用户');
		 	$('#fm').form('load',row);//这句话有问题，第一次加载时正确的，第二次就出错了，还保持第一次的数据
		 	url = path+"/user/editUser?id="+id;
		 	mesTitle = '编辑用户成功';
	 	}else{
	 		$.messager.alert('提示', '请选择要编辑的记录！', 'error');
	 	}
	}
 	
	function saveUser(){
	 	$('#fm').form('submit',{
		 	url: url,
		 	onSubmit: function(){
		 		return $(this).form('validate');
		 	},
			success: function(result){
				/* console.info(result); */
				var result = eval('('+result+')');
				if (result.success){
				 	$('#dlg').dialog('close'); 
				 	$('#datagrid').datagrid('reload'); 
				} else {
					 mesTitle = '新增用户失败';
				}
				$.messager.show({ 
					 title: mesTitle,
					 msg: result.msg
				});
			}
	 	});
	}	
</script>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 用户信息列表 -->
		<table id="datagrid" title="用户管理" class="easyui-datagrid" fit="true"
			url="${path}/user/datagrid" toolbar="#toolbar" pagination="true"
			fitColumns="true" singleSelect="true" rownumbers="true"
			border="false" nowrap="false">
			<thead>
				<tr>
					<th field="id" width="100">用户编号</th>
					<th field="username" width="100">用户名</th>
					<th field="password" width="100">密码</th>
					<th field="email" width="100">邮箱</th>
				</tr>
			</thead>
		</table>

		<!-- 按钮 -->
		<div id="toolbar">
			<a href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="addUser();">新增用户</a> <a
				href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="editUser();">编辑用户</a> <a
				href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" onclick="deleteUser();">删除用户</a>
		</div>

		<!-- 对话框 -->
		<div id="dlg" class="easyui-dialog"
			style="width:400px;height:280px;padding:10px 20px" closed="true"
			buttons="#dlg-buttons">
			<div class="ftitle">新增用户</div>
			<form id="fm" method="post" novalidate>
				<div class="fitem">
					<label>用户名:</label> <input name="username" class="easyui-textbox"
						required="true">
				</div>
				<div class="fitem">
					<label>密码:</label> <input name="password" class="easyui-textbox"
						required="true">
				</div>
				<div class="fitem">
					<label>Email:</label> <input name="email" class="easyui-textbox"
						validType="email">
				</div>
			</form>
		</div>

		<!-- 对话框按钮 -->
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				iconCls="icon-ok" onclick="saveUser()" style="width:90px">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
				style="width:90px">取消</a>
		</div>
	</div>
</body>
</html>
