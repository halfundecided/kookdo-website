<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<% String ctx = request.getContextPath(); %>

<html>
<jsp:include page="../commonHeader.jsp" />

${test}

<script src="<c:url value="/resources/js/board/function.js" />"></script>
<jsp:include page="../commonFooter.jsp" />
</body>
</html>