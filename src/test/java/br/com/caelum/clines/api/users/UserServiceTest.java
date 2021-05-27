package br.com.caelum.clines.api.users;

import br.com.caelum.clines.shared.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private static final String ID = "4";
    private static final String NAME = "Wendel Macedo";
    private static final String EMAIL = "wendel@wendel.com";
    private static final String PASSWORD = "123";

    private static final User DEFAULT_USER = new User(NAME, EMAIL, PASSWORD);

    @Spy
    private UserFormMapper formMapper;

    @Spy
    private UserViewMapper viewMapper;

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    @Test
    void shouldReturnAnSingleUserViewWhenExistingInRepository() {

        given(repository.findById(Long.valueOf(ID))).willReturn(Optional.of(DEFAULT_USER));

        UserView userView = service.showUserBy(ID);

        then(repository).should(only()).findById(Long.valueOf(ID));
        then(viewMapper).should(only()).map(DEFAULT_USER);
        then(formMapper).shouldHaveNoInteractions();

        assertEquals(NAME, userView.getName());
        assertEquals(EMAIL, userView.getEmail());
    }

}