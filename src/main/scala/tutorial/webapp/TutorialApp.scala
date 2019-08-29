package tutorial.webapp

import org.scalajs.dom
import dom.document
import org.scalajs.dom.html.Canvas

import scala.scalajs.js.annotation.JSExportTopLevel


object TutorialApp {
  def main(args: Array[String]): Unit = {

    addParagraph(createParagraph(), "Hello Word")
    addButton(createParagraph())
    initScreen(createParagraph())
  }

  @JSExportTopLevel("addClickedMessage")
  def addClickedMessage(): Unit = {
    addParagraph(document.body, "You clicked the button!")
  }

  def createParagraph():dom.Node = {
    val p = document.createElement("p")
    document.body.appendChild(p)
    p
  }

  def addButton(targetNode:dom.Node) = {
    val button = document.createElement("button")
    button.innerHTML= "Click Me!"
    button.setAttribute("onClick", "addClickedMessage()")
    targetNode.appendChild(button)
    button
  }

  def addParagraph(targetNode: dom.Node, text: String): dom.Node = {
    val textNode = document.createTextNode(text)
    targetNode.appendChild(textNode)
  }


  def initScreen(targetNode:dom.Node): dom.CanvasRenderingContext2D = {
    val width = 600
    val height = 400
    val canvas = document.createElement("canvas").asInstanceOf[Canvas]
    canvas.width = width
    canvas.height = height

    val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
    ctx.fillStyle = "#40E0D0"
    ctx.fillRect(0,0,width,height)

    document.createElement("p")
    targetNode.appendChild(canvas)
    ctx
  }

}
