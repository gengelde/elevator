Elevator System
Overview
The Elevator System is a Java application designed to manage and control passenger, service, and freight elevators in a building. 
It provides functionalities to handle elevator requests, manage elevator queues, and simulate elevator operations.

Features
Passenger Elevators: Processes requests from passengers to move between floors.
Service Elevators: Handles requests for transporting goods, maintenance, or emergency situations.
Freight Elevators: Specifically designed for transporting heavy goods or materials between floors.
Concurrent Processing: Utilizes multi-threading to handle simultaneous elevator requests efficiently.
Dynamic Queue Management: Dynamically manages elevator queues based on passenger requests and elevator availability.
Occupancy and Weight Limits: Enforces limits on elevator occupancy and weight to ensure safety and optimal operation.

Components
The project consists of the following main components:
Passenger Mechanism: Handles operations related to passenger elevators, including queue management and occupancy tracking.
Service Mechanism: Handles operations related to service elevators, including queue management, weight tracking, and occupancy tracking.
Freight Mechanism: Handles operations related to freight elevators, including queue management and weight tracking.
Elevator Threads: Provides separate threads for processing passenger, service, and freight elevator requests concurrently.
Message Class: Represents the data structure for passing elevator requests between threads.

Prerequisites
Before running the Elevator System, ensure you have the following installed:
Java Development Kit (JDK): OpenJDK version 21.0.1 or later
MongoDB: Install MongoDB on your system to store and manage elevator data.
MongoDB Java Driver: Use the mongo-java-driver3.12.14.jar library for Java-MongoDB integration.
Java IDE: Any Java Integrated Development Environment (IDE) can be used to run the program. Ensure the IDE is configured with the JDK and MongoDB Java Driver.

Setup
Install MongoDB: Follow the installation instructions for your operating system provided on the MongoDB website.
Import Data: Manually add the JSON data from the elevator_data.json file into the Elevator collection in the Elevator_DB in MongoDB.
Download MongoDB Java Driver: Download the mongo-java-driver3.12.14.jar library and include it in your Java project's lib classpath.
Compile and Run: Open the project in your Java IDE and run the Main class to start the elevator system.

Running the Code
To run the Elevator System:
Open your Java IDE.
Import the project into your IDE.
Make sure the JDK and MongoDB Java Driver are properly configured in your project's build path.
Run the Main class to start the elevator system.
Use the provided interface or API to send elevator requests and monitor system operations.

To operate the Elevator System, follow these steps:
To use the program you will enter the type of elevator you would like to use in the "Enter Elevator Code" text box area. 
Afterwards you will enter a passenger amount and/or a weight amount entering the elevator. 
Next you will optionally enter an ID into the "Enter ID" text box area (Based on the entered ID will grant access to employee only elevators and determine set destination floors for the passenger elevator.)
Once you have entered all of the information you wish to enter you will then select a call button (UP/DN 1-10.)
The elevator will then arrive to the called floor and you should then re-enter passenger amount and/or a weight amount that will be exiting the elevator on the later selected "EL" destination floor.
From there you will have the choice to select a destination floor button (EL 1-10) OR press the Submit ID button to submit the entered in the "Enter ID" text box area to the database so that the destination floor associated with that User ID will be selected.

Contributors
Garrett Engelder (@email: gengelde@purdue.edu)
Christopher Russeau (@email: crusseau@purdue.edu)
Nicholas Charlesworth (@email: ncharle@purdue.edu)