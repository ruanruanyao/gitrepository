<i><%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>当当图书 – 全球最大的中文网上书店</title>
<link href="${path }/front/css/book.css" rel="stylesheet"
	type="text/css" />
<link href="${path }/front/css/second.css" rel="stylesheet"
	type="text/css" />
<link href="${path }/front/css/secBook_Show.css" rel="stylesheet"
	type="text/css" />
<link href="${path }/front/css/list.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="${path }/front/js/prototype-1.6.0.3.js"></script>
</head>
<body>
	&nbsp;

	<!-- 头部开始 -->
	<%@include file="../common/head.jsp"%>
	<!-- 头部结束 -->

	<div style="width: 962px; margin: auto;">
		<a href="#"><img
			src="${path }/front/images/default/book_banner_081203.jpg" border="0" />
		</a>
	</div>
	<div class="your_position">
		您现在的位置:&nbsp; <a href="#">当当图书</a> &gt;&gt; <font
			<c:if test="${cid==null }"> style='color: #cc3300'</c:if>=""><strong>${cate.cate_name }</strong>
		</font>
		<c:forEach items="${cate.categorys }" var="c">
			<c:if test="${cid==c.id }">&gt;&gt;<strong style="color:red">${c.cate_name }</strong>
			</c:if>
		</c:forEach>
	</div>

	<div class="book">

		<!--左栏开始-->
		<div id="left" class="book_left">
			<div id="__fenleiliulan">
				<div class="second_l_border2">
					<h2>分类浏览</h2>
					<ul>
						<li>
							<div>
								<div class="second_fenlei">
									<strong <c:if test="${cid==null }">style="color:red"</c:if>="">&middot;全部&nbsp;</strong>
								</div>
							</div>
						</li>
						<div class="clear"></div>
						<!--2级分类开始-->
						<c:forEach items="${cate.categorys }" var="c">
							<li>
								<div>
									<div class="second_fenlei">&middot;</div>
									<div class="second_fenlei">
										<a href="#"
											<c:if test="${cid==c.id }">style="color:red"</c:if>="">${c.cate_name }&nbsp;</a>
									</div>
								</div>
							</li>
							<div class="clear"></div>
						</c:forEach>
						<!--2级分类结束-->
						<li>
							<div></div>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<!--左栏结束-->

		<!--中栏开始-->
		<div class="book_center">

			<!--图书列表开始-->
			<div id="divRight" class="list_right">

				<div id="book_list" class="list_r_title">
					<div class="list_r_title_text">排序方式</div>
					<select onchange="" name="select_order" size="1"
						class="list_r_title_ml">
						<option value="">按上架时间 降序</option>
					</select>
					<div id="divTopPageNavi" class="list_r_title_text3">

						<!--分页导航开始-->
						<!-- 如果page=1 使超链接失效 -->
						<c:if test="${page==1 }">
							<div class="list_r_title_text3a">
								<img src="../front/images/page_down_gray.gif" />
							</div>
						</c:if>
						<c:if test="${page!=1 }">
							<div class="list_r_title_text3a">
								<a name="link_page_next"
									href="${path }/category/showFrontTwo?fid=${cate.id}&amp;&amp;page=${page-1 }<c:if test='${cid!=null}'>&&cid=${cid }</c:if>">
									<img src="${path }/front/images/page_up.gif" />
								</a>
							</div>
						</c:if>




						<div class="list_r_title_text3b">第${page}页/共${pageNum}页</div>

						<!-- 如果page=pageNum 使超链接失效 -->
						<c:if test="${page==pageNum }">
							<div class="list_r_title_text3a">
								<img src="../front/images/page_down_gray.gif" />
							</div>
						</c:if>
						<c:if test="${page!=pageNum }">
							<div class="list_r_title_text3a">
								<a name="link_page_next"
									href="${path }/category/showFrontTwo?fid=${cate.id}&amp;&amp;page=${page+1 }<c:if test='${cid!=null}'>&&cid=${cid }</c:if>">
									<img src="../front/images/page_down.gif" />
								</a>
							</div>
						</c:if>




						<!--分页导航结束-->
					</div>
				</div>

				<!--商品条目开始-->

				<div class="list_r_line"></div>
				<c:forEach items="${books }" var="b">
					<div class="clear"></div>
					<div class="list_r_list">
						<span class="list_r_list_book"> <a name="link_prd_img"
							href="#"> <img src="${path }/back/img/${b.src}" />
						</a>
						</span>
						<h2>
							<a name="link_prd_name" href="#">${b.book_name }</a>
						</h2>
						<h3>顾客评分：100</h3>
						<h4 class="list_r_list_h4">
							作 者: <a href="#" name="作者">${b.author }</a>
						</h4>
						<h4>
							出版社： <a href="#" name="出版社">${b.company }</a>
						</h4>
						<h4>出版时间：${b.publish_time }</h4>
						<h5>这是一本好书，描述了Struts、Hibernate和Spring等框架的整合应用！</h5>
						<div class="clear"></div>
						<h6>
							<span class="del">￥${b.price }</span> <span class="red">￥${b.dd_price }</span>
							节省：￥${b.price-b.dd_price }
						</h6>
						<span class="list_r_list_button"> <a href="#"> <img
								src="../front/images/buttom_goumai.gif" />
						</a> <span id="cartinfo"></span>
						</span>
					</div>
					<div class="clear"></div>
				</c:forEach>

				<!--商品条目结束-->

				<div class="clear"></div>
				<div id="divBottomPageNavi" class="fanye_bottom"></div>

			</div>
			<!--图书列表结束-->

		</div>
		<!--中栏结束-->
		<div class="clear"></div>
	</div>

	<!--页尾开始 -->
	<%@include file="../common/foot.jsp"%>
	<!--页尾结束 -->
</body>
	</html> </i>