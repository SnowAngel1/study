package com.study.sentinelrulepush.feign;

import com.common.utils.R;
import com.study.sentinelrulepush.domain.request.UserInfoReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author：陈迎鹏
 * @Description TODO
 * @since 1.0.0
 */
@FeignClient(value = "mall-user",path = "/user")
public interface UserFeignService {

    @RequestMapping("/get/user")
    R findOrderByUserId(UserInfoReq request);
}
