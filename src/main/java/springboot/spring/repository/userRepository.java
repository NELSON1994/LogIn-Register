package springboot.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.spring.entity.User;


@Repository
public interface userRepository extends JpaRepository<User, Long> {
    User saveUser(User user);

    User findUserByPassword(String password);

    User findByUsername(String username);

    User findUserByEmail(String email);
}




package com.payment.demo.interceptors;


        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.stereotype.Component;
        import org.springframework.web.servlet.HandlerInterceptor;
        import org.springframework.web.servlet.ModelAndView;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.util.Date;

@Component
public class payment1Interceptors implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("-----------------------------------------");
        logger.info("AUTHORIZATION  :" + request.getHeader("Authorization"));
        logger.info("SECRET KEY  :" + request.getHeader("secretkey"));
        String secretkey = request.getHeader("secretkey");
        if (!secretkey.equalsIgnoreCase("DCD")) {
            logger.info("SECRET KEY NOT CORRECT");
        } else {
            logger.info("SECRET KEY  CORRECT");
        }
        logger.info("-----------------------------------------");
        logger.info("IPAddress :" + request.getRemoteAddr());
        //logger.info("LOCALPRORT :" + request.getLocalPort(7777);
        logger.info("-----------------------------------------");
        logger.info("REMOTE ADDRESS    :" + request.getRemoteAddr());
        logger.info("PROTOCOL    :" + request.getProtocol());
        logger.info("-----------------------------------------");
        logger.info("SERVER NAME   :" + request.getServerName());
        logger.info("SERVER PORT     :" + request.getServerPort());
        logger.info("*********************************************");

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
