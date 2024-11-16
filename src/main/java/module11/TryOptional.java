package module11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * Optional shows that a result can be null, so it has to be checked.
 */
class TryOptional {

    private record User(String name, String email){};

    private static class UserService{
        private Collection<User> users;

        public UserService() {
            this.users = new ArrayList<>();

            addUser("John Dou", "john.dou@gmail.com");
            addUser("Jane Dou", "jane.ddou@gmail.com");
        }

        private void addUser(String name, String email){
            users.add(new User(name, email));
        }

        public Optional<User> findUserByEmail(String email){
            for (User user : this.users) {
                 if (user.email().equals(email)) {
                     return Optional.of(user);
                 }
            }
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        UserService userService = new UserService();

        Optional<User> findedUser = userService.findUserByEmail("john111.dou@gmail.com");

        System.out.println(findedUser.orElse(new User("default", "default@rmail.com")));
    }


}
