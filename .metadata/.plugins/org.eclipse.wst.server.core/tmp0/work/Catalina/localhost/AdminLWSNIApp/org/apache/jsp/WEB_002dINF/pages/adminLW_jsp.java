/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.27
 * Generated at: 2020-08-10 08:34:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminLW_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Manage articles</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n");
      out.write("<style>\r\n");
      out.write(".container {\r\n");
      out.write("\toverflow: hidden\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".tab {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".tab-1 {\r\n");
      out.write("\tmargin-left: 50px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".tab-1 input {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\tmargin-bottom: 10px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".tab-2 {\r\n");
      out.write("\tmargin-left: 100px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".tab-2 input {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\tmargin-bottom: 10px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("tr {\r\n");
      out.write("\ttransition: all .5s ease-in-out\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("tr:hover {\r\n");
      out.write("\tbackground-color: #EEE;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div style=\"position: relative\">\r\n");
      out.write("\t\t<p style=\"font-weight: bold; margin-left: 20px\">\r\n");
      out.write("\t\t\tUlogovani ste kao:\r\n");
      out.write("\t\t\t");

			out.print(session.getAttribute("username"));
		
      out.write("\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t\t<h1 style=\"text-align: center\">Manage articles</h1>\r\n");
      out.write("\t\t<form action=\"?action=logout\" method=\"post\">\r\n");
      out.write("\t\t\t<input\r\n");
      out.write("\t\t\t\tstyle=\"font-weight: bold; position: absolute; right: 10px; top: 5px; color: green; font-size: 20px; border-radius: 12px;\"\r\n");
      out.write("\t\t\t\ttype=\"submit\" value=\"Logout\" />\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"tab tab-1\">\r\n");
      out.write("\t\t\t<!--  <table id=\"table\" border=\"1\">\t-->\r\n");
      out.write("\t\t\t<table id=\"table\" class=\"w3-table-all w3-hoverable\">\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>Name</th>\r\n");
      out.write("\t\t\t\t\t\t<th>Price</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tbody id=\"data\">\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"tab tab-2\">\r\n");
      out.write("\t\t\t<form method=\"POST\">\r\n");
      out.write("\t\t\t\t<!-- Id:  -->\r\n");
      out.write("\t\t\t\t<input style=\"display: none\" type=\"number\" name=\"id\" id=\"id\">\r\n");
      out.write("\t\t\t\tName: <input type=\"text\" name=\"name\" id=\"name\"> Price: <input\r\n");
      out.write("\t\t\t\t\ttype=\"number\" name=\"price\" id=\"price\">\r\n");
      out.write("\t\t\t\t<button formaction=\"?action=addArticle\" type=\"submit\"\r\n");
      out.write("\t\t\t\t\tonclick=\"addHTMLTableRow();\"\r\n");
      out.write("\t\t\t\t\tstyle=\"background-color: #4CAF50; font-size: 20px; border-radius: 12px;\">Add</button>\r\n");
      out.write("\t\t\t\t<br> <br />\r\n");
      out.write("\t\t\t\t<button formaction=\"?action=editArticle\"\r\n");
      out.write("\t\t\t\t\tonclick=\"editHtmlTableSelectedRow();\"\r\n");
      out.write("\t\t\t\t\tstyle=\"background-color: #008CBA; font-size: 20px; border-radius: 12px;\">Edit</button>\r\n");
      out.write("\t\t\t\t<br> <br />\r\n");
      out.write("\t\t\t\t<button formaction=\"?action=setUnactiveArticle\"\r\n");
      out.write("\t\t\t\t\tonclick=\"removeSelectedRow();\"\r\n");
      out.write("\t\t\t\t\tstyle=\"background-color: #f44336; font-size: 20px; border-radius: 12px;\">Remove</button>\r\n");
      out.write("\t\t\t\t<br> <br />\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\tfunction loadArticles(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar request = new XMLHttpRequest();\t\t\r\n");
      out.write("\t    request.open(\"GET\", \"api/article\", true);    \r\n");
      out.write("\t\trequest.onreadystatechange = function (){\r\n");
      out.write("\t        if ((request.readyState == 4) && (request.status == 200)) {\r\n");
      out.write("\t            var allArticles = JSON.parse(request.responseText);\r\n");
      out.write("\t            populateTable(allArticles);\r\n");
      out.write("\t        }\r\n");
      out.write("\t    }\t    \r\n");
      out.write("\t    request.send();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction populateTable(allUsers){\r\n");
      out.write("\t\tvar temp = \"\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tallUsers.forEach((u) => {\r\n");
      out.write("\t\t\ttemp += \"<tr class='w3-hover-green'>\";\r\n");
      out.write("\t\t\ttemp += \"<td style='display:none;'>\"+u.id + \"</td>\";\r\n");
      out.write("\t\t\ttemp += \"<td>\"+u.name + \"</td>\";\r\n");
      out.write("\t\t\t//temp += \"<td>\"+u.password + \"</td>\";\r\n");
      out.write("\t\t\ttemp += \"<td>\"+u.price + \"</td>\";\r\n");
      out.write("\t\t\t//temp += \"<td>\"+u.id + \"</td></tr>\";\r\n");
      out.write("\t\t\ttemp += \"<td style='display:none;'>\"+u.active + \"</td>\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"data\").innerHTML = temp;\r\n");
      out.write("\t\tselectedRowToInput();\r\n");
      out.write("\t}\t\r\n");
      out.write("\t//document.addEventListener(\"DOMContentLoaded\", () => { loadArticles();  });\r\n");
      out.write("\t\t\r\n");
      out.write("\tvar rIndex, \r\n");
      out.write("\t\ttable = document.getElementById(\"table\");\r\n");
      out.write("\t\r\n");
      out.write("\tfunction checkEmptyInput(){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\tvar isEmpty = false;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tname = document.getElementById(\"name\").value,\r\n");
      out.write("\t\tprice = document.getElementById(\"price\").value;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(name === \"\"){\r\n");
      out.write("\t\t\talert(\"Name cannot Be Empty\");\r\n");
      out.write("\t\t\tisEmpty = true;\r\n");
      out.write("\t\t} else if(price === \"\"){\r\n");
      out.write("\t\t\talert(\"Price cannot Be Empty\");\r\n");
      out.write("\t\t\tisEmpty = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\treturn isEmpty;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction addHTMLTableRow(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(!checkEmptyInput()){\r\n");
      out.write("\t\tnewRow = table.insertRow(table.length),\r\n");
      out.write("\t\tcell1 = newRow.insertCell(1),\r\n");
      out.write("\t\tcell2 = newRow.insertCell(2),\t\r\n");
      out.write("\t\tname = document.getElementById(\"name\").value,\r\n");
      out.write("\t\tprice = document.getElementById(\"price\").value,\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tcell1.innerHTML = name; \r\n");
      out.write("\t\tcell2.innerHTML = price;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tselectedRowToInput();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction selectedRowToInput(){\r\n");
      out.write("\t\r\n");
      out.write("\t\tfor(var i=1; i < table.rows.length; i++){\r\n");
      out.write("\t\t\ttable.rows[i].onclick = function(){\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\trIndex = this.rowIndex;\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"id\").value = this.cells[0].innerHTML;\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"name\").value = this.cells[1].innerHTML;\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"price\").value = this.cells[2].innerHTML;\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tloadArticles();\r\n");
      out.write("\tselectedRowToInput();\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction editHtmlTableSelectedRow(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar name = document.getElementById(\"name\").value,\r\n");
      out.write("\t\t\tprice = document.getElementById(\"price\").value;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\ttable.rows[rIndex].cells[1].innerHTML = name;\r\n");
      out.write("\t\ttable.rows[rIndex].cells[2].innerHTML = price;\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction removeSelectedRow(){\t\t\r\n");
      out.write("\t\ttable.deleteRow(rIndex);\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"name\").value = \"\";\r\n");
      out.write("\t\tdocument.getElementById(\"price\").value = \"\";\r\n");
      out.write("\t}\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}