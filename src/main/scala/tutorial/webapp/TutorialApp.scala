package tutorial.webapp

import org.scalajs.dom
import dom.document
import scala.scalajs.js.annotation.JSExportTopLevel


object TutorialApp {
  def main(args: Array[String]): Unit = {
    addParagraph(document.body, "Hello Word")
    addButton()
  }

  @JSExportTopLevel("addClickedMessage")
  def addClickedMessage(): Unit = {
    addParagraph(document.body, "You clicked the button!")
  }

  def addButton() = {
    val button = document.createElement("button")
    button.innerHTML= "Click Me!"
    button.setAttribute("onClick", "addClickedMessage()")
    document.body.appendChild(button)
  }

  def addParagraph(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

}
