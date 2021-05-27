package br.com.caelum.clines.api.users;

import br.com.caelum.clines.shared.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserFormMapperTest {
    private final String NAME = "Wendel Teste";
    private final String EMAIL = "w@w.com";
    private final String PASSWORD = "123";

    private UserFormMapper mapper;

    @Test
    void shouldConvertUserFormToUser() {
        UserForm userForm = new UserForm(NAME, EMAIL, PASSWORD);
        mapper = new UserFormMapper();

        User user = mapper.map(userForm);

        assertEquals(NAME, user.getName());
        assertEquals(EMAIL, user.getEmail());
        assertEquals(PASSWORD, user.getPassword());

    }

}