package ru.yandex.practicum.filmarate.controller;

class UserControllerTest {
 /*   private static UserController userController;

    @BeforeEach
    public void beforeEach() {
        userController = new UserController();
    }

    @Test
    public void addUser() {
        User user = new User(1, "A@yandex.ru", "tdesbillVasya", "Vasya",
                LocalDate.parse("2000-01-01"));
        userController.addUser(user);
        assertTrue(userController.getAll().contains(user));
    }

    @Test
    public void addUserWithEmailBlankAndShouldBeException() {
        User user = new User(1, "A@yandex.ru", "tdesbillVasya", "Vasya",
                LocalDate.parse("2000-01-01"));
        user.setEmail("");
        assertThrows(ValidationException.class, () -> userController.addUser(user));
        assertFalse(userController.getAll().contains(user));
    }

    @Test
    public void addUserWithEmailWithoutDogAndShouldBeException() {
        User user = new User(1, "A@yandex.ru", "tdesbillVasya", "Vasya",
                LocalDate.parse("2000-01-01"));
        user.setEmail("QWE");
        assertThrows(ValidationException.class, () -> userController.addUser(user));
        assertFalse(userController.getAll().contains(user));
    }

    @Test
    void addUserWithLoginIsEmptyAndShouldBeException() {
        User user = new User(1, "A@yandex.ru", "tdesbillVasya", "Vasya",
                LocalDate.parse("2000-01-01"));
        user.setLogin("");
        assertThrows(ValidationException.class, () -> userController.addUser(user));
        assertFalse(userController.getAll().contains(user));
    }

    @Test
    void addUserWithLoginContainsSpaceAndShouldBeException() {
        User user = new User(1, "A@yandex.ru", "tdesbillVasya", "Vasya",
                LocalDate.parse("2000-01-01"));
        user.setLogin("fdlj dkjf");
        assertThrows(ValidationException.class, () -> userController.addUser(user));
        assertFalse(userController.getAll().contains(user));
    }

    @Test
    void addUserWithNameIsNullAndShouldBeException() {
        User user = new User(1, "A@yandex.ru", "thdesbillVasya", "Vasya",
                LocalDate.parse("2000-01-01"));
        user.setName("");
        userController.addUser(user);
        final Collection<User> users = userController.getAll();
        for (User user1 : users) {
            assertEquals(user1.getName(), user1.getLogin());
        }
    }

    @Test
    void addUserWithFalseDateReliesAndShouldBeException() {
        User user = new User(1, "A@yandex.ru", "tdesbillVasya", "Vasya",
                LocalDate.parse("2000-01-01"));
        user.setBirthday((LocalDate.parse("3000-01-01")));
        assertThrows(ValidationException.class, () -> userController.addUser(user));
        assertFalse(userController.getAll().contains(user));
    } */
}