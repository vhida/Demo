package Sample;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Liu Hao on 6/3/16.
 */
    @Service
    @Validated
    public class UserServiceImpl implements UserService {

        private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
        private final UserRepository repository;


        @Autowired
        public UserServiceImpl(final UserRepository repository) {
            this.repository = repository;
        }

        @Override
        @Transactional
        public User save(@NotNull @Valid final User user) {
            LOGGER.info("Creating {}", user);
            User existing = repository.findOne(new UserPK(user.getFirstName(),user.getLastName()));
            if (existing != null) {
                throw new DuplicateUserException("The name has been saved");
            }
            return repository.save(user);
        }

        @Override
        @Transactional(readOnly = true)
        public List<User> search(String keyword) {
            LOGGER.info("Retrieving the list of all users");
            return repository.findByFirstNameOrLastName(keyword);
        }

    }
