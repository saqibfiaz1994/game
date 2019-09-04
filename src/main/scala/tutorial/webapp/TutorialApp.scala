package tutorial.webapp

import org.scalajs.dom
import dom.document
import org.scalajs.dom.html.Canvas
import org.scalajs.dom.raw.HTMLImageElement

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel
import scala.scalajs.js.timers.SetIntervalHandle


object TutorialApp {
  def main(args: Array[String]): Unit = {

    addParagraph(createParagraph(), "Hello Everybody")
    addButton(createParagraph())
    initScreen(createParagraph())
    keyprint()
  }

  var playerX = 200
  var playerY = 180
  var playerSpeed = 8

  def keyprint() = {
    dom.window.addEventListener("keydown", (e: dom.KeyboardEvent) => {
      println("hello" + e.keyCode)

      e.keyCode match {
        case 37 => playerX -= 5
        case 38 => playerY -= 5
        case 39 => playerX += 5
        case 40 => playerY += 5

      }


    }, false)
  }

  @JSExportTopLevel("addClickedMessage") def addClickedMessage(): Unit = {
    addParagraph(document.body, "did you really just press me!")
  }

  def createParagraph(): dom.Node = {
    val p = document.createElement("p")
    document.body.appendChild(p)
  }

  def addButton(targetNode: dom.Node) = {
    val button = document.createElement("button")
    button.innerHTML = "Click Me!"
    button.setAttribute("onClick", "addClickedMessage()")
    targetNode.appendChild(button)
    button
  }

  def addParagraph(targetNode: dom.Node, text: String): dom.Node = {
    val textNode = document.createTextNode(text)
    targetNode.appendChild(textNode)
  }


    def initScreen(targetNode: dom.Node): SetIntervalHandle = {
      //(What is SetIntervalHandle)
    val width = 600
    val height = 400
    val canvas = document.createElement("canvas").asInstanceOf[Canvas]
      canvas.width = width
      canvas.height = height

    val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
//

      //def movePlayer(): Unit = {
      //playerX -= playerSpeed
      //}

    class Image(src: String) {
      private var ready: Boolean = false

        val element = dom.document.createElement("img").asInstanceOf[HTMLImageElement]
        element.onload = (e: dom.Event) => ready = true
        element.src = src


      def isReady: Boolean = ready
    }

        val bgImage = new Image("images/field")
        val cavemanBobImage = new Image("images/cavemanBob.png")
        val tomatoImage = new Image("images/tomato.png")

      def drawThings() = {
        // ctx.fillStyle = "#000000"
        //ctx.fillRect(0, 0, width, height)
        render()
        ctx.fillStyle = "#fff"
        ctx.fillRect(playerX, playerY, 50, 50)

    }

      def render() {
        if (bgImage.isReady) {
        ctx.drawImage(bgImage.element, 0, 0, width, height)
      }
    }

      js.timers.setInterval(28) {
      drawThings()
    }
  }
}
