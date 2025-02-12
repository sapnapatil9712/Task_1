import java.util.*;
import java.text.SimpleDateFormat;

// Thread-safe Singleton Logger
class Logger {
    private static volatile Logger instance;
    private static final Object lock = new Object();

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("[" + timestamp + "] " + message);
    }
}

// Singleton DatabaseConnection
class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private static final Object lock = new Object();
    private boolean isConnected = false;

    private DatabaseConnection() {}

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public void connect() {
        if (!isConnected) {
            isConnected = true;
            System.out.println("Connected to the database.");
        } else {
            System.out.println("Already connected to the database.");
        }
    }

    public void disconnect() {
        if (isConnected) {
            isConnected = false;
            System.out.println("Disconnected from the database.");
        } else {
            System.out.println("No active database connection.");
        }
    }
}

// Enum for User Roles
enum UserRole {
    ADMIN, USER, GUEST;

    public String getAccessLevel() {
        switch (this) {
            case ADMIN: return "Full access";
            case USER: return "Limited access";
            case GUEST: return "Read-only access";
            default: return "Unknown access level";
        }
    }
}

// Enum for Days of the Week
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }
}

// Enum for Status Codes
enum StatusCode {
    SUCCESS("Operation successful"),
    ERROR("Operation failed"),
    PENDING("Operation in progress");

    private final String message;

    StatusCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

public class SortingRecursion2 {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Application started.");
        
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.connect();
        db.disconnect();
        
        System.out.println("UserRole ADMIN access level: " + UserRole.ADMIN.getAccessLevel());
        
        Day today = Day.SATURDAY;
        System.out.println(today + " is weekend: " + today.isWeekend());
        
        System.out.println("StatusCode SUCCESS message: " + StatusCode.SUCCESS.getMessage());
    }
}
