package br.dev.unifametro.aluno.agendaOnline.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "table_id", nullable = false,  updatable = false, unique = true)
    private  Long id;

    @Column( name = "external_idd", nullable = false, updatable = false, unique = true)
    private UUID externalID;
}
