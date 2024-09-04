# Java Project Setup with MySQL Connector/J in Visual Studio Code

This guide helps you set up a Java project in Visual Studio Code (VSCode) with the MySQL Connector/J (JDBC Driver) version 9.0.0 to resolve the `ClassNotFoundException`.

## Prerequisites

- **Java JDK**: Ensure you have Java JDK 11 or later installed.
- **VSCode**: Visual Studio Code installed with the Java Extension Pack.
- **MySQL Server**: Running MySQL server accessible on `localhost:3306`.
- **MySQL Connector/J**: Download the JDBC driver (version `9.0.0`).

## Step 1: Download MySQL Connector/J

1. Visit the [MySQL Connector/J download page](https://dev.mysql.com/downloads/connector/j/).
2. Download the `mysql-connector-j-9.0.0.jar` file.

## Step 2: Add MySQL JDBC Driver to Your Project

1. **Create a `lib` folder** in your project's root directory.
2. Place the `mysql-connector-j-9.0.0.jar` file in the `lib` folder.

Your project structure should look like this:


## Step 3: Configure Classpath in VSCode

### Option 1: Update `settings.json`

1. Open VSCode settings by pressing `Ctrl+,` or go to `File > Preferences > Settings`.
2. Click on **Open Settings (JSON)** in the top right corner.
3. Add the following entry to include the JAR file:

    ```json
    "java.project.referencedLibraries": [
        "lib/**/*.jar"
    ]
    ```

### Option 2: Update `launch.json`

1. Go to the **Run and Debug** tab or press `Ctrl+Shift+D`.
2. Click on **create a launch.json file** if it doesn't exist.
3. Add the JAR path to the `classpath` array:

    ```json
    {
      "version": "0.2.0",
      "configurations": [
        {
          "type": "java",
          "name": "Launch Program",
          "request": "launch",
          "mainClass": "com.cts.MainApp",
          "classpath": [
            "${workspaceFolder}/lib/mysql-connector-j-9.0.0.jar"
          ]
        }
      ]
    }
    ```

## Step 4: Reload VSCode and Rebuild the Project

- **Reload the Window**: Press `Ctrl+Shift+P` and select `Developer: Reload Window`.
- **Rebuild Your Project**: Make sure your Java project is properly compiled, and VSCode recognizes all dependencies.

## Step 5: Ensure JDBC Driver is Loaded Correctly in Your Code

In your `DBUtil` class, make sure you are loading the driver correctly:

```java
public class DBUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL JDBC driver
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load MySQL JDBC driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/digital_magazine";
        String user = "yourUsername";
        String password = "yourPassword";
        return DriverManager.getConnection(url, user, password);
    }
}
