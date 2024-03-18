# musical-octo-fortnight
Spring Web, Spring Data JPA, H2 Database, Spring Boot DevTools


[https://start.spring.io/](https://start.spring.io/)

![https://github.com/ilmsg/musical-octo-fortnight/blob/main/images/2024-02-11_081233.png?raw=true](https://github.com/ilmsg/musical-octo-fortnight/blob/main/images/2024-02-11_081233.png?raw=true)

---

auth-security

refer: https://github.com/afsalashyana/Spring-Boot-Tutorials/tree/master/LearnSpringSecurity




---

ticket

refer:
- https://github.com/learnCodeWithSankalp/Spring-Boot-Project-Code/tree/Spring-boot-transaction-management
- https://www.youtube.com/watch?v=CokAkwI5U3s


เรื่อง transaction management 

@EnableTransactionManagement

    package com.ilmsg.ticket;

    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.transaction.annotation.EnableTransactionManagement;

    @SpringBootApplication
    @EnableTransactionManagement
    public class TicketApplication {
        public static void main(String[] args) {
            SpringApplication.run(TicketApplication.class, args);
        }
    }

ใช้กับ @Transactional ถ้า method มี throw error ออกมา ก็จะ rollback transaction นั้น

    @Service
    public class MovieTicketService {
        @Autowired
        private TicketInfoRepository ticketInfoRepository;

        @Transactional
        public MovieTicketAcknowledgement bookMovieTicket(MovieTicketReqeust request) {
            TicketInfo newTicketInfo = request.getTicketInfo();
            TicketInfo ticketInfo = ticketInfoRepository.save(newTicketInfo);
            ...
        }
    }
