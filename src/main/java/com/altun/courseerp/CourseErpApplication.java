package com.altun.courseerp;

import com.altun.courseerp.mappers.CourseEntityMapper;
import com.altun.courseerp.models.enums.UserStatus;
import com.altun.courseerp.models.mybatis.course.Course;
import com.altun.courseerp.models.mybatis.user.User;
import com.altun.courseerp.models.mybatis.user.UserServiceImpl;
import com.altun.courseerp.models.properties.security.SecurityProperties;
import com.altun.courseerp.payload.auth.SignUpPayload;
import com.altun.courseerp.repository.UserRepository;
import com.altun.courseerp.service.course.CourseService;
import com.altun.courseerp.service.security.AccesTokenManager;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@MapperScan("com.altun.courseerp.repository")
@RequiredArgsConstructor
public class CourseErpApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CourseErpApplication.class, args);
    }


    private final UserRepository userRepository;

//    @Value("${security.jwt.public-key}")
//    private String key;
    private final SecurityProperties securityProperties;
    private final AccesTokenManager accesTokenManager;
    private final UserServiceImpl service;
    private final PasswordEncoder passwordEncoder;
    private final CourseService courseService;

    @Override
    public void run(String... args) throws Exception {



        //                                 ****Testing Course inserting****
//        SignUpPayload signUpPayload = new SignUpPayload();
//        signUpPayload.setName("789");
//        signUpPayload.setCourseName("456");
//
//        System.out.println(CourseEntityMapper.INSTANCE.fromSignUpPayload(signUpPayload));


        //                                    ****Testing User****
//        User user = User.builder()
//                .name("Test")
//                .surname("test")
//                .roleId(1L)
//                .phoneNumber("12")
//                .status(UserStatus.ACTIVE)
//                .password(passwordEncoder.encode("123"))
//                .email("altun@email.com").build();
//        user.setId(1L);
//        try{
//            service.insert(user);
//            System.out.println("ugurla inserted");
//        }catch (Exception e){
//            System.out.println("bu xeta: " + e.getMessage());
//        }
//
//            User retrievedUser = service.getEmail("altun@email.com");
//            System.out.println("Retrieved user: " + retrievedUser.getName());
//        } catch (Exception e) {
//            System.err.println("Failed to retrieve user: " + e.getMessage());
//        }

        // System.out.println(service.getEmail("altun@email.com"));

        //      System.out.println(securityProperties);
//        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
//        keyGenerator.initialize(1024);
//        KeyPair kp = keyGenerator.genKeyPair();
//        PublicKey publicKey = kp.getPublic();
//        PrivateKey privateKey = kp.getPrivate();
//
//        String encodedPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
//        String encodedPrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());
//
//        System.out.println(convertToPublicKey(encodedPublicKey));
//
//        System.out.println();
//
//        System.out.println(convertToPrivateKey(encodedPrivateKey));

    }

    private static String convertToPrivateKey(String key) {
        StringBuilder result = new StringBuilder();
        result.append("-----BEGIN PRIVATE KEY-----\n");
        result.append(key);
        result.append("\n-----END PRIVATE KEY-----");
        return result.toString();
    }

    private static String convertToPublicKey(String key) {
        StringBuilder result = new StringBuilder();
        result.append("-----BEGIN PUBLIC KEY-----\n");
        result.append(key);
        result.append("\n-----END PUBLIC KEY-----");
        return result.toString();
    }
}
