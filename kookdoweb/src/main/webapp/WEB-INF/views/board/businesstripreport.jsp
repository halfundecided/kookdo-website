<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<%@ page import="java.sql.*" %>
<% String ctx = request.getContextPath(); %>
<html>
<jsp:include page="../commonHeader.jsp" />

<%
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

try{
	Class.forName("com.myslq.jdbc.Driver");
	conn = DriverManager.getConnection("jabd:mysql://cafe24pty1026.cafe24.com/pty1026","pty1026","Ekdmsdl123");
	stmt = conn.createStatement();
	rs = stmt.executeQuery("select version()");
	
	while(rs.next()){
		out.print("mysql version");
	}
} catch (Exception e){
	e.printStackTrace();
} finally {
	if(rs != null) try {rs.close(); } catch(Exception ex) {}
	if(stmt != null) try {stmt.close(); } catch(Exception ex) {}
	if(conn != null) try {conn.close(); } catch(Exception ex) {}
}


%>

<jsp:include page="../commonFooter.jsp" />
</body>
</html>
