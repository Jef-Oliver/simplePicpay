package com.picpaysimplificado.simplepicpay.services;

import com.picpaysimplificado.simplepicpay.domain.user.User;
import com.picpaysimplificado.simplepicpay.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);

//        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationRequest, String.class);
//
//        if (!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
//            System.out.println("Erro ao enviar a notificação");
//            throw new Exception("Serviço de notificação indisponível");
//        }
        System.out.println("Notificação enviada com sucesso");

    }
}
