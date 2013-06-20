package com.skplanet.webhello.myboard.interceptor;

import com.skplanet.webhello.myboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 13. 6. 18.
 * Time: 오후 4:02
 * To change this template use File | Settings | File Templates.
 */
public class BoardInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    BoardService boardService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(boardService.isLogin(request)==false){
            redirectLoginPage(response);
            return false;
        }

        return true;
    }

    private void redirectLoginPage(HttpServletResponse response)throws Exception{
        response.sendRedirect("/loginForm");
    }
}
