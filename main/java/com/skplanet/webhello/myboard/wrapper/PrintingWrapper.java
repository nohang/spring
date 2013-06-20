package com.skplanet.webhello.myboard.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 13. 3. 13.
 * Time: 오후 4:29
 * To change this template use File | Settings | File Templates.
 */
public class PrintingWrapper extends HttpServletRequestWrapper{
    public PrintingWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Object getAttribute(String name) {
//        System.out.println("PrintingWrapper.getAttribute");
//        System.out.println("name = [" + name + "]");
        return super.getAttribute(name);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void setAttribute(String name, Object o) {
//        System.out.println("PrintingWrapper.setAttribute");
//        System.out.println("name = [" + name + "], o = [" + o + "]");
        super.setAttribute(name, o);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
