package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <title>Document</title>\n");
      out.write("    <link href=\"css/styleHome.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <link href=\"css/bootstrap-4.0.0-dist/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <link href=\"css/bootstrap-4.0.0-dist/css/bootstrap-grid.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("    <div id=\"slider\">\n");
      out.write("        <div class=\"text-content\">\n");
      out.write("            <h2 class=\"text-description\">Your pleasure is our happiness</h2>\n");
      out.write("            <h2 class=\"text-header\">Outer beauty comes from inner health.</h2>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"main-content\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row  choice-list\">\n");
      out.write("                <div class=\"col-sm-6 ml-auto\">\n");
      out.write("                    <h5>DANH MỤC SẢN PHẨM</h5>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-6 mr-auto\">\n");
      out.write("                    <a href=\"./detailVaccine.jsp\">Xem tất cả</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-4 content-vaccine\">\n");
      out.write("                    <img src=\"https://vnvc.vn/wp-content/uploads/2021/07/vaxigrip-tetra.jpg\" alt=\"\">\n");
      out.write("                    <h6>Vắc xin Tứ giá Vaxigrip Tetra phòng bệnh Cúm mùa</h6>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4 content-vaccine\">\n");
      out.write("                    <img src=\"https://vnvc.vn/wp-content/uploads/2019/11/prevenar.jpg\" alt=\"\">\n");
      out.write("                    <h6>Vắc xin phế cầu PREVENAR 13 – Phòng các bệnh do phế cầu khuẩn</h6>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4 content-vaccine\">\n");
      out.write("                    <img src=\"https://vnvc.vn/wp-content/uploads/2020/02/boostrix.jpg\" alt=\"\">\n");
      out.write("                    <h6>Vắc xin BOOSTRIX (Bỉ) phòng Ho gà – Bạch hầu – Uốn ván</h6>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-4 content-vaccine\">\n");
      out.write("                    <img src=\"https://vnvc.vn/wp-content/uploads/2021/07/vaxigrip-tetra.jpg\" alt=\"\">\n");
      out.write("                    <h6>Vắc xin Tứ giá Vaxigrip Tetra phòng bệnh Cúm mùa</h6>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4 content-vaccine\">\n");
      out.write("                    <img src=\"https://vnvc.vn/wp-content/uploads/2019/11/prevenar.jpg\" alt=\"\">\n");
      out.write("                    <h6>Vắc xin phế cầu PREVENAR 13 – Phòng các bệnh do phế cầu khuẩn</h6>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4 content-vaccine\">\n");
      out.write("                    <img src=\"https://vnvc.vn/wp-content/uploads/2020/02/boostrix.jpg\" alt=\"\">\n");
      out.write("                    <h6>Vắc xin BOOSTRIX (Bỉ) phòng Ho gà – Bạch hầu – Uốn ván</h6>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-4 content-vaccine\">\n");
      out.write("                    <img src=\"https://vnvc.vn/wp-content/uploads/2021/07/vaxigrip-tetra.jpg\" alt=\"\">\n");
      out.write("                    <h6>Vắc xin Tứ giá Vaxigrip Tetra phòng bệnh Cúm mùa</h6>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4 content-vaccine\">\n");
      out.write("                    <img src=\"https://vnvc.vn/wp-content/uploads/2019/11/prevenar.jpg\" alt=\"\">\n");
      out.write("                    <h6>Vắc xin phế cầu PREVENAR 13 – Phòng các bệnh do phế cầu khuẩn</h6>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4 content-vaccine\">\n");
      out.write("                    <img src=\"https://vnvc.vn/wp-content/uploads/2020/02/boostrix.jpg\" alt=\"\">\n");
      out.write("                    <h6>Vắc xin BOOSTRIX (Bỉ) phòng Ho gà – Bạch hầu – Uốn ván</h6>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("    \n");
      out.write("          <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    \n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
