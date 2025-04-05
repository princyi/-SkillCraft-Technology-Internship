##Create a program for calculate converted temperature
 ##solution 

##Here's a Python program using the matplotlib library to visualize the temperature conversions. This will show the converted temperatures as bar graphs for a given input temperature.

##MAIN CODE IN PYTHON LANGUAGE 

import matplotlib.pyplot as plt

def celsius_to_fahrenheit(c):
    return (c * 9/5) + 32

def celsius_to_kelvin(c):
    return c + 273.15

def fahrenheit_to_celsius(f):
    return (f - 32) * 5/9

def fahrenheit_to_kelvin(f):
    return (f - 32) * 5/9 + 273.15

def kelvin_to_celsius(k):
    return k - 273.15

def kelvin_to_fahrenheit(k):
    return (k - 273.15) * 9/5 + 32

def convert_and_plot(temperature, unit):
    if unit.lower() == 'celsius' or unit.lower() == 'c':
        fahrenheit = celsius_to_fahrenheit(temperature)
        kelvin = celsius_to_kelvin(temperature)
        labels = ['Celsius', 'Fahrenheit', 'Kelvin']
        values = [temperature, fahrenheit, kelvin]
        title = f"Temperature Conversion from {temperature}°C"
    elif unit.lower() == 'fahrenheit' or unit.lower() == 'f':
        celsius = fahrenheit_to_celsius(temperature)
        kelvin = fahrenheit_to_kelvin(temperature)
        labels = ['Fahrenheit', 'Celsius', 'Kelvin']
        values = [temperature, celsius, kelvin]
        title = f"Temperature Conversion from {temperature}°F"
    elif unit.lower() == 'kelvin' or unit.lower() == 'k':
        celsius = kelvin_to_celsius(temperature)
        fahrenheit = kelvin_to_fahrenheit(temperature)
        labels = ['Kelvin', 'Celsius', 'Fahrenheit']
        values = [temperature, celsius, fahrenheit]
        title = f"Temperature Conversion from {temperature}K"
    else:
        print("Invalid unit. Please use Celsius (C), Fahrenheit (F), or Kelvin (K).")
        return

    plt.figure(figsize=(8, 6))
    plt.bar(labels, values, color=['blue', 'green', 'red'])
    plt.ylabel("Temperature")
    plt.title(title)
    plt.grid(axis='y', linestyle='--')
    plt.show()

if __name__ == "__main__":
    while True:
        try:
            temp_input = float(input("Enter the temperature value: "))
            unit_input = input("Enter the unit (Celsius, Fahrenheit, or Kelvin): ")
            convert_and_plot(temp_input, unit_input)
            break
        except ValueError:
            print("Invalid temperature value. Please enter a number.")
        except Exception as e:
            print(f"An error occurred: {e}")


How to run this code:

Save: Save the code as a Python file (e.g., temperature_converter.py).
Install matplotlib: If you don't have it installed, open your terminal or command prompt and run:
Bash

pip install matplotlib
Run: Open your terminal or command prompt, navigate to the directory where you saved the file, and run:
Bash

python temperature_converter.py
How the code works:

Conversion Functions: It defines functions to convert between each pair of temperature scales.
convert_and_plot Function:
Takes the temperature value and its unit as input.
Performs the necessary conversions based on the input unit.
Creates labels and values for the bar graph.
Uses matplotlib.pyplot to create a bar chart:
plt.figure() creates a new figure for the plot.
plt.bar() creates the bar graph with specified labels and values.
plt.ylabel(), plt.title(), and plt.grid() add labels, a title, and a grid to the plot for better readability.
plt.show() displays the generated graph.
Main Execution Block (if __name__ == "__main__":)
Prompts the user to enter the temperature value and unit.
Calls the convert_and_plot function to perform the conversion and display the graph.
Includes basic error handling for invalid input.
Output:

When you run the code, it will ask you to enter a temperature and its unit. After you provide the input, a separate window will pop up displaying a bar graph. This graph will show the original temperature and its equivalent values in the other two temperature scales, with each scale represented by a bar of a different color.

##For example, if you enter 25 for the temperature and Celsius for the unit, you will see a bar graph showing the values for 25°C, 77°F, and 298.15K.
