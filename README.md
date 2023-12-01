# SGPA Calculator

* [Introduction](#introduction)
* [Download](#download)
* [How to use](#how-to-use)
* [Technologies used](#technologies-used)
* [Dependencies](#dependencies)

# Introduction

This is an application that can be used to calculate the SGPA/GPA of
subjects by entering their grades and credits. It can have any number of
subjects from 1 to 13 but the default number of subjects is 8. It is meant
to work for SGPA calculation for Chandigarh University (CU).

# Download

[Download Windows executable setup](https://github.com/NavjotSRakhra/SGPACalculatorGUI/releases/download/1.0.7/SGPA_Calculator_Setup.exe)

[Download Java 11+ Jar](https://github.com/NavjotSRakhra/SGPACalculatorGUI/releases/download/1.0.7/SGPA_Calculator.jar)

[Download Android apk file (Android 8 and above)](https://github.com/NavjotSRakhra/SGPACalculatorGUI/releases/download/1.0.8/SGPA_Calculator_v1.0.8.apk)

To download this application go to the releases section of GitHub page of
this project and download the setup executable if you don't want to install
Java 11+ or you can download the jar file and execute it using the ``java -jar filename.jar`` command.
You can also Download and install the APK to calculate SGPA in android.

# How to use

![img-1](resources/sample-img-1.png)

This is how the UI of the app looks like. You can change the number of
subjects to any integral number between 1 and 13 (both exclusive). The UI
will change accordingly.

![img-2](resources/sample-img-2.png)

Then enter the Grade from the drop-down list. Also enter the credits of
corresponding subject

![img-3](resources/sample-img-3.png)

Finally, click calculate after entering all the respective fields to
calculate SGPA/GPA

![img-4](resources/sample-img-4.png)

# Technologies used

This project has been written in OpenJDK 11 and can run on Java 11 and above.
I also plan on porting it to android.

# Dependencies

This project uses SGPACalculator from maven central. To use it in your own
project add the following to your ```POM.xml```

    <dependencies>
        ...
        <dependency>
            <groupId>io.github.NavjotSRakhra</groupId>
            <artifactId>SGPACalculator</artifactId>
            <version>1.1.0</version>
        </dependency>
        ...
    </dependencies>

# License

Copyright © 2023 Navjot Singh Rakhra

Non-Commercial Contribution and Access License

Version 1.0, June, 14 2023

Permission is hereby granted, free of charge, to any person or organization ("Contributor") obtaining a copy of this software and associated documentation files (the "Software"), to contribute to the Software and use it for non-commercial purposes, subject to the following conditions:

1. Contributions:
   By contributing to this project, Contributor agrees to grant the project's copyright holder ("Copyright Holder") a worldwide, non-exclusive, irrevocable, royalty-free license to access, use, modify, reproduce, distribute, prepare derivative works of, display, and perform the contributions, including any intellectual property rights therein, for the purposes of developing, maintaining, and promoting the project.

2. Non-Commercial Use:
   Any person or organization using the Software for non-commercial purposes is granted a worldwide, non-exclusive, royalty-free license to use, reproduce, distribute, prepare derivative works of, and display the Software, in source or object code form, with or without modification, subject to the following conditions:
   (a) The Software may not be used for any commercial purposes without obtaining a separate license from the Copyright Holder.
   (b) Redistributions of the Software in source code form must retain the above copyright notice, this list of conditions, and the following disclaimer.
   (c) Redistributions of the Software in object code form must reproduce the above copyright notice, this list of conditions, and the following disclaimer in the documentation and/or other materials provided with the distribution.

3. Commercial Use:
   For any commercial use of the Software, the Contributor must obtain a separate license from the Copyright Holder.

4. No Warranty:
   The Software is provided "as is," without warranty of any kind, express or implied, including but not limited to the warranties of merchantability, fitness for a particular purpose, and non-infringement. The Copyright Holder, Contributors, and any other party involved in the creation, production, or delivery of the Software shall not be liable for any direct, indirect, incidental, special, exemplary, or consequential damages, including but not limited to loss of profits, data, or use, arising in any way out of the use or performance of the Software.

5. Governing Law:
   This license shall be governed by and construed in accordance with the laws of India. Any legal disputes arising out of or in connection with this license shall be subject to the exclusive jurisdiction of the courts in Punjab, India.
   
