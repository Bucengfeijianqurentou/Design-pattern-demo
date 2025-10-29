package builder.test;

public class UserTest {
    public static void main(String[] args) {
        User user1 = User.Builder()
                .username("zhangsan")
                .password("123")
                .build();
        System.out.println("user1 = " + user1);

        User user2 = User.Builder()
                .username("lisi")
                .password("123")
                .nikeName("xiaoli")
                .email("lisi@qq.com")
                .build();

        System.out.println("user2 = " + user2);

    }
}
