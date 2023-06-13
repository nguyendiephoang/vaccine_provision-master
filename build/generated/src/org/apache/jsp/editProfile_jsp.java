package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class editProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Document</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/style_EProfile.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css\"\n");
      out.write("              integrity=\"sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=\" crossorigin=\"anonymous\" />\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-12\">\n");
      out.write("\n");
      out.write("                    <div class=\"my-5\">\n");
      out.write("                        <h3>My Profile</h3>\n");
      out.write("                        <hr>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <form id=\"infor\" method=\"post\" action=\"updateInfor\" class=\"file-upload\">\n");
      out.write("                        <div class=\"row mb-5 gx-5\">\n");
      out.write("\n");
      out.write("                            <div class=\"col-xxl-8 mb-5 mb-xxl-0\">\n");
      out.write("                                <div class=\"bg-secondary-soft px-4 py-5 rounded\">\n");
      out.write("                                    <div class=\"row g-3\">\n");
      out.write("                                        <h4 class=\"mb-4 mt-0\">Contact detail</h4>\n");
      out.write("\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label class=\"form-label\">Full name *</label>\n");
      out.write("                                            <input required name=\"name\" type=\"text\" class=\"form-control\" placeholder aria-label=\"First name\">\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label class=\"form-label\">Email Address *</label>\n");
      out.write("                                            <input required name=\"email\" pattern=\"[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$\" title=\"Wrong format email\" type=\"email\" class=\"form-control\" placeholder aria-label=\"Last name\">\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label class=\"form-label\">Health Insurance *</label>\n");
      out.write("                                            <input required name=\"healthInsurance\" pattern=\"([0-9]{15})\\b\" title=\"Wrong health insurance\" type=\"text\" class=\"form-control\" placeholder aria-label=\"Phone number\">\n");
      out.write("                                            ");

                                                String ExistHealthInsurance = (String) request.getSession().getAttribute("ExistHealthInsurance");
                                                if (ExistHealthInsurance != null) {
                                            
      out.write("\n");
      out.write("                                            <div style=\"color: red\">");
      out.print( ExistHealthInsurance);
      out.write("</div>\n");
      out.write("                                            ");

                                                    // Xóa thuộc tính session để tránh hiển thị lại cảnh báo
                                                    request.getSession().removeAttribute("ExistHealthInsurance");
                                                }
                                            
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label  class=\"form-label\">Phone number *</label>\n");
      out.write("                                            <input required name=\"phone\" attern=\"(84|0[3|5|7|8|9])+([0-9]{8})\\b\" type=\"phone\" class=\"form-control\" id=\"inputEmail4\">\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label class=\"form-label\">Identification *</label>\n");
      out.write("                                            <input required name=\"identification\" pattern=\"([0-9]{12})\\b\" type=\"text\" class=\"form-control\" placeholder aria-label=\"Phone number\">\n");
      out.write("                                            ");

                                                String ExistIdentification = (String) request.getSession().getAttribute("ExistIdentification");
                                                if (ExistIdentification != null) {
                                            
      out.write("\n");
      out.write("                                            <div style=\"color: red\">");
      out.print( ExistIdentification);
      out.write("</div>\n");
      out.write("                                            ");

                                                    // Xóa thuộc tính session để tránh hiển thị lại cảnh báo
                                                    request.getSession().removeAttribute("ExistIdentification");
                                                }
                                            
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label class=\"form-label\">Birth Date *</label>\n");
      out.write("                                            <input required name =\"dob\" type=\"date\" class=\"form-control\" placeholder aria-label=\"Phone number\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <h6>Gender</h6>\n");
      out.write("                                            <div class=\"gender-option\">\n");
      out.write("                                                <div class=\"gender\" >\n");
      out.write("                                                    <input  value=\"false\" type=\"radio\" id=\"check-male\" name = \"gender\" checked />\n");
      out.write("                                                    <label for=\"check-male\">Female</label>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"gender\">\n");
      out.write("                                                    <input  value=\"true\" type=\"radio\" id=\"check-female\" name = \"gender\" />\n");
      out.write("                                                    <label for=\"check-female\">Male</label>\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"gap-3 d-md-flex justify-content-md-end text-center\">\n");
      out.write("                                            <button type=\"submit\" class=\"btn btn-primary btn-lg\">Update</button>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <div class=\"col-xxl-4\">\n");
      out.write("                                <div class=\"bg-secondary-soft px-4 py-5 rounded\">\n");
      out.write("                                    <div class=\"row g-3\">\n");
      out.write("                                        <h4 class=\"mb-4 mt-0\">Upload your profile photo</h4>\n");
      out.write("                                        <div class=\"text-center\">\n");
      out.write("\n");
      out.write("                                            <div class=\"square position-relative display-2 mb-3\">\n");
      out.write("                                                <i\n");
      out.write("                                                    class=\"fas fa-fw fa-user position-absolute top-50 start-50 translate-middle text-secondary\"></i>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                            <input type=\"file\" id=\"customFile\" name=\"file\" hidden>\n");
      out.write("                                            <label class=\"mt-3 btn btn-success-soft btn-block\" for=\"customFile\">Upload</label>\n");
      out.write("                                            <button type=\"submit\" class=\"mt-3 btn btn-danger-soft\">Remove</button>\n");
      out.write("\n");
      out.write("                                            <!--                                        <p class=\"text-muted mt-3 mb-0\"><span class=\"me-1\">Note:</span>Minimum size\n");
      out.write("                                                                                        300px x 300px</p>-->\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <form id=\"changepass\" method=\"post\" action=\"updatePass\">\n");
      out.write("                        <div class=\"row mb-5 gx-5\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <div class=\"col-xxl-6\">\n");
      out.write("                                <div class=\"bg-secondary-soft px-4 py-5 rounded\">\n");
      out.write("                                    <div class=\"row g-3\">\n");
      out.write("                                        <h4 class=\"my-4\">Change Password</h4>\n");
      out.write("\n");
      out.write("                                        <div class=\"col-md-12\">\n");
      out.write("                                            ");

                                                String oldPassU = (String) request.getSession().getAttribute("oldPassU");
                                                if (oldPassU != null) {
                                            
      out.write("\n");
      out.write("                                            <div style=\"color: red\">");
      out.print( oldPassU);
      out.write("</div>\n");
      out.write("                                            ");

                                                    // Xóa thuộc tính session để tránh hiển thị lại cảnh báo
                                                    request.getSession().removeAttribute("oldPassU");
                                                }
                                            
      out.write("\n");
      out.write("                                            <label for=\"exampleInputPassword1\" class=\"form-label\">Old password *</label>\n");
      out.write("                                            <input required name=\"oldPass\" type=\"password\" class=\"form-control\" id=\"exampleInputPassword1\">\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label for=\"exampleInputPassword2\" class=\"form-label\">New password *</label>\n");
      out.write("                                            <input required name=\"newPass\" type=\"password\" class=\"form-control\" id=\"exampleInputPassword2\">\n");
      out.write("                                             ");

                                                String conflictPass = (String) request.getSession().getAttribute("conflictPass");
                                                if (conflictPass != null) {
                                            
      out.write("\n");
      out.write("                                            <div  style=\"color: red\">");
      out.print( conflictPass);
      out.write("</div>\n");
      out.write("                                            ");

                                                    // Xóa thuộc tính session để tránh hiển thị lại cảnh báo
                                                    request.getSession().removeAttribute("conflictPass");
                                                }
                                            
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <label for=\"exampleInputPassword3\" class=\"form-label\">Confirm Password *</label>\n");
      out.write("                                            <input required name=\"reNewPass\" type=\"password\" class=\"form-control\" id=\"exampleInputPassword3\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"gap-3 d-md-flex justify-content-md-end text-center\">\n");
      out.write("                                           \n");
      out.write("                                            ");

                                                String changpasssucess = (String) request.getSession().getAttribute("changpasssucess");
                                                if (changpasssucess != null) {
                                            
      out.write("\n");
      out.write("                                            <div  style=\"color: blue\">");
      out.print( changpasssucess);
      out.write("</div>\n");
      out.write("                                            ");

                                                    // Xóa thuộc tính session để tránh hiển thị lại cảnh báo
                                                    request.getSession().removeAttribute("changpasssucess");
                                                }
                                            
      out.write("\n");
      out.write("                                            <button type=\"submit\" class=\"btn btn-primary btn-lg\">Update</button>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"gap-3 d-md-flex justify-content-md-end text-center\">\n");
      out.write("                            <a href=\"home.jsp\" type=\"button\" class=\"btn btn-danger btn-lg\">Back </a>\n");
      out.write("<!--                            <button type=\"button\" class=\"btn btn-danger btn-lg\"></button>-->\n");
      out.write("<!--                            <button type=\"submit\" class=\"btn btn-primary btn-lg\">Update profile</button>-->\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-1.10.2.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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
