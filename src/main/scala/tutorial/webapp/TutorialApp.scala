package tutorial.webapp


import org.scalajs.dom
import dom.document

import scala.scalajs.js.annotation.JSExportTopLevel


object TutorialApp {
  def main(args: Array[String]): Unit = {
    addParagraph("Hello Word")
  }

  def addParagraph(in: String): Unit = {
    document.body.appendChild(document.createElement("p").appendChild(document.createTextNode(in)))
    addButton()
  }

  @JSExportTopLevel("addClickedMessage")
  def addClickedMessage(): Unit = {
    appendPar(document.body, "You clicked the button!")
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }


  def addButton() = {
    val button = document.createElement("button")
    button.innerHTML= "Click Me!"
    button.setAttribute("onClick", "addClickedMessage()")
    document.body.appendChild(button)
  }

}
