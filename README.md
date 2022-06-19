# Canvas-Api-Mobiler.dev

See the blog post of this project [here][0]

-------------

## Project Presentation

<br>

 To start using it, you must first call the androidx.compose.foundation.Canvas function in the Compose project you have created.
 First, add the piece of code you will use to create a blank screen and put a black rectangle inside.

```kotlin   
@Composable
fun CanvasIcon() {
    Box(modifier = Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier) { 
            drawRect(color = Color.Black, 
                     size = size) 
        }
    }
}
```
<br>

Next, write the code needed to build the framework.
```kotlin   
@Composable
fun Canvas(modifier: Modifier, onDraw: DrawScope.() -> Unit) = Spacer(modifier.drawBehind(onDraw))
```
<br>

This code you have written will create a blank screen for you. You cannot see the rectangle because the default value is zero. Now add height and width to make the rectangle visible.
```kotlin
   @Composable
fun CanvasIcon() {
    Box(modifier = Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.width(100.dp).height(100.dp)) {
            drawRect(color = Color.Black, size = size)
        }
    }
}
```
<br>
    
By specifying the location of the Box you have used, you can change the position of the item and center it on the screen. All you have to do is add contentAlignment. So the rectangle will be in the middle of the screen.    
To make reusable components, you can start by first creating a custom component.
```kotlin
@Composable
fun ComponentIcon(mySize: Dp = 100.dp) {
    Canvas(modifier = Modifier.size(mySize)) {
        drawRect(color = Color.Black
                 size = size)
    }
}
```
<br>

* All size and position related settings can be controlled in pixels using Canvas. It would be most logical to pass the parameters that make up this component as Float.
* At the same time, this component can be simply improved. For example, add a circle inside.
* In addition to all these changes you have made, you can change your drawings with color lists, make them more animated and add different animations. <br>
      1) The "rotate" method can rotate the rectangle any degree you want.<br>
      2) The "translate" method can rotate the rectangle any degree you want and push it down at the same time.<br>

-----------
## And Result
<p align="center">
  <img src="https://user-images.githubusercontent.com/71982171/174492739-791aed68-857e-4eda-b6b1-677ced240e76.gif" alt="GIF" />
</p>

[0]: https://www.mobiler.dev/post/jetpack-compose-da-canvas-api-kullanimi
