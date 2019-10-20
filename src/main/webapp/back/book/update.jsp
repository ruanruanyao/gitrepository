<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="../css/btn.css" />
	
<style type="text/css">
td{
	padding-top: 8px;
}
#file_upload1 {
	display: none;
}
#file_upload1_label {
	display: inline-block;
	border: 1px solid #aaa;
	width: 120px;
	height: 145px;
	margin-left: 20px;
	text-align: center;
	line-height: 145px;
	cursor: pointer;
}
</style>


</head>

<body style="background-color: #f0f9fd;text-align: center">
	<div style="font-size:25px">修改图书信息</div>
	<hr />
	<div align="center">
	<form action="" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					
					<td>名称：</td>
					<td><input type="text" name="" class="el-input__inner" value="测试图书1"></td>
					<td rowspan="14" style="width: 300px">
					<td>页数：</td>
					<td><input type="number" name="" class="el-input__inner" value="500" ></td>
				</tr>
				<tr>
					<td>所属分类：</td>
					<td>
						<select name="" class="el-select__inner inner2">
							<option value="${category.id }" >四大名著</option>
							<option value="${category.id }" >古典小说</option>
							<option value="${category.id }" >悬疑</option>
						</select>
					</td>
					<td>字数：</td>
					<td><input type="number" name="" class="el-input__inner" value="50000" ></td>
				</tr>
				
				<tr>
					<td>原价：</td>
					<td><input type="number" name="" class="el-input__inner" value="100"></td>
					<td>封面：</td>
					<td rowspan="3">
						<label id="file_upload1_label" for="file_upload1">
							<img id="uploadimg" src="" alt="" width="120" height="145" />
						</label> 
						<input type="file" name="" class="" id="file_upload1"	onchange="upload_review()">
					</td>
				</tr>
				
				<tr>
					<td>当当价：</td>
					<td><input type=number name="" class="el-input__inner" value="100"></td>
					<td></td>
				</tr>
				<tr>
					<td>库存：</td>
					<td><input type="number" name="" class="el-input__inner" value="999"></td>
					<td></td>
				</tr>
				<tr>
					<td>作者：</td>
					<td><input type="text" name="" class="el-input__inner" value="小黑"></td>
					<td>编辑推荐：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="">这里是编辑推荐</textarea></td>
				</tr>
				<tr>
					<td>出版社：</td>
					<td><input type="text" name="" class="el-input__inner" value="百知教育出版社"></td>
					<td></td>
				</tr>
				<tr>
					<td>出版时间：</td>
					<td><input type="date" name="" class="el-input__inner" value="2012-12-12"></td>
					<td>内容简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="" >这里是内容简介</textarea></td>
				</tr>
				<tr>
					<td>版次：</td>
					<td><input type="text" name="" class="el-input__inner" value="第五版"></td>
					<td></td>
				</tr>
				<tr>
					<td>印刷时间：</td>
					<td><input type="date" name="" class="el-input__inner" value="2012-12-12"></td>
					<td>作者简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="">这里是作者简介</textarea></td>
				</tr>
				<tr>
					<td>印次：</td>
					<td><input type="text" name="" class="el-input__inner" value="第三次印刷"></td>
					<td></td>
				</tr>
				<tr>
					<td>ISBN：</td>
					<td><input type="text" name="=" class="el-input__inner" value="9876543210"></td>
					<td>基本目录：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="" >这里是基本目录</textarea></td>
				</tr>
				<tr>
					<td>开本：</td>
					<td><input type="text" name="" class="el-input__inner" value="16开"></td>
					<td></td>
				</tr>
				<tr>
					<td>纸张：</td>
					<td><input type="text" name="" class="el-input__inner" value="A4纸"></td>
					<td>媒体评论：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="">这里是媒体评论</textarea></td>
				</tr>
				<tr>
					<td>包装：</td>
					<td><input type="text" name="" class="el-input__inner" value="精装"></td>
					<td></td>
				</tr>
			</table>
			<input type="submit" class="button btn-p" value="提交" />&emsp; 
			<input type="button" class="button btn-p" value="返回上级" onclick="history.go(-1);" />
		</form>
	</div>
	<script>
		function upload_review() {
			var img = document.getElementById("uploadimg");
			var input = document.getElementById("file_upload1");
			var tip = document.getElementById("uploadtip");			

			var file = input.files.item(0);
			var freader = new FileReader();
			freader.readAsDataURL(file);
			freader.onload = function(e) {
				img.src = e.target.result;
				tip.style.display = "none";
			};
		}
	</script>
</body>
</html>

