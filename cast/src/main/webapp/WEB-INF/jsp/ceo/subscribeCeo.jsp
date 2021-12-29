<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<div class="columns">
					  <ul class="price">
					    <li class="header"style="background-color:grey">Basic</li>
					    <li class="grey">Free</li>
					    <li>체험 등록 불가</li>
					    <li>호텔 등록 불가</li>
					    <li>방 등록 불가</li>
					    <li class="grey"><a href="#" class="button">Sign Up</a></li>
					  </ul>
					</div>
					
					<div class="columns">
					  <ul class="price">
					    <li class="header" style="background-color:#04AA6D">Pro</li>
					    <li class="grey">&#8361; 5,000 / year</li>
					    <li>체험 5개 등록 가능</li>
					    <li>호텔 5개 등록 가능</li>
					    <li>방 50개 등록 가능</li>
					    <li class="grey"><a href="#" class="button">Sign Up</a></li>
					  </ul>
					</div>
					
					<div class="columns">
					  <ul class="price">
					    <li class="header">Premium</li>
					    <li class="grey">&#8361; 10,000 / year</li>
					    <li>체험 무제한 등록 가능</li>
					    <li>호텔 무제한 등록 가능</li>
					    <li>방 무제한 등록 가능</li>
					    <li class="grey"><a href="#" class="button">Sign Up</a></li>
					  </ul>
					  
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>