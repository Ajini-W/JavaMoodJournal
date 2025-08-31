# 🧠 MoodJournal - Sentiment-Based Journal Application

**MoodJournal** is a Java desktop application that allows users to write daily journal entries and analyzes their emotional tone using a simple keyword-based sentiment analysis algorithm. It classifies moods as Positive, Negative, or Neutral and stores them in a MySQL database.

---

## 📌 Features

- ✍️ Journal writing interface using Java Swing
- 📊 Sentiment analysis to detect mood
- 🗓️ Automatically saves entries by date
- 🗃️ Entries stored in a MySQL database
- 💬 Displays mood prediction popup after each entry is saved

---

## 🛠 Technologies Used

- Java (JDK 17+)
- Java Swing (GUI)
- JDBC (Database Connectivity)
- MySQL (Database)
- Eclipse IDE

---

## 🧠 Sentiment Analysis

Sentiment is detected by matching journal entry words against a list of predefined keywords:

// Positive words
Set.of("happy", "joy", "excited", "love", "great", "fun", "good");

// Negative words
Set.of("sad", "angry", "depressed", "bad", "tired", "hate", "anxious");

⬩Positive score > 0 → Positive mood

⬩Negative score < 0 → Negative mood

⬩Score = 0 → Neutral mood

## 🗄️ Database Setup

Create the database and entries table before running the app:

CREATE DATABASE moodjournal;

USE moodjournal;

CREATE TABLE entries (
    
    id INT AUTO_INCREMENT PRIMARY KEY,
    
    user_id INT,
    
    date DATE,
    
    entry_text TEXT,
    
    mood VARCHAR(10)

);

## ⚙️ Configuration

Edit your database credentials in DBConnection.java:

private static final String URL = "jdbc:mysql://localhost:3306/moodjournal";

private static final String USER = "root";  // Your DB username

private static final String PASSWORD = "MySQL@123";  // Your DB password

Ensure your MySQL server is running and accessible.

## 🚀 How to Run the Project

Clone this repository:

git clone https://github.com/Ajini-W/JavaMoodJournal.git

Open the project in Eclipse IDE (or any Java IDE).

Make sure you have the MySQL JDBC Driver added to the project libraries.

Run the Main.java file to launch the application.

The app uses a default user_id of 1 for journal entries. You can modify it in Main.java.

## 📁 Project Structure

MoodJournal/

├── db/

│   └── DBConnection.java          # Handles MySQL DB connection

│

├── util/

│   └── SentimentAnalyzer.java    # Basic sentiment analysis logic

│

├── ui/

│   ├── DashboardFrame.java       # Main journal UI window

│   └── Main.java                 # Entry point

│

└── README.md

## 🔮 Future Improvements

⬩Add user login & authentication

⬩Use advanced NLP libraries (like Stanford NLP or OpenNLP)

⬩View mood history charts

⬩Export entries to PDF

⬩Dark mode UI

## 📜 License

This project is licensed under the MIT License.

## 🤝 Contributing

Pull requests are welcome! Open issues to suggest new features or improvements.

## 💬 Contact

Have feedback, questions, or want to collaborate? Reach out through GitHub Issues or Discussions.
