package builder.test;

public class User {

    private String username;

    private String password;

    private String email;

    private String nikeName;

    private User(Builder builder){
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.nikeName = builder.nikeName;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }

    public static Builder Builder(){
        return new Builder();
    }


    public static class Builder {

        private String username;

        private String password;

        private String email;

        private String nikeName;

        public Builder (){

        }

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder nikeName(String nikeName){
            this.nikeName = nikeName;
            return this;
        }

        public User build(){
            return new User(this);
        }


    }

}
