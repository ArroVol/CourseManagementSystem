package edu.ben.cmsc3330.data.translator;

import edu.ben.cmsc3330.data.model.User;
import edu.ben.cmsc3330.web.model.UserView;

/**
 * Translator for Users
 */
public class UserTranslator {

    /**
     * User View Builder
     * @param user User
     * @return User View
     */
    public static UserView entityToView(final User user) {
        return UserView.builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .studentId(user.getStudentId())
                .build();
    }
}
