package com.picpaysimplificado.simplepicpay.domain.transaction;


import com.picpaysimplificado.simplepicpay.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    @ManyToOne //um usuário pode ter várias transações mas uma transação só pode ter um sender e um receiver
    @JoinColumn(name = "sender_id")
    private User sender;
    @ManyToOne //um usuário pode ter várias transações relacioandas a ele, mas uma transação só pode ter um sender e um receiver
    @JoinColumn(name = "receiver_id")
    private User receiver;
    private LocalDateTime timestamp;

    public Transaction() {

    }
}
