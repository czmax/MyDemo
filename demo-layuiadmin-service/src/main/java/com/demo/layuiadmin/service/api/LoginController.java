package com.demo.layuiadmin.service.api;

import com.demo.common.response.RestResponse;
import com.demo.common.response.RestResponseAccessToken;
import com.demo.common.response.RestResponseFactory;
import com.demo.common.utils.VerCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Enumeration;

@Slf4j
@RestController
public class LoginController {

    @RequestMapping(value = "/login")
    public RestResponse<RestResponseAccessToken> login(HttpServletRequest request){
        // 获取到当前线程绑定的请求对象
        // HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 已经拿到session,就可以拿到session中保存的用户信息了。
        System.out.println(request.getSession().getAttribute("vercode"));
        RestResponseAccessToken accessToken = new RestResponseAccessToken();
        accessToken.setAccess_token("");
        return RestResponseFactory.ok(accessToken);
    }

    @RequestMapping(value = "/login/vercode")
    public void vercode(HttpServletResponse response, HttpSession session) throws Exception {
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = VerCodeUtil.createImage();
        log.debug("图形验证为：" + objs[0]);
        //将验证码存入Session
        session.setAttribute("vercode", objs[0]);

        //将图片输出给浏览器
        BufferedImage image = (BufferedImage) objs[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }
}
