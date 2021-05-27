package br.com.caelum.clines.api.users;

import br.com.caelum.clines.shared.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserViewMapperTest {

    private final String NAME = "Wendel Teste";
    private final String EMAIL = "w@w.com";
    private final String PASSWORD = "123";

    private UserViewMapper mapper;

    @Test
    void shouldConvertUserToUserView() {
        User user = new User(NAME, EMAIL, PASSWORD);
        mapper = new UserViewMapper();

        UserView userView = mapper.map(user);

        assertEquals(NAME, userView.getName());
        assertEquals(EMAIL, userView.getEmail());
    }
}