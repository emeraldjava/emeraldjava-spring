package ie.emeraldjava.raft.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * https://www.baeldung.com/spring-extract-custom-header-request
 */
@Slf4j
public class RaftHeaderInterceptor implements HandlerInterceptor {
    //private final OperatorHolder operatorHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String operator = request.getHeader("raft-operator");
        log.info("operator: {}", operator);
      //  operatorHolder.setOperator(operator);
        return true;
    }
}
