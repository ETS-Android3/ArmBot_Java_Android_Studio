# Armbot-Java-Android Studio

## Project Goal

'*Duchenne muscular dystrophy (DMD) is a genetic disorder characterized by progressive muscle degeneration and weakness due to the alterations of a protein called dystrophin that helps keep muscle cells intact*'. 

([Muscular Dystrophy Association](https://www.mda.org/disease/duchenne-muscular-dystrophy) - Duchenne Muscular Dystrophy (DMD) - Diseases (2021, April 29))

Approximatly 4.78 people out of 100,000 poccess the DMD in the world. To help those people improve their autonomy, we decided to create a robotic arm, accessible and customizable. Our goal was to create an arm, controllable with android app, and under a 400€ budget, with a 3D printer. 

This project was possible thanks to [Niryo](https://niryo.com/fr/)'s 3D models of the arm, the FabLab of [ECE Paris](https://www.ece.fr/) school and [HandiTech](https://handitech-france.fr/).

## Java Application Goal

This is the code for the android app to control the robotic arm.


## Application Organisation

The application is composed of a manifest, controllers, drawables, layouts, a menu, mipmaps, a navigation area and resource values.

In the manifest, it is define the main theme, the icon, the label and the activity to start.

The controllers enables to set the app by calling the layouts and set some functions.

The navigation part enables to go from one layout to the other.

The menu enables to travel to one layout to the other by clicking on the desired layout.

The mipmap stores all the icons.

The drawables stores all the images and xml files.

The values enables to store all the variables such as the colors used, the dimensions of the app's window, the string used and the different themes.

