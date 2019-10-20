<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>当当图书 – 全球最大的中文网上书店</title>
<link href="../front/css/book.css" rel="stylesheet" type="text/css" />
<link href="../front/css/second.css" rel="stylesheet" type="text/css" />
<link href="../front/css/secBook_Show.css" rel="stylesheet"
	type="text/css" />
<link href="../front/css/shopping_vehicle.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<br />
	<br />
	<div class="my_shopping">
		<img class="pic_shop" src="../front/images/pic_myshopping.gif" />
	</div>
	<c:if test="${cart==null&&cart.items.size()==0 }">
		<div id="div_no_choice">
			<div class="choice_title"></div>
			<div class="no_select">
				您还没有挑选商品[<a href=''> 继续挑选商品&gt;&gt;</a>]
			</div>
		</div>
	</c:if>
	<div id="div_choice" class="choice_merch">
		<h2 id="cart_tips">您已选购以下商品</h2>
		<div class="choice_bord">
			<table class="tabl_buy" id="tbCartItemsNormal">
				<tr class="tabl_buy_title">
					<td class="buy_td_6"><span>&nbsp;</span></td>
					<td><span class="span_w1">商品名</span></td>
					<td class="buy_td_5"><span class="span_w2">市场价</span></td>
					<td class="buy_td_4"><span class="span_w3">当当价</span></td>
					<td class="buy_td_1"><span class="span_w2">数量</span></td>
					<td class="buy_td_2"><span>变更数量</span></td>
					<td class="buy_td_1"><span>删除</span></td>
				</tr>
				<tr class='objhide' over="no">
					<td colspan="8">&nbsp;</td>
				</tr>
				<c:forEach items="${cart.items }" var="i">
					<!-- 购物列表开始 -->
					<tr class='td_no_bord'>
						<td style='display: none'>${i.key }</td>
						<td class="buy_td_6"><span class="objhide"> <img
								src="" />
						</span></td>
						<td><a href="">${i.value.book_name }</a></td>
						<td class="buy_td_5"><span class="c_gray">￥${i.value.price }</span>
						</td>
						<td class="buy_td_4">&nbsp;&nbsp; <span>￥${i.value.dd_price }</span>
						</td>
						<td class="buy_td_1">&nbsp;&nbsp;${i.value.count }</td>

						<td>
							<form
								action="${pageContext.request.contextPath }/cart/updateCart">
								<input type="hidden" name="id" value="${i.key }" /> <input
									id="" class="del_num" type="number" size="3" maxlength="4"
									name="count" /> <input type="submit" value="变更"></a>
							</form>
						</td>
						<td><a
							href="${pageContext.request.contextPath }/cart/deleteCart?id=${i.key}">删除</a>
						</td>
					</tr>
					<!-- 结束 -->
				</c:forEach>
			</table>

			<div class="choice_balance">
				<div class="select_merch">
					<a href=''> 继续挑选商品>></a>
				</div>
				<div class="total_balance">
					<div class="save_total">
						您共节省： <span class="c_red"> ￥<span id="total_economy">${cart.cart_price-cart.ddcart_price }</span>
						</span> <span style="font-size: 14px">|</span> <span class="t_add">商品金额总计：</span>
						<span class="c_red_b"> ￥<span id='total_account'>${cart.ddcart_price }</span>
						</span>
					</div>
					<div id="balance" class="balance">
						<a name='checkout' href='../front/order/order_info.jsp'> <img
							src="../front/images/butt_balance.gif" alt="结算" border="0"
							title="结算" />
						</a>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${delcart!=null&&delcart.items.size()!=0 }">
			<!-- 用户删除恢复区 -->
			<div id="divCartItemsRemoved" class="del_merch">
				<div class="del_title">您已删除以下商品，如果想重新购买，请点击“恢复”</div>
				<table class=tabl_del id=del_table>
					<tbody>
						<c:forEach items="${delcart.items}" var="cartItem">
							<tr>
								<td width="58" class=buy_td_6>&nbsp;</td>
								<td width="365" class=t2><a href="#">${cartItem.value.book_name }</a>
								</td>
								<td width="106" class=buy_td_5>￥${cartItem.value.price }</td>
								<td width="134" class=buy_td_4><span>￥${cartItem.value.dd_price }</span>
								</td>
								<td width="56" class=buy_td_1><a
									href="${pageContext.request.contextPath }/cart/recover?id=${cartItem.key}">恢复</a>
								</td>
								<td width="16" class=objhide>&nbsp;</td>
							</tr>
							<tr class=td_add_bord>
								<td colspan=8>&nbsp;</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
	</div>

	<!--页尾开始 -->
	<div style="position:absolute;bottom: 10px;width:100%;">
		<%@include file="../common/foot.jsp"%>
	</div>
	<!--页尾结束 -->
</body>
</html>



