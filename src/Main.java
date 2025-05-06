public class Main {
    public static void main(String[] args) {
        DatabaseConnector databaseConnector = new DatabaseConnector();

        try {
            System.out.println(databaseConnector.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Connection closed");
        }
    }

}
