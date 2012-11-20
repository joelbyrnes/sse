package com.adeptusproductions.sse.chat

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.ServletException

class SendServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sessionId = request.getSession().getId()
        String channel = request.getParameter("channel")
        String message = request.getParameter("message")

        def system = System.getInstance()
        def user = system.users.get(sessionId)

        println "got message ${message} from session ${sessionId}, user ${user.name}"

        // TODO use channel param
        system.channels.get("default").message(user, message)

        // TODO for some reason the browser complains that no response was received. not sure if this matters with ajax.
//        response.setStatus(200)
        response.setContentType("text/html")
        java.io.PrintWriter out = response.getWriter()
        out.write("OK")
        out.close()
    }
}
