package com.zyc.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 作者:ZYC
 * DATE:2024/8/7
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
@WebListener
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    /**
     * 添加参数时触发
     * @param event the HttpSessionBindingEvent containing the session
     * and the name and value of the attribute that was added
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("session添加了属性");
    }

    /**
     * 移除参数时触发
     * @param event the HttpSessionBindingEvent containing the session
     * and the name and value of the attribute that was removed
     */
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("session移除了了属性");
    }

    /**
     * 替换参数时触发
     * @param event the HttpSessionBindingEvent containing the session
     * and the name and (old) value of the attribute that was replaced
     */
    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("session替换了属性");
    }

    /**
     * 创建时触发
     * @param se the HttpSessionEvent containing the session
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session被创建");
    }

    /**
     * 销毁时触发
     * @param se the HttpSessionEvent containing the session
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session挂了");
    }
}
