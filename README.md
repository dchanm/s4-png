# s4-png
Convert S4 PNG Java serialized objects to actual images

The Samsung Galaxy S4 stock browser creates PNG files which are really TabData serialized objects. This program converts the bitmap data stored within the TabData objects into a PNG file that is viewable with normal photo software.


#### Compile
```shell
javac *.java
``` 

#### Run
```shell
java Main [INPUT FILE]
```
The output file name is obtained by removing the extension and appending *-out.png*

*e.g.*

**Image.png** becomes **Image-out.png**

#### Notes
The original implementation required the Android SDK to compile due to a dependency on *android.graphics.Bitmap.Config*. However the mConfig member isn't needed to properly deserialize the object. References to *Bitmap.Config* were replaced with *Object*
#### References
1. [TabData smali](https://github.com/mrimp/G900FXXU1ANCF/blob/45865c2e1d1f370a34c46cf63c24f83ea5228606/SBrowser/smali/com/sec/android/app/sbrowser/common/TabData.smali)

