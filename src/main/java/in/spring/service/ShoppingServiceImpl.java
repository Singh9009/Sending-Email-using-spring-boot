package in.spring.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service("shopping")
public class ShoppingServiceImpl implements IShopping {

	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Override
	public String shopping(String[] items, Float[] price, String[] toMail) {

		Float billAmt = 0.0f;
		for(Float local:price)
		{
			billAmt = billAmt+local;
		}
		String message = "The items "+Arrays.toString(items)+" with price "+
		                              Arrays.toString(price)+" are purchased of amount "+billAmt;

		String status = sendMail(message, "Shopping Details", toMail); 
		return message+"==="+status;
	}
	
	private String sendMail(String emailBody, String emailSubject, String toMails[])
	{
		try {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(fromMail);
		helper.setCc(toMails);
		helper.setSubject(emailSubject);
		helper.setSentDate(new Date());
		helper.setText(emailBody);
		helper.addAttachment("Prashant_image.jpg", new ClassPathResource("Image.jpg"));
		sender.send(message);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "Email sent successfully with attachment";
	}

}
