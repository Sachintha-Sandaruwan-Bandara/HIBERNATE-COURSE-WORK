package lk.ijse.HIBERNATE_COURSE_WORK.controller;
/* 
    @author Sachi_S_Bandara
    @created 3/15/2024 - 7:55 AM 
*/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.HIBERNATE_COURSE_WORK.dto.AdminDTO;
import lk.ijse.HIBERNATE_COURSE_WORK.navigation.Navigation;
import lk.ijse.HIBERNATE_COURSE_WORK.navigation.Routes;
import lk.ijse.HIBERNATE_COURSE_WORK.service.AdminService;
import lk.ijse.HIBERNATE_COURSE_WORK.service.impl.AdminServiceImpl;

import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class AdminCreateAccountController {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtOtp;

    @FXML
    private Label txtOtpIncorrect;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtRePassword;

    @FXML
    private TextField txtUserName;

    private int otp;

    private AdminService adminService;

    public void initialize(){
        adminService= AdminServiceImpl.getInstance();
        txtOtpIncorrect.setVisible(false);
    }

    @FXML
    void btnGetOtpOnAction(ActionEvent event) {
//            emailSender();
    }

//    private void emailSender() {
//        // Generate a random OTP
//         otp = generateOTP();
//
//        // Recipient's email address
//        String to = txtEmail.getText();
//
//        // Sender's email address and password
//        String from = "ontheway753@gmail.com";
//        String password = "0788740073";
//
//        // SMTP server settings
//        String host = "smtp.gmail.com";
//        String port = "587"; // or "465" for SSL 587
//
//        // Email subject and body
//        String subject = "Your OTP From Book Warm";
//        String body = "Your OTP is: " + otp;
//
//        // Send the email
//        sendEmail(from, password, to, subject, body, host, port);
//    }
//
//    private int generateOTP() {
//        return (int) (Math.random() * 9000) + 1000;
//    }

//    private void sendEmail(String from, String password, String to, String subject, String body, String host, String port) {
//        Properties properties = System.getProperties();
//
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port", port);
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//
//        Session session = Session.getInstance(properties, new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(from, password);
//            }
//        });
//
//        try {
//            MimeMessage message = new MimeMessage(session);
//
//            message.setFrom(new InternetAddress(from));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            message.setSubject(subject);
//            message.setText(body);
//
//            Transport.send(message);
//            System.out.println("OTP sent successfully!");
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
//    }

    @FXML
    void btnReSendOtpOnAction(ActionEvent event) {
//        emailSender();
    }

    @FXML
    void btnVerifyOtpOnAction(ActionEvent event) throws IOException {
//          if (otp == Integer.parseInt(txtOtp.getText())){

              AdminDTO adminDTO = new AdminDTO();
              adminDTO.setUsername(txtUserName.getText());
              adminDTO.setPassword(txtPassword.getText());
              adminDTO.setEmail(txtEmail.getText());

              Long adminId = adminService.saveAdmin(adminDTO);

              System.out.println("this is admin id :"+adminId);

              Navigation.navigate(Routes.LOGOUT,anchorPane);

//          }
//          else {
//              txtOtpIncorrect.setVisible(true);
//          }
    }

}
