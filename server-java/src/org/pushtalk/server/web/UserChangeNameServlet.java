package org.pushtalk.server.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.pushtalk.server.web.common.FreemarkerBaseServlet;

public class UserChangeNameServlet extends FreemarkerBaseServlet {
	private static final long serialVersionUID = 348660245631638687L;
    private static Logger LOG = Logger.getLogger(UserChangeNameServlet.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
	public void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	    
	    LOG.debug("action - user change name");
        Map data = new HashMap();

	    String udid = request.getParameter("udid");
	    if (null == udid) {
	        responseError(response, "udid is required!");
	        return;
	    }
        data.put("udid", udid);
        data.put("changeName", true);

        processTemplate(response, "register.html", data);
	}

	
}
