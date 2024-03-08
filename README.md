seng438-a3

Read [the assignment guideline](seng438-a3.md) 

1. Open eclipse in the "seng438-a3-NicoleHeather/Project Folder" folder.
2. Go to File -> Open Projects From File System.
3. Set directory to "seng438-a3-NicoleHeather/Project Folder".
4. Click finish.
5. Add libraies by going right clicking on the src folder, going to "Configure Build Paths" and then going to libraries to add external jar files.
    - Select the jfreechart-1.0.19-demo.jar file from "seng438-a3-artifact/Unzipped Files/jfreechart-1.0.19" and add all the .jar files from the lib and lib/Jmock directory.
    - Select the jfreechart.jar file from "JFreeChart v1.0" as well as all the libraires from the "lib" folder, indluding the Jmock files.
    - Apply the new libaries and close the library window.
6. Then, navigate to src -> org -> jfree -> data and right click.
7. Click on "Coverage As" and choose JUnit Application.

The coverage tool use was EclEmma, it should already be installed in your eclipse workspace as it comes with it, if not go to Help -> Eclipse Marketplace and search for EclEmma to install.