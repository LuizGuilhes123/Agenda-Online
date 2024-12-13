package br.dev.unifametro.aluno.agendaOnline.domain.user;


import br.dev.unifametro.aluno.agendaOnline.domain.BaseEntity;
import br.dev.unifametro.aluno.agendaOnline.domain.user.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(name = "governmt_id", nullable = false, updatable = false, length = 15)
    private String governmentId;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 30)
    private char[] password;

    @Column(name = "first_name", nullable = false, length = 30)
    private Role role;

    @Column(name = "cpf_Service_Provider", nullable = false, length = 30)
    private boolean cpfServiceProvider;
}
