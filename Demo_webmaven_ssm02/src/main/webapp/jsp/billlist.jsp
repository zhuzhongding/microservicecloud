<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>

<div class="right">
       <div class="location">
           <strong>你现在所在的位置是:</strong>
           <span>订单管理页面</span>
       </div>
       <div class="search">
       <form method="post" action="${pageContext.request.contextPath }/dnysearch">
			<input name="method" value="query" class="input-text" type="hidden">
			<span>商品名称：</span>
			<input name="queryProductName" type="text" value="${queryProductName }">
			 
			<span>供应商：</span>
			<select name="queryProviderId">
				<%-- <c:if test="${listpro != null }">  --%>
				   <option value="0">--请选择--</option>
				  <%-- <c:forEach var="provider" items="${listpro}">
				   		<option value="${provider.PRONAME}">${provider.PRONAME}</option>
				   </c:forEach>  --%>
				<%-- </c:if> --%>
       		</select>
			 
			<span>是否付款：</span>
			<select name="queryIsPayment">
				<option value="0">--请选择--</option>
				<%-- <option value="1" ${queryIsPayment == 1 ? "selected=\"selected\"":"" }>未付款</option>
				<option value="2" ${queryIsPayment == 2 ? "selected=\"selected\"":"" }>已付款</option> --%>
				<%-- <c:forEach items="${listispay }" var="lst">
					<c:if test="${lst.ISPAYMENT == 1}">
						<option value="${lst.ISPAYMENT}">未付款</option>
					</c:if>
					<c:if test="${lst.ISPAYMENT == 2}">
						<option value="${lst.ISPAYMENT}">已付款</option>
					</c:if>
				</c:forEach> --%>
       		</select>
			
			 <input	value="查 询" type="submit" id="searchbutton">
			 <a href="${pageContext.request.contextPath }/jsp/billadd.jsp">添加订单</a>
		</form>
       </div>
       <!--账单表格 样式和供应商公用-->
      <table class="providerTable" cellpadding="0" cellspacing="0">
          <tr class="firstTr">
              <th width="10%">订单编码</th>
              <th width="20%">商品名称</th>
              <th width="10%">供应商</th>
              <th width="10%">订单金额</th>
              <th width="10%">是否付款</th>
              <th width="10%">创建时间</th>
              <th width="30%">操作</th>
          </tr>
          <c:forEach var="bill" items="${listbill }" varStatus="status">
				<tr>
					<td>
					<span>${bill.billcode }</span>
					</td>
					<td>
					<span>${bill.productname }</span>
					</td>
					<td>
					<span>${bill.spro.proname}</span>
					</td>
					<td>
					<span>${bill.totalprice}</span>
					</td>
					<td>
					<span>
						<c:if test="${bill.ispayment == 1}">未付款</c:if>
						<c:if test="${bill.ispayment == 2}">已付款</c:if>
					</span>
					</td>
					<td>
					<span>
					<fmt:formatDate value="${bill.creationdate}" pattern="yyyy-MM-dd"/>
					</span>
					</td>
					<td>
					<span><a class="viewBill" href="javascript:;" ><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
					<span><a href="javascript:;" onclick="updateBill('${bill.id}');" ><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
					<span><a class="deleteBill" href="javascript:;" onclick="return del('${bill.id}');"><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
					</td>
				</tr>
			</c:forEach>
      </table>
      <%-- <a href="page?currentpage=1">首页</a>&nbsp;&nbsp;
      <a href="page?currentpage=${pg.currentpage-1 }">上一页</a>&nbsp;&nbsp;
      <a href="page?currentpage=${pg.currentpage+1 }">下一页</a>&nbsp;&nbsp;
      <a href="page?currentpage=${pg.lastpage}">尾页</a>&nbsp;&nbsp; --%>
  </div>
</section>
<script>
	function del(id){
		//alert("id:"+id);
		var cfm=confirm("是否要删除此条数？");
		if(cfm){
			window.location.href="delBill?id="+id;
		}else{
			return false;
		}
	}
	function updateBill(id){
		//alert("update id:"+id);
		window.location.href="${pageContext.request.contextPath }/upBill?id="+id;
	}
	
</script>
<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/billlist.js"></script>