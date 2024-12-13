package br.dev.unifametro.aluno.agendaOnline.domain.user.enums;

import br.dev.unifametro.aluno.agendaOnline.util.RoleType;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMIN(RoleType.ADMIN),
    PROVIDER(RoleType.PROVIDER),
    CLIENT(RoleType.CLIENT);

    private final String authority;
    Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
