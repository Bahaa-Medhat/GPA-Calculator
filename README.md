# GPA Calculator Project

## Overview
The **GPA Calculator** project is a desktop application developed using **Java** with the **Model-View-Controller (MVC)** architecture and **JavaFX** for the graphical user interface. The application provides two main modes:

1. **GPA Calculator**
2. **Coursework Calculator**

These features aim to simplify the management of academic performance by offering an intuitive and user-friendly interface.

---

## Features

### 1. GPA Calculator
- Calculates GPA based on the German grading system.
- Users can input:
  - Course name
  - Credit hours
  - Grade (A+ to D or below, with associated GPA values).
- GPA is calculated using the following scale:
  ```java
  switch (grade) {
      case "A+": gpa = 0.7; break;
      case "A":  gpa = 1.0; break;
      case "A-": gpa = 1.3; break;
      case "B+": gpa = 1.7; break;
      case "B":  gpa = 2.0; break;
      case "B-": gpa = 2.3; break;
      case "C+": gpa = 2.7; break;
      case "C":  gpa = 3.0; break;
      case "C-": gpa = 3.3; break;
      case "D+": gpa = 3.7; break;
      case "D":  gpa = 4.0; break;
      default:    gpa = 5.0; // Failing grade
  }
  ```
- The GPA is calculated as a weighted average, considering course credits.

### 2. Coursework Calculator
- Calculates the overall grade for a course based on weighted sections.
- Users can input:
  - Section name
  - Grade (numerical or percentage)
  - Weight (percentage of the total coursework).
- Outputs the weighted average grade for the course.

---

## Architecture

The project follows the **MVC architecture**, ensuring a clean separation of concerns:
- **Model**: Handles the core logic for GPA and coursework calculations.
- **View**: Provides the graphical interface using JavaFX.
- **Controller**: Manages user interactions and connects the view to the model.

---

## Technologies Used
- **Java**: Programming language.
- **JavaFX**: GUI framework for building the application interface.
- **Scene Switching**: Ensures smooth navigation between the GPA Calculator and Coursework Calculator views while maintaining state.

---

## How to Run
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Open the project in your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Ensure you have JDK 11 or higher installed.
4. Run the `Main.java` file to start the application.

---

## Future Improvements
- Add functionality to save and load data.
- Support for custom grading systems.
- Enhanced UI/UX for easier navigation and customization.
- Export GPA and coursework results to a file.

---

## Contribution
Contributions are welcome! Feel free to fork the repository and submit pull requests for bug fixes, new features, or other improvements.

---

## Contact
For any questions or feedback, please contact [your email or GitHub profile link].

