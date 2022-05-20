package com.yqxd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@WebServlet("/vc")
public class MakeAVCController extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建空白图片
        BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random r = new Random();
        //设置画笔颜色
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        //绘制矩形背景
        g.fillRect(0, 0, 100, 30);
        //绘制八条干扰线
        for (int i = 1; i <= 8; i++) {
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
        }
        //画字母
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        String number = getNumbers(5);
        g.setFont(new Font(null,Font.BOLD+Font.ITALIC,24));
        g.drawString(number,5,25);
        response.setContentType("image/jpeg");
        OutputStream out = response.getOutputStream();
        ImageIO.write(image,"jpeg",out);
        out.close();
    }
    public String getNumbers(int size){
        String str = "DSADACDCSVferhisdhfg2fg654gd161g6r1514hr61sfgvrVERVGEGdadewrFgergerdfWEFAWFEGEGAfdewfsfsdfsfwfaEGRGFRFSDFEFEgergegWFREGTEGRTEGEWEGFEWF";
        String number = "";
        Random r = new Random();
        for (int i = 0;i<size;i++){
            number = number + str.charAt(r.nextInt(str.length()));
        }
        return number;
    }
}