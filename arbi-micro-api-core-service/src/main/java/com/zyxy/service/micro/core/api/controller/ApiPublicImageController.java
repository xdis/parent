package com.zyxy.service.micro.core.api.controller;

import com.zyxy.common.annotation.WebLog;
import com.zyxy.common.constants.Constant;
import com.zyxy.common.util.ImageUtil;
import com.zyxy.common.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * 公共图片获取模块
 */
@Api(description = "公共信息发送模块")
@RequestMapping("/api/public/image")
@RestController
public class ApiPublicImageController extends BaseController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 发送登录验证短信
     */
    @WebLog("公共-获取登录图形验证码")
    @ApiOperation(value = "公共-获取登录图形验证码")
    @GetMapping(value = "/loginCode")
    public void sendSmsLogin(HttpServletResponse response, @RequestParam String username) throws IOException {
        Object[] imageObj = ImageUtil.createNumberImage(200, 100, new Color(121, 136, 178), 4, 10);
        String code = (String) imageObj[0];
        BufferedImage bufferedImage = (BufferedImage) imageObj[1];
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        String key = Constant.LOGIN_IMG_CODE + username;
        operations.set(key, code);
        stringRedisTemplate.expire(key, 10, TimeUnit.MINUTES);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        ImageIO.write(bufferedImage, "jpeg", response.getOutputStream());
    }

    /**
     * 获取忘记密码的图像验证码
     */
    @WebLog("公共-获取忘记密码的图像验证码")
    @ApiOperation(value = "公共-获取忘记密码的图像验证码")
    @GetMapping(value = "/lostPassWordImgCode")
    public void imagecode(HttpServletResponse response, @RequestParam String phone) throws IOException {
        Object[] imageObj = ImageUtil.createNumberImage(200, 100, new Color(121, 136, 178), 4, 10);
        String code = (String) imageObj[0];
        BufferedImage bufferedImage = (BufferedImage) imageObj[1];
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(Constant.LOST_PWD_IMG_CODE + phone, code);
        stringRedisTemplate.expire(Constant.LOST_PWD_IMG_CODE + phone, 10, TimeUnit.MINUTES);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        ImageIO.write(bufferedImage, "jpeg", response.getOutputStream());
    }

    /**
     * 获取注册的图像验证码
     */
    @WebLog("公共-获取注册的图像验证码")
    @ApiOperation(value = "公共-获取注册的图像验证码")
    @GetMapping(value = "/regImgCode")
    public void regImgCode(HttpServletResponse response, @RequestParam String phone) throws IOException {
        Object[] imageObj = ImageUtil.createNumberImage(200, 100, new Color(121, 136, 178), 4, 10);
        String code = (String) imageObj[0];
        BufferedImage bufferedImage = (BufferedImage) imageObj[1];
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(Constant.REG_PWD_IMG_CODE + phone, code);
        stringRedisTemplate.expire(Constant.REG_PWD_IMG_CODE + phone, 10, TimeUnit.MINUTES);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        ImageIO.write(bufferedImage, "jpeg", response.getOutputStream());
    }
}
