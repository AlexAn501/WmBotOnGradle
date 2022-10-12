package ru.worldmac.wmbot.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import ru.worldmac.wmbot.entity.TelegramUser;

import java.util.List;
import java.util.Optional;

/**
 * Integration-level testing for {@link TelegramUserRepository}.
 */

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TelegramUserRepositoryTest {

    @Autowired
    private TelegramUserRepository telegramUserRepository;

    @Sql(scripts = {"/sql/clearDbs.sql", "/sql/telegramUsers.sql"})
    @Test
    public void shouldProperlyFindAllActiveUsers() {
        List<TelegramUser> users = telegramUserRepository.findAllByActiveTrue();

        Assertions.assertEquals(5, users.size());
    }

    @Sql(scripts = {"/sql/clearDbs.sql"})
    @Test
    public void shouldProperlySaveTelegramUser() {
        TelegramUser user = new TelegramUser();
        user.setChatId("1234567890");
        user.setActive(false);
        telegramUserRepository.save(user);

        Optional<TelegramUser> saved = telegramUserRepository.findById(user.getChatId());

        Assertions.assertTrue(saved.isPresent());
        Assertions.assertEquals(user, saved.get());
    }
}
