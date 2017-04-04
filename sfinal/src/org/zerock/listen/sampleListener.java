package org.zerock.listen;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.zerock.persistence.BoardDAO;

/**
 * Application Lifecycle Listener implementation class sampleListener
 *
 */
@WebListener
public class sampleListener implements ServletContextListener, ServletRequestListener {

    /**
     * Default constructor. 
     */
    public sampleListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         String addr = sre.getServletRequest().getRemoteAddr();
         
         System.out.println(addr);
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         //WAS가 톰켓에서 죽을떄 발생하는 이벤트
    	
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	//WAS가 톰켓에서 로딩될때 발생하는 이벤트
    	
    ServletContext ctx = sce.getServletContext(); //컨텍스트 나오면 무조건 울타리 기억해라. 울타리(범위,공간), 라이프싸이클.기억!!
    
    ctx.setAttribute("logo", "NolRan");//session, request, Context 까지 세번쨰.
    ctx.setAttribute("util", new RequestUtil());
    
    try {
		ctx.setAttribute("boardDAO", new BoardDAO());
	} catch (Exception e) {

		e.printStackTrace();
	}
    
    
    for(int i=0; i<10; i++){
    	System.out.println("컨텍스트 생성...." + i);
    }
    	
    }
	
}
