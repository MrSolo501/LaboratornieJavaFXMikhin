import java.util.function.Consumer;

class RoomInventoryApp {

    public static void main(String[] args) {
        RoomInventoryApp app = new RoomInventoryApp();
        app.displayRoomInventoryInfo();
    }

    public void displayRoomInventoryInfo() {
        // Лямбда-выражение для вывода информации об аудитории
        Consumer<Room> roomInfo = room -> {
            System.out.println("Room Number: " + room.getRoomNumber());
            System.out.println("Responsible Person: " + room.getResponsiblePerson());
        };

        // Лямбда-выражение для вывода информации об инвентаре
        Consumer<Inventory> inventoryInfo = inventory -> {
            System.out.println("Inventory Number: " + inventory.getInventoryNumber());
            System.out.println("Name: " + inventory.getName());
            System.out.println("Quantity: " + inventory.getQuantity());
            System.out.println("Description: " + inventory.getDescription());
        };

        // Создание объекта аудитории
        Room room101 = new Room(101, "Иванов Иван Иванович");

        // Создание объектов инвентаря
        Inventory inventory1 = new Inventory(12345, "Проектор", 1, "Мультимедийный проектор Epson");
        Inventory inventory2 = new Inventory(67890, "Стулья", 20, "Металлические стулья с мягкими сиденьями");

        // Вывод информации об аудитории
        System.out.println("Room Information:");
        System.out.println("--------------------");
        roomInfo.accept(room101);
        System.out.println("--------------------");

        // Вывод информации об инвентаре
        System.out.println("Inventory Information:");
        System.out.println("--------------------");
        inventoryInfo.accept(inventory1);
        System.out.println("--------------------");
        inventoryInfo.accept(inventory2);
    }

    // Класс для описания аудитории
    class Room {
        private int roomNumber;
        private String responsiblePerson;

        public Room(int roomNumber, String responsiblePerson) {
            this.roomNumber = roomNumber;
            this.responsiblePerson = responsiblePerson;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public String getResponsiblePerson() {
            return responsiblePerson;
        }
    }

    // Класс для описания инвентаря
    class Inventory {
        private int inventoryNumber;
        private String name;
        private int quantity;
        private String description;

        public Inventory(int inventoryNumber, String name, int quantity, String description) {
            this.inventoryNumber = inventoryNumber;
            this.name = name;
            this.quantity = quantity;
            this.description = description;
        }

        public int getInventoryNumber() {
            return inventoryNumber;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public String getDescription() {
            return description;
        }
    }
}
