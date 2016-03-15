package Sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Liu Hao on 5/3/16.
 */
@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home() {
        return "index.html";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody User saveUser(@RequestBody @Valid final User user) {
        LOGGER.info("Received request to create the {}", user);
        return userService.save(user);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchUsers(){
        return "searchPage.html";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public @ResponseBody List<User> getUsers(@RequestParam String keyword) {
        LOGGER.info("Received request to list all users");
        return userService.search(keyword);
    }

    @ExceptionHandler(DuplicateUserException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT,reason = "Duplicate use can't be saved")
    public void handleDuplicateUserException() {
        LOGGER.info("Duplicate user not saved");

    }

}
