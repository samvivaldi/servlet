package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

	private static final long serialVersionUID = -3469029488630174020L;

	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		printHeaders(request);
		
        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK);

        //[response-headers]
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");

        //[Header 편의 메서드]
        content(response);
        cookie(response);
        redirect(response);


        PrintWriter writer = response.getWriter();
        writer.println("ok");
    }

	// Header 모든 정보
	private void printHeaders(HttpServletRequest request) {
		System.out.println("--- Headers - start ---");
		/*
		 * Enumeration<String> headerNames = request.getHeaderNames(); while
		 * (headerNames.hasMoreElements()) { String headerName =
		 * headerNames.nextElement(); System.out.println(headerName + ": " +
		 * request.getHeader(headerName)); }
		 */
		request.getHeaderNames().asIterator()
				.forEachRemaining(headerName -> System.out.println(headerName + ":" + request.getHeader(headerName)));
		System.out.println("--- Headers - end ---");
		System.out.println();
	}	
	
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        
//        response.setContentLength(2); //(생략시 자동 생성)
    }

    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        cookie.setValue("TestSam");
        cookie.setValue("TestSam2=123456789");
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html

//        response.setStatus(HttpServletResponse.SC_FOUND); //302
//        response.setHeader("Location", "/basic/hello-form.html");
    	
        response.sendRedirect("/basic/hello-form.html");
    }
}
