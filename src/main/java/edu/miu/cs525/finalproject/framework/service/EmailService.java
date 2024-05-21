package edu.miu.cs525.finalproject.framework.service;

public class EmailService {
    public static void sendEmail(String to, String subject, String body) {
        System.out.println("Sending email to " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}
