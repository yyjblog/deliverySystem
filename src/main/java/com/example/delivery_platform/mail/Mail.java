package com.example.delivery_platform.mail;
        import javax.mail.*;
        import javax.mail.internet.InternetAddress;
        import javax.mail.internet.MimeMessage;
        import java.util.Properties;
        import java.util.Random;

public class Mail {

    /**
     * @Auther: 外卖平台小组
     * @DateTime :  2022年9月2日20:14:45
     * @descriptoin: github就是个垃圾！！！！！！！！！！不然我就不用在这里手动合并代码了
     */

    public String getResult;

    public void sendMail(String mail) throws MessagingException {
        // 创建Properties 类用于记录邮箱的一些属性
        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //端口号，QQ邮箱端口587
        props.put("mail.smtp.port", "587");
        // 此处填写，写信人的账号(自行修改)
        props.put("mail.user", "934902584@qq.com");
        // 此处填写16位STMP口令(自行修改)
        props.put("mail.password", "ykwpmojdiusdbcaf");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人的邮箱 ----这里mail是sendMail(String mail)中的参数  (自行修改)
        InternetAddress to = new InternetAddress(mail);

        message.setRecipient(MimeMessage.RecipientType.TO, to);

        // 设置邮件标题
        message.setSubject("外卖平台注册系统验证码");

        //随机数字6位
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++) {
            result += random.nextInt(10);
        }

        // 设置邮件的内容体
        message.setContent("注册的验证是:" + result, "text/html;charset=UTF-8");

        //存验证码在服务器---可应用与servlet中
        // HttpSession session = req.getSession();
        // session.setAttribute("trueyzm", result);
        //以秒为单位，即在没有活动30分钟后，session将失效
        //session.setMaxInactiveInterval(30*60);
        // System.out.println("yzm->:" + result);

        // 最后当然就是发送邮件啦
        Transport.send(message);

        System.out.println("验证码是："+result);

        getResult = result;
    }
}
