package org.comstudy.myweb.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
    // 현재 이 인터페이스를 구현하는 클래스는 반드시 process를 상속받아 구현해야함!
    String process (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
