/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.27
 * Generated at: 2020-08-10 08:32:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Manage accounts</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n");
      out.write("<!-- <script src=\"script/index.js\"></script> -->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div style=\"position: relative\">\r\n");
      out.write("\t\t<p style=\"font-weight: bold; margin-left: 20px\">Ulogovani ste kao:\r\n");
      out.write("\t\t\t\t\t");

							out.print(session.getAttribute("username"));
					
      out.write("\r\n");
      out.write("\t</p> \r\n");
      out.write("\t<h1 style=\"text-align: center\">Manage accounts</h1>\r\n");
      out.write("\t\t<form action=\"?action=logout\" method=\"post\">\r\n");
      out.write("\t\t\t<input style=\"font-weight: bold; position: absolute; right: 10px; top: 5px; color: green;\"  type=\"submit\" value=\"Logout\"/>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<div>\r\n");
      out.write(" \t\r\n");
      out.write(" \t<table class=\"w3-table-all w3-hoverable\">\r\n");
      out.write(" \t<thead>\r\n");
      out.write("            <tr class=\"w3-red\">\r\n");
      out.write("                <th>Username</th>\r\n");
      out.write("                <!-- <th>Password</th>\t-->\r\n");
      out.write("                <th>Roles</th>\r\n");
      out.write("                <th>Active</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write(" \t\t<tbody id=\"data\">\r\n");
      out.write(" \t\t</tbody>\r\n");
      out.write(" \t</table>\r\n");
      out.write(" \t\r\n");
      out.write(" \t  \r\n");
      out.write(" \t<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\tconst userDatatableConst = document.querySelector(\"#usersDatatable > tbody\");\r\n");
      out.write("\t\r\n");
      out.write("\tfunction loadUsers(){\t\r\n");
      out.write("\tvar request = new XMLHttpRequest();\t\r\n");
      out.write("    request.open(\"GET\", \"api/user\", true);    \r\n");
      out.write("\trequest.onreadystatechange = function (){\r\n");
      out.write("        if ((request.readyState == 4) && (request.status == 200)) {\r\n");
      out.write("            var allUsers = JSON.parse(request.responseText);\r\n");
      out.write("            populateTable(allUsers);\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    \trequest.send();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction populateTable(allUsers){\r\n");
      out.write("\t\tvar temp = \"\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tallUsers.forEach((u) => {\r\n");
      out.write("\t\t\ttemp += \"<tr class='w3-hover-green'>\";\r\n");
      out.write("\t\t\ttemp += \"<td>\"+u.username + \"</td>\";\r\n");
      out.write("\t\t\t//temp += \"<td>\"+u.password + \"</td>\";\r\n");
      out.write("\t\t\ttemp += \"<td>\"+u.roles + \"</td>\";\r\n");
      out.write("\t\t\ttemp += \"<td>\"+u.active + \"</td></tr>\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"data\").innerHTML = temp;\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tdocument.addEventListener(\"DOMContentLoaded\", () => { loadUsers();  });\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write(" \t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
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