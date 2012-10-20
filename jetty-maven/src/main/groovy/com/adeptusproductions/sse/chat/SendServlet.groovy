package com.adeptusproductions.sse.chat

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.ServletException

class SendServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name")
        String message = request.getParameter("message")
        println "got message ${message} from ${name}"

        Channel.getInstance().message(name, message)

        // TODO for some reason the browser complains that no response was received. not sure if this matters with ajax.
//        response.setStatus(200)
        response.setContentType("text/html")
        java.io.PrintWriter out = response.getWriter()
        out.write("OK")
        out.close()
    }
}
