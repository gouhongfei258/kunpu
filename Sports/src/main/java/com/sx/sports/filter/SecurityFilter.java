package com.sx.sports.filter;


import com.fasterxml.jackson.databind.ObjectMapper;


import com.sx.sports.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.logging.LogRecord;


@WebFilter("/*")
@Slf4j
public class SecurityFilter implements Filter {

    @Autowired
    //private AuthService authService;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String path = request.getServletPath();

        // 白名单放行:请求验证码，登录，登出
        if(path.equals("/")
                || path.equals("/captcha/captchaImage")
                || path.equals("/login")
                || path.equals("/logout")) {
            // 继续传递
            chain.doFilter(request, response);
            return;
        }

        // 静态资源放行
        if(path.endsWith(".html")
                || path.endsWith(".css")
                || path.endsWith(".js")
                || path.endsWith(".jpg")
                || path.endsWith(".jpeg")
                || path.endsWith(".png")
                || path.endsWith(".gif")
                || path.endsWith(".webp")
                || path.startsWith("/whimg")
                || path.contains("/download")
        ) {
            // 继续传递
            chain.doFilter(request, response);
            return;
        }

        // 检查Token
        String clientToken = request.getHeader(WarehouseConstants.HEADER_TOKEN_NAME);
        Result result = loginController.verifyToken(clientToken);
        if(result.isSuccess()){
            // 登录通过，进行权限检查
            CurrentUser currentUser = TokenUtils.getCurrentUser(clientToken);
            // 1,3,4,5,6,8,18,25
            String authIds = authService.findAuthIds(currentUser.getUserId()); // 该用户所有权限id
            // 当前url对应权限id
            Auth auth = authService.findAuthByUrl(path); // 权限对象
            Integer authId = auth==null ?0:auth.getAuthId(); // 5
            if((authIds+",").contains(authId+",")){
                // 有权限放行

            }
            chain.doFilter(request, response);
            return;
        }


        // 其它情况，将校验结果返回
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(result); // 将result对象转成json串
        out.print(json);
        out.flush();
        out.close();
    }


}
}



