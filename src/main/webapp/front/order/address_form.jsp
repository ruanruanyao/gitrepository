<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath }" var="path"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>生成订单 - 当当网</title>
<link href="../front/css/login.css" rel="stylesheet" type="text/css" />
<link href="../front/css/page_bottom.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${path }/front/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	function change() {
		var id = $("#address").val();
		location.href = "${path}/address/queryAddressById?id="+id;
	}
</script>
</head>
<body>
	<%@include file="../common/head1.jsp"%>
	<div class="login_step">
		生成订单骤: 1.确认订单 > <span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
	</div>
	<div class="fill_message">
	<form name="ctl00" method="post" action="${path }/order/addOrder" id="f">
		<p>
			选择地址： <select id="address" name="address.id" onchange="change()">
				<option value="aaa">填写新地址</option>
				<c:forEach items="${addresses }" var="a">
					<option value="${a.id }"<c:if test="${id==a.id }">selected=selected</c:if>>${a.detail }</option>
				</c:forEach>
			</select>
		</p>
		<!-- <input type="hidden" name="id" id="addressId" value="${addr.id }"/> -->
			<table class="tab_login">
				<tr>
					<td valign="top" class="w1">收件人姓名：</td>
					<td><input type="text" class="text_input" name="address.name"
						id="receiveName" value="${addr.name }"/>
						<div class="text_left" id="nameValidMsg">
							<p>请填写有效的收件人姓名</p>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">收件人详细地址：</td>
					<td><input type="text" name="address.detail" class="text_input"
						id="fullAddress" value="${addr.detail }"/>
						<div class="text_left" id="addressValidMsg">
							<p>请填写有效的收件人的详细地址</p>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">邮政编码</td>
					<td><input type="text" class="text_input" name="address.zip_code"
						id="postalCode" value="${addr.zip_code }"/>
						<div class="text_left" id="codeValidMsg">
							<p>请填写有效的收件人的邮政编码</p>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">电话</td>
					<td><input type="text" class="text_input" name="address.phone"
						id="phone" value="${addr.phone }"/>
						<div class="text_left" id="phoneValidMsg">
							<p>请填写有效的收件人的电话</p>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">手机</td>
					<td><input type="text" class="text_input" name="address.mobile"
						id="mobile" value="${addr.mobile }"/>
						<div class="text_left" id="mobileValidMsg">
							<p>请填写有效的收件人的手机</p>
						</div></td>
				</tr>
			</table>

			<div class="login_in">
				<a href="order_info.jsp"> <input id="btnClientRegister"
					class="button_1" name="submit" type="submit" value="取消" />
				</a> <input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" />
			</div>
		</form>
	</div>
	<%@include file="../common/foot1.jsp"%>
</body>
</html>

