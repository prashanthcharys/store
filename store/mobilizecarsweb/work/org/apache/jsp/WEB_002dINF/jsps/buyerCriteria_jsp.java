/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.35
 * Generated at: 2013-12-06 22:40:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsps;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class buyerCriteria_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    java.lang.Throwable exception = org.apache.jasper.runtime.JspRuntimeLibrary.getThrowable(request);
    if (exception != null) {
      response.setStatus(javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"errorPage.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=utf-8 />\r\n");
      out.write("\t\t<title> Byer Criteria</title>\r\n");
      out.write("\t\t<link href=\"../../css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../../js/jquery.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("        //$(function(){   $(\"#content\").load(\"mainPage_2.html\"); }); \r\n");
      out.write("        </script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("        <!--<div name=\"content\" id=\"content\" style=\"height:130px; width:1200px; background-color:#ffcc99; float:left; margin:0px 0px 0px 0px\"></div>\r\n");
      out.write("        <fieldset  style=\"margin-left:300px; height:300px; width:600px; float:left; border:solid thick\" >-->\r\n");
      out.write("        <fieldset >\r\n");
      out.write("\t\t\t<legend>\r\n");
      out.write("\t\t\t\tByers Criteria\r\n");
      out.write("\t\t\t</legend>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<label for=\"year\">Year:</label>\r\n");
      out.write("\t\t\t\t<input type=\"number\" name=\"year\" id=\"year\" required>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<label for=\"make\">Make:</label>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"make\" id=\"make\" required>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<label for=\"model\">Model:</label>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"model-local\" id=\"model\" required>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<label for=\"mileage\">Mileage:</label>\r\n");
      out.write("\t\t\t\t<input type=\"number\" name=\"mileage\" id=\"mileage\" required>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<label for=\"color\">color:</label>\r\n");
      out.write("\t\t\t\t<input type=\"color\" name=\"color\" id=\"color\" required>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<label for=\"price\">Price:</label>\r\n");
      out.write("\t\t\t\t<input type=\"number\" name=\"price\" id=\"price\" required>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<label for=\"comments\">Comments:</label>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"comments\" id=\"comments\" required>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"divTable\">\r\n");
      out.write("\t\t\t\t<div class=\"divRow\">\r\n");
      out.write("\t\t\t\t\t<div class=\"divCell\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" name=\"save\" id=\"save\" value=\"Save\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"divCell\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" name=\"delete\" id=\"delete\" value=\"Delete\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</fieldset>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}