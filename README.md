# CONVERT_JPEG_to_PNG

This project contains simple Java programs to convert an image file's format and extension from `.jpeg` to `.png`.

---

## Requirements

- **Java Development Kit (JDK)** installed on your system.

> **Note:** Unlike Python, no external libraries are required. Java includes built-in support for image processing (`javax.imageio`) and graphical interfaces (`javax.swing`) right out of the box.

---

## Two Methods

This project provides two approaches:

---

### 1. Using Terminal

1. Place your JPEG image in the same folder as the Java file.
2. Rename the image to:
   ```
   input.jpeg
   ```
3. Open your terminal or command prompt and compile the program:
   ```bash
   javac ConverterTerminal.java
   ```
4. Run the compiled program:
   ```bash
   java ConverterTerminal
   ```

✅ The converted file `output.png` will be generated automatically in the same folder.

---

### 2. Using GUI

1. Open your terminal or command prompt and compile the GUI program:
   ```bash
   javac ConverterGUI.java
   ```
2. Run the compiled program:
   ```bash
   java ConverterGUI
   ```

3. A window will open:
   - Click **Import JPEG File** to select an image.
   - Click **Convert JPEG to PNG**.
   - Choose where to save the converted file.

✅ The PNG file will be saved to your selected location.

---

## Summary

| Method   | Interface | Ease of Use | Flexibility |
|----------|----------|------------|-------------|
| Terminal | CLI      | Simple     | Fixed input/output |
| GUI      | Window   | User-friendly | Choose any file/location |

---

## Author

Devraj Charan
