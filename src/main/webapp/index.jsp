<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<script type="text/javascript"
	src="${path }/front/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	// 鼠标移入事件
	// 鼠标移出事件
	// 鼠标移动事件
	$(function() {
		$(".zoom").mouseover(
				function(e) {
					var bigImg = $("<img id='bImg' src='" + $(this).attr("src")
							+ "'/>");
					$(bigImg).css({
						"top" : e.pageY + 5,
						"left" : e.pageX + 5,
						"position" : "absolute",
						"height" : "200px"
					})
					$("body").append(bigImg);
				}).mouseout(function() {
			$("#bImg").remove();
		}).mousemove(function(e) {
			$("#bImg").css({
				"top" : e.pageY + 5,
				"left" : e.pageX + 5,
				"position" : "absolute",
				"height" : "200px"
			})
		})
	});
</script>
<body>
	<h2>Hello World!</h2>
	<form action="${pageContext.request.contextPath }/upload/upload"
		enctype="multipart/form-data" method="post">
		<input type="file" name="upload"> <input type="submit">
	</form>
	<img class="zoom"
		src="${pageContext.request.contextPath }/back/img/2.jpg">
</body>
</html>
