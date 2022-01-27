# Armbot-Java-Android Studio

## Project Goal

'*Duchenne muscular dystrophy (DMD) is a genetic disorder characterized by progressive muscle degeneration and weakness due to the alterations of a protein called dystrophin that helps keep muscle cells intact*'. 

([Muscular Dystrophy Association](https://www.mda.org/disease/duchenne-muscular-dystrophy) - Duchenne Muscular Dystrophy (DMD) - Diseases (2021, April 29))

Approximatly 4.78 people out of 100,000 poccess the DMD in the world. To help those people improve their autonomy, we decided to create a robotic arm, accessible and customizable. Our goal was to create an arm, controllable with android app, and under a ~400€ budget, using a 3D printer. 

This project was possible thanks to [Niryo](https://niryo.com/fr/)'s 3D models of the arm, the FabLab of [ECE Paris](https://www.ece.fr/) school and [HandiTech](https://handitech-france.fr/).

**The usage of the arm is under the responsability of the user.**

To learn how to use our arm, please go through our [course](https://rise.articulate.com/share/YxWGhuafWEo22Ty-tBzGM7W94fOSDhKb#/).

You'll find further informations in our GitHub and all the ressources in the following [link](https://drive.google.com/drive/folders/1EEAC_9meE7mFTIsfq7AG75mwahTAs3Wy?usp=sharing).

Finally, dont miss to visit our [YouTube](https://www.youtube.com/channel/UCcuagSu5sPNIdyUf5VJzb_w.) page.




## Java Application Goal

This is the code for the android app to control the robotic arm.

### Prerequisite

In order to create a connection between the app and the Raspberry, you need to have followed the [Raspberry Pi steps](https://github.com/ArmBot-ECE/ArmBot_Raspberry) before.


### Application Download

* On your Android, go to this [link](https://drive.google.com/drive/folders/1EEAC_9meE7mFTIsfq7AG75mwahTAs3Wy?usp=sharing) and click on "ArmBot_app.apk" to download it.
* Explore the files of your Smartphone to find the APK application file you previously downloaded.
* Click on the file and press “Install” to launch the installation.

> :warning: **Warning** : By default, Android do not allow the installation of application not installed via the Play Store. You need to permit the installation of application from unknown sources. 
>
> So navigate to your phone settings menu then to the security settings. Enable the Install from Unknown Sources option.


### How to use the app

* Once launched, you'll end up on the home page.

<p align="center">
  <img width="180" height="330" src="https://user-images.githubusercontent.com/71266159/151386833-0daa5920-4e6a-4e10-a858-34003eab69bd.jpg">
</p>

* You'll be able to come back to the home page at any type by clicking on the <img width="25" height="25" src="https://user-images.githubusercontent.com/71266159/151388556-671b8d19-42be-49e8-ac86-d626048b7b1a.PNG"> button.

<p align="center">
  <img src="https://user-images.githubusercontent.com/71266159/151389110-d5ff84ef-1fe5-47c6-81cc-3aef2bfe1483.PNG">
</p>

* The message under the "Home" title outputs the state of the Bluetooth connection between the app and the Raspberry. 

> ℹ **Information** : To use the app, you'll need to enable Bluetooth and the localisation.

* Click on the <img width="25" height="25" src="https://user-images.githubusercontent.com/71266159/151390232-fd6ead72-5359-4c4c-8f66-151f76a996b7.PNG"> button to enable the Bluetooth if not already enabled. 

* Click on the <img width="25" height="25" src="https://user-images.githubusercontent.com/71266159/151390791-1c620555-a89d-48a8-8973-ca2fe329f6d1.PNG"> button to search Bluetooth devices.

* In the Bluetooth page, select the Raspberryn which should be already paired and wait until the "Connected : 'Raspberry name'" message appears under the "Home" title.

* Click on the "Enter" button to go to the controllers.

> ℹ **Note** : The top buttons enables to control the arm; the bottom ones control the robot gripper.

* To change the robot speed or other settings, click on the <img width="25" height="25" src="https://user-images.githubusercontent.com/71266159/151392768-65b559d2-46be-4eb0-9f08-6bf0912d31e6.PNG"> button and select "Settings".
