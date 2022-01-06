<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
	  box-sizing: border-box;
	}
	
	/* Create three columns of equal width */
	.columns {
	  float: left;
	  width: 33.3%;
	  padding: 8px;
	}
	
	/* Style the list */
	.price {
	  list-style-type: none;
	  border: 1px solid #eee;
	  margin: 0;
	  padding: 0;
	  -webkit-transition: 0.3s;
	  transition: 0.3s;
	}
	
	/* Add shadows on hover */
	.price:hover {
	  box-shadow: 0 8px 12px 0 rgba(0,0,0,0.2)
	}
	
	/* Pricing header */
	.price .header {
	  background-color: #111;
	  color: white;
	  font-size: 25px;
	}
	
	/* List items */
	.price li {
	  border-bottom: 1px solid #eee;
	  padding: 20px;
	  text-align: center;
	}
	
	/* Grey list item */
	.price .grey {
	  background-color: #eee;
	  font-size: 20px;
	}
	
	/* The "Sign Up" button */
	.button {
	  background-color: #5f5f5f;
	  border: none;
	  border-radius: 7px;
	  color: white;
	  padding: 10px 25px;
	  text-align: center;
	  text-decoration: none;
	  font-size: 18px;
	}
	
	/* Change the width of the three columns to 100%
	(to stack horizontally on small screens) */
	@media only screen and (max-width: 600px) {
	  .columns {
	    width: 100%;
	  }
	}
</style>
</head>
<body>
	<%@ include file="ceoBase.jsp"%>
	<br>
	<div>
		<div class="col-12 grid-margin stretch-card">
				<div class="card">
					<div class="card-body">
						<h2 class="card-title">구독 후 이용 가능합니다</h2>
						<p class="card-description">구독 가능한 상품의 리스트입니다.</p>
						<c:forEach items="${subscriptionList}" var="subscription">
							<div class="columns">
							  <ul class="price">
							  	<c:if test="${subscription.subscriptionName eq 'Basic'}">
							  		<li class="header" style="background-color:grey">${subscription.subscriptionName}</li>
							  	</c:if>
							  	<c:if test="${subscription.subscriptionName eq 'Pro'}">
							  		<li class="header" style="background-color:#04AA6D">${subscription.subscriptionName}</li>
							  	</c:if>
							    <c:if test="${subscription.subscriptionName eq 'Premium'}">
							  		<li class="header">${subscription.subscriptionName}</li>
							  	</c:if>
							    <li class="grey">&#8361; <fmt:formatNumber value="${subscription.subscriptionPay}" pattern="#,###"/> / year</li>
							    <c:if test="${subscription.subscriptionName eq 'Basic'}">
							    	<li>체험 등록 불가능</li>
							    	<li>호텔 등록 불가능</li>
							    </c:if>
							     <c:if test="${subscription.subscriptionName ne 'Basic'}">
							    	<li>체험 ${subscription.subscriptionExperience} 등록 가능</li>
							    	<li>호텔 ${subscription.subscriptionHotel} 등록 가능</li>
							    </c:if>
							    <c:if test="${subscription.subscriptionExhibitionEnum eq '무'}">
							    	<li>전시 소개 등록 비제공</li>
							    </c:if>
							     <c:if test="${subscription.subscriptionExhibitionEnum eq '유'}">
							    	<li>전시 소개 등록 제공</li>
							    </c:if>
							     <li class="grey">
							    <c:if test="${subscription.subscriptionNo eq subscriptionNo }">
									<a class="btn btn-secondary" style="text-align: center;">구독 중</a>
								</c:if>
								<c:if test="${subscription.subscriptionNo ne subscriptionNo }">
									<a href="${pageContext.request.contextPath}/ceo/updateSubscribe?ceoId=${ceoId}&subscriptionNo=${subscription.subscriptionNo}"class="btn btn-warning">구독 변경</a>
								</c:if>
								</li>
							  </ul>
							</div>
						</c:forEach>
					</div>
				</div>
		</div>
	</div>
	<script type="text/javascript">
	// 구독 1개만 체크박스 되도록
	function checkOnlyOne(element) {
		  
		  const checkboxes 
		      = document.getElementsByName("subscriptionNo");
		  
		  checkboxes.forEach((cb) => {
		    cb.checked = false;
		  })
		  
		  element.checked = true;
		}
	</script>
</body>
</html>