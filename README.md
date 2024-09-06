To implement this, we have to follow some instructions:-

1} Create project and add some packages.
2} Develop logic as mentioned in the ShoppingServiceImpl class based on the requirement.

# Configuring email server related configuration

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username= <source emailID> like--abc@gmail.com
spring.mail.password=<Your Password>
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.connectiontimeout=5000
spring.mail.properties.mail.smtp.timeout=5000
spring.mail.properties.mail.smtp.writetimeout=5000

# Note #

While at the of running this application

Make sure that your two factor-authentication is disabled and also enable low secured.
If any Anti-virus is running, Stop that because this application is no that much secured.
Finally, Rin the application.

